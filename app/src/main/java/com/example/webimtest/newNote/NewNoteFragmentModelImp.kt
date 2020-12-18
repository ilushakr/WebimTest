package com.example.webimtest.newNote

import com.example.webimtest.entities.NoteDB
import com.example.webimtest.room.NoteDao
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

class NewNoteFragmentModelImp @Inject constructor(private val noteDao: NoteDao):  NewNoteFragmentModel{

    override fun addNewNote(note: NoteDB) = noteDao.insert(note)
}