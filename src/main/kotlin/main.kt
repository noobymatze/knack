import kotlinx.browser.document


data class Model(
    val count: Int
)

fun view(i: Model): Html<Int> = div(
    arrayOf(),
    button(arrayOf(onClick(1)),
        text("Bla")
    )
)


val program = Program(
    init = { Model(0) },
    update = { i, model -> model.copy(count = model.count + i) },
    view = { view(it) }
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