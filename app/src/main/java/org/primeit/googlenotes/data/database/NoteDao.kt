package org.primeit.googlenotes.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import org.primeit.googlenotes.data.model.Note


@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)


    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)


    @Query("Select*from notes_table order by id ASC")
    fun getAllNotes(): LiveData<List<Note>>

}