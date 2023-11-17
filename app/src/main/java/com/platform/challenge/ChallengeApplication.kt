package com.platform.challenge

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ChallengeApplication: Application() {

    override fun onCreate() {
        super.onCreate()

    }

}