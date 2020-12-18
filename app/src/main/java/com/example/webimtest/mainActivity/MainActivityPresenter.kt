package com.example.webimtest.mainActivity

interface MainActivityPresenter {

    fun attachView(view: MainActivityView)

    fun getNotes()
}