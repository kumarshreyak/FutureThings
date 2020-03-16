package abc.def.futurethings

import abc.def.futurethings.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Data binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        val viewModel: MainViewModel by viewModels()
        this.viewModel = viewModel
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.coolResponse.observe(this, Observer {
            binding.ourText.setText(it.result.get(0).country)
        })
    }

    fun searchItBro(view: View) {
        viewModel.fetchData(binding.userEt.text.toString())
    }
}
