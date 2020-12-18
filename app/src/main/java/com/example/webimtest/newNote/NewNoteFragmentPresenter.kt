package com.example.webimtest.newNote

import com.example.webimtest.entities.Note

interface NewNoteFragmentPresenter {

    fun attachView(view: NewNoteFragmentView)

    fun addNewNote(note: Note)
}