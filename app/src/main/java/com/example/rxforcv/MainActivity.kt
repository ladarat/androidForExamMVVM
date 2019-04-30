package com.example.rxforcv

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.rxforcv.character.datasource.api.Repository.CharacterRepo
import com.example.rxforcv.character.datasource.api.domain.usecase.AllCharacterUsecase
import com.example.rxforcv.character.presenter.ui.CharacterListViewModelFactory
import com.example.rxforcv.character.presenter.ui.CharacterViewModel
import com.example.rxforcv.core.util.viewModelProvider
import com.example.rxforcv.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val allCharacterUsecase = AllCharacterUsecase(CharacterRepo())
    val characterListViewModelFactory = CharacterListViewModelFactory(allCharacterUsecase)
    lateinit var viewModel: CharacterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        viewModel = viewModelProvider(characterListViewModelFactory)

        binding.viewModel = viewModel
        binding.setLifecycleOwner { lifecycle }

        callCharacterButton.setOnClickListener { viewModel.requestCharacterList() }
    }
}
