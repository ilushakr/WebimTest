package com.example.webimtest.mainActivity

import com.example.webimtest.entities.NoteDB
import com.example.webimtest.room.RoomMapper
import javax.inject.Inject

class MainActivityPresenterImp @Inject constructor(private val mainActivityModel: MainActivityModel, private val roomMapper: RoomMapper): MainActivityPresenter {

    lateinit var view: MainActivityView

    override fun attachView(view: MainActivityView) {
        this.view = view
        mainActivityModel.get().subscribe { notes: List<NoteDB>? ->
            this.setNotes(notes)
        }
    }

    override fun getNotes() {
        mainActivityModel.get().subscribe { notes: List<NoteDB>? ->
            this.setNotes(notes)
        }
    }

    private fun setNotes(notes: List<NoteDB>?){
        view.setList(roomMapper.mapFromEntitiesList(notes))
    }
}