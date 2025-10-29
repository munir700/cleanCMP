package learning.cleancmp.di

import org.koin.dsl.module

/**
 * Koin DI Module
 * Defines all dependencies for the application
 */
val koinModule = module {
    // Use Cases
    viewModelModule
    useCaseModule
    repositoryModule
}

