package com.example.busschedule

import android.app.Application
import com.example.busschedule.data.AppDatabase

class BusScheduleApplication : Application() {
    // Create the database when something tries to use it for the first time
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}