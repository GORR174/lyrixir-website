package catstack.net.lyrixir.plugins

import catstack.net.lyrixir.pages.artists.artists
import catstack.net.lyrixir.pages.artists.loadArtistsPage
import catstack.net.lyrixir.pages.artists.songs
import catstack.net.lyrixir.repository.ArtistRepository
import catstack.net.lyrixir.repository.SongRepository
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import kotlinx.html.body
import org.koin.ktor.ext.inject
import java.io.File

fun Application.configureRouting() {
    val artistRepository by inject<ArtistRepository>()
    val songRepository by inject<SongRepository>()

    routing {
        staticResources("/", "static.config")
//        staticResources("/", "config")
        staticResources("/resources", "static")
        get("/") {
            call.respondHtml {
                artists(artistRepository)
            }
        }
        get("/artistNextPage") {
            call.respondHtml { body {
                val page = call.request.queryParameters["page"]?.toInt() ?: 0
                loadArtistsPage(page, artistRepository)
            } }
        }
        get("/artist{id}") {
            println(call.parameters["id"])
            call.respondHtml {
                songs(call.parameters["id"]?.toLongOrNull() ?: -1, artistRepository, songRepository)
            }
        }
    }
}
