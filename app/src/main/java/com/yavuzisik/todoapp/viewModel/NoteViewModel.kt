package com.yavuzisik.todoapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yavuzisik.todoapp.data.Note
import com.yavuzisik.todoapp.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    var allNotes: StateFlow<List<Note>> = repository.allNotes.asStateFlow()


    init {
        getAllNote()
    }

    fun getAllNote() {
        repository.getAllNotes()
    }

    fun addNote(newNote: Note) = viewModelScope.launch {
        repository.addNote(newNote)
        getAllNote()
    }

    fun deleteNote(note: Note) = viewModelScope.launch {
        repository.deleteNote(note)
        getAllNote()
    }

    fun updateNote(note: Note) = viewModelScope.launch {
        repository.updateNote(note)
        getAllNote()
    }

}