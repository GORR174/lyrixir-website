package catstack.net.lyrixir.plugins

import catstack.net.lyrixir.pages.artists.artists
import catstack.net.lyrixir.repository.ArtistRepository
import io.ktor.client.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent.inject
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val artistRepository by inject<ArtistRepository>()

    routing {
        get("/") {
            call.respondHtml {
                artists(artistRepository)
            }
        }
    }
}
