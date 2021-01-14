class Singleton private constructor() {
    // private lateinit var singleton: Singleton
    companion object {
        @JvmStatic
        private lateinit var singleton: Singleton

        @JvmStatic
        fun getInstance(): Singleton {
            if (!this::singleton.isInitialized) {
                singleton = Singleton()
            }

            return singleton
        }
    }
}

// 多线程单例
class Singleton2 private constructor() {
    companion object {
        @JvmStatic
        private lateinit var singleton: Singleton2

        @JvmStatic
        fun getInstance(): Singleton2 {
            synchronized(this) {
                if (!this::singleton.isInitialized) {
                    singleton = Singleton2()
                }
                return singleton
            }
        }
    }
}

// 双重锁定
class Singleton3 private constructor() {
    companion object {
        @JvmStatic
        private lateinit var singleton: Singleton3

        @JvmStatic
        fun getInstance(): Singleton3 {
            if (!this::singleton.isInitialized) {
                synchronized(this) {
                    if (!this::singleton.isInitialized) {
                        singleton = Singleton3()
                    }
                }
            }
            return singleton
        }
    }
}

fun main() {
    val s1 = Singleton.getInstance()
    val s2 = Singleton.getInstance()

    if (s1 == s2) {
        println("相同")
    }
}