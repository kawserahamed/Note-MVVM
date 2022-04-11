package org.primeit.googlenotes.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
class Note(
    @ColumnInfo(name = "title") val noteTitle: String,
    @ColumnInfo(name = "description") val noteDescription: String,
    @ColumnInfo(name = "timestamp") val timeStamp: String
) {


    @PrimaryKey(autoGenerate = true)
    var id = 0

}