package catstack.net.lyrixir.pages.artists

import catstack.net.lyrixir.components.*
import catstack.net.lyrixir.domain.ArtistDto
import catstack.net.lyrixir.repository.ArtistRepository
import kotlinx.html.*
import kotlin.collections.forEach
import kotlin.collections.set

fun HTML.artists(artistRepository: ArtistRepository) {
    head {
        basic("Artists")
    }
    baseBody {
        div(classes = "h-screen bg-white dark:bg-gray-800") {
            div(classes = "grid gap-6 lg:gap-8 pb-12 lg:pb-24") {
                div(classes = "mx-auto max-w-6xl grid items-center justify-center gap-4 px-4 lg:gap-10") {
                    title("Artists")
                    searchBar("Artist name")
                }
                artistContainer {
                    loadArtistsPage(0, artistRepository)
                }
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
    val artists = artistRepository.getArtists(page, 2).artists.apply {
        forEach(::artist)
    }
    if (artists.isNotEmpty()) {
        loadNextPageBlock(page + 1)
    }
}

fun HtmlBlockTag.artist(artist: ArtistDto) {
    val img = artist.profileImage ?: "https://news.store.rambler.ru/img/72b877a200c444a64236e279f888bede?img-1-resize=width%3A1280%2Cheight%3A1280%2Cfit%3Acover&img-format=auto"
    div(classes = "flex bg-gray-300 flex-col gap-2 group p-4 rounded hover:bg-gray-200 dark:bg-slate-800 dark:hover:bg-slate-700 cursor-pointer") {
        onClick = "location.href = 'artist${artist.id}';"
        img(
            src = img,
            alt = artist.name, classes = "rounded-xl object-cover aspect-square max-w-[250px]"
        )
        div(classes = "flex flex-col gap-1") {
            h3(classes = "text-xl font-semibold dark:text-white") { +artist.name }
        }
    }
}

fun HtmlBlockTag.loadNextPageBlock(nextPage: Int) {
    div(classes = "flex bg-gray-300 dark:bg-slate-700 flex-col gap-2 group p-4 rounded hover:bg-gray-200 dark:hover:bg-slate-600 cursor-pointer") {
        attributes["hx-get"] = "/artistNextPage?page=$nextPage"
        attributes["hx-trigger"] = "click"
        attributes["hx-swap"] = "outerHTML"

        div(classes = "flex flex-col gap-1") {
            h3(classes = "text-xl font-semibold dark:text-white") { +"Load more" }
        }
    }
}