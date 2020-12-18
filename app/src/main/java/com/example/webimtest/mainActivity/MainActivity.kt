package com.example.webimtest.mainActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.webimtest.R
import com.example.webimtest.entities.Note
import com.example.webimtest.mainActivity.recyclerViewAdapter.NotesAdapter
import com.example.webimtest.newNote.NewNoteFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainActivityView {

    @Inject
    lateinit var mainActivityPresenter: MainActivityPresenter

    private lateinit var notesAdapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notesAdapter = NotesAdapter()
        mainActivityPresenter.attachView(this)

        initViews()

    }

    private fun initViews(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = notesAdapter

        addNoteButton.setOnClickListener {
            supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.fragment_animation_open, R.anim.fragment_animation_close,
                R.anim.fragment_animation_open, R.anim.fragment_animation_close).replace(R.id.newNoteFrameLayout, NewNoteFragment()).addToBackStack("new_note").commit()
        }
    }

    override fun setList(notes: List<Note>?) {
        notesAdapter.setNotes(notes!!)
    }

    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount == 1){
            supportFragmentManager.popBackStack()
        }
    }
}