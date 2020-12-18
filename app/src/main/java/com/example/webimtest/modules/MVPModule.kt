package com.example.webimtest.modules

import com.example.webimtest.mainActivity.MainActivityModel
import com.example.webimtest.mainActivity.MainActivityModelImp
import com.example.webimtest.mainActivity.MainActivityPresenter
import com.example.webimtest.mainActivity.MainActivityPresenterImp
import com.example.webimtest.newNote.NewNoteFragmentModel
import com.example.webimtest.newNote.NewNoteFragmentModelImp
import com.example.webimtest.newNote.NewNoteFragmentPresenter
import com.example.webimtest.newNote.NewNoteFragmentPresenterImp
import com.example.webimtest.room.NoteDao
import com.example.webimtest.room.RoomMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object MVPModule {

    @Singleton
    @Provides
    fun provideMainPresenter(
        mainActivityModel: MainActivityModel,
        roomMapper: RoomMapper
    ): MainActivityPresenter {
        return MainActivityPresenterImp(mainActivityModel, roomMapper)
    }

    @Singleton
    @Provides
    fun provideMainModel(
        noteDao: NoteDao
    ): MainActivityModel {
        return MainActivityModelImp(noteDao)
    }

    @Singleton
    @Provides
    fun provideNewNoteFragmentPresenter(
        newNoteFragmentModel: NewNoteFragmentModel,
        roomMapper: RoomMapper
    ): NewNoteFragmentPresenter{
        return NewNoteFragmentPresenterImp(newNoteFragmentModel, roomMapper)
    }

    @Singleton
    @Provides
    fun provideNewNoteFragmentModel(
        noteDao: NoteDao
    ): NewNoteFragmentModel{
        return NewNoteFragmentModelImp(noteDao)
    }
}