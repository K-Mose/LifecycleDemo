package com.example.lifecycledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.lifecycledemo.databinding.MainActivityBinding
import com.example.lifecycledemo.ui.main.MainFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }

        // 메인에서 실행되는 코루틴
        lifecycleScope.launch(Dispatchers.IO) {
            Log.e("TAG", "coroutine : ${Thread.currentThread()}")
            withContext(Dispatchers.Main) {
                Log.e("TAG", "coroutine : ${Thread.currentThread()}")
                delay(5000)
                binding.pgBar.visibility = View.VISIBLE
                delay(10000)
                binding.pgBar.visibility = View.GONE
            }
        }
    }
}