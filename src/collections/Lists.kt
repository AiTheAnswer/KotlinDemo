package collections

/**
 * List 集合  分为不可变和可变集合
 *
 * List接口继承Collection接口
 * Collection接口继承Iterable接口
 */
/**
 * 一、创建不可变的List集合
 */
fun createImmutableList() {
    //fun <T> listOf(): List<T> = emptyList()
    //创建一个空List集合
    val list0 = listOf<String>()
    //fun <T> listOf(element: T): List<T> = java.util.Collections.singletonList(element)
    //创建只有一个元素的list集合
    val list1 = listOf("Allen")
    //fun <T> listOf(vararg elements: T): List<T> = if (elements.size > 0) elements.asList() else emptyList()
    // 创建可以有多个元素的List集合
    val list2 = listOf("Allen", 1)

}

/**
 * 将数组转换为List集合
 */
fun arrayToList() {
    var array = arrayOf(1, 2, 3, 4, 5, 6)
    val list = array.asList()
}

/**
 * 创建ArrayList集合
 * Java中的ArrayList
 */
fun createArrayList() {
    val arrayListOf = arrayListOf<Int>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(arrayListOf::class)
}

/**
 * 创建可变集合MutableList
 */
fun createMutableList() {
    //1、空的可变集合
    val emptyList = mutableListOf<Int>()
    //2、多个元素的可变集合
    val mutableListOf = mutableListOf(1, 2, 3, 4, 5, 6, 7)
}

/**
 * List元素的遍历
 * 1、使用迭代器
 * 2、使用ForEach
 */
fun listForEach() {
    val listOf = listOf(1, 2, 3)
    //使用迭代器遍历取出
    //1、获取迭代器
    val iterator = listOf.iterator()
    //2、用迭代器的hasNext()判断是否有下一个
    println("-----------------使用迭代器取出---------------------")
    while (iterator.hasNext()) {
        //3、如果有下一个用next()方法取出
        val next = iterator.next()
        println(next)
    }
    println("------------------使用forEach取出---------------------------")
    //使用ForEach遍历取出
    listOf.forEach {
        //it 指代每次取出的元素
        println(it)
    }

}

/**
 * 可变List集合的元素操作函数
 */
fun mutableListMethods() {
    val mutableList = mutableListOf<String>("Allen", "Kotlin")
    println("原始集合中的元素")
    mutableList.forEach {
        print("$it  ")
    }
    //1、向集合中添加一个元素,不指定添加位置，默认在集合末尾 add()
    mutableList.add("Html")
    println()
    println("填加一个元素之后")
    mutableList.forEach {
        print("$it  ")
    }
    println()
    //2、向List集合指定位置添加元素
    mutableList.add(0, "Kobe")
    mutableList.forEach {
        print("$it  ")
    }
    //3、删除某个元素,如果删除成功返回true  删除失败返回false
    mutableList.remove("Allen")
    //4、删除某个位置上的元素，如果删除成功返回的是当前删除的元素
    mutableList.removeAt(0)
    //5、添加子集合
    mutableList.addAll(listOf("Allen", "Java", "C"))
    println("删除子元素之前----------")
    mutableList.forEach {
        println("$it  ")
    }
    //6、移除子集合
    mutableList.removeAll(listOf("Java", "C"))
    println("删除子元素之后--------------")
    mutableList.forEach {
        println("$it  ")
    }
    //7、set()设置某个位置的元素值
    val set = mutableList.set(0, "明目")
    //8、清空集合
    mutableList.clear()
    //9、把可变集合转换为不可变集合
    mutableList.toList()
    mutableList.addAll(listOf("Kotlin", "Java", "C", "C++", "Html", "JS"))
    val listOf = mutableListOf("Kotlin", "Java", "Html")
    //10、取两个集合的交集 retainAll()
    //retainAll() 返回boolean值   交集的元素返回调用此方法的集合中
    val isRetain = mutableList.retainAll(listOf)
    println("isRetain  = $isRetain")
    mutableList.forEach {
        print("$it   ")
    }
    //11、判断集合中是否包含指定元素 contains()  包含返回true 不包含返回false
    val contains = mutableList.contains("Kotlin")
    //12、查找下标对应的元素 elementAt(index)
    val elementAt = mutableList.elementAt(1)
    //13、查找下标对应的元素，如果越界返回默认值，不会报错
    val elementAtOrElse = mutableList.elementAtOrElse(10, { "$it Default" })
    println(elementAtOrElse)
    //14、查找下标对应的元素，如果越界返回null
    val elementAtOrNull = mutableList.elementAtOrNull(10)
    println(elementAtOrNull)
    //15、返回集合第一个元素，如果是空集，抛出异常NoSuchElementException
    val first = mutableList.first()
    //16、对应的有针对异常处理的函数   如果为空集合  返回为null 不会报错
    val firstOrNull = mutableList.firstOrNull()
    //17、返回第一个满足条件的元素，如果没有则抛出NoSuchElementException
    val first1 = mutableList.first { it == "Java" }
    //18、返回第一个满足条件的元素，如果没有返回null
    val firstOrNull1 = mutableList.firstOrNull { it == "Kotlin" }
    //19、返回指定元素的下标，如果没有该元素，返回-1
    val toList = mutableList.toList()
    val indexOf = toList.indexOf("Kotlin")
    //20、返回第一个符合条件的元素下标，没有就返回-1
    val indexOfFirst = toList.indexOfFirst { it.contains("J") }
    println(indexOfFirst)
    //20、返回最后一个符合条件的元素下标，没有就返回-1
    val indexOfLast = toList.indexOfLast { it.contains("J") }
    println(indexOfLast)
    //21、返回集合最后一个元素，空集抛出异常NoSuchElementException
    val last = mutableList.last()
    //22、返回最后一个满足条件的元素，没有就抛出NoSuchElementException
    val last1 = mutableList.last { it.contains("a") }
    //23、针对越界处理的lastOrNull
    val lastOrNull = mutableList.lastOrNull { it.contains("A") }
    val list = listOf(2, 4, 6, 8, 9, 11, 12, 16)
    val takeLastWhile = list.takeLastWhile({ it % 2 == 0 })
    println("-------------")
    takeLastWhile.forEach({ println(it) })
    //24、去除前n个元素，返回剩下元素的子集合
    val drop = list.drop(3)
    //25、取开始下标至结束下标元素子集合
    mutableList.addAll(listOf("Kotlin", "Java", "C", "JS", "Html"))
    val slice = mutableList.slice(1..3)
    slice.forEachIndexed { index, s ->
        println("index = $index s = $s")
    }
    val map = list.map {
        if (it % 2 == 0){
            val i = it * it
            i
        }else{
            val s = "A"
            s
        }

    }
    map.forEach {
        println(it)
    }

}

fun main(args: Array<String>) {
    createImmutableList()
    createArrayList()
    createMutableList()
    listForEach()
    mutableListMethods()
}