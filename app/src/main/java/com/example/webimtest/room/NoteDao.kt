package com.example.webimtest.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.webimtest.entities.NoteDB
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single


@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(post: NoteDB): Completable

    @Query("SELECT * FROM NoteDB ORDER BY id DESC")
    fun get(): Observable<List<NoteDB>?>

}