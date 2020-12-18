package com.example.webimtest.mainActivity

import com.example.webimtest.room.NoteDao
import javax.inject.Inject

class MainActivityModelImp @Inject constructor(private val noteDao: NoteDao): MainActivityModel {

    override fun get() = noteDao.get()

    override fun insert() {
        TODO("Not yet implemented")
    }
}