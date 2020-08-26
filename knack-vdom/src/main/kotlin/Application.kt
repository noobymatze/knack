import kotlinx.browser.window
import org.w3c.dom.Node

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
                val newNode = applyPatches(patches, newView, currentNode, ::handler)
                this.model = newModel
                this.currentNode = newNode
                this.currentVNode = newView
            }
        }
    }

    init {
        val view = program.view(model)
        this.currentVNode = view
        val rootNode = virtualize<Msg>(currentNode)
        val patches = diff(rootNode, view)
        this.currentNode = applyPatches(patches, view, currentNode, ::handler)
    }

}

