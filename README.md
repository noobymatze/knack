**THIS IS AN EXPERIMENT AND WORK IN PROGRESS, DON'T EXPECT ANYTHING TO WORK AT ALL**

# Knack

Knack is an implementation of [The Elm Architecture (TEA)][tea] in
Kotlin. To quote the first sentence from that link:

> The Elm Architecture is a pattern for architecting interactive
> programs, like webapps and games.

TODO: document basic idea.

If you are coming from JavaScript, you can think of it as React with
a built-in, global reducer and built-in side-effects.



## Example

To better understand it, take a look at the following example. *Note*:
In contrast to `kotlinx.html`, the html is not 'type safe'.


```kotlin
// MODEL


data class Model(
    val counter: Int
)


fun init() = 
    Model(0) to Cmd.none



// VIEW


fun view(model: Model): Html<Msg> = 
    div(
        text("${model.counter}"),
        button(onClick(Msg.Inc), text("Increment")),
        button(onClick(Msg.Dec), text("Decrement")),
    )


// UPDATE


sealed interface Msg {
    object Inc: Msg
    object Dec: Msg
}


fun update(msg: Msg, model: Model): Pair<Model, Msg> = when (msg) {
    is Inc -> 
        model.copy(counter = model.counter + 1) to Cmd.none

    is Dec -> 
        model.copy(counter = model.counter - 1) to Cmd.none
}


// MAIN

fun main() {
    val program = Program(::init, ::update, ::view)
    val element = document.getElementById("app")
    val app = program.run(element)
}
```


[tea]: https://guide.elm-lang.org/architecture/
