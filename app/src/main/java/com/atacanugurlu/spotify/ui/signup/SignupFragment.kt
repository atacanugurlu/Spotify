package com.atacanugurlu.spotify.ui.signup

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.atacanugurlu.spotify.MainApp
import com.atacanugurlu.spotify.R
import com.atacanugurlu.spotify.databinding.MainFragmentBinding
import com.atacanugurlu.spotify.databinding.SignupFragmentBinding
import com.atacanugurlu.spotify.ui.main.MainViewModel
import javax.inject.Inject

class SignupFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory
    private lateinit var binding : SignupFragmentBinding

    private val viewModel: SignupViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[SignupViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SignupFragmentBinding.inflate(inflater)


        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MainApp.instance.appComponent.inject(this)
    }

}