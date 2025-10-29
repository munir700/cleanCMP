package learning.cleancmp.presentation.users

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import learning.cleancmp.domain.useCases.FetchUsersUseCase
import learning.cleancmp.domain.useCases.ObserveUsersUseCase
import learning.cleancmp.presentation.base.BaseViewModel

class UserListViewModel(
    private val fetchUsers: FetchUsersUseCase,
    private val observeUsers: ObserveUsersUseCase
) : BaseViewModel<UserListState, UserListEvent>() {

    init {
        observeUsersFlow()
    }

    override fun setInitialState(): UserListState = UserListState()

    private fun observeUsersFlow() {
        viewModelScope.launch {
            observeUsers()
                .collect { users ->
                    setState { copy(isLoading = false, users = users) }
                }
        }
    }

    fun refreshUsers() {
        viewModelScope.launch {
            setState { copy(isLoading = true) }
            try {
                fetchUsers()
                sendEvent(UserListEvent.ShowSnackbar("Users updated"))
            } catch (e: Exception) {
                setState { copy(error = e.message) }
            } finally {
                setState { copy(isLoading = false) }
            }
        }
    }

    fun onUserClicked() {
        viewModelScope.launch {
            sendEvent(UserListEvent.NavigateToDetails)
        }
    }
}
