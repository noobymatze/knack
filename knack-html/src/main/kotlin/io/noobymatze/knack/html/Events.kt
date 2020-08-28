package io.noobymatze.knack.html

import io.noobymatze.knack.vdom.Attribute
import io.noobymatze.knack.vdom.on


object Events {

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

}