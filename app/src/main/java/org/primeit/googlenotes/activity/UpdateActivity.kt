package org.primeit.googlenotes.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import org.primeit.googlenotes.data.model.Note
import org.primeit.googlenotes.data.viewModel.NoteViewModel
import org.primeit.googlenotes.databinding.ActivityUpdateBinding
import java.text.SimpleDateFormat
import java.util.*

class UpdateActivity : AppCompatActivity() {

    lateinit var binding: ActivityUpdateBinding
    lateinit var viewModel: NoteViewModel


    private val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss",Locale.getDefault())
    private val currentDate = sdf.format(Date())

    var note = Note()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[NoteViewModel::class.java]

        note = intent.getSerializableExtra("notes") as Note

        binding.edTitle.setText(note.noteTitle)
        binding.descriptionId.setText(note.noteDescription)



        binding.doneId.setOnClickListener {

            note.noteTitle = binding.edTitle.text.toString()
            note.noteDescription = binding.descriptionId.text.toString()
            note.timeStamp = currentDate
            viewModel.updateNote(note)
            this.finish()


        }


    }
}