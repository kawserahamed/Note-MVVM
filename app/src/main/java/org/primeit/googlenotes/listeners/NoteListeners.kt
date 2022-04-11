package org.primeit.googlenotes.listeners

import org.primeit.googlenotes.data.model.Note

interface NoteListeners {

    fun ondDeleteNote(note: Note)

    fun onClickedNote(note: Note)

}