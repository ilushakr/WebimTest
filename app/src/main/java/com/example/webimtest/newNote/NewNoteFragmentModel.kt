package com.example.webimtest.newNote

import com.example.webimtest.entities.NoteDB
import io.reactivex.rxjava3.core.Completable

interface NewNoteFragmentModel {

    fun addNewNote(note: NoteDB): Completable
}