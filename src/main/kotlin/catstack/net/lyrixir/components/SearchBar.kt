package catstack.net.lyrixir.components

import kotlinx.html.*

fun DIV.searchBar(placeholderText: String) {
    form(
        classes = "max-w-md mx-auto"
    ) {
        div(
            classes = "relative"
        ) {
            div(
                classes = "absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none"
            ) {
                svg(
                    classes = "w-4 h-4 text-gray-500 dark:text-gray-400"
                ) {
                    attributes["aria-hidden"] = "true"
                    attributes["fill"] = "none"
                    attributes["viewBox"] = "0 0 20 20"

                    path {
                        attributes["stroke"] = "currentColor"
                        attributes["stroke-linecap"] = "round"
                        attributes["stroke-linejoin"] = "round"
                        attributes["stroke-width"] = "2"
                        attributes["d"] = "m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z"
                    }
                }
            }
            input(type = InputType.search, classes = "block w-96 p-4 ps-10 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500") {
                id = "default-search"
                placeholder = placeholderText
            }
            button(type = ButtonType.submit, classes = "text-white absolute end-2.5 bottom-2.5 bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800") {
                +"Search"
            }
        }
    }
}

class Path(consumer: TagConsumer<*>) : HTMLTag("path", consumer, mapOf(), null, true, false), HtmlInlineTag

fun FlowOrPhrasingContent.path(block: Path.() -> Unit = {}) {
    Path(consumer).visit(block)
}

