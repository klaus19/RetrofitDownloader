package com.example.retrofitdownloader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitdownloader.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var service: RetrofitInterface
    val url: String = "https://github.com/gameplay3d/GamePlay/archive/master.zip"
    lateinit var target: File


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        with(binding) {
            //Button click listener

            button.setOnClickListener {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://github.com/")
                    .client(OkHttpClient.Builder().build())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()


                val downloadService = retrofit.create(RetrofitInterface::class.java)
                val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)
                scope.launch {

                    downloadService.downloadFile("gameplay3d/GamePlay/archive/master.zip")

                }

            }

        }


    }
}









