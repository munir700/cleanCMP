package learning.cleancmp.domain.models.local

/**
 * Result wrapper for handling success/error states
 */
sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
    object Loading : Result<Nothing>()

    /**
     * Map the success value to a different type
     */
    inline fun <R> map(transform: (T) -> R): Result<R> = when (this) {
        is Success -> Success(transform(data))
        is Error -> Error(exception)
        is Loading -> Loading
    }

    /**
     * Get the data or null if it's not a success
     */
    fun getOrNull(): T? = (this as? Success)?.data

    /**
     * Get the exception or null if it's not an error
     */
    fun exceptionOrNull(): Exception? = (this as? Error)?.exception
}

/**
 * Extension functions for Result
 */
inline fun <T> Result<T>.onSuccess(action: (T) -> Unit): Result<T> {
    if (this is Result.Success) action(data)
    return this
}

inline fun <T> Result<T>.onError(action: (Exception) -> Unit): Result<T> {
    if (this is Result.Error) action(exception)
    return this
}

inline fun <T> Result<T>.onLoading(action: () -> Unit): Result<T> {
    if (this is Result.Loading) action()
    return this
}

