package com.may.myandroidsamples

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.may.myandroidsamples.databinding.ActivityMainBinding
import com.may.myandroidsamples.viewmodel.User
import com.may.myandroidsamples.viewmodel.livedata.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    // Using LiveData
    private val viewModel: MyViewModel by lazy {
        //ViewModelProvider.of(this).get(MyViewModel::class.java)
        ViewModelProvider.NewInstanceFactory().create(MyViewModel::class.java)
    }

    private val changeObserver =
        Observer<Int> {
                value -> value?.let { incrementCount(value) }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Using DataBinding
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.user = User("May", "Park")


        // Set MyHandlers
        binding.handlers = MyHandlers()


        // Conditional
        val count = 30
        val conditionalString = when {
            count == 30 -> "count is 30"
            count > 35 -> "count > 35??"
            else -> "else ~~ "
        }
        Log.d("MySample", conditionalString)


        // Function call
        val answerString = generateAnswerString(20)
        Log.d("MySample", answerString)

        // Anonymous functions
        val stringLenthFunc : (String) -> Int = {
            it.length
        }
        val stringLenth : Int = stringLenthFunc("Hello~")
        Log.d("MySample", "stringLenth is $stringLenth")


        // Higher-order function call
        val highOrderFunctionVall : Int = stringMapper("Hi there!", ({
            it.length + 10
        }))
        Log.d("MySample", "Higher-order function call. stringLenth is $highOrderFunctionVall")



        // Using LiveData
        viewModel.changeNotifier.observe(this, changeObserver)
        button.setOnClickListener{viewModel.increment()}

    }

    // Kotlin's function
    fun generateAnswerString(countThreshold: Int) : String {
        val count = 30
        // first syntax
//        val answerString = if (count > countThreshold) {
//            "I have the answer"
//        } else {
//            "The answer eludes me"
//        }
//        return answerString

        // value 생략 바로 리턴
        return if (count > countThreshold) {
            "I have the answer"
        } else {
            "The answer eludes me"
        }
    }

    // Higher-order function
    fun stringMapper(str: String, mapper: (String) -> Int) : Int {
        // Invoke function
        return mapper(str)
    }



    // Using LiveData
    private fun incrementCount(value: Int) {
        button.text = (value).toString()
        Log.d("MySample", "Using LiveData. incrementCount = $value")
    }
}
