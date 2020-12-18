package com.example.webimtest.mainActivity

import com.example.webimtest.entities.NoteDB
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface MainActivityModel {

    fun get(): Observable<List<NoteDB>?>
    fun insert()
}