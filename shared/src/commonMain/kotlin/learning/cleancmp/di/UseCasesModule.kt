package learning.cleancmp.di

import org.koin.dsl.module
import learning.cleancmp.domain.useCases.FetchUsersUseCase
import learning.cleancmp.domain.useCases.ObserveUsersUseCase

/**
 * Koin DI Module
 * Defines all dependencies for the application
 */
val useCaseModule = module {
    // Use Cases
    factory { FetchUsersUseCase(get()) }
    factory { ObserveUsersUseCase(get()) }

    // ViewModels
}

