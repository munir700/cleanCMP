package learning.cleancmp.domain.useCases


import kotlinx.coroutines.flow.Flow
import learning.cleancmp.domain.models.remote.User
import learning.cleancmp.domain.repository.UserRepository

class ObserveUsersUseCase(
    private val repository: UserRepository
) {
    operator fun invoke(): Flow<List<User>> = repository.observeUsers()
}
