package learning.cleancmp.domain.repository


import kotlinx.coroutines.flow.Flow
import learning.cleancmp.base.CoreRepository
import learning.cleancmp.domain.models.remote.User

interface UserRepository : CoreRepository {
    fun observeUsers(): Flow<List<User>>
    suspend fun fetchUsers()
}
