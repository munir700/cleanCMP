package learning.cleancmp.di

import learning.cleancmp.presentation.users.UserListViewModel
import org.koin.dsl.module

/**
 * Koin DI Module
 * Defines ViewModels dependencies for the application
 */
val viewModelModule = module {


    factory {
        UserListViewModel(
            fetchUsers = get(),
            observeUsers = get()
        )
    }
}

