package classes

/**
 * 一、类的声明
 */
//1、类的声明用 class关键字修饰
class Invoice {

}

//2、类如果没有类体  花括号可以省略
class Empty

/**
 * 二、构造方法
 */
class Person1 constructor(firstName: String) {
    var lastName: String = ""
    fun say() {
        println("A")
    }
}

/**
 * 如果主构造函数没有注解和可见性说明，则constructor关键字是可以省略的
 */
class Person2(firstName: String)


/**
 * 主构造函数是类头的一部分，直接放在类名后面
 */
open class Student constructor(var naem: String, var age: Int) : Any() {
    fun study() {}
}

/**
 * 如果主构造函数没有任何注解或者可见性修饰符，可以省略这个 constructor 关键
 * 字。如果构造函数有注解或可见性修饰符，这个 constructor 关键字是必需的，并且
 * 这些修饰符在它前面：
 */
annotation class MyAutowired

private class ElementaryStudent @MyAutowired private constructor(name: String, age: Int) : Student(name, age) {
    var weight = 40
    var yin = "yin"
}

/**
 * 工人类
 * 初始化代码块
 */
class Worker(name: String, age: Int) {
    var student = object : Student("A", 12){

    }
    internal var name: String = name
    internal var age: Int = age
    internal var sex: Int


    //如果有次级构造方法，必须继承主级构造方法，使用this
    constructor(name: String, age: Int, sex: Int) : this(name, age) {
        this.sex = sex
    }

    //初始化代码块在主构造方法执行后执行
    init {
        this.sex = 0
    }

}

fun main(args: Array<String>) {
    val worker0 = Worker("张三", 20)
    val worker1 = Worker("李四", 20, 1)
    val name = worker0.name
    val age = worker0.age
    val sex = worker0.sex
    worker0.name = "王五"
    println("worker0{name = ${worker0.name} , age = $age ,sex = $sex}")

}

