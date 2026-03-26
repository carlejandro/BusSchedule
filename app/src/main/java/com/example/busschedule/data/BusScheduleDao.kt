package com.example.busschedule.data

//Room provides abstraction layer over SQLlite


import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BusScheduleDao {

    @Query("SELECT * FROM schedule ORDER BY arrival_time ASC")
    fun getAll(): Flow<List<BusSchedule>>


    // Assign query decorator to fun get By Stop name inject with :var --> thats a place holder
    @Query(
        "SELECT * FROM schedule " +
                "WHERE stop_name = :stopName " +
                "ORDER BY arrival_time ASC"
    )
    fun getByStopName(stopName: String): Flow<List<BusSchedule>>
}
