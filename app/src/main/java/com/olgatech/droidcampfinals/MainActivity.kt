package com.olgatech.droidcampfinals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.olgatech.droidcampfinals.databinding.ActivityMainBinding
import com.olgatech.droidcampfinals.model.FileModel
import kotlinx.android.synthetic.main.fragment_file_list.*

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val values = ArrayList<FileModel>()
//        FileAdapter(this, values)
//        recycler_view.adapter


    }

}