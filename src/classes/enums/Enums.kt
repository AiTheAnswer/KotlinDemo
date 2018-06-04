package classes.enums

/**
 * 枚举类
 * enum关键字修饰
 * 两个关键的属性
 * public final val name : String  //对象的值
 * public final val ordinal : Int  //对象的下标
 * 枚举类还实现了Comparable接口
 */

/**
 * 和Java枚举的语法区别
 *   1、Java的枚举类声明不需要class关键字，而Kotlin中的枚举类需要用class关键字修饰
 */
/**
 * 例如方向枚举类
 */
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

/**
 * 初始化枚举值
 */
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

/**
 * 枚举常量也可以声明自己的匿名类
 */
enum class ActivityLifeState {
    ON_CREATE {
        override fun signal() = ON_CREATE
    },
    ON_START {
        override fun signal() = ON_START
    },
    ON_RESUME {
        override fun signal() = ON_RESUME
    };

    abstract fun signal(): ActivityLifeState
}

fun main(args: Array<String>) {
    val north = Direction.NORTH
    println("${north.name} , ${north.ordinal}")
    val red = Color.RED
    val rgb = red.rgb
    println(rgb)
    val state = ActivityLifeState.ON_START
    println(state.signal().name)
    val joinToString = enumValues<Color>().joinToString { "${it.rgb}: ${it.name} : ${it.ordinal}" }
    println(joinToString)
}