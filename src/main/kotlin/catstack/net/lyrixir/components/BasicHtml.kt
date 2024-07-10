package catstack.net.lyrixir.components

import io.ktor.server.application.*
import io.ktor.server.html.*
import kotlinx.html.*

fun HtmlHeadTag.basic(title: String) {
    title(title)
    link(href = "https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.css", rel = "stylesheet") {  }
}

fun HtmlBlockTag.scripts() {
    script(src = "https://cdn.tailwindcss.com") {}
    script(src = "https://unpkg.com/htmx.org@1.9.12") {
        attributes["crossorigin"] = "anonymous"
        attributes["integrity"] = "sha384-ujb1lZYygJmzgSwoxRggbCHcjc0rB2XoQrxeTUQyRjrOnlCoYta87iKBWq3EsdM2"
    }
    script(src = "https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.js") {}
    script(src = "/tailwind.config.js") {  }
}

@HtmlTagMarker fun HTML.baseBody(block: BODY.() -> Unit) {
    body {
        block(this)

        scripts()
    }
}

suspend fun ApplicationCall.respondDarkHtml(block: HTML.() -> Unit) {
    respondHtml {
        classes = setOf("dark")

        block(this)
    }
}