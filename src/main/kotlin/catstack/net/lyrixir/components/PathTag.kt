package catstack.net.lyrixir.components

import kotlinx.html.*

class PathTag(consumer: TagConsumer<*>) : HTMLTag("path", consumer, mapOf(), null, true, false), HtmlInlineTag

@HtmlTagMarker
fun HtmlBlockTag.path(block: PathTag.() -> Unit = {}) {
    PathTag(consumer).visit(block)
}