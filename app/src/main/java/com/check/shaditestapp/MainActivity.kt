package com.check.shaditestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(ProfileFragment.getInstance(),
            addToBackStack = false)
    }

    private fun replaceFragment(fragment: Fragment?, addToBackStack: Boolean = true) {
        if (fragment == null) return
        val className = fragment.javaClass.name

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(className)
        }
        fragmentTransaction.replace(R.id.framelayout_fullscreen, fragment, className).commit()

    }

    fun getRetrofit(): ApiService? {
        val retrofit = Retrofit.Builder()
            .baseUrl(AppConstant.BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)
    }
}