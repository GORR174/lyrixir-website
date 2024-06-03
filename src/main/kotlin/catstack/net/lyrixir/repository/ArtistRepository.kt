package catstack.net.lyrixir.repository

import catstack.net.lyrixir.domain.GetArtistsResponseDto
import catstack.net.lyrixir.domain.ResponseDto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking

class ArtistRepository(private val httpClient: HttpClient) {
    fun getArtists(): GetArtistsResponseDto {
        return runBlocking {
            val endpoint = "artist/artists"
            val resp: ResponseDto<GetArtistsResponseDto> = httpClient.get(endpoint).body()

            return@runBlocking resp.response
        }
    }
}