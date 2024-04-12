package com.example.projectthree
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectthree.databinding.FragmentBookListBinding
class BookListFragment: Fragment() {
    private var _binding: FragmentBookListBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null.  Is the view visible?"
        }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookListBinding.inflate(inflater, container, false)
        binding.bookList.layoutManager = LinearLayoutManager(context)
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}