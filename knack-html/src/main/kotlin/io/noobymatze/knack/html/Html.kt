package io.noobymatze.knack.html

import io.noobymatze.knack.vdom.*
import io.noobymatze.knack.vdom.node
import org.w3c.dom.events.Event


typealias Html<Msg> = VNode<Msg>

/**
 *
 * @param key
 * @param value
 * @return
 */
fun <Msg> attribute(
    key: String,
    value: String
): Attribute<Msg> =
    io.noobymatze.knack.vdom.attribute(key, value)

/**
 *
 * @param key
 * @param handler
 * @return
 */
fun <Msg> on(
    key: String,
    handler: (Event) -> Msg
): Attribute<Msg> =
    io.noobymatze.knack.vdom.on(key, handler)

/**
 *
 * @param property
 * @param value
 * @return
 */
fun <Msg> style(property: String, value: String): Attribute<Msg> =
    io.noobymatze.knack.vdom.style(property, value)

/**
 *
 */
fun <Msg> text(content: String): Html<Msg> =
    io.noobymatze.knack.vdom.text(content)

/**
 *
 */
fun <Msg> node(tag: String, vararg modifier: Modifier<Msg>): Html<Msg> =
    io.noobymatze.knack.vdom.node(tag, modifier)

fun <Msg> h1(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("h1", modifier)

fun <Msg> h2(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("h2", modifier)

fun <Msg> h3(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("h3", modifier)

fun <Msg> h4(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("h4", modifier)

fun <Msg> h5(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("h5", modifier)

fun <Msg> h6(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("h6", modifier)

fun <Msg> div(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("div", modifier)

fun <Msg> p(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("p", modifier)

fun <Msg> hr(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("hr", modifier)

fun <Msg> pre(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("pre", modifier)

fun <Msg> blockquote(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("blockquote", modifier)

fun <Msg> span(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("span", modifier)

fun <Msg> a(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("a", modifier)

fun <Msg> code(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("code", modifier)

fun <Msg> em(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("em", modifier)

fun <Msg> strong(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("strong", modifier)

fun <Msg> i(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("i", modifier)

fun <Msg> b(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("b", modifier)

fun <Msg> u(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("u", modifier)

fun <Msg> sub(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("sub", modifier)

fun <Msg> sup(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("sup", modifier)

fun <Msg> br(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("br", modifier)

fun <Msg> ol(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("ol", modifier)

fun <Msg> ul(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("ul", modifier)

fun <Msg> li(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("li", modifier)

fun <Msg> dl(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("dl", modifier)

fun <Msg> dt(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("dt", modifier)

fun <Msg> dd(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("dd", modifier)

fun <Msg> img(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("img", modifier)

fun <Msg> iframe(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("iframe", modifier)

fun <Msg> canvas(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("canvas", modifier)

fun <Msg> math(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("math", modifier)

fun <Msg> form(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("form", modifier)

fun <Msg> input(vararg attributes: Attribute<Msg>): Html<Msg> =
    node("input", attributes, arrayOf())

fun <Msg> textarea(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("textarea", modifier)

fun <Msg> button(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("button", modifier)

fun <Msg> select(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("select", modifier)

fun <Msg> option(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("option", modifier)

fun <Msg> section(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("section", modifier)

fun <Msg> nav(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("nav", modifier)

fun <Msg> article(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("article", modifier)

fun <Msg> aside(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("aside", modifier)

fun <Msg> header(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("header", modifier)

fun <Msg> footer(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("footer", modifier)

fun <Msg> address(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("address", modifier)

fun <Msg> main_(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("main_", modifier)

fun <Msg> figure(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("figure", modifier)

fun <Msg> figcaption(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("figcaption", modifier)

fun <Msg> table(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("table", modifier)

fun <Msg> caption(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("caption", modifier)

fun <Msg> colgroup(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("colgroup", modifier)

fun <Msg> col(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("col", modifier)

fun <Msg> tbody(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("tbody", modifier)

fun <Msg> thead(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("thead", modifier)

fun <Msg> tfoot(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("tfoot", modifier)

fun <Msg> tr(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("tr", modifier)

fun <Msg> td(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("td", modifier)

fun <Msg> th(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("th", modifier)

fun <Msg> fieldset(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("fieldset", modifier)

fun <Msg> legend(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("legend", modifier)

fun <Msg> label(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("label", modifier)

fun <Msg> datalist(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("datalist", modifier)

fun <Msg> optgroup(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("optgroup", modifier)

fun <Msg> output(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("output", modifier)

fun <Msg> progress(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("progress", modifier)

fun <Msg> meter(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("meter", modifier)

fun <Msg> audio(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("audio", modifier)

fun <Msg> video(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("video", modifier)

fun <Msg> source(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("source", modifier)

fun <Msg> track(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("track", modifier)

fun <Msg> embed(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("embed", modifier)

fun <Msg> `object`(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("object", modifier)

fun <Msg> param(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("param", modifier)

fun <Msg> ins(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("ins", modifier)

fun <Msg> del(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("del", modifier)

fun <Msg> small(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("small", modifier)

fun <Msg> cite(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("cite", modifier)

fun <Msg> dfn(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("dfn", modifier)

fun <Msg> abbr(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("abbr", modifier)

fun <Msg> time(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("time", modifier)

fun <Msg> `var`(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("var", modifier)

fun <Msg> samp(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("samp", modifier)

fun <Msg> kbd(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("kbd", modifier)

fun <Msg> s(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("s", modifier)

fun <Msg> q(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("q", modifier)

fun <Msg> mark(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("mark", modifier)

fun <Msg> ruby(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("ruby", modifier)

fun <Msg> rt(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("rt", modifier)

fun <Msg> rp(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("rp", modifier)

fun <Msg> bdi(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("bdi", modifier)

fun <Msg> bdo(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("bdo", modifier)

fun <Msg> wbr(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("wbr", modifier)

fun <Msg> details(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("details", modifier)

fun <Msg> summary(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("summary", modifier)

fun <Msg> menuitem(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("menuitem", modifier)

fun <Msg> menu(vararg modifier: Modifier<Msg>): Html<Msg> =
    node("menu", modifier)

