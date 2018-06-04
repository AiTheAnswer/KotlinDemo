package collections.generic_type

/**
 * 泛型
 * 和Java相似，主要是 in out
 * 在Kotlin中，我们把那些只能保证读取数据时类型安全的对象叫做生产者，用 out T 标记；
 * 把那些只能保证写入数据安全时类型安全的对象叫做消费者，用 in T 标记。
 */
open class Food
open class FastFood : Food()
class Burger : FastFood()
interface Production<out Food> {
    fun produce(): Food
}

class FoodStore : Production<Food> {
    override fun produce(): Food {
        println("生产食物")
        return Food()
    }
}

class FastFoodStore : Production<FastFood> {
    override fun produce(): FastFood {
        println("生产快餐")
        return FastFood()
    }
}

class BurgerStore : Production<Burger> {
    override fun produce(): Burger {
        println("生产汉堡")
        return Burger()
    }
}

interface Consumer<in Food> {
    fun consumer(item: Food)
}

class Everybody : Consumer<Food> {
    override fun consumer(item: Food) {
        println("Eat Food")
    }
}

class ModernPeople : Consumer<FastFood> {
    override fun consumer(item: FastFood) {
        println("Eat fastFood")
    }

}

class American : Consumer<Burger> {
    override fun consumer(item: Burger) {
        println("Eat Burger")
    }

}

fun main(args: Array<String>) {
    val production1: Production<Food> = FoodStore()
    val production2: Production<Food> = FastFoodStore()
    val production3: Production<Food> = BurgerStore()
    val comsumer1: Consumer<Burger> = Everybody()
    val comsumer2: Consumer<Burger> = ModernPeople()
    val comsumer3: Consumer<Burger> = American()
}