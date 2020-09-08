package io.noobymatze.knack.http

import io.noobymatze.knack.effects.Cmd

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


fun <Msg> Request<Msg>.execute(handle: (Response<String>) -> Msg): Cmd<Msg> = TODO()