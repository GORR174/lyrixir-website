package catstack.net.lyrixir.repository

import catstack.net.lyrixir.domain.ArtistDto
import catstack.net.lyrixir.domain.GetArtistsResponseDto
import catstack.net.lyrixir.domain.ResponseDto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking

class ArtistRepository(private val httpClient: HttpClient) {
    fun getArtists(page: Int, size: Int): GetArtistsResponseDto {
        return runBlocking {
            val endpoint = "artist/artists?page=$page&size=$size"
            val resp: ResponseDto<GetArtistsResponseDto> = httpClient.get(endpoint).body()

            return@runBlocking resp.response
        }
    }

    fun getArtist(id: Long): ArtistDto {
        return runBlocking {
            val endpoint = "artist/getArtist?id=$id"
            val resp: ResponseDto<ArtistDto> = httpClient.get(endpoint).body()

            return@runBlocking resp.response
        }
    }
}