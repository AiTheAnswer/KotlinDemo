package classes.interfaces

/**
 * Kotlin 的接口 用interface来修饰
 * 与抽象类相比，他们都可以包含抽象的方法以及方法的实现
 * 接口的是不允许初始化的，也就是说接口中的属性都是抽象的
 */
/**
 * 接口和Java接口语法上的区别
 * 1、Java中的接口不允许有抽象的属性，Java中接口的属性都不是抽象的，而Kotlin中接口中的属性都是抽象的
 * 2、Java中的接口不允许有非抽象的方法，也就是不允许方法有方法体，而Kotlin中可以有非抽象的方法
 * 3、Java中不会有重写的冲突，而Kotlin中会有覆盖冲突。使用super<>.
 */

interface ProjectService {
    val name: String
    val owner: String
    fun save(project: String)
    //覆盖冲突
    fun print() {
        println("I am Project")
    }

}

interface MilestoneService {
    val name: String //抽象属性
    val owner: String get() = "Jack" //访问器
    fun save(milestone: Int)
    fun print() {
        println("I am MilestoneService")
    }

    fun doLogin(name: String, pwd: String) {

    }
}

class ProjectMilestoneServiceImpl : ProjectService, MilestoneService {
    override val name: String
        get() = "ProjectMilestone"

    override val owner: String
        get() = "Owner"

    override fun save(project: String) {
        println("save $project")
    }

    /**
     * 覆盖冲突
     * 如果多个父接口有同样的方法，覆盖后调用父类方法不能仅用super.print()
     * 可以用super<ProjectService>.print()
     */
    override fun print() {
        super<ProjectService>.print()
        super<MilestoneService>.print()
        println("print")
    }

    override fun save(milestone: Int) {
        print("milestone : $milestone")
    }

}

fun main(args: Array<String>) {
    val serviceImpl = ProjectMilestoneServiceImpl()
}
/**
 * 抽象类和接口的差异
 * 概念上的区别
 *     接口主要是对动作的抽象，定义了行为特约的规约。
 *     抽象类是对根源的抽象。
 *     当你关注一个事物的本质的时候，用抽象类
 *     当你关注一个操作的时候，用接口
 * 语法层面上的区别
 *     1、接口不能保存状态，可以有属性但必须是抽象的。一个类只能继承一个抽象类，而一个类却可以实现多个接口。
 *     2、类如果要实现一个接口，它必须要实现接口声明的所有方法。但是，类可以不实现抽象类声明的所有方法，当然，在这种情况下，类
 *  也必须得声明成抽象的。
 *     3、接口中所有的方法隐含的都是抽象的。而抽象类则可以同时包含抽象和非抽象的方法
 *  设计层面上的区别
 *     1、抽象类是对一种事物的抽象，即对类抽象，而接口是对行为的抽象。抽象类是对整个类整体进行抽象，包括属性、行为，但是接口是对类局部（行为）进行抽象
 *     2、对于抽象类，如果需要添加新的方法，可以直接在抽象类中添加具体的实现，子类可以不进行变更
 *     3、而接口不行，如果接口进行了变更，则所有实现这个接口的类都必须进行相应的改动
 *
 */