package classes.sealed

/**
 * sealed 密封类
 * 一、为什么要使用密封类
 * 一个类之所以被设计成sealed,就是为了限制类的继承结构，将一个值限制在有限集中的类型中，而不能有任何其他的类型
 * 在某种意义上，sealed类是枚举类的扩展：枚举类型的值集合也是受限的，但每个枚举常量只存在一个实例，
 * 而密封类的一个子类有可包含状态的多个实例。
 * 二、 声明密封类
 *   需要在类名前面添加sealed修饰符。密封类的所有子类都必须与密封类在同一个文件中声明
 *
 */
sealed class Expression

class Unit : Expression()

data class Const(val number: Double) : Expression()

data class Sum(val e1: Expression, val e2: Expression) : Expression()

data class Multiply(val e1: Expression, val e2: Expression) : Expression()

object NaN : Expression()

fun eval(expr: Expression): Double = when (expr) {
    is Unit -> 1.0
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    is Multiply -> eval(expr.e1) * eval(expr.e2)
    NaN -> Double.NaN
}

/**
 * 使用密封类的主要场景是在使用 when 表达式的时候，能够验证语句覆盖了所有情
 * 况，而无需再添加一个 else 子句
 */
fun eval2(expr: Expression): Double {
    return when (expr) {
        is Unit -> 1.0
        is Const -> expr.number
        is Sum -> eval(expr.e1) + eval(expr.e2)
        is Multiply -> eval(expr.e1) * eval(expr.e2)
        NaN -> Double.NaN
    }
}

fun main(args: Array<String>) {
    val u = eval(Unit())
    val a = eval(Const(10.0))
    val b = eval(Sum(Const(10.0), Const(20.0)))
    val c = eval(Multiply(Const(10.0), Const(10.0)))
    val d = eval(NaN)
    println(u)
    println(a)
    println(b)
    println(c)
    println(d)

}