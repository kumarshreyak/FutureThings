package abc.def.futurethings

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface CoolNetworkInterface {

    @GET("user.info")
    fun getCoolData(@Query("handles") userId: String): Observable<Response<ResponseBody>>
}