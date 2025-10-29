package learning.cleancmp.di

import learning.cleancmp.data.repositories.UserRepositoryImpl
import learning.cleancmp.domain.repository.UserRepository
import org.koin.dsl.module

/**
 * Koin DI Module
 * Defines all dependencies for the application
 */
val repositoryModule = module {
    single<UserRepository> {
        UserRepositoryImpl()
    }
}

