package io.noobymatze.knack.http

import io.noobymatze.knack.effects.Cmd
import org.w3c.xhr.XMLHttpRequest

data class Header(val name: String, val value: String)

/**
 *
 */
data class Request<out Msg>(
    val method: String,
    val url: String,
    val headers: List<Header>,
    val body: Body,
    val expect: Expect<Msg>
)

sealed class Expect<out Msg> {
}


sealed class Body {
}


sealed class Response<out Body> {
    data class BadUrl(val url: String): Response<Nothing>()
    object Timeout: Response<Nothing>()
    object NetworkError: Response<Nothing>()
    data class BadStatus<out Body>(
        val meta: Metadata,
        val body: Body
    ): Response<Body>()

    data class GoodStatus<out Body>(
        val meta: Metadata,
        val body: Body
    ): Response<Body>()
}

data class Metadata(
    val url: String,
    val statusCode: Int,
    val statusText: String,
    val headers: Map<String, String>
)


fun <Msg> Request<Msg>.execute(handle: (Response<String>) -> Msg): Cmd<Msg> = Cmd.effect { callback ->
    val xhr = XMLHttpRequest()
    xhr.open(method, url)
    headers.forEach {
        xhr.setRequestHeader(it.name, it.value)
    }
    xhr.addEventListener("success", { event ->
        val statusCode = xhr.status
        val meta = Metadata(
            url = url,
            statusCode = statusCode.toInt(),
            statusText = xhr.statusText,
            headers = mapOf()
        )

        if (200 <= statusCode && statusCode < 400) {
            val response = Response.GoodStatus(
                body = xhr.responseText,
                meta = meta
            )

            callback(handle(response))
        }
        else {
            val response = Response.BadStatus(
                body = xhr.responseText,
                meta = meta
            )

            callback(handle(response))
        }
    })

    xhr.addEventListener("error", { event ->

    })

    xhr.send()
}