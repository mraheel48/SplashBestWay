package com.example.splashbestway

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.AnticipateInterpolator
import android.widget.ImageView
import androidx.core.animation.doOnEnd

//This line add in android 12 and Above
@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {

    lateinit var iconView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_splash_screen)
        iconView = findViewById(R.id.imageView)

        val slide_up: Animation =
            AnimationUtils.loadAnimation(this, R.anim.slide_down)
        iconView.animation = slide_up

        slide_up.setAnimationListener(object :Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                iconView.visibility = View.GONE
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