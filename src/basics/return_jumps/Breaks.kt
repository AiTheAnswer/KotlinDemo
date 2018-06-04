package basics.return_jumps

/**
 * break  跳出当前循环
 */

fun foo1() {
    for (i in 1..15){
        if(i == 10){
            break
        }
        println(i)
    }
    println("----------------")
    loop@ for (i in 1..5){
        for(j in 1..5){
            if (j == 3){
                break@loop
            }
            println(j)
        }
    }
}

fun main(args: Array<String>) {
  foo1()
}
