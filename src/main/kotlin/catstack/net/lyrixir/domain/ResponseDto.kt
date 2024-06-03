package catstack.net.lyrixir.domain

data class ResponseDto<T>(val status: Int, val error: Any, val response: T)