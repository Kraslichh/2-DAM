package com.example.ciclovida
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.View


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.d("Lifecycle", "SecondActivity - onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "SecondActivity - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "SecondActivity - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "SecondActivity - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "SecondActivity - onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Lifecycle", "SecondActivity - onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "SecondActivity - onDestroy")
    }

    fun goToThirdActivity(view: View) {
        val intent = Intent(this, ThirdActivity::class.java)
        startActivity(intent)
    }
}
