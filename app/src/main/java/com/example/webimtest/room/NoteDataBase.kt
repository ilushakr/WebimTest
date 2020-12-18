package com.example.webimtest.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.webimtest.entities.NoteDB

@Database(entities = [NoteDB::class], version = 1)
abstract class NoteDataBase: RoomDatabase(){

    abstract fun noteDao(): NoteDao

    companion object{
        val NAME = "NOTE_DB"
    }
}