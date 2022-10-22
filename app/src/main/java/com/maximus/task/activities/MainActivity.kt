package com.maximus.task.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.maximus.task.R
import com.maximus.task.ViewModel.MainViewModel
import com.maximus.task.databinding.ActivityMainBinding
import com.maximus.task.util.ApiState
import com.maximus.task.util.hide
import com.maximus.task.util.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //@Inject

    lateinit var binding: ActivityMainBinding

    //lateinit var text: MaterialTextView
    //lateinit var loadingPB: ProgressBar
   // lateinit var button : MaterialButton



    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //text = findViewById(R.id.facttext)
        //loadingPB = findViewById(R.id.idLoadingPB)
        //button = findViewById(R.id.refreshbtn)
        DataLoad()
        gifPlaying()
// set on-click listener
        binding.refreshbtn.setOnClickListener {
            viewModel.fetchRepositories()
        }


    }


    private fun DataLoad() {
        lifecycleScope.launch {

            viewModel._uiState.collect {

                when (it) {

                    is ApiState.Loading -> {
                        navigateToLoadingScreen()
                    }

                    is ApiState.Success -> {

                        updateUi(it.response)

                    }


                    else -> {
                    }
                }
            }
        }
    }

    private fun navigateToLoadingScreen() {
        binding.idLoadingPB.show()

    }


    private fun updateUi(response: String?) {

        if (!response.isNullOrEmpty()){
            binding.idLoadingPB.hide()
            binding.facttext.setText(response)
        }

    }


    fun gifPlaying()
    {

        Glide.with(this).load(R.drawable.newpanda).into(binding.pandaimg);
    }

    override fun onBackPressed() {

        DialogBox()

    }

    fun DialogBox()
    {


        val builder = AlertDialog.Builder(this)
        builder.setTitle("Confirm")
        builder.setMessage("Are you sure you want to exit")

        builder.setPositiveButton(android.R.string.yes) { dialog, which ->
          finish()

            //exitProcess(0)
        }

        builder.setNegativeButton(android.R.string.no) { dialog, which ->
            dialog.dismiss()
        }
        builder.show()
    }
}