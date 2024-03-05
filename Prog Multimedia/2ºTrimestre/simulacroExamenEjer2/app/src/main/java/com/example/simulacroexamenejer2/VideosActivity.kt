package com.example.simulacroexamenejer2
import android.net.Uri
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class VideosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videos)

        val videoView1: VideoView = findViewById(R.id.videoView1)
        val videoView2: VideoView = findViewById(R.id.videoView2)
        val videoView3: VideoView = findViewById(R.id.videoView3)
        val backButton: Button = findViewById(R.id.loginButton)

        // Cargar y reproducir los vídeos
        cargarYReproducirVideo(videoView1, R.raw.nieve, R.anim.combined)
        cargarYReproducirVideo(videoView2, R.raw.nieve2, R.anim.scale)
        cargarYReproducirVideo(videoView3, R.raw.nieve3, R.anim.slide_in)

        // Listener para el botón de regreso al login
        backButton.setOnClickListener {
            finish() // Cierra esta actividad y vuelve al login
        }
    }

    private fun cargarYReproducirVideo(videoView: VideoView, videoResId: Int, animResId: Int) {
        // Cargar el vídeo
        val videoUri = Uri.parse("android.resource://" + packageName + "/" + videoResId)
        videoView.setVideoURI(videoUri)

        // Cargar la animación
        val animation = AnimationUtils.loadAnimation(this, animResId)

        // Asignar la animación al VideoView
        videoView.startAnimation(animation)

        // Iniciar la reproducción del vídeo
        videoView.setOnPreparedListener {
            it.isLooping = true
            it.start()
        }
    }
}

