package catstack.net.lyrixir.plugins

import catstack.net.lyrixir.components.respondDarkHtml
import catstack.net.lyrixir.pages.artists.artists
import catstack.net.lyrixir.pages.artists.loadArtistsPage
import catstack.net.lyrixir.pages.song.song
import catstack.net.lyrixir.pages.song.songs
import catstack.net.lyrixir.repository.ArtistRepository
import catstack.net.lyrixir.repository.SongRepository
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import kotlinx.html.body
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val artistRepository by inject<ArtistRepository>()
    val songRepository by inject<SongRepository>()

    routing {
        staticResources("/", "static.config")
        staticResources("/resources", "static")
        get("/") {
            call.respondDarkHtml {
                artists(artistRepository)
            }
        }
        get("/artistNextPage") {
            call.respondDarkHtml { body {
                val page = call.request.queryParameters["page"]?.toInt() ?: 0
                loadArtistsPage(page, artistRepository)
            } }
        }
        get("/artist{id}") {
            println(call.parameters["id"])
            call.respondDarkHtml {
                songs(call.parameters["id"]?.toLongOrNull() ?: -1, artistRepository, songRepository)
            }
        }
        get("/song{id}") {
            println(call.parameters["id"])
            call.respondDarkHtml {
                song(call.parameters["id"]?.toLongOrNull() ?: -1, artistRepository, songRepository)
            }
        }
    }
}
