package com.example.webimtest.newNote

import com.example.webimtest.entities.Note
import com.example.webimtest.room.RoomMapper
import io.reactivex.rxjava3.functions.Action
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject


class NewNoteFragmentPresenterImp @Inject constructor(
    private val newNoteFragmentModel: NewNoteFragmentModel,
    private val roomMapper: RoomMapper
): NewNoteFragmentPresenter {

    lateinit var view: NewNoteFragmentView

    override fun attachView(view: NewNoteFragmentView) {
        this.view = view
    }

    override fun addNewNote(note: Note) {
//        Completable.fromAction { newNoteFragmentModel.addNewNote(roomMapper.mapToEntity(note)) }.subscribe(
//            { view.submitAdding() },
//            { error -> view.errorOnAdding(error.toString()) })
//        newNoteFragmentModel.addNewNote(roomMapper.mapToEntity(note)).subscribe(
//            { view.submitAdding() },
//            { error -> view.errorOnAdding(error.toString()) })

        newNoteFragmentModel.addNewNote(roomMapper.mapToEntity(note)).subscribeOn(Schedulers.io()).subscribe(
            {
                view.submitAdding()
            }
        ) { error ->
            view.errorOnAdding(error.toString())
        }

    }
}