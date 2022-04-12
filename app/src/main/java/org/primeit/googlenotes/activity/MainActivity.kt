package org.primeit.googlenotes.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import org.primeit.googlenotes.data.model.Note
import org.primeit.googlenotes.data.viewModel.NoteViewModel
import org.primeit.googlenotes.databinding.ActivityMainBinding
import org.primeit.googlenotes.listeners.NoteListeners
import org.primeit.googlenotes.recyclerView.RecyclerAdapter

class MainActivity : AppCompatActivity(), NoteListeners {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewId.layoutManager = LinearLayoutManager(this)

        val myAdapter = RecyclerAdapter(this)
        binding.recyclerViewId.adapter = myAdapter
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[NoteViewModel::class.java]
        viewModel.allNotes.observe(this, Observer { list ->
            list?.let {
                myAdapter.updateList(it)
            }

        })

        binding.floatingId.setOnClickListener {
            val intent = Intent(applicationContext, AddNote::class.java)
            startActivity(intent)

        }

    }

    override fun ondDeleteNote(note: Note) {
        viewModel.deleteNote(note)
        Toast.makeText(applicationContext, "${note.noteTitle} Deleted", Toast.LENGTH_SHORT).show()
    }

    override fun onClickedNote(note: Note) {
        val intent = Intent(applicationContext, UpdateActivity::class.java)
        intent.putExtra("notes", note)
        startActivity(intent)

    }


}

