package basics.destructuring_declaration

/**
 * 结构解析
 */
fun main(args: Array<String>) {
    //创建有两个参数的类对象
    val pair = Pair(3, "Ai")
    //将对象的多个属性解析成多个变量
    val (number) = pair
    println("number = $number ")
    //创建有三个参数的类对象
    val triple = Triple("上海", 2, "北京")
    //将对象的属性进行解析
    val (address1, index, address2) = triple
    println("address1 = $address1 , index = $index , address2 = $address2")
    //也可以使用componentN进行属性单个解析
    var address = triple.component1()
    println("address = $address")
}