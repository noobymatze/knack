import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.Node
import org.w3c.dom.events.Event
import org.w3c.dom.events.InputEvent

class Application<Model, Msg> internal constructor(
    private val program: Program<Model, Msg>,
    private var currentNode: Node,
    private var model: Model
) {

    private var currentVNode: dynamic = null

    private fun handler(msg: Msg) {
        val newModel = program.update(msg, model)
        // If the references are not equal, we need to render again
        if (newModel !== model) {
            window.requestAnimationFrame {
                val newView = program.view(newModel)
                val patches = diff(currentVNode, newView)
                cleanUpEventListener(currentNode)
                val newNode = applyPatches(patches, newView, currentNode, ::handler)
                this.model = newModel
                this.currentNode = newNode
                this.currentVNode = newView
                setupEventListener(currentNode)
            }
        }
    }

    init {
        val view = program.view(model)
        this.currentVNode = view
        val rootNode = virtualize<Msg>(currentNode)
        val patches = diff(rootNode, view)
        this.currentNode = applyPatches(patches, view, currentNode, ::handler)
        setupEventListener(currentNode)
    }

    fun cleanUpEventListener(rootNode: Node) {
        rootNode.removeEventListener("click", ::handleClick)
        rootNode.removeEventListener("input", ::handleInput)
    }

    fun handleClick(event: Event) {
        console.log(event)

        val t = event.target?.asDynamic()
        console.log(t)
        if (t.eventFs["click"] != undefined) {

            t.eventFs["click"](event)
        }
    }

    fun handleInput(event: Event) {
        val t = event.target?.asDynamic()
        console.log(t)
        console.log(t.eventFs["input"])
        t.eventFs["input"](event)
    }

    fun setupEventListener(rootNode: Node) {
        rootNode.addEventListener("click", ::handleClick)
        rootNode.addEventListener("input", ::handleInput)
    }

}

