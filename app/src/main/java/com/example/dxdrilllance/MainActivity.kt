package com.example.dxdrilllance

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import com.example.dxdrilllance.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val soundFiles = arrayOf(
        R.raw.reala_sounds1,
        R.raw.reala_sounds2,
        R.raw.reala_sounds3,
        R.raw.reala_sounds4,
        R.raw.reala_sounds5,
        R.raw.reala_sounds6,
        R.raw.reala_sounds7,
        R.raw.reala_sounds8,
        R.raw.reala_sounds9,
        R.raw.reala_sounds10,
        R.raw.reala_sounds11,
        R.raw.reala_sounds12,
        R.raw.reala_sounds13,
        R.raw.reala_sounds14,
        R.raw.reala_sounds15,
        R.raw.reala_sounds16,
        R.raw.reala_sounds17,
        R.raw.reala_sounds18,
        R.raw.reala_sounds19,
        R.raw.reala_sounds20,
        R.raw.reala_sounds21,
        R.raw.reala_sounds22,
        R.raw.reala_sounds23
    )
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView.setImageResource(R.drawable.image)

        binding.imageView.setOnTouchListener {
            _, event -> when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    changeImageAndPlaySound()
                }
                MotionEvent.ACTION_UP -> {
                    revertImage()
                }
            }
            true
        }
    }

    private fun changeImageAndPlaySound() {
        binding.imageView.setImageResource(R.drawable.image_on_tap)
        playRandomSound()
    }

    private fun revertImage() {
        binding.imageView.setImageResource(R.drawable.image)
    }

    private fun playRandomSound() {
        mediaPlayer?.release()
        val randomSoundId = soundFiles.random()
        mediaPlayer = MediaPlayer.create(this, randomSoundId)
        mediaPlayer?.start()
    }

    override fun onDestroy() {
        mediaPlayer?.release()
        super.onDestroy()
    }
}