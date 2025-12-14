package com.newsappde.utils.extensions

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import coil.compose.AsyncImage
import com.newsappde.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

fun ViewModel.viewModelScope(
    action: suspend CoroutineScope.() -> Unit
) {
    viewModelScope.launch { action() }
}

fun <T> LifecycleOwner.observe(
    flow: Flow<T>,
    action: (T) -> Unit
) {
    lifecycleScope.launch {
        flow.collect { data ->
            action(data)
        }
    }
}

fun Fragment.lifeCycleScope(
    action: suspend CoroutineScope.() -> Unit
) {
    viewLifecycleOwner.lifecycleScope.launch {
        action()
    }
}

@Composable
fun NewsImage(url: String?, modifier: Modifier = Modifier) {
    AsyncImage(
        model = url,
        placeholder = painterResource(R.drawable.ic_splash),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .height(150.dp)
            .clip(RoundedCornerShape(12.dp))
    )
}