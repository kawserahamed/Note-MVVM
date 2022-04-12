package org.primeit.googlenotes.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import org.primeit.googlenotes.data.model.Note
import org.primeit.googlenotes.data.viewModel.NoteViewModel
import org.primeit.googlenotes.databinding.ActivityAddNoteBinding
import java.text.SimpleDateFormat
import java.util.*

class AddNote : AppCompatActivity() {

    lateinit var binding: ActivityAddNoteBinding
    lateinit var viewModel: NoteViewModel

    @SuppressLint("SimpleDateFormat")
    val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
    val currentDate = sdf.format(Date())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NoteViewModel::class.java)

        binding.doneId.setOnClickListener {
            val note = Note()
            note.noteTitle = binding.edTitle.text.toString()
            note.noteDescription = binding.descriptionId.text.toString()
            note.timeStamp = currentDate
            viewModel.addNote(note)
            this.finish()

        }


    }
}