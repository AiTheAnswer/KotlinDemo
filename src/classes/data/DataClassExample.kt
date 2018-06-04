package classes.data

/**
 * 数据类必须要用data 修饰   格式：  data class Person(val name:String ,val age : Int){}
 * 数据实体类（可以指定属性的默认值和属性是否可以为null）
 * 可以通过 .属性名获取属性值
 * 属性名必须用var获val修饰
 */


/**
 * 创建一个员工数据类
 * 有两个属性 姓名和年龄（没有默认值，参数必须传）
 */
data class Employee(val name: String, val age: Int)

/**
 * 创建一个工人数据类
 * 也有两个属性 姓名和年龄 有默认值，创建对象的时候可以不参数
 */
data class Worker(val name: String = "Unknown", val age: Int = 0)

/**
 * 用户类
 * 属性id 可以为null
 */
data class User(val name: String, val id: Int?)

/**
 * 方法获取一个默认的用户
 */
fun getUser(): User {
    return User("王五", null)
}

fun main(args: Array<String>) {
    val employee0 = Employee("张三", 20)
    val worker0 = Worker("李四", 25)
    val worker1 = Worker()
    println(employee0)
    println(worker0)
    println(worker1)
    val user = getUser()
    println("name = ${user.name} , id = ${user.id}")
    //or
    val (name, id) = getUser()
    println("name = $name , id = $id")
    //or
    println("name = ${getUser().name} ,id = ${getUser().id}")

}
