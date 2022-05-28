package com.example.retrofitdownloader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitdownloader.databinding.ActivityMainBinding
import kotlinx.coroutines.coroutineScope
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            button.setOnClickListener{
                  val ok_builder = OkHttpClient.Builder()
                val retrofit= Retrofit.Builder()
                         .baseUrl("https://github.com/")
                         .client(OkHttpClient.Builder().build())
                         .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()



                val downloadService = retrofit.create(RetrofitInterface::class.java)



                  downloadService.downloadFile("gameplay3d/GamePlay/archive/master.zip")


            }
        }




    }


}