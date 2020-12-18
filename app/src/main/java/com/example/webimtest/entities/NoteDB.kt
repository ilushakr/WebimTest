package com.example.webimtest.entities

import android.accounts.AuthenticatorDescription
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteDB(
    @PrimaryKey
    var id: Int? = null,

    @ColumnInfo
    var title: String,

    @ColumnInfo
    var description: String,

//    @ColumnInfo
//    var date: String
)
