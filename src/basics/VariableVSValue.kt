package basics

/**
 * 声明变量和值
 */

class VariableVSValue {
    fun declareVar() {
        var a = 1
        a = 2
        println(a)
        println(a::class)
        println(a::class.java)

    }
}

fun main(args: Array<String>) {
    val variableVSValue = VariableVSValue()
    variableVSValue.declareVar()
    val any = Any()
    println(any)
    println(any::class)
    println(any::class.java)
}