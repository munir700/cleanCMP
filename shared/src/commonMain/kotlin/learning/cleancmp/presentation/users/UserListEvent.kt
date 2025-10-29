package learning.cleancmp.presentation.users

sealed class UserListEvent {
    data object NavigateToDetails : UserListEvent()
    data class ShowSnackbar(val message: String) : UserListEvent()
}
