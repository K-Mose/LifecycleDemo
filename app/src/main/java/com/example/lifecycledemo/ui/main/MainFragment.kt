package com.example.lifecycledemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.lifecycledemo.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        lifecycleScope.launch(Dispatchers.IO) {
            Log.e("TAG", "coroutine : ${Thread.currentThread()}")
        }

        // onCreate 실행 시 딱 한번 시작됨
        lifecycleScope.launchWhenCreated {

        }
        // 마찬가지로 onStart 실행 시 실행
        lifecycleScope.launchWhenStarted {

        }
        // onResume 실행 시 실행
        lifecycleScope.launchWhenResumed {

        }



    }

}