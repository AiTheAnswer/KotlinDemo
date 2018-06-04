package basics

/**
 * 使用 is 操作符检测是否为类型实例
 */


fun main(args: Array<String>) {
      println(getStringLength("aaa"))
      println(getStringLength(22))

}


/**
 * 使用is操作符检测是否为类型实例，会自动转型
 */
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        //‘obj'在该条件分支内自动转换成'String'
        println("String " + obj::class) //class java.lang.String
    }
    //在离开检测分支后，'obj'仍然是'Any'类型
    println(obj::class.java) //class java.lang,Object
    //使用 ！is 表示非当前类型
    if (obj !is String) {
        if (obj is Int) {
            //‘obj'在该条件分支内自动转换成'Int'
            println(obj::class) //class java.lang.String
        }
    }
    //在离开检测分支后，'obj'仍然是'Any'类型
    println(obj::class) //class java.lang,Object
    //在when 条件语句中会自动转型
    /* when (obj) {
         is Int -> return obj + 1
         is String -> return obj.length + 1
         is IntArray -> return obj.sum()
     }
 */
    return null
}