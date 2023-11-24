package com.example.pix60

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.pix60.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val imageAdapter = ImageAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClick()
    }

    private fun initClick() {
        with(binding){
            btnSearch.setOnClickListener {
                RetrofitServices.api.getImages(keyWord = etSearch.text.toString())
                    .enqueue(object : retrofit2.Callback<PixaModel>{
                        override fun onResponse(
                            call: Call<PixaModel>,
                            response: Response<PixaModel>
                        ) {
                            if (response.isSuccessful){
                                response.body()?.let {
                                    recycler.adapter = imageAdapter
                                    imageAdapter.addImage(it.hits)
                                }
                            }
                        }

                        override fun onFailure(call: Call<PixaModel>, t: Throwable) {
                            Log.e("ololo","Failed: ${t.message}")
                        }

                    })
            }
        }
    }
}