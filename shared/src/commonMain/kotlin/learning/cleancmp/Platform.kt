package learning.cleancmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform