package catstack.net.lyrixir.repository

import catstack.net.lyrixir.domain.ArtistDto
import catstack.net.lyrixir.domain.GetArtistsResponseDto
import catstack.net.lyrixir.domain.ResponseDto
import catstack.net.lyrixir.domain.SongDto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking

class SongRepository(private val httpClient: HttpClient) {
    fun getAllSongs(artistId: Long): List<SongDto> {
        return runBlocking {
            val endpoint = "song/getAllSongs?artistId=$artistId"
            val resp: ResponseDto<List<SongDto>> = httpClient.get(endpoint).body()

            return@runBlocking resp.response
        }
    }
}