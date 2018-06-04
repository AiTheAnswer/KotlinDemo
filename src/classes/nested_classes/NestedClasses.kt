package classes.nested_classes

/**
 * 嵌套类：类中类
 * 类可以嵌套在其他类中，可以嵌套多层
 */
class NestedClassesDemo {
    class Outer {
        private val zero: Int = 0
        val one: Int = 1

        class Nested {
            fun getTwo() = 2

            class Nested1 {
                val three = 3
                fun getFour() = 4
            }
        }
    }
}

fun main(args: Array<String>) {
    /**
     * 访问嵌套类的方式是直接使用类名. ,有多少层嵌套，就用多少层类名来访问
     * 普通的嵌套类，没有持有外部类的引用，所以是无法访问外部类的变量
     */
    val one = NestedClassesDemo.Outer().one
    val two = NestedClassesDemo.Outer.Nested().getTwo()
    val three = NestedClassesDemo.Outer.Nested.Nested1().three
    val four = NestedClassesDemo.Outer.Nested.Nested1().getFour()
}