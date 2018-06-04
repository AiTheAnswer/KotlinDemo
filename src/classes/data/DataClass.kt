package classes.data

/**
 * 类声明
 * 写法一:
 * 这个name变量是无法被外部访问的。
 */
class Aook(name: String)
/** 等同于Java中这样写,
 *  public final class Aook{
 *     public Aook(@NotNull String name){
 *        super();
 *     }
 * }
 */
/**
 * 写法二、
 * 要想这个name变量被访问到，我们可以在类体中在声明一个变量
 *，然后把这个构造函数中的参数赋值给它：
 * val 只会生成getter方法
 * var 会生成getter和setter方法
 */
class Cook(name: String) {
    val name = name
    //这样写外部就可以访问这个变量了
}

/** 等同于Java中这样写
 * public final class Cook {
 *    @NotNull
 *    private final String name;
 *    public final String getName(){
 *       return this.name;
 *     }
 *    public Cook(@NotNull String name){
 *      super();
 *      this.name = name;
 *   }
 * }
 */
/**
 * 写法三：
 * 构造函数中带有val、var修饰符，Kotlin 编译器会自动为他们生成getter、setter函数
 * val 常量参数不会生成setter方法
 * var 变量参数会生成setter方法
 */
class Dook(val name: String)

class Eook(var name: String)

/**
 * 相当于java中这样写
 * public final class Dook{
 *   @NtNull
 *   private final String name;
 *
 *   public final String getName(){
 *     return this.name;
 *   }
 *   public Dook(@NotNull String name){
 *      super();
 *      this.name = name;
 *   }
 * }
 * public final class Eook{
 *   @NotNull
 *   private String name;
 *
 *   public final String getName(){
 *      return name;
 *   }
 *
 *   @NotNull
 *   public final void setName(String name){
 *      this.name = name;
 *   }
 *
 *   public Eook(String name){
 *       super();
 *       this.name = name;
 *   }
 *
 * }
 */


/**
 * 数据类对应java中的各种实体类
 * 声明：  data class Student(var id: Int){
 *}
 * 主构造函数至少有一个参数，如果想有一个无参构造函数，指定构造参数的默认值
 * 这里的var和val是必须要带上的，因为编译器要把主构造器函数中声明的所有属性值，自动生成一下函数
 * equals()/hashCode()
 * toString(): 格式是User(name = Jacky,gender = Male,age = 10)
 * componentN() 函数
 * copy() 函数
 * 如果自定义了这些函数，或者继承父类重写了这些函数，编译器就不会再去生成
 */
data class Book(val name: String)

data class Fook(var name: String)

data class Student(var name: String, val gender: String, var age: Int) {
    fun validate(): Boolean {
        return true
    }
}

/**
 * 数据类的限制
 * 1、主构造函数需要至少有一个参数（数据类也可以普通类一样可以有次级构造函数）
 * 2、主构造函数的所有的参数需要标记为val或var
 * 3、数据类不能是抽象、开放、密封或者内部的
 * 4、在1.1之前数据类只能实现接口，自1.1起，数据类还可以扩展其他类
 */
open class DBase

interface IBaseA

interface IBaseB

data class LoginUser(val name: String, val pwd: String) : DBase(), IBaseA, IBaseB

/**
 * 数据类的解构
 * 解构相当于Component函数的逆向映射
 * var(name,age) = student
 */
/**
 * 标准数据类Pair,Triple
 */
fun main(args: Array<String>) {
    val aook = Aook("aook")

    val cook = Cook("cook")
    val cookName = cook.name

    val dook = Dook("dook")
    val dookName = dook.name

    val eook = Eook("eook")
    val eookName = eook.name
    eook.name = "eook1"

    val student = Student("张三", "一年级", 8)
    println("$student")
    val equals = student == student.copy(name = "张三")
    println(equals)
    println("${student.hashCode()}")
    //copy方法，复制一个对象 可以指定要更改的属性
    val student1 = student.copy(name = "李四")
    println(student1)
    var (name, gender, age) = student
    println("$name ,$gender , $age")
}