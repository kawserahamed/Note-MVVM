package org.primeit.googlenotes.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "notes_table")
class Note(
    @ColumnInfo(name = "title") var noteTitle: String ="",
    @ColumnInfo(name = "description") var noteDescription: String="",
    @ColumnInfo(name = "timestamp") var timeStamp: String = ""
): Serializable {

    @PrimaryKey(autoGenerate = true)
    var id = 0

}