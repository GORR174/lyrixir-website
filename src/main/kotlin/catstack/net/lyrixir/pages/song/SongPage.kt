package catstack.net.lyrixir.pages.song

import catstack.net.lyrixir.components.*
import catstack.net.lyrixir.domain.SongDto
import catstack.net.lyrixir.repository.ArtistRepository
import catstack.net.lyrixir.repository.SongRepository
import kotlinx.html.*

fun HTML.song(songId: Long, artistRepository: ArtistRepository, songRepository: SongRepository) {
//    val artist = artistRepository.getArtist(artistId)
    val song = songRepository.getById(songId)

    head {
        basic(song.songName)
    }

    baseBodyContainer {
        titleWithSearchBar(song.songName, "Song name")
        songContainer {
            div(classes = "whitespace-pre-line min-w-96 dark:text-white") {
                +(song.text ?: "Song not found!")
            }
        }
    }
}

private fun DIV.songContainer(block: DIV.() -> Unit) {
    div(classes = "flex container mx-auto items-stretch justify-center gap-4 pt-8 px-4 md:gap-6") {
        div(classes = "flex w-full ps-32 gap-4md:gap-4") {
            block()
        }
    }
}