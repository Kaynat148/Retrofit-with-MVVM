package com.maximus.task.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.maximus.task.R
import com.maximus.task.databinding.ActivityMainBinding
import com.maximus.task.databinding.ActivitySplashBinding

class Splash : AppCompatActivity() {

    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_splash)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        //var image : ImageView = findViewById(R.id.imageView)
        Glide.with(this).load(R.drawable.snail).fitCenter().into(binding.imageView)

        var intent: Intent
        Handler().postDelayed({

            intent= Intent(this, MainActivity::class.java)
            this.finish()
            startActivity(intent)
        }, 4000)

    /*     Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)*/


    }
}