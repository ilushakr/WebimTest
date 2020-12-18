package com.example.webimtest.mainActivity

import com.example.webimtest.entities.Note

interface MainActivityView {

    fun setList(notes: List<Note>?)
}