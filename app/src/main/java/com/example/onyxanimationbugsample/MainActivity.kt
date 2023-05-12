package com.example.onyxanimationbugsample

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onyxanimationbugsample.databinding.ActivityMainBinding
import com.onyx.android.sdk.api.device.EpdDeviceManager

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonEnterAnimationUpdate.setOnClickListener {
            EpdDeviceManager.enterAnimationUpdate(true)
        }
        binding.buttonExitAnimationUpdate.setOnClickListener {
            EpdDeviceManager.exitAnimationUpdate(true)
        }

        binding.recyclerView.layoutManager = GridLayoutManager(this, 4)
        binding.recyclerView.adapter = object : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
                object : RecyclerView.ViewHolder(ImageView(parent.context).apply {
                    setImageResource(R.mipmap.ic_launcher)
                    layoutParams = ViewGroup.LayoutParams(100.dp, 100.dp)
                }) {}

            override fun getItemCount() = 50
            override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {}
        }
    }

    private val Int.dp: Int get() = (this * Resources.getSystem().displayMetrics.density).toInt()
}