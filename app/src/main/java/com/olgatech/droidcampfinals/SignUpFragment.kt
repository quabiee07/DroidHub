package com.olgatech.droidcampfinals

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.olgatech.droidcampfinals.databinding.FragmentSignUp2Binding
import com.olgatech.droidcampfinals.model.LogInModel
import kotlinx.android.synthetic.main.fragment_sign_up2.*
import java.util.regex.Pattern

class SignUpFragment : Fragment() {
    private lateinit var mAuth: FirebaseAuth
    private var _binding: FragmentSignUp2Binding? = null
    private val binding get() = _binding!!
    private val TAG = SignUpFragment::class.java.simpleName


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mAuth = FirebaseAuth.getInstance()
        _binding = FragmentSignUp2Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signUpBtn.setOnClickListener {
            signUpUser()

        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser: FirebaseUser? = mAuth.currentUser
        updateUI(currentUser)

    }

    private fun updateUI(currentUser: FirebaseUser?) {

    }


    private fun signUpUser() {
        val name = binding.nameEditText.text.toString()
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()

        if (binding.nameEditText.text.toString().isEmpty()) {
            binding.nameEditText.error = "Name Required"
            binding.nameEditText.requestFocus()
            return
        }

        if (binding.emailEditText.text.toString().isEmpty()) {
            binding.emailEditText.error = "Email Address Required"
            binding.emailEditText.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(binding.emailEditText.text.toString()).matches()) {
            binding.emailEditText.error = "Enter a valid Emaiil Address"
            return
        }

        if (binding.passwordEditText.text.toString().isEmpty()) {
            binding.passwordEditText.error = "Password Required"
            binding.passwordEditText.requestFocus()
            return
        }

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{ task ->
                if (task.isSuccessful) {
                   findNavController().navigate(R.id.loginFragment)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(context, "Authentication failed. Try again Later",
                        Toast.LENGTH_SHORT).show()
                }

            }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
