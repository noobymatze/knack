package io.noobymatze.knack.html

import io.noobymatze.knack.vdom.Attribute
import io.noobymatze.knack.vdom.VNode
import io.noobymatze.knack.vdom.node
import io.noobymatze.knack.vdom.on


typealias Html<Msg> = VNode<Msg>

fun <Msg> text(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("text", attributes, children)

fun <Msg> text(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("text", attributes, children)

fun <Msg> node(tag: String, attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node(tag, attributes, children)

fun <Msg> map(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("map", attributes, children)

fun <Msg> map(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("map", attributes, children)

fun <Msg> h1(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("h1", attributes, children)

fun <Msg> h1(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("h1", attributes, children)

fun <Msg> h2(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("h2", attributes, children)

fun <Msg> h2(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("h2", attributes, children)

fun <Msg> h3(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("h3", attributes, children)

fun <Msg> h3(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("h3", attributes, children)

fun <Msg> h4(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("h4", attributes, children)

fun <Msg> h4(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("h4", attributes, children)

fun <Msg> h5(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("h5", attributes, children)

fun <Msg> h5(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("h5", attributes, children)

fun <Msg> h6(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("h6", attributes, children)

fun <Msg> h6(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("h6", attributes, children)

fun <Msg> div(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("div", attributes, children)

fun <Msg> div(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("div", attributes, children)

fun <Msg> p(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("p", attributes, children)

fun <Msg> p(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("p", attributes, children)

fun <Msg> hr(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("hr", attributes, children)

fun <Msg> hr(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("hr", attributes, children)

fun <Msg> pre(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("pre", attributes, children)

fun <Msg> pre(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("pre", attributes, children)

fun <Msg> blockquote(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("blockquote", attributes, children)

fun <Msg> blockquote(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("blockquote", attributes, children)

fun <Msg> span(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("span", attributes, children)

fun <Msg> span(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("span", attributes, children)

fun <Msg> a(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("a", attributes, children)

fun <Msg> a(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("a", attributes, children)

fun <Msg> code(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("code", attributes, children)

fun <Msg> code(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("code", attributes, children)

fun <Msg> em(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("em", attributes, children)

fun <Msg> em(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("em", attributes, children)

fun <Msg> strong(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("strong", attributes, children)

fun <Msg> strong(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("strong", attributes, children)

fun <Msg> i(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("i", attributes, children)

fun <Msg> i(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("i", attributes, children)

fun <Msg> b(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("b", attributes, children)

fun <Msg> b(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("b", attributes, children)

fun <Msg> u(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("u", attributes, children)

fun <Msg> u(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("u", attributes, children)

fun <Msg> sub(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("sub", attributes, children)

fun <Msg> sub(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("sub", attributes, children)

fun <Msg> sup(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("sup", attributes, children)

fun <Msg> sup(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("sup", attributes, children)

fun <Msg> br(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("br", attributes, children)

fun <Msg> br(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("br", attributes, children)

fun <Msg> ol(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("ol", attributes, children)

fun <Msg> ol(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("ol", attributes, children)

fun <Msg> ul(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("ul", attributes, children)

fun <Msg> ul(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("ul", attributes, children)

fun <Msg> li(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("li", attributes, children)

fun <Msg> li(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("li", attributes, children)

fun <Msg> dl(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("dl", attributes, children)

fun <Msg> dl(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("dl", attributes, children)

fun <Msg> dt(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("dt", attributes, children)

fun <Msg> dt(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("dt", attributes, children)

fun <Msg> dd(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("dd", attributes, children)

fun <Msg> dd(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("dd", attributes, children)

fun <Msg> img(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("img", attributes, children)

fun <Msg> img(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("img", attributes, children)

fun <Msg> iframe(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("iframe", attributes, children)

fun <Msg> iframe(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("iframe", attributes, children)

fun <Msg> canvas(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("canvas", attributes, children)

fun <Msg> canvas(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("canvas", attributes, children)

fun <Msg> math(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("math", attributes, children)

fun <Msg> math(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("math", attributes, children)

fun <Msg> form(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("form", attributes, children)

fun <Msg> form(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("form", attributes, children)

fun <Msg> input(vararg attributes: Attribute<Msg>): Html<Msg> =
    node("input", attributes, arrayOf())

fun <Msg> textarea(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("textarea", attributes, children)

fun <Msg> textarea(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("textarea", attributes, children)

fun <Msg> button(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("button", attributes, children)

fun <Msg> button(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("button", attributes, children)

fun <Msg> select(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("select", attributes, children)

fun <Msg> select(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("select", attributes, children)

fun <Msg> option(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("option", attributes, children)

fun <Msg> option(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("option", attributes, children)

fun <Msg> section(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("section", attributes, children)

fun <Msg> section(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("section", attributes, children)

fun <Msg> nav(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("nav", attributes, children)

fun <Msg> nav(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("nav", attributes, children)

fun <Msg> article(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("article", attributes, children)

fun <Msg> article(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("article", attributes, children)

fun <Msg> aside(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("aside", attributes, children)

fun <Msg> aside(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("aside", attributes, children)

fun <Msg> header(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("header", attributes, children)

fun <Msg> header(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("header", attributes, children)

fun <Msg> footer(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("footer", attributes, children)

fun <Msg> footer(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("footer", attributes, children)

fun <Msg> address(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("address", attributes, children)

fun <Msg> address(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("address", attributes, children)

fun <Msg> main_(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("main_", attributes, children)

fun <Msg> main_(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("main_", attributes, children)

fun <Msg> figure(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("figure", attributes, children)

fun <Msg> figure(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("figure", attributes, children)

fun <Msg> figcaption(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("figcaption", attributes, children)

fun <Msg> figcaption(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("figcaption", attributes, children)

fun <Msg> table(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("table", attributes, children)

fun <Msg> table(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("table", attributes, children)

fun <Msg> caption(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("caption", attributes, children)

fun <Msg> caption(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("caption", attributes, children)

fun <Msg> colgroup(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("colgroup", attributes, children)

fun <Msg> colgroup(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("colgroup", attributes, children)

fun <Msg> col(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("col", attributes, children)

fun <Msg> col(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("col", attributes, children)

fun <Msg> tbody(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("tbody", attributes, children)

fun <Msg> tbody(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("tbody", attributes, children)

fun <Msg> thead(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("thead", attributes, children)

fun <Msg> thead(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("thead", attributes, children)

fun <Msg> tfoot(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("tfoot", attributes, children)

fun <Msg> tfoot(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("tfoot", attributes, children)

fun <Msg> tr(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("tr", attributes, children)

fun <Msg> tr(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("tr", attributes, children)

fun <Msg> td(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("td", attributes, children)

fun <Msg> td(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("td", attributes, children)

fun <Msg> th(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("th", attributes, children)

fun <Msg> th(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("th", attributes, children)

fun <Msg> fieldset(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("fieldset", attributes, children)

fun <Msg> fieldset(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("fieldset", attributes, children)

fun <Msg> legend(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("legend", attributes, children)

fun <Msg> legend(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("legend", attributes, children)

fun <Msg> label(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("label", attributes, children)

fun <Msg> label(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("label", attributes, children)

fun <Msg> datalist(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("datalist", attributes, children)

fun <Msg> datalist(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("datalist", attributes, children)

fun <Msg> optgroup(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("optgroup", attributes, children)

fun <Msg> optgroup(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("optgroup", attributes, children)

fun <Msg> output(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("output", attributes, children)

fun <Msg> output(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("output", attributes, children)

fun <Msg> progress(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("progress", attributes, children)

fun <Msg> progress(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("progress", attributes, children)

fun <Msg> meter(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("meter", attributes, children)

fun <Msg> meter(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("meter", attributes, children)

fun <Msg> audio(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("audio", attributes, children)

fun <Msg> audio(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("audio", attributes, children)

fun <Msg> video(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("video", attributes, children)

fun <Msg> video(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("video", attributes, children)

fun <Msg> source(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("source", attributes, children)

fun <Msg> source(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("source", attributes, children)

fun <Msg> track(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("track", attributes, children)

fun <Msg> track(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("track", attributes, children)

fun <Msg> embed(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("embed", attributes, children)

fun <Msg> embed(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("embed", attributes, children)

fun <Msg> `object`(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("object", attributes, children)

fun <Msg> `object`(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("object", attributes, children)

fun <Msg> param(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("param", attributes, children)

fun <Msg> param(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("param", attributes, children)

fun <Msg> ins(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("ins", attributes, children)

fun <Msg> ins(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("ins", attributes, children)

fun <Msg> del(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("del", attributes, children)

fun <Msg> del(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("del", attributes, children)

fun <Msg> small(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("small", attributes, children)

fun <Msg> small(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("small", attributes, children)

fun <Msg> cite(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("cite", attributes, children)

fun <Msg> cite(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("cite", attributes, children)

fun <Msg> dfn(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("dfn", attributes, children)

fun <Msg> dfn(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("dfn", attributes, children)

fun <Msg> abbr(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("abbr", attributes, children)

fun <Msg> abbr(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("abbr", attributes, children)

fun <Msg> time(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("time", attributes, children)

fun <Msg> time(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("time", attributes, children)

fun <Msg> `var`(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("var", attributes, children)

fun <Msg> `var`(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("var", attributes, children)

fun <Msg> samp(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("samp", attributes, children)

fun <Msg> samp(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("samp", attributes, children)

fun <Msg> kbd(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("kbd", attributes, children)

fun <Msg> kbd(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("kbd", attributes, children)

fun <Msg> s(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("s", attributes, children)

fun <Msg> s(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("s", attributes, children)

fun <Msg> q(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("q", attributes, children)

fun <Msg> q(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("q", attributes, children)

fun <Msg> mark(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("mark", attributes, children)

fun <Msg> mark(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("mark", attributes, children)

fun <Msg> ruby(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("ruby", attributes, children)

fun <Msg> ruby(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("ruby", attributes, children)

fun <Msg> rt(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("rt", attributes, children)

fun <Msg> rt(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("rt", attributes, children)

fun <Msg> rp(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("rp", attributes, children)

fun <Msg> rp(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("rp", attributes, children)

fun <Msg> bdi(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("bdi", attributes, children)

fun <Msg> bdi(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("bdi", attributes, children)

fun <Msg> bdo(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("bdo", attributes, children)

fun <Msg> bdo(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("bdo", attributes, children)

fun <Msg> wbr(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("wbr", attributes, children)

fun <Msg> wbr(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("wbr", attributes, children)

fun <Msg> details(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("details", attributes, children)

fun <Msg> details(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("details", attributes, children)

fun <Msg> summary(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("summary", attributes, children)

fun <Msg> summary(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("summary", attributes, children)

fun <Msg> menuitem(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("menuitem", attributes, children)

fun <Msg> menuitem(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("menuitem", attributes, children)

fun <Msg> menu(attributes: Array<out Attribute<Msg>>, children: Array<out Html<Msg>>): Html<Msg> =
    node("menu", attributes, children)

fun <Msg> menu(attributes: Array<out Attribute<Msg>>, vararg children: Html<Msg>): Html<Msg> =
    node("menu", attributes, children)
