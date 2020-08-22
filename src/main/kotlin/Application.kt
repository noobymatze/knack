import org.w3c.dom.Node

class Application<Model, Msg>(
    private val program: Program<Model, Msg>,
    private var mount: Node,
    private var model: Model
) {

    private val handler: (Msg) -> Unit get() = { msg ->
        val newModel = program.update(msg, model)
        val newView = program.view(newModel)
        val newNode = render(newView, handler)
        mount.parentNode?.replaceChild(newNode, mount)
        this.model = newModel
        this.mount = newNode
    }

    init {
        val view = program.view(model)
        val node = render(view, handler)
        mount.parentNode?.replaceChild(node, mount)
        this.mount = node
    }

}

