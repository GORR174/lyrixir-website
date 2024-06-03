package catstack.net.lyrixir.di

import catstack.net.lyrixir.repository.ArtistRepository
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.gson.*
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    single<HttpClient> {
        HttpClient(CIO) {
            defaultRequest {
                url("http://localhost:8080/api/")
            }
            install(ContentNegotiation) {
                gson()
            }
        }
    }

    singleOf(::ArtistRepository)
}