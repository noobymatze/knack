import kotlinx.browser.document
import org.w3c.dom.Node
import org.w3c.dom.events.Event

fun x(i: Model): Html<Int> = node("div", arrayOf(), arrayOf(node("button", arrayOf(on("click", { 1 })), arrayOf(text("Test $i")))))

class Program<Model, Msg>(
    val init: () -> Model,
    val update: (Msg, Model) -> Model,
    val view: (Model) -> Html<Msg>
) {

    fun run(mount: Node): Application<Model, Msg> = Application(
        this,
        mount,
        init()
    )

}


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

data class Model(
    val count: Int
)

val program = Program<Model, Int>(
    init = { Model(0) },
    update = { i, model -> model.copy(count = model.count + i) },
    view = ::x
)

fun main() {
    document.addEventListener("click", { event ->
        console.log(event);

        val t = event.target?.asDynamic()
        console.log(t)
        console.log(t.eventFs["click"])
        t.eventFs["click"](event)
    })

    val app = program.run(document.getElementById("app")!!)
}