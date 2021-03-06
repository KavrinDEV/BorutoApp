package com.kavrin.borutoapp.presentation.screens.splash


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kavrin.borutoapp.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

	private val _onBoardingCompleted = MutableStateFlow(false)
	val onBoardingCompleted: StateFlow<Boolean> = _onBoardingCompleted

	init {
		viewModelScope.launch(context = Dispatchers.IO) {
			_onBoardingCompleted.value =
				// With operator fun invoke we can call our class like function
				// State in for change Flow to StateFlow
				useCases.readOnBoardingUseCase().stateIn(scope = viewModelScope).value
		}
	}
}