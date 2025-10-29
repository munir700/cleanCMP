package learning.cleancmp.domain.useCases


import learning.cleancmp.domain.repository.UserRepository

class FetchUsersUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke() {
        repository.fetchUsers()
    }
}
