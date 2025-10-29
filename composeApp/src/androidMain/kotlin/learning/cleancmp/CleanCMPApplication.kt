package learning.cleancmp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import learning.cleancmp.di.koinModule

/**
 * Application class for initializing Koin DI
 */
class CleanCMPApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Initialize Koin
        startKoin {
            androidContext(this@CleanCMPApplication)
            modules(koinModule)
        }
    }
}

