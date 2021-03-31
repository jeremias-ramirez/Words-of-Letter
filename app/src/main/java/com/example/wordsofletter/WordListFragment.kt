package com.example.wordsofletter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordsofletter.databinding.FragmentWordListBinding

/**
 * A simple [Fragment] subclass.
 * Use the [WordListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WordListFragment : Fragment() {

    private var _binding: FragmentWordListBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val LETTER = "letter"
        val SEARCH_PREFIX = "https://www.google.com/search?q="

    }

    private lateinit var letterId : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{
                letterId = it.getString(LETTER).toString()
        }
    }
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentWordListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Retrieve the LETTER from the Intent extras
        // intent.extras.getString returns string? (String or null)
        // so toString() guarantees that the value will be a String
        //val letterId = activity?.intent?.extras?.getString(LETTER).toString()

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())

        recyclerView.adapter = WordAdapter(letterId, this.requireContext())

        // Adds a [DividerItemDecoration] between items
        recyclerView.addItemDecoration(
                DividerItemDecoration(this.requireContext(), DividerItemDecoration.VERTICAL)
        )

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}