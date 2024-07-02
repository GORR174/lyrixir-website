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