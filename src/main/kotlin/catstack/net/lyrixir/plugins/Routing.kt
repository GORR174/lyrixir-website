package catstack.net.lyrixir.plugins

import catstack.net.lyrixir.pages.artists.artists
import catstack.net.lyrixir.pages.artists.loadArtistsPage
import catstack.net.lyrixir.repository.ArtistRepository
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.body
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val artistRepository by inject<ArtistRepository>()

    routing {
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
    }
}
