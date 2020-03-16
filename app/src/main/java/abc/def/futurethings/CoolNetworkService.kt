package abc.def.futurethings

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CoolNetworkService() {
    companion object {
        fun getCoolNetworkInterface(): CoolNetworkInterface {
            val retrofit = Retrofit.Builder()
                .baseUrl(" https://codeforces.com/api/")
                .client(OkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(CoolNetworkInterface::class.java)
            return service
        }
    }
}