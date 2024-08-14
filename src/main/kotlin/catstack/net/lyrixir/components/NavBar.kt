package catstack.net.lyrixir.components

import kotlinx.html.*

fun HtmlBlockTag.navBar() {
    nav(classes = "bg-white dark:bg-gray-900 fixed w-full z-20 top-0 start-0 border-b border-gray-200 dark:border-gray-600") {
        div(classes = "max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4") {
            a(href = "/", classes = "flex items-center space-x-3 rtl:space-x-reverse") {
                span(classes = "self-center text-2xl font-semibold whitespace-nowrap dark:text-white") { +"lyrixir" }
            }
            div(classes = "flex md:order-2 space-x3 md:space-x-0 rtl:space-x-reverse") {
                button(type = ButtonType.button, classes = "text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800") { +"New artist" }

                div(classes = "ps-4 flex flex-col justify-center ml-3") {
                    input(type = InputType.checkBox, name = "light-switch", classes = "light-switch sr-only") {
                        attributes["id"] = "light-switch"
                    }
                    label(classes = "relative cursor-pointer p-2") {
                        attributes["for"] = "light-switch"
                        svg(classes = "dark:hidden") {
                            attributes["width"] = "16"
                            attributes["height"] = "16"
                            path {
                                attributes["class"] = "fill-slate-300"
                                attributes["d"] = "M7 0h2v2H7zM12.88 1.637l1.414 1.415-1.415 1.413-1.413-1.414zM14 7h2v2h-2zM12.95 14.433l-1.414-1.413 1.413-1.415 1.415 1.414zM7 14h2v2H7zM2.98 14.364l-1.413-1.415 1.414-1.414 1.414 1.415zM0 7h2v2H0zM3.05 1.706 4.463 3.12 3.05 4.535 1.636 3.12z"
                            }
                            path {
                                attributes["class"] = "fill-slate-400"
                                attributes["d"] = "M8 4C5.8 4 4 5.8 4 8s1.8 4 4 4 4-1.8 4-4-1.8-4-4-4Z"
                            }
                        }
                        svg(classes = "hidden dark:block") {
                            attributes["width"] = "16"
                            attributes["height"] = "16"
                            path {
                                attributes["class"] = "fill-slate-400"
                                attributes["d"] = "M6.2 1C3.2 1.8 1 4.6 1 7.9 1 11.8 4.2 15 8.1 15c3.3 0 6-2.2 6.9-5.2C9.7 11.2 4.8 6.3 6.2 1Z"
                            }
                            path {
                                attributes["class"] = "fill-slate-500"
                                attributes["d"] = "M12.5 5a.625.625 0 0 1-.625-.625 1.252 1.252 0 0 0-1.25-1.25.625.625 0 1 1 0-1.25 1.252 1.252 0 0 0 1.25-1.25.625.625 0 1 1 1.25 0c.001.69.56 1.249 1.25 1.25a.625.625 0 1 1 0 1.25c-.69.001-1.249.56-1.25 1.25A.625.625 0 0 1 12.5 5Z"
                            }
                        }
                    }
                    span(classes = "sr-only") {
                        +"Switch to light / dark version"
                    }
                }

                button(type = ButtonType.button, classes = "inline-flex items-center p-2 w-10 h-10 justify-center text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600") {
                    attributes["data-collapse-toggle"] = "navbar-sticky"
                    attributes["aria-controls"] = "navbar-sticky"
                    attributes["aria-expanded"] = "false"
                    span(classes = "sr-only") { +"Open main menu" }
                    svg(classes = "w-5 h-5") {
                        attributes["aria-hidden"] = "true"
                        attributes["fill"] = "none"
                        attributes["viewBox"] = "0 0 17 14"
                        path {
                            attributes["stroke"] = "currentColor"
                            attributes["stroke-linecap"] = "round"
                            attributes["stroke-linejoin"] = "round"
                            attributes["stroke-width"] = "2"
                            attributes["d"] = "M1 1h15M1 7h15M1 13h15"
                        }
                    }
                }
            }
            div(classes = "items-center justify-between hidden w-full md:flex md:w-auto md:order-1") {
                attributes["id"] = "navbar-sticky"
                ul(classes = "flex flex-col p-4 md:p-0 mt-4 font-medium border border-gray-100 rounded-lg bg-gray-50 md:space-x-8 rtl:space-x-reverse md:flex-row md:mt-0 md:border-0 md:bg-white dark:bg-gray-800 md:dark:bg-gray-900 dark:border-gray-700") {
                    li {
                        a(href = "/", classes = "block py-2 px-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 md:dark:text-blue-500") {
                            attributes["aria-current"] = "page"
                            +"Home"
                        }
                    }
                    li {
                        a(href = "/", classes = "block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 md:dark:hover:text-blue-500 dark:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700") {
//                            attributes["aria-current"] = "page"
                            +"about"
                        }
                    }
                }
            }
        }
    }
}