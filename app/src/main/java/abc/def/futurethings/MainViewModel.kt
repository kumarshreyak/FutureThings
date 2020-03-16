package abc.def.futurethings

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import retrofit2.Response

class MainViewModel: ViewModel()
{
    var coolResponse: MutableLiveData<CoolResponse> = MutableLiveData()

    // Do async network call to fetch data
    fun fetchData(request: String) {
        // Do async network api call
        val someObserver = getNewObserver()
        CoolNetworkService.getCoolNetworkInterface().getCoolData(request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(someObserver)
    }


    fun getNewObserver(): Observer<Response<ResponseBody>> {
        return object: Observer<Response<ResponseBody>> {
            override fun onSubscribe(d: Disposable) {
                Log.d("onSubscribe", "Subscribed !!")
            }

            override fun onError(e: Throwable) {
                Log.d("onError", e.message.toString())
            }

            override fun onComplete() {
                Log.d("onComplete", "Completed !!")
            }

            override fun onNext(response: Response<ResponseBody>) {
                Log.d("onNext", "Response recieved  - " + response.code().toString())
                val gson = Gson()
                if(response.code() == 200) {
                    // Success
                    coolResponse.value = gson.fromJson(response.body()?.string(), CoolResponse::class.java)
                } else {
                    // Failure
                    coolResponse.value = gson.fromJson(response.body()?.string(), CoolResponse::class.java)
                }
            }

        }
    }
}