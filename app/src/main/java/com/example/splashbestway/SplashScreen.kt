package com.example.splashbestway


import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.splashbestway.databinding.ActivitySplashScreenBinding


//This line add in android 12 and Above
@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {

    lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme2)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val slideUp: Animation =
            AnimationUtils.loadAnimation(this, R.anim.slide_down)
        binding.imageView.animation = slideUp

        slideUp.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.imageView.visibility = View.GONE
                startActivity(Intent(this@SplashScreen, MainActivity::class.java))
                finish()
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

        })

        /* startActivity(Intent(this, MainActivity::class.java))
         finish()*/

    }
}