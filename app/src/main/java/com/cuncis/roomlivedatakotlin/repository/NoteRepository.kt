package com.cuncis.roomlivedatakotlin.repository

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.cuncis.roomlivedatakotlin.dao.NoteDao
import com.cuncis.roomlivedatakotlin.db.NoteDatabase
import com.cuncis.roomlivedatakotlin.model.Note
import com.cuncis.roomlivedatakotlin.utils.Util

class NoteRepository(application: Application) {

    private var noteDao: NoteDao

    private var allNotes: LiveData<List<Note>>

    init {
        val database: NoteDatabase = NoteDatabase.getInstance(
            application.applicationContext
        )!!

        noteDao = database.noteDao()
        allNotes = noteDao.getAllNotes()
    }

    fun insert(note: Note) {
        InsertNoteAsyncTask(noteDao).execute(note)
    }

    fun deleteAllNotes() {
       DeleteNoteAsyncTask(noteDao).execute()
    }

    fun getAllNotes(): LiveData<List<Note>> {
        return allNotes
    }

    private class InsertNoteAsyncTask(val noteDao: NoteDao): AsyncTask<Note, Unit, Unit>() {
        override fun doInBackground(vararg p0: Note?) {
            noteDao.insert(p0[0]!!)
        }
    }

    private class DeleteNoteAsyncTask(val noteDao: NoteDao): AsyncTask<Unit, Unit, Unit>() {
        override fun doInBackground(vararg p0: Unit?) {
            noteDao.deleteAllNotes()
        }
    }

}