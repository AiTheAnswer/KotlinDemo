package classes.inner_classes

/**
 * 内部类
 * 类可以标记为inner以便能够访问外部类的成员，内部类会带有一个对外部类的对象的引用
 */
class NestedClassesDemo {
    class Outer {
        private val zero = 0
        val one = 1

        class Test {
            fun test() {
                println("test")
            }
        }

        inner class Inner {
            fun accessOuter() {
                println(zero)
                println(one)
            }
        }
    }
}

fun main(args: Array<String>) {
    /**
     * 访问内部类必须通过外部类的实例来访问
     * 访问普通嵌套类直接通过外部类名
     */
    NestedClassesDemo.Outer().Inner().accessOuter()
    NestedClassesDemo.Outer.Test().test()
}