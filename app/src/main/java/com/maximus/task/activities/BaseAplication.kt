package com.maximus.task.activities

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltAndroidApp
class BaseApplication @Inject constructor() : Application() {


   /* @Inject
    lateinit var dataStoreManager: DataStoreManager*/

    override fun onCreate() {
        super.onCreate()



        GlobalScope.launch {

        }

    }


}
