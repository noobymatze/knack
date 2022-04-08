package io.noobymatze.knack.app

import io.noobymatze.knack.effects.Cmd
import io.noobymatze.knack.vdom.render
import kotlinx.browser.window
import org.w3c.dom.Node

class Application<Model, Msg> internal constructor(
    private val program: Program<Model, Msg>,
    private var currentNode: Node
) {

    private var alreadyScheduled = false
    private var messages: MutableList<Msg> = mutableListOf()
    private var model: Model? = null
    private var currentVNode: dynamic = null

    fun send(msg: Msg) {
        messages.add(msg)
        updateIfNeeded()
    }

    private fun updateIfNeeded() {
        if (!alreadyScheduled) {
            window.requestAnimationFrame(::update)
            alreadyScheduled = true
        }
    }

    private fun update(tick: Double) {
        console.log(messages, model)
        if (messages.isNotEmpty() && model != null) {
            val newCommands = mutableListOf<Cmd<Msg>>()
            var currentModel = model
            messages.forEach {
                val (newModel, nextCmd) = program.update(it, currentModel!!)
                newCommands.add(nextCmd)
                currentModel = newModel
            }

            messages.clear()
            if (currentModel != model) {
                val newView = program.view(currentModel!!)
                this.currentNode = render(currentNode, newView, currentVNode, ::send)
                this.model = currentModel
                this.currentVNode = newView
            }
            alreadyScheduled = false
        }
        else {
            updateIfNeeded()
        }
    }

    internal fun start(): Application<Model, Msg> {
        val (initialModel, cmd) = program.init()
        this.model = initialModel
        val view = program.view(model.asDynamic())
        this.currentVNode = view
        this.currentNode = render(currentNode, view, null, ::send)
        return this
    }

}

