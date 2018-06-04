package classes.inheritance

/**
 * 一、继承的概念
 * 继承是面向对象编程的一个重要的方式，因为通过继承，子类就可以扩展父类的功能
 * 在Kotlin 中，所有的类会默认继承Any这个父类，但Any并不完全等于Java中的Object类，因为它只有equals(),hashCode(),toString()这三个方法
 */

/**
 * 二、open 类
 *
 * 除了抽象类、接口默认可以被继承（实现）外，我们也可以把一个类声明为open的，这样我们就可以继承这个open类
 *
 * 抽象类默认是open的
 */
/**
 * 三、单继承
 * Kotlin和Java一样，没有采用多继承，任何一个子类仅允许一个直接父类存在
 */
/**
 * 父类
 * Kotlin中的类都默认是被public final 修饰的
 * 如果这个类要被可以被继承，必须使用open关键字修饰
 * open 类中的方法如果希望子类可以重写的也需要用open关键字修饰
 *
 * 抽象函数和接口中定义的方法默认都是open的
 *
 */
open class Base(name: String) {
    internal var name: String
    private var type: String

    constructor(name: String, type: String) : this(name) {
        this.name = name
        this.type = type
    }

    init {
        this.name = name
        this.type = "A"
    }

    open fun doSomething() {
        println("父：你能做什么呢？")
    }

    fun doLogin(name: String?, pwd: String?): String {
        var result = "登录失败"
        if (name.isNullOrEmpty() || pwd.isNullOrEmpty()) {
            println("没有用户名和密码如何登录，你是不是傻？")
        } else if (name.equals("admin") && pwd.equals("admin")) {
            result = "登录成功"
        } else {
            println("用户名或密码错误，哎！你还能干什么")
        }
        return result
    }
}

/**
 * 子类
 * 子类重写父类方法需要用override
 */
class SubClass(type: String) : Base(type) {

    //override的方法也是open修饰的，如果override方法不想被子类修饰可以用final修饰
    override fun doSomething() {
        super.doSomething()
        println("子：你能做什么我就可以做什么")
    }
}


fun main(args: Array<String>) {
    val subClass = SubClass("A")
    subClass.doSomething()
    subClass.name
    val result = subClass.doLogin("admin", "admin")
    println("登录结果： $result")
    val dog = Dog("哮天犬")
    dog.doEat()
    dog.doRun()
    val eagle = Eagle("老鹰1号")
    eagle.doEat()
    eagle.doFly()
    val archaeopteryx =Archaeopteryx("始祖鸟1号")
    archaeopteryx.doEat()
    archaeopteryx.doFly()
    archaeopteryx.doRun()
}

/**
 * 单继承、多实现
 */
//抽象动物父类
abstract class Animal(name: String) {
    internal var name: String = name
    abstract fun doEat()
}

//会跑行为的接口
interface Runnable {
    fun doRun()
}

//会飞行为的接口
interface Flyable {
    fun doFly()
}

/**
 * Dog类继承子Animal,实现会跑行为的接口
 */
class Dog(name: String) : Animal(name), Runnable {
    override fun doEat() {
        println("Dog: $name 爱吃狗肉馅的包子")
    }

    override fun doRun() {
        println("Dog: $name 可以跑的很快的")
    }
}

/**
 * Eagle类继承Animal类，实现会飞行为的方法
 */

class Eagle(name: String) : Animal(name), Flyable {
    override fun doEat() {
        println("Eagle: $name 爱吃什么呢？好像我也不知道呀")
    }

    override fun doFly() {
        println("Eagle: $name 但我知道它会飞呀")
    }
}

/**
 * 始祖鸟继承Animal,实现会跑会飞的接口
 */
class Archaeopteryx(name: String) : Animal(name), Runnable, Flyable {
    override fun doEat() {
        println("Archaeopteryx: $name 好像这个我也不知道爱吃什么，但我知道它会吃东西")
    }

    override fun doRun() {
        println("Archaeopteryx: $name 会跑的，是不是很厉害")
    }

    override fun doFly() {
        println("Archaeopteryx: $name 还会飞的，厉害吧")
    }

}