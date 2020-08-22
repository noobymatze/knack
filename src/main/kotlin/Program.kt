import org.w3c.dom.Node

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


