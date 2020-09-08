import io.noobymatze.knack.effects.Cmd
import io.noobymatze.knack.app.Program
import io.noobymatze.knack.html.*
import io.noobymatze.knack.html.Events.onClick
import io.noobymatze.knack.html.Events.onInput
import io.noobymatze.knack.vdom.attribute
import io.noobymatze.knack.vdom.style
import io.noobymatze.knack.vdom.text
import kotlinx.browser.document


// MODEL


data class Model(
    val count: Int,
    val name: String
)


fun init(): Pair<Model, Cmd<Msg>> =
    Model(0, "") to Cmd.none



// VIEW


fun view(i: Model): Html<Msg> = div(
    arrayOf(),
    text("${i.count}"),
    button(arrayOf(onClick(Msg.Inc)),
        a(arrayOf(onClick(Msg.Dec)), text("Bla")),
        text("Klick me"),
    ),
    input(onInput(Msg::SetName), attribute("value", i.name)),
    text(i.name),
    if (i.name == "Test")
        div(arrayOf(style("color", "red")), text("This is a Test"))
    else
        text("What")
)



// UPDATE


sealed class Msg {
    object Inc: Msg()
    object Dec: Msg()
    data class SetName(val name: String): Msg()
}


fun update(msg: Msg, model: Model): Pair<Model, Cmd<Msg>> = when (msg) {
    Msg.Inc ->
        model.copy(count = model.count + 1) to Cmd.none

    Msg.Dec ->
        model.copy(count = model.count - 1) to Cmd.none

    is Msg.SetName ->
        model.copy(name = msg.name) to Cmd.none
}



val program = Program(
    init = ::init,
    update = ::update,
    view = ::view
)


fun main() {
    val app = program.run(document.getElementById("app")!!)
}