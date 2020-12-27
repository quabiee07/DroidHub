package com.olgatech.droidcampfinals

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.olgatech.droidcampfinals.databinding.FragmentFileListBinding


import com.olgatech.droidcampfinals.model.FileModel


class FileAdapter(private val context: FileFragment, private val values: List<FileModel>) : RecyclerView.Adapter<FileAdapter.ViewHolder>() {
    private var _binding :FragmentFileListBinding? = null
    val binding get() =_binding!!


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_file, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text[position]
    }

    override fun getItemCount(): Int {
        return 10
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView= binding.fileTitle

    }
}