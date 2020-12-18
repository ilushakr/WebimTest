package com.example.webimtest.modules

import android.content.Context
import androidx.room.Room
import com.example.webimtest.room.NoteDao
import com.example.webimtest.room.NoteDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context):NoteDataBase{
        return Room.databaseBuilder(
                context,
            NoteDataBase::class.java,
            NoteDataBase.NAME
                )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideDao(postDatabase: NoteDataBase): NoteDao {
        return postDatabase.noteDao()
    }

}