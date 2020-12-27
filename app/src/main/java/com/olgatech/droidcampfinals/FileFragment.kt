package com.olgatech.droidcampfinals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isEmpty
import com.olgatech.droidcampfinals.databinding.FragmentFileBinding
import com.olgatech.droidcampfinals.model.FileModel
import kotlinx.android.synthetic.main.fragment_file_list.*

/**
 * A fragment representing a list of Items.
 */
class FileFragment : Fragment() {


    private var _binding: FragmentFileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentFileBinding.inflate(layoutInflater)
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val values= ArrayList<FileModel>()
        val fileAdapter=FileAdapter(this, values)

        binding.recyclerView.adapter
        binding.addFileFab.setOnClickListener {
            findNavController().navigate(R.id.file_upload_fragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}