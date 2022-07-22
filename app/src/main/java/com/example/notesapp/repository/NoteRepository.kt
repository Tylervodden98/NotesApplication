package com.example.notesapp.repository

import com.example.notesapp.data.NoteDatabaseDao
import com.example.notesapp.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import java.util.concurrent.Flow
import javax.inject.Inject


//NoteRepository implements the Dao database which uses SQL Queries
class NoteRepository @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao){
    suspend fun addNote(note:Note) = noteDatabaseDao.insert(note)

    suspend fun updateNote(note: Note) = noteDatabaseDao.update(note)

    suspend fun deleteNote(note: Note) = noteDatabaseDao.deleteNote(note)

    suspend fun deleteAllNotes() = noteDatabaseDao.deleteAll()

    fun getAllNotes(): kotlinx.coroutines.flow.Flow<List<Note>> = noteDatabaseDao.getNotes().flowOn(Dispatchers.IO)
        .conflate()


}