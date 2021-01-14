package iterator

abstract class Iterator {
    abstract fun first(): Any
    abstract fun next(): Any
    abstract fun isDone(): Boolean
    abstract fun currentItem(): Any
}

abstract class Aggregate {
    abstract fun createIterator(): Iterator
}

class ConcreteIterator(private val aggregate: ConcreteAggregate): Iterator() {
    private var current = 0
    override fun first(): Any {
        return aggregate[0]
    }

    override fun next(): Any {
        current++
        return if (current < aggregate.count()) {
            aggregate[current]
        } else {

        }
    }

    override fun isDone(): Boolean {
        return current >= aggregate.count()
    }

    override fun currentItem(): Any {
        return aggregate[current]
    }
}

class ConcreteAggregate: Aggregate() {
    private val items = mutableListOf<Any>()

    override fun createIterator(): Iterator {
        return ConcreteIterator(this)
    }

    fun count(): Int {
        return items.count()
    }

    operator fun get(index: Int): Any {
        return items[index]
    }

    operator fun set(index: Int, value: Any) {
        items.add(index, value)
    }
}

class ConcreteIteratorDesc: Iterator {
    private lateinit var aggregate: ConcreteAggregate
    private var current = 0
    constructor(aggregate: ConcreteAggregate) {
        this.aggregate = aggregate
        current = aggregate.count() - 1
    }

    override fun first(): Any {
        return aggregate[aggregate.count() - 1]
    }

    override fun next(): Any {
        current--
        return if(current >= 0) {
            aggregate[current]
        } else { }
    }

    override fun isDone(): Boolean {
        return current < 0
    }

    override fun currentItem(): Any {
        return aggregate[current]
    }
}

fun main() {
    val a = ConcreteAggregate()

    a[0] = "大鸟"
    a[1] = "小菜"
    a[2] = "行李"
    a[3] = "老外"
    a[4] = "公交车内部员工"
    a[5] = "小偷"

    val i = ConcreteIteratorDesc(a)

    val item = i.first()
    while(!i.isDone()) {
        println("${i.currentItem()} 请买车票！")
        i.next()
    }
}