package com.basecamp.kotlin.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.basecamp.kotlin.R
import com.basecamp.kotlin.extensions.*
import com.basecamp.kotlin.helpers.atleastLollipop
import com.basecamp.kotlin.helpers.runDelayed
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.onClick

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.backgroundCircle(R.color.colorAccent)

        runDelayed(2000) { button.alphaAnimator(0f, 1f, 500).start() }
        atleastLollipop { button.onClick { reveal() } }
    }

    fun reveal() {
        overlay.circularRevealAnimator(centerX(), centerY(), 300)
            .animationEnd { button.onClick { hide() } }
            .start()
    }

    fun hide() {
        overlay.circularHideAnimator(centerX(), centerY(), 300)
            .animationEnd { button.onClick { reveal() } }
            .start()
    }

    fun centerX() = overlay.width / 2

    fun centerY() = overlay.height / 2
}
