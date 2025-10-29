package learning.cleancmp.presentation.users

import learning.cleancmp.domain.models.remote.User


data class UserListState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val error: String? = null
)
