package com.example.projectthree
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectthree.databinding.FragmentBookListBinding
import kotlinx.coroutines.launch
class BookListFragment: Fragment() {
    private var _binding: FragmentBookListBinding? = null
    private val binding get() = checkNotNull(_binding) {
        "Cannot access binding because it is null.  Is the view visible?"
    }
    private val bookListViewModel: BookListViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentBookListBinding.inflate(inflater, container, false)
        binding.bookList.layoutManager = LinearLayoutManager(context)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                bookListViewModel.listItems.collect { items ->
                    binding.bookList.adapter = BookListAdapter(items)
                }
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}