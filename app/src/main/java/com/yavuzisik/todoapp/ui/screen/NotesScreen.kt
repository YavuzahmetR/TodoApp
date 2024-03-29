package com.yavuzisik.todoapp.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NoteAdd
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yavuzisik.todoapp.data.Note
import com.yavuzisik.todoapp.ui.components.FloatingActionButton
import com.yavuzisik.todoapp.ui.components.NoteCard
import com.yavuzisik.todoapp.ui.components.TopBar
import com.yavuzisik.todoapp.viewModel.NoteViewModel

@Composable
fun AllNoteScreen(
    onFabClicked: () -> Unit,
    viewModel: NoteViewModel,
    allNoteZ: List<Note>
) {


    Scaffold(
        topBar = { TopBar() },
        floatingActionButton = { FloatingActionButton(onFabClicked) }
    ) { padding ->
        NoteScreen(
            modifier = Modifier.padding(padding),
            viewModel = viewModel,
            allNoteZ = allNoteZ
        )
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NoteScreen(
    modifier: Modifier = Modifier,
    viewModel: NoteViewModel,
    allNoteZ: List<Note>
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp),
        verticalArrangement =
        if (allNoteZ.isEmpty()) Arrangement.Center
        else Arrangement.Top
    ) {
        if (allNoteZ.isEmpty()) {
            EmptyPlaceHolder()
        } else {
            LazyColumn(modifier = modifier
                .fillMaxSize()
                .padding(bottom = 8.dp, top = 4.dp),
                content = {
                    items(allNoteZ.size) { index ->
                        NoteCard(
                            note = allNoteZ[index],
                            onDelete = {
                                viewModel.deleteNote(
                                    allNoteZ[index]
                                )
                            }
                        )
                    }
                }
            )
        }
    }
}

@Composable
fun EmptyPlaceHolder() {
    Column(
        Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            imageVector = Icons.Filled.NoteAdd,
            contentDescription = "add note",
            modifier = Modifier
                .padding(16.dp)
                .size(120.dp)
                .alpha(0.5f),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
        )
        Text(
            text = "No note here, let's add some.",
            modifier = Modifier.padding(12.dp),
            color = Color.DarkGray,
            fontSize = 18.sp,
            style = MaterialTheme.typography.labelSmall
        )
    }
}

@Preview
@Composable
fun PrevNotes() {
}