package classes.abstract_classes

/**
 * 抽象类
 * 抽象类和普通类的区别有：
 * 1、抽象函数必须为public或protected(因为如果为private,则不能被子类继承，子类便无法实现该方法)，缺省情况下默认为public
 * 2、抽象类不能用来创建对象实例
 * 3、如果一个类继承于一个抽象类，则子类必须重写父类的抽象方法。实现父类抽象函数，我们使用override关键字来表明是重写函数
 */
abstract  class  Person(var name: String, var age: Int) : Any() {
    /**
     * 抽象属性就是在var或val前被abstract修饰，抽象属性的声明格式如下
     * 1、抽象属性在抽象类中不能被初始化
     * 2、如果在子类中没有主构造函数，要对抽象属性手动初始化。如果子类中有主构造函数，抽象属性可以在主构造函数中声明
     */
    //抽象属性
    abstract var address: String
    //抽象属性
    abstract var weight: Float

    /**
     * 抽象函数的特征
     * 1、 抽象函数必须用abstract关键字进行修饰
     * 2、 抽象函数不用手动添加open，默认被open修饰
     * 3、 抽象函数没有具体实现
     * 4、 含有抽象函数的类称为抽象类、必须有abstract关键字修饰。抽象类中可以有具体实现的函数，这样的函数默认是final（不能被覆盖重写）
     *     如果还要重写这个函数，给这个函数加上open 关键字
     */

    //抽象方法doEat()
    abstract fun doEat()

    //抽象方法doWalk()
    abstract fun doWalk()

    //默认被final 修饰的方法，不可被重写
    fun doSwimming() {
        println("I am Swimming")
    }

    //open修饰的方法，可以被重写
    open fun doSleep() {
        println("I am Sleeping")
    }
}

class Teacher(name: String, age: Int) : Person(name, age) {
    override var address: String = "西安"

    override var weight: Float = 74F


    override fun doEat() {
        println("Teacher is Eating")
    }

    override fun doWalk() {
        println("Teacher is Walking")
    }

    override fun doSleep() {
        super.doSleep()
        println("Teacher is Sleeping")
    }

}