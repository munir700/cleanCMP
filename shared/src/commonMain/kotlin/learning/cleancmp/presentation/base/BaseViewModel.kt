package learning.cleancmp.presentation.base

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import org.koin.core.component.KoinComponent

/**
 * Base class for state management
 * Provides common functionality for state management across all platforms
 */
abstract class BaseViewModel<ViewState, ViewEvent>() : ViewModel(), KoinComponent {

    private val initialState by lazy { setInitialState() }
    private val _viewState = mutableStateOf(initialState)
    val viewState: State<ViewState> = _viewState
    protected val currentState: ViewState get() = _viewState.value

    // Events management
    private val _events = Channel<ViewEvent>()
    val events: Flow<ViewEvent> = _events.receiveAsFlow()

    protected fun setState(reducer: ViewState.() -> ViewState) {
        val newState = viewState.value.reducer()
        _viewState.value = newState
    }

    protected suspend fun sendEvent(event: ViewEvent) {
        _events.send(event)
    }

    abstract fun setInitialState(): ViewState
}
