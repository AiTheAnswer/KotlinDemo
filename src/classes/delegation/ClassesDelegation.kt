package classes.delegation

import java.util.*

/**
 * 类的委托（Class Delegation）
 */

interface Subject {
    fun hello()
}

class RealSubject(var name: String) : Subject {
    override fun hello() {
        val now = Date()
        println("Hello,REAL $name! Now is $now")
    }
}

class ProxySubject(private val sb: Subject) : Subject {
    override fun hello() {
        println("Before ! Now is ${Date()}")
        sb.hello()
        println("After ! Now is ${Date()}")
    }
}

fun main(args: Array<String>) {
   val subject = RealSubject("World")
    subject.hello()
    println("-----------")
    val proxySubject = ProxySubject(subject)
    proxySubject.hello()
}