typealias Html<Msg> = VNode<Msg>

fun <Msg> onClick(msg: Msg): Attribute<Msg> =
    on("click") { msg }

fun <Msg> onInput(toMsg: (String) -> Msg): Attribute<Msg> =
    on("input") {
        val value = it.target?.asDynamic()?.value
        if (value != null && value != undefined)
            toMsg(value as String)
        else
            throw RuntimeException()
    }

fun <Msg> div(attributes: Array<Attribute<Msg>> = arrayOf(), vararg children: Html<Msg>): Html<Msg> =
    node("div", attributes, children)


fun <Msg> button(attributes: Array<Attribute<Msg>> = arrayOf(), vararg children: Html<Msg>): Html<Msg> =
    node("button", attributes, children)


