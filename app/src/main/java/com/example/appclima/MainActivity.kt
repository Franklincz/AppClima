package com.example.appclima

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val likeImageView = findViewById<LottieAnimationView>(R.id.likeImageView);
        var like = false


        likeImageView.setOnClickListener {
            like = likeAnimation(likeImageView, R.raw.lluviosoanimation, like)
        }


        like2(likeImageView, R.raw.lluviosoanimation )
    }


    private fun likeAnimation(imageView: LottieAnimationView,
                              animation: Int,
                              like: Boolean) : Boolean {

        if (!like) {
            imageView.setAnimation(animation)
            imageView.playAnimation()
        } else {
            imageView.animate()
                .alpha(0f)
                .setDuration(200)
                .setListener(object : AnimatorListenerAdapter() {

                    override fun onAnimationEnd(animator: Animator) {

                        imageView.setImageResource(R.drawable.ic_luna)
                        imageView.alpha = 1f
                    }

                })

        }

        return !like
    }

    private fun like2(imageView :LottieAnimationView , animation: Int ){

        imageView.setAnimation(animation)
       imageView.repeatCount=5
       /* imageView.translationX=100f
        imageView.translationY=100f
        */
        //imageView.speed=200f

        imageView.playAnimation()




    }







}