package com.yavuzisik.todoapp.repository

import com.yavuzisik.todoapp.data.Note
import com.yavuzisik.todoapp.data.NoteDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject



class NoteRepository @Inject constructor(
    private val noteDao: NoteDao
) {

    val allNotes: MutableStateFlow<List<Note>> = MutableStateFlow(emptyList())

    fun getAllNotes() {
        CoroutineScope(Dispatchers.IO).launch {
            allNotes.value = noteDao.getAllNotes()
        }
    }

    fun addNote(newNote: Note) {
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.addNote(newNote)
        }
    }

    fun deleteNote(note: Note) {
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.deleteNote(note)
        }
    }

    fun updateNote(note: Note) {
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.updateNote(note)
        }
    }

}