fun main(args: Array<String>) {
    var a = 1
    a =2
    println(a)
    println(a::class)
    println(a::class.java)
    println("Hello World")
    for (name in args) {
        println("Hello $name")
    }
    if (args.isEmpty()) {
        println("main 方法的参数为空")
    } else {
        println("Hello ${args[0]}")
    }
    val language = if (args.isEmpty())
        "EN"
    else
        args[0]
    println(when (language) {
        "EN" -> "Hello!"
        "FR" -> "Sa!"
        "IT" -> "It!"
        else -> 757
    })
   var demo =  Demo("Demo")
    println(demo)
}

class Demo(var name: String){
    fun greet(){
        println(name)
    }
}