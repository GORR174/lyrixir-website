package catstack.net.lyrixir.components

import kotlinx.html.DIV
import kotlinx.html.div
import kotlinx.html.h1

fun DIV.title(title: String) {
    div(classes = "space-y-1 text-center") {
        h1(classes = "text-3xl font-bold tracking-tighter sm:text-4xl md:text-5xl dark:text-white") {
            +title
        }
    }
}

fun DIV.titleContainer(block: DIV.() -> Unit) {
    div(classes = "mx-auto max-w-6xl grid items-center justify-center gap-4 px-4 pt-4 lg:gap-10") {
        block()
    }
}

fun DIV.titleWithSearchBar(title: String, placeholderText: String) {
    titleContainer {
        title(title)
        searchBar(placeholderText)
    }
}