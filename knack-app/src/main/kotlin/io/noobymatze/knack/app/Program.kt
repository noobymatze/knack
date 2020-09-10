package io.noobymatze.knack.app

import io.noobymatze.knack.effects.Cmd
import io.noobymatze.knack.html.VIEW
import io.noobymatze.knack.html.Html
import org.w3c.dom.Node

class Program<Model, Msg>(
    val init: () -> Pair<Model, Cmd<Msg>>,
    val update: (Msg, Model) -> Pair<Model, Cmd<Msg>>,
    val view: VIEW<Msg>.(Model) -> Html<Msg>
) {

    fun run(mount: Node): Application<Model, Msg> = Application(
        this,
        mount
    ).start()

}


