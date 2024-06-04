package catstack.net.lyrixir.pages.artists

import catstack.net.lyrixir.repository.ArtistRepository
import kotlinx.html.*
import kotlin.collections.forEach
import kotlin.collections.set

fun HTML.artists(artistRepository: ArtistRepository) {
    head {
        title("Artists")
        script(src = "https://cdn.tailwindcss.com") {}
        script(src = "https://unpkg.com/htmx.org@1.9.12") {
            attributes["crossorigin"] = "anonymous"
            attributes["integrity"] = "sha384-ujb1lZYygJmzgSwoxRggbCHcjc0rB2XoQrxeTUQyRjrOnlCoYta87iKBWq3EsdM2"
        }
    }
    body {
        div(classes = "grid gap-6 lg:gap-8 pb-12 lg:pb-24") {
            div(classes = "mx-auto max-w-6xl grid items-center justify-center gap-4 px-4 lg:gap-10") {
                name()
                searchBar()
            }
            artistContainer {
                loadArtistsPage(0, artistRepository)
            }
        }
    }
}

private fun DIV.artistContainer(block: DIV.() -> Unit) {
    div(classes = "container mx-auto grid items-stretch justify-center gap-4 px-4 md:gap-6") {
        div(classes = "grid w-full grid-cols-2 items-center justify-center gap-4 md:grid-cols-4 md:gap-4") {
            block()
        }
    }
}

fun HtmlBlockTag.loadArtistsPage(page: Int, artistRepository: ArtistRepository) {
    val artists = artistRepository.getArtists(page, 1).artists.apply {
        forEach {
            artist(it.name, it.profileImage)
        }
    }
    if (artists.isNotEmpty()) {
        loadNextPageBlock(page + 1)
    }
}

fun HtmlBlockTag.artist(
    name: String,
    img: String? = "https://news.store.rambler.ru/img/72b877a200c444a64236e279f888bede?img-1-resize=width%3A1280%2Cheight%3A1280%2Cfit%3Acover&img-format=auto"
) {
    val img = img ?: "https://news.store.rambler.ru/img/72b877a200c444a64236e279f888bede?img-1-resize=width%3A1280%2Cheight%3A1280%2Cfit%3Acover&img-format=auto"
    div(classes = "flex bg-gray-300 flex-col gap-2 group p-4 rounded hover:bg-gray-200 cursor-pointer") {
        img(
            src = img,
            alt = name, classes = "rounded-xl object-cover aspect-square max-w-[250px]"
        )
        div(classes = "flex flex-col gap-1") {
            h3(classes = "text-xl font-semibold") { +name }
        }
    }
}

fun HtmlBlockTag.loadNextPageBlock(nextPage: Int) {
    div(classes = "flex bg-gray-300 flex-col gap-2 group p-4 rounded hover:bg-gray-200 cursor-pointer") {
        attributes["hx-get"] = "/artistNextPage?page=$nextPage"
        attributes["hx-trigger"] = "click"
        attributes["hx-swap"] = "outerHTML"

        div(classes = "flex flex-col gap-1") {
            h3(classes = "text-xl font-semibold") { +"Load more" }
        }
    }
}

private fun DIV.name() {
    div(classes = "space-y-1 text-center") {
        h1(classes = "text-3xl font-bold tracking-tighter sm:text-4xl md:text-5xl") {
            +"Artists"
        }
    }
}

private fun DIV.searchBar() {
    div(
        classes = "w-full max-w-[300px] md:max-w-[500px] mx-auto rounded-lg " +
                "border border-gray-200 border-dashed dark:border-gray-800"
    ) {
        div(
            classes = "flex h-10 items-center rounded-lg bg-gray-100 border border-gray-200 border-gray-200 " +
                    "border-dashed border-b-0 dark:bg-gray-950 " +
                    "dark:border-gray-800 dark:border-gray-800 dark:border-gray-800"
        ) {
            input(
                classes = "flex w-full rounded-md border-input py-2 ring-offset-background file:border-0 " +
                        "file:bg-transparent file:text-sm file:font-medium placeholder:text-muted-foreground " +
                        "focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring " +
                        "focus-visible:ring-offset-2 disabled:cursor-not-allowed disabled:opacity-50 flex-1 " +
                        "h-full appearance-none bg-transparent border-0 border-l-0 px-4 text-sm " +
                        "dark:placeholder-gray-300 dark:color-gray-50",
                type = InputType.text
            ) {
                placeholder = "Search artist"
            }
            button(
                classes = "inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm " +
                        "font-medium ring-offset-background transition-colors focus-visible:outline-none " +
                        "focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 " +
                        "disabled:pointer-events-none disabled:opacity-50 hover:bg-accent " +
                        "hover:text-accent-foreground h-full p-3"
            ) {
                svg(classes = "w-4 h-4") {
                    attributes["width"] = "24"
                    attributes["height"] = "24"
                    attributes["viewBox"] = "0 0 24 24"
                    attributes["fill"] = "none"
                    attributes["stroke"] = "white"
                    attributes["stoke-width"] = "2"
                    attributes["stoke-linecap"] = "round"
                    attributes["stoke-linejoin"] = "round"


                }
                span(classes = "sr-only") {
                    +"Search"
                }
            }
        }
    }
}