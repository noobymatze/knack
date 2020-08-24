import kotlinx.browser.document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.events.Event
import org.w3c.dom.get
import kotlin.math.abs
import kotlin.math.min

private const val PATCH_REDRAW = "PATCH_REDRAW"
private const val PATCH_REDRAW_TEXT = "PATCH_REDRAW_TEXT"
private const val PATCH_REMOVE_FROM = "PATCH_REMOVE_FROM"
private const val PATCH_ADD = "PATCH_ADD"
private const val PATCH_ATTRS = "PATCH_ATTRS"

private const val ATTRIBUTE_STYLE = "STYLE"
private const val ATTRIBUTE_EVENTS = "EVENT"
private const val ATTRIBUTE_ATTR = "ATTR"

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
    js("{$: '$ATTRIBUTE_ATTR', key: key, value: value}")

/**
 *
 * @param key
 * @param handler
 * @return
 */
fun <Msg> on(key: String, handler: (Event) -> Msg): Attribute<Msg> =
    js("{$: '$ATTRIBUTE_EVENTS', key: key, value: handler}")

/**
 *
 * @param property
 * @param value
 * @return
 */
fun <Msg> style(property: String, value: String): Attribute<Msg> =
    js("{$: '$ATTRIBUTE_STYLE', key: property, value: value}")

/**
 *
 * @param name
 * @param attributes
 * @param children
 * @return
 */
fun <Msg> node(name: String, attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> {
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
    if (tag == "TEXT") {
        val domNode = document.createTextNode(node.value)
        return domNode
    }

    val attributes = node.attributes
    val children = node.children

    val el = document.createElement(node.name)
    applyAttributes<Msg>(el, attributes, send)
    children.forEach { value ->
        val domNode = render<Msg>(value, send)
        el.appendChild(domNode)
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


fun <Msg> diff(
    oldVNode: Html<Msg>,
    newVNode: Html<Msg>,
): dynamic {
    val patches = js("[]")
    diffHelp(oldVNode, newVNode, patches, 0)
    return patches
}

private fun diffHelp(
    oldVNode: dynamic,
    newVNode: dynamic,
    patches: dynamic,
    index: Int
): Int {
    if (oldVNode === newVNode)
        // Nothing changed, bail
        return index

    val oldTag = oldVNode["$"]
    val newTag = newVNode["$"]

    if (oldTag != newTag) {
        // The tags are different, so the structure has changed
        pushPatch(patches, PATCH_REDRAW, index, undefined)
        return index
    }

    when (newTag) {
        "TEXT" -> {
            if (oldVNode.value != newVNode.value) {
                pushPatch(patches, PATCH_REDRAW_TEXT, index, newVNode.value)
            }

            return index
        }

        "NODE" -> {
            val diff = diffAttributes(oldVNode.attributes, newVNode.attributes)
            if (diff != null) {
                pushPatch(patches, PATCH_ATTRS, index, diff)
            }

            return diffChildren(oldVNode.children, newVNode.children, patches, index)
        }

        else ->
            throw Error("Unknown Tag")
    }
}


private fun diffChildren(
    oldChildren: dynamic,
    newChildren: dynamic,
    patches: dynamic,
    index: Int
): Int {
    var curIdx = index
    val newLength = newChildren.length
    val oldLength = oldChildren.length

    if (newLength < oldLength) {
        pushPatch(patches, PATCH_REMOVE_FROM, index, newLength)
    }
    else if (oldLength < newLength) {
        pushPatch(patches, PATCH_ADD, index, oldLength)
    }

    var i: dynamic= 0
    val minLen = if (oldLength < newLength) oldLength else newLength
    while (i < minLen) {
        curIdx = diffHelp(oldChildren[i], newChildren[i], patches, ++curIdx)
        i++
    }

    return curIdx
}


private fun diffAttributes(oldAttrs: dynamic, newAttrs: dynamic, category: String? = null): dynamic {
    var diff: dynamic = js("undefined")
    val keys = js("Object").keys(oldAttrs)
    var i: dynamic = 0
    while (i < keys.length) {
        val key = keys[i]
        if (key == ATTRIBUTE_ATTR || key == ATTRIBUTE_EVENTS || key == ATTRIBUTE_STYLE) {
            js("diff = diff || {}")
            diff[key] = diffAttributes(oldAttrs[key], newAttrs[key], key)
            i++
            continue
        }

        js("newAttrs = newAttrs || {}")
        if (!(js("key in newAttrs"))) {
            js("diff = diff || {}")
            js("diff[key] = undefined")
            i++
            continue
        }

        val oldValue = oldAttrs[key]
        val newValue = newAttrs[key]

        if (oldValue == newValue) {
            i++
            continue
        }

        js("diff = diff || {}")
        js("diff[key] = newValue")
        i++
    }

    val newKeys = js("Object").keys(newAttrs)
    var j: dynamic = 0
    while (j < newAttrs.length) {
        val curKey = newKeys[j]
        js("diff = diff || {}")
        js("diff[curKey] = newAttrs[curKey]")
        j++
    }

    return diff
}


private fun pushPatch(patches: dynamic, patchType: String, index: Int, data: dynamic) {
    val patch = js("{$: patchType, index: index, data: data, domNode: undefined, send: undefined}")
    patches.push(patch)
}


private fun <Msg> addDomNodes(patches: dynamic, domNode: Node, send: (Msg) -> Unit) {
    addDomNodesHelp(patches, domNode, 0, send)
}

private fun <Msg> addDomNodesHelp(patches: dynamic, domNode: Node, index: Int, send: (Msg) -> Unit): Int {
    val patchLength = patches.length
    var i: dynamic = index
    while (i < patchLength) {
        val patch = patches[i]
        if (patch.index == i) {
            patch.domNode = domNode
            patch.send = send
            i++
        }
        else {
            val children = domNode.childNodes
            val childLength = children.length
            var childIdx = 0
            while (childIdx < childLength) {
                val childNode = children.get(childIdx).asDynamic()
                i = addDomNodesHelp<Msg>(patches, childNode, i, send)
                childIdx++
            }
        }
    }

    return i
}

fun <Msg> applyPatches(patches: dynamic, vNode: Html<Msg>, domNode: Node, send: (Msg) -> Unit): Node {
    if (patches.length == 0) {
        return domNode
    }

    addDomNodes<Msg>(patches, domNode, send)

    var i: dynamic = 0
    while (i < patches.length) {
        applyPatch(patches[i], vNode)
        i++
    }

    return domNode
}

private fun <Msg> applyPatch(patch: dynamic, vNode: Html<Msg>): Node {
    val patchType = patch["$"]
    when (patchType) {
        PATCH_REDRAW -> {
            val domNode = patch.domNode
            val el = render(vNode, patch.send)
            domNode.parentNode.replaceChild(el, domNode)
            return domNode
        }

        PATCH_REDRAW_TEXT -> {
            val domNode = patch.domNode
            domNode.replaceData(0, domNode.length, patch.data)
            return domNode
        }

        PATCH_ATTRS -> {
            val domNode = patch.domNode
            applyAttributes<Msg>(domNode, patch.data, patch.send)
            return domNode
        }

        PATCH_ADD -> {
            val n = vNode.asDynamic()
            val children = n.children
            val domNode = patch.domNode
            val from = patch.data
            var i: dynamic = from
            while (i < children.length) {
                domNode.appendChild(render<Msg>(children[i], patch.send))
                i++
            }

            return domNode
        }
    }

    throw Error("Unknown patch msg")
}


fun <Msg> virtualize(node: Node): Html<Msg> {
    if (node.nodeType == 3.asDynamic()) {
        return text(node.textContent ?: "")
    }

    if (node.nodeType != 1.asDynamic()) {
        return text("")
    }

    val el = node.asDynamic()

    val attrList = js("[]")
    val attrs = el.attributes
    var i: dynamic = 0
    while (i < attrs.length) {
        val attr = attrs[i]
        val name = attr.name
        val value = attr.value
        attrList.push(attribute<Msg>(name, value))
        i++
    }

    val tag = el.tagName.toLowerCase()
    val childList = js("[]")
    val children = el.children
    var j: dynamic = 0
    while (j < children.length) {
        childList.push(children[i])
        j++
    }

    return node(tag, attrList, childList)
}
