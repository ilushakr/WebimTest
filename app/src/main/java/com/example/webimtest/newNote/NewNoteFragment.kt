package com.example.webimtest.newNote

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.webimtest.R
import com.example.webimtest.entities.Note
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.add_note_fragment.view.*
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class NewNoteFragment: Fragment(), NewNoteFragmentView {

    @Inject
    lateinit var newNoteFragmentPresenter: NewNoteFragmentPresenter

    private lateinit var newNoteFragmentView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.add_note_fragment, container, false)

        newNoteFragmentPresenter.attachView(this)

        newNoteFragmentView = view

        initViews()
        return view
    }

    private fun initViews(){
        newNoteFragmentView.editTextTitle.setText("")
        newNoteFragmentView.editTextDescription.setText("")
        newNoteFragmentView.saveNewNote.setOnClickListener {
            newNoteFragmentPresenter.addNewNote(Note(title = newNoteFragmentView.editTextTitle.text.toString(), description = newNoteFragmentView.editTextDescription.text.toString()))
            hideKeyboard()
        }
    }

    private fun hideKeyboard() {
        val imm = activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(newNoteFragmentView.windowToken, 0)
    }

    override fun submitAdding() {
        activity!!.onBackPressed()
    }

    override fun errorOnAdding(error: String) {
        Toast.makeText(activity, error, Toast.LENGTH_LONG).show()
    }
}