package com.yavuzisik.todoapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun FloatingActionButton(onNavigate: () -> Unit) {
    androidx.compose.material3.FloatingActionButton(
        onClick = onNavigate,
        containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
        shape = FloatingActionButtonDefaults.largeShape
    ) {
        Icon(
            imageVector = Icons.Filled.Edit,
            contentDescription = "add_note",
            tint = MaterialTheme.colorScheme.surface
        )
    }
}