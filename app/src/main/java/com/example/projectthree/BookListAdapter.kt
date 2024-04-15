package com.example.projectthree
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectthree.api.ListItem
import com.example.projectthree.databinding.ListItemBookBinding
class BookListAdapter(private val listItems: List<ListItem>): RecyclerView.Adapter<BookViewHolder>() {
    override fun getItemCount() = listItems.size
    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val item = listItems[position]
        holder.bind(item)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBookBinding.inflate(inflater, parent, false)
        return BookViewHolder(binding)
    }
}
class BookViewHolder(private val binding: ListItemBookBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(listItem: ListItem) {
        //TODO
    }
}