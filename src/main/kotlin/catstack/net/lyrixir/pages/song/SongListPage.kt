package catstack.net.lyrixir.pages.song

import catstack.net.lyrixir.components.baseBody
import catstack.net.lyrixir.components.basic
import catstack.net.lyrixir.components.searchBar
import catstack.net.lyrixir.components.title
import catstack.net.lyrixir.domain.SongDto
import catstack.net.lyrixir.repository.ArtistRepository
import catstack.net.lyrixir.repository.SongRepository
import kotlinx.html.*

fun HTML.songs(artistId: Long, artistRepository: ArtistRepository, songRepository: SongRepository) {
    val artist = artistRepository.getArtist(artistId)

    head {
        basic(artist.name)
    }

    baseBody {
        div(classes = "h-screen bg-white dark:bg-gray-800") {
            div(classes = "grid gap-6 lg:gap-8 pb-12 lg:pb-24") {
                div(classes = "mx-auto max-w-6xl grid items-center justify-center gap-4 px-4 lg:gap-10") {
                    title(artist.name)
                    searchBar("Song name")
                }
                songContainer {
                    div(classes = "w-6/12 min-w-96 relative overflow-x-auto shadow-md sm:rounded-lg") {
                        table(classes = "w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400") {
                            thead(classes = "text-xs text-gray-700 uppercase bg-gray-50 dark:bg-sky-950 dark:text-gray-400") {
                                tr {
                                    th(scope = ThScope.col, classes = "px-6 py-3") { +"song name" }
                                }
                            }
                            tbody {
                                songRepository.getAllSongs(artistId).forEach {
                                    song(it)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

private fun TBODY.song(song: SongDto) {
    tr(classes = "bg-white border-b dark:bg-gray-700 dark:border-gray-600 hover:bg-gray-50 dark:hover:bg-gray-600 cursor-pointer") {
        onClick = "location.href = 'song${song.id}';"
        th(scope = ThScope.row, classes = "px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white") {
            +song.songName
        }
    }
}

private fun DIV.songContainer(block: DIV.() -> Unit) {
    div(classes = "flex container mx-auto items-stretch justify-center gap-4 px-4 md:gap-6") {
        div(classes = "flex w-full items-center justify-center gap-4md:gap-4") {
            block()
        }
    }
}