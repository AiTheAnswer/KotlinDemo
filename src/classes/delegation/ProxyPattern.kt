package classes.delegation

/**
 * 代理模式
 */

/**
 * 代理者需要有的功能
 */
interface JSubject{
    fun request()
}

/**
 * 真正执行请求的类
 */
class JRealSubject:JSubject{
    override fun request() {
        println("JRealSubject : 真正执行请求")
    }
}

/**
 * 调用代理者的类
 */
class JProxy (private val subject : JSubject): JSubject{

    private fun before(){
        println("请求开始之前")
    }

    override fun request() {
        before()
        subject.request()
        after()
    }
    private fun after(){
        println("请求完成之后")
    }

}

fun main(args: Array<String>) {
    val jRealSubject = JRealSubject()
    val jProxy = JProxy(jRealSubject)
    jProxy.request()
}