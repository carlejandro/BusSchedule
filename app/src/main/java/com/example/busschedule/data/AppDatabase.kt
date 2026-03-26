package com.example.busschedule.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//Db with buschedule entity abstract class is the room database itself which extends roomdatabase
@Database(entities = [BusSchedule::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    // wire the dao into the room database
    abstract fun busScheduleDao(): BusScheduleDao

    companion object {
        // Shared variable volatile for thread safety one object.
        @Volatile
        private var Instance: AppDatabase? = null
        // Returns the database instance (creates it if it doesn't exist)
        fun getDatabase(context: Context): AppDatabase {
            return  Instance ?: synchronized(this){
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database"
                ).createFromAsset("database/bus_schedule.db")
                    .build()
                    .also{ Instance = it }

            }
        }
    }
}