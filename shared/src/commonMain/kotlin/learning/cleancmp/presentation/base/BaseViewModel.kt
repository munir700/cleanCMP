package learning.cleancmp.presentation.base

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Base class for state management
 * Provides common functionality for state management across all platforms
 */
abstract class BaseViewModel<UiState>(initialState: UiState) {

    protected val _uiState = MutableStateFlow(initialState)
    open val uiState: StateFlow<UiState> = _uiState.asStateFlow()
}

