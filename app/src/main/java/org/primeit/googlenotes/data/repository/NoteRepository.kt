package org.primeit.googlenotes.data.repository

import androidx.lifecycle.LiveData
import org.primeit.googlenotes.data.database.NoteDao
import org.primeit.googlenotes.data.model.Note

class NoteRepository(private val noteDao: NoteDao) {

    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()


    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }

    suspend fun update(note: Note) {
        noteDao.delete(note)
    }

    suspend fun delete(note: Note) {
        noteDao.delete(note)
    }
}