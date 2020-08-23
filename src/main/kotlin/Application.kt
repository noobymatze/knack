import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.Node
import org.w3c.dom.events.Event
import org.w3c.dom.events.InputEvent

class Application<Model, Msg>(
    private val program: Program<Model, Msg>,
    private var currentNode: Node,
    private var model: Model
) {

    private fun handler(msg: Msg) {
        val newModel = program.update(msg, model)
        // If the references are not equal, we need to render again
        if (newModel !== model) {
            window.requestAnimationFrame {
                val newView = program.view(newModel)
                val newNode = render(newView, ::handler)
                cleanUpEventListener(currentNode)
                currentNode.parentNode?.replaceChild(newNode, currentNode)
                this.model = newModel
                this.currentNode = newNode
                setupEventListener(currentNode)
            }
        }
    }

    init {
        val view = program.view(model)
        val node = render(view, ::handler)
        currentNode.parentNode?.replaceChild(node, currentNode)
        this.currentNode = node
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

