import kotlinx.browser.document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.events.Event

/**
 *
 */
class Attribute<out Msg> private constructor()

/**
 *
 */
class Html<out Msg> private constructor()


/**
 *
 * @param key
 * @param value
 * @return
 */
fun <Msg> attribute(
    @Suppress("UNUSED_VARIABLE")
    key: String,
    @Suppress("UNUSED_VARIABLE")
    value: String
): Attribute<Msg> =
    js("{$: 'ATTR', key: key, value: value}")

/**
 *
 * @param key
 * @param handler
 * @return
 */
fun <Msg> on(key: String, handler: (Event) -> Msg): Attribute<Msg> =
    js("{$: 'EVENT', key: key, value: handler}")

/**
 *
 * @param property
 * @param value
 * @return
 */
fun <Msg> style(property: String, value: String): Attribute<Msg> =
    js("{$: 'STYLE', key: property, value: value}")

/**
 *
 * @param name
 * @param attributes
 * @param children
 * @return
 */
fun <Msg> node(name: String, attributes: Array<Attribute<Msg>>, children: Array<Html<Msg>>): Html<Msg> {
    val organizeFacts = { attributes: Array<Attribute<Msg>> ->
        val result = js("{}")
        attributes.forEach {
            val attr = it.asDynamic()
            val tag = attr["$"]
            if (result[tag] == undefined)
                result[tag] = js("{}")
            val r = result[tag]
            r[attr.key] = attr.value
        }

        result
    }

    return js("""{$: 'NODE', name: name, attributes: organizeFacts(attributes), children: children}""")
}

/**
 * @param value
 * @return
 */
fun text(value: String): Html<Nothing> =
    js("""{$: 'TEXT', value: value}""")

/**
 *
 */
fun <Msg> render(html: Html<Msg>, send: (Msg) -> Unit): Node {
    val node = html.asDynamic()
    val tag = node["$"]
    if (tag == "TEXT")
        return document.createTextNode(node.value)

    val attributes = node.attributes
    val children = node.children

    val el = document.createElement(node.name)
    applyAttributes<Msg>(el, attributes, send)
    children.forEach { value ->
        el.appendChild(render<Msg>(value, send))
    }

    return el
}

private fun <Msg> applyAttributes(el: Element, attributes: dynamic, send: (Msg) -> Unit) {
    forIn(attributes) { tag ->
        val value = attributes[tag]
        when (tag) {
            "STYLE" ->
                applyStyles(el, value)

            "ATTR" ->
                applyAttrs(el, value)

            "EVENT" ->
                applyEvents<Msg>(el, value, send)
        }
    }
}

private fun <Msg> applyEvents(domNode: Element, events: dynamic, sendToApp: (Msg) -> Unit) {
    val node = domNode.asDynamic()
    val allCallbacks = when (node.eventFs) {
        undefined -> {
            node.eventFs = js("{}")
            node.eventFs
        }

        else ->
            node.eventFs
    }

    forIn(events) { key ->
        val newHandler = events[key]
        if (!newHandler) {
            allCallbacks[key] = undefined
        }
        else {
            val callback = { event: Event ->
                sendToApp(newHandler(event))
            }

            allCallbacks[key] = callback
        }
    }
}

private fun applyAttrs(domNode: Element, attributes: dynamic) {
    forIn(attributes) { key ->
        val value = attributes[key]
        if (value == undefined)
            domNode.removeAttribute(key)
        else
            domNode.setAttribute(key, value)
    }
}

private fun applyStyles(domNode: Node, styles: dynamic) {
    val nodeStyles = domNode.asDynamic().style
    val keys = js("Object.keys(styles)")
    var i = 0
    while (i.asDynamic() < keys.length) {
        val key = keys[i]
        nodeStyles[key] = styles[key]
        i++
    }
}

private inline fun forIn(value: dynamic, f: (key: dynamic) -> Unit) {
    val keys = js("Object.keys(value)")
    var i: dynamic = 0
    while (i < keys.length) {
        f(keys[i])
        i++
    }
}
