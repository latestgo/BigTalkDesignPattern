package interpret

abstract class AbstractExpression {
    abstract fun interpret(context: Context)
}

class TerminalExpression: AbstractExpression() {
    override fun interpret(context: Context) {
        println("终端解释器")
    }
}

class NonterminalExpression: AbstractExpression() {
    override fun interpret(context: Context) {
        println("非终端解释器")
    }
}

class Context {
    lateinit var input: String
    lateinit var output: String
}

fun main() {
    val context = Context()
    val list = listOf(TerminalExpression(), NonterminalExpression(), TerminalExpression(), TerminalExpression())

    list.forEach { it.interpret(context) }
}