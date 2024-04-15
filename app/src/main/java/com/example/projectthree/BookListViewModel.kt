package com.example.projectthree
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectthree.api.ListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
private const val TAG = "BookListViewModel"
class BookListViewModel: ViewModel() {
    private val bookRepository = BookRepository()
    private val _listItems: MutableStateFlow<List<ListItem>> = MutableStateFlow(emptyList())
    val listItems: StateFlow<List<ListItem>>
        get() = _listItems.asStateFlow()
    init {
        viewModelScope.launch {
            try {
                val items = bookRepository.fetchBooks()
                Log.d(TAG, "Items received: $items")
                _listItems.value = items
            } catch (ex: Exception) {
                Log.e(TAG, "Failed to fetch list items", ex)
            }
        }
    }
}