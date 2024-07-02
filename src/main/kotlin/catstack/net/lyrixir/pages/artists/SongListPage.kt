package catstack.net.lyrixir.pages.artists

import catstack.net.lyrixir.components.searchBar
import catstack.net.lyrixir.components.title
import kotlinx.html.*

fun HTML.songs(artistId: Long) {
    classes = setOf("dark")
    head {
        title("Artists")
        script(src = "https://cdn.tailwindcss.com") {}
        script(src = "https://unpkg.com/htmx.org@1.9.12") {
            attributes["crossorigin"] = "anonymous"
            attributes["integrity"] = "sha384-ujb1lZYygJmzgSwoxRggbCHcjc0rB2XoQrxeTUQyRjrOnlCoYta87iKBWq3EsdM2"
        }
        link(href = "https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.css", rel = "stylesheet") {  }
        script(src = "https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.js") {}
        script(src = "/tailwind.config.js") {  }
    }
    body {
        div(classes = "h-screen bg-white dark:bg-gray-800") {
            div(classes = "grid gap-6 lg:gap-8 pb-12 lg:pb-24") {
                div(classes = "mx-auto max-w-6xl grid items-center justify-center gap-4 px-4 lg:gap-10") {
                    title(artistId.toString())
                    searchBar("Song name")
                }
                songContainer {

                }
            }
        }
    }
}

private fun DIV.songContainer(block: DIV.() -> Unit) {
    div(classes = "container mx-auto grid items-stretch justify-center gap-4 px-4 md:gap-6") {
        div(classes = "grid w-full grid-cols-2 items-center justify-center gap-4 md:grid-cols-4 md:gap-4") {
            block()
        }
    }
}