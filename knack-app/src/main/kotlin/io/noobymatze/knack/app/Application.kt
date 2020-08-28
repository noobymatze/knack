package io.noobymatze.knack.app

import io.noobymatze.knack.vdom.render
import kotlinx.browser.window
import org.w3c.dom.Node

class Application<Model, Msg> internal constructor(
    private val program: Program<Model, Msg>,
    private var currentNode: Node
) {

    private var messages: MutableList<Msg> = mutableListOf()
    private var model: Model? = null
    private var currentVNode: dynamic = null

    private fun handler(msg: Msg) {
        val (newModel, cmd) = program.update(msg, model.asDynamic())
        // If the references are not equal, we need to io.noobymatze.knack.render again
        if (newModel !== model) {
            window.requestAnimationFrame {
                val newView = program.view(newModel)
                this.currentNode = render(currentNode, currentVNode, newView, ::handler)
                this.model = newModel
                this.currentVNode = newView
            }
        }
    }

    fun send(msg: Msg) {
        messages.add(msg)
        updateIfNeeded()
    }

    private fun updateIfNeeded() {
        if (!messages.isEmpty()) {
            window.requestAnimationFrame {  }
        }
    }


    internal fun start(): Application<Model, Msg> {
        val (initialModel, cmd) = program.init()
        this.model = initialModel
        val view = program.view(model.asDynamic())
        this.currentVNode = view
        this.currentNode = render(currentNode, view, null, ::handler)


        return this
    }

}

