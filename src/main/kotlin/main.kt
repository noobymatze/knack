import kotlinx.browser.document


// MODEL


data class Model(
    val count: Int,
    val name: String
)


fun init(): Model = Model(0, "")



// VIEW


fun view(i: Model): Html<Msg> = div(
    arrayOf(),
    text("${i.count}"),
    button(arrayOf(onClick(Msg.Inc)),
        node("a", arrayOf(onClick(Msg.Dec)), arrayOf(text("Bla"))),
        text("Klick me"),
    ),
    node("input", arrayOf(onInput(Msg::SetName), attribute("value", i.name)), arrayOf()),
    text(i.name)
)



// UPDATE


sealed class Msg {
    object Inc: Msg()
    object Dec: Msg()
    data class SetName(val name: String): Msg()
}


fun update(msg: Msg, model: Model): Model = when (msg) {
    Msg.Inc ->
        model.copy(count = model.count + 1)

    Msg.Dec ->
        model.copy(count = model.count - 1)

    is Msg.SetName ->
        model.copy(name = msg.name)
}



val program = Program(
    init = ::init,
    update = ::update,
    view = ::view
)


fun main() {
    val app = program.run(document.getElementById("app")!!)
}