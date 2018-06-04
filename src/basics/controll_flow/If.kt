package basics.controll_flow

fun main(args: Array<String>) {
    ifExample(5,4)
}

fun ifExample(x: Int, y: Int): Unit {
    var result = if(x > y){
        println("$x > $y")
        true
    }else{
        println("$x < $y")
        false
    }
    println("result = $result")
}