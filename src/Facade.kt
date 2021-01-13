class SubSystemOne {
    fun methodOne() {
        println("子系统方法一")
    }
}

class SubSystemTwo {
    fun methodTwo() {
        println("子系统方法二")
    }
}

class SubSystemThree {
    fun methodThree() {
        println("子系统方法三")
    }
}

class SubSystemFour {
    fun methodFour() {
        println("子系统方法四")
    }
}

class Facade() {
    private lateinit var subSystemOne: SubSystemOne
    private lateinit var subSystemTwo: SubSystemTwo
    private lateinit var subSystemThree: SubSystemThree
    private lateinit var subSystemFour: SubSystemFour

    init {
        subSystemOne = SubSystemOne()
        subSystemTwo = SubSystemTwo()
        subSystemThree  = SubSystemThree()
        subSystemFour = SubSystemFour()
    }

    fun methodA() {
        println("\n 方法组 A()------")
        subSystemOne.methodOne()
        subSystemTwo.methodTwo()
        subSystemFour.methodFour()
    }

    fun methodB() {
        println("\n 方法组 B()------")
        subSystemTwo.methodTwo()
        subSystemThree.methodThree()
    }
}

fun main() {
    val facade = Facade()

    facade.methodA()
    facade.methodB()
}