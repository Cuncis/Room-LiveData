package com.cuncis.roomlivedatakotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.cuncis.roomlivedatakotlin.model.Note
import com.cuncis.roomlivedatakotlin.repository.NoteRepository


class NoteViewModel(application: Application): AndroidViewModel(application) {

    private var repository: NoteRepository = NoteRepository(application)
    private var allNote: LiveData<List<Note>> = repository.getAllNotes()

    fun insert(note: Note) {
        repository.insert(note)
    }

    fun deleteAllNote() {
        repository.deleteAllNotes()
    }

    fun getAllNotes(): LiveData<List<Note>> {
        return allNote
    }
}