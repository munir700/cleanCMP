package learning.cleancmp.data.repositories

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import learning.cleancmp.domain.models.remote.User
import learning.cleancmp.domain.repository.UserRepository

class UserRepositoryImpl : UserRepository {

    private val _users = MutableStateFlow<List<User>>(emptyList())

    override fun observeUsers(): Flow<List<User>> = _users

    override suspend fun fetchUsers() {
        delay(1000) // simulate API call
        _users.value = listOf(
            User(1, "Alice"),
            User(2, "Bob"),
            User(3, "Charlie")
        )
    }
}