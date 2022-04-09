package io.noobymatze.knack.http

import io.noobymatze.knack.effects.Cmd
import org.w3c.xhr.XMLHttpRequest

/**
 *
 * @param name
 * @param value
 */
data class Header(
    val name: String,
    val value: String
)

/**
 *
 * @param method
 * @param url
 * @param headers
 * @param body
 * @param expect
 */
data class Request<out A>(
    val method: String,
    val url: String,
    val headers: List<Header> = emptyList(),
    val body: Body = Body.None,
    val expect: Expect<A>,
    val timeout: Double,
)

/**
 *
 */
sealed interface Expect<out A> {

    /**
     *
     */
    class Json<out A>: Expect<A>

    /**
     *
     */
    object Empty: Expect<Nothing>

    /**
     *
     */
    object Text: Expect<String>

}


/**
 *
 */
sealed interface Body {

    /**
     *
     */
    object None: Body

    /**
     *
     */
    data class Json<out A>(val value: A): Body

}


/**
 *
 */
sealed class Response<out Body> {

    /**
     *
     */
    data class BadUrl(val url: String): Response<Nothing>()

    /**
     *
     */
    object Timeout: Response<Nothing>()

    /**
     *
     */
    object NetworkError: Response<Nothing>()

    /**
     *
     */
    data class BadStatus<out A>(
        val meta: Metadata,
        val body: String,
    ): Response<A>()

    /**
     *
     */
    data class GoodStatus<out Body>(
        val meta: Metadata,
        val body: Body
    ): Response<Body>()
}

/**
 *
 * @param url
 * @param statusCode
 * @param statusText
 * @param headers
 */
data class Metadata(
    val url: String,
    val statusCode: Int,
    val statusText: String,
    val headers: Map<String, String>,
)


fun <A, Msg> Request<A>.execute(handle: (Response<A>) -> Msg): Cmd<Msg> = Cmd.effect { callback ->
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
            headers = emptyMap(),
        )

        if (200 <= statusCode && statusCode < 400) {
            val response = Response.GoodStatus(
                body = when (expect) {
                    is Expect.Json ->
                        JSON.parse<A>(xhr.responseText)

                    is Expect.Empty ->
                        null as A

                    is Expect.Text ->
                        xhr.responseText as A

                },
                meta = meta
            )

            callback(handle(response))
        }
        else {
            val response = Response.BadStatus<A>(
                body = xhr.responseText,
                meta = meta
            )

            callback(handle(response))
        }
    })

    xhr.addEventListener("error", { event ->
        callback(handle(Response.NetworkError))
    })

    xhr.send(when (body) {
        is Body.None ->
            undefined

        is Body.Json<*> ->
            JSON.stringify(body.value)
    })
}