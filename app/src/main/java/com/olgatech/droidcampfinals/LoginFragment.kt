package com.olgatech.droidcampfinals

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.olgatech.droidcampfinals.databinding.FragmentLogin2Binding

class LoginFragment : Fragment() {
    private val TAG = LoginFragment::class.java.simpleName
    private lateinit var mAuth: FirebaseAuth
    private var _binding: FragmentLogin2Binding? = null
    private val binding get() = _binding!!
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mAuth = FirebaseAuth.getInstance()
        // Inflate the layout for this fragment
        _binding = FragmentLogin2Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signupTxt.setOnClickListener {
            findNavController().navigate(R.id.signUpFragment)
        }

        binding.loginBtn.setOnClickListener {
            validateDetails()

        }
    }

    private fun validateDetails() {
        if (binding.loginEmailEditText.text.toString().isEmpty()) {
            binding.loginEmailEditText.error = "Email Address Required"
            binding.loginEmailEditText.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(binding.loginEmailEditText.text.toString()).matches()) {
            binding.loginEmailEditText.error = "Enter a valid Emaiil Address"
            return
        }

        if (binding.loginPasswordEditText.text.toString().isEmpty()) {
            binding.loginPasswordEditText.error = "Password Required"
            binding.loginPasswordEditText.requestFocus()
            return
        }

        mAuth.signInWithEmailAndPassword(binding.loginEmailEditText.text.toString(), binding.loginPasswordEditText.text.toString())
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                  findNavController().navigate(R.id.fileFragment)
                } else {
                    Toast.makeText(context, "Login Failed. Try again after some time", Toast.LENGTH_LONG).show()
                }
            }

//        requireActivity().onBackPressed()

    }

    override fun onStart(){
        super.onStart()
        val currentUser:FirebaseUser? = mAuth.currentUser
        updateUI(currentUser)
    }
    private fun updateUI(currentUser: FirebaseUser?) {

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}