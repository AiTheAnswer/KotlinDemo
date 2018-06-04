package classes.delegation

import kotlin.reflect.KProperty

/**
 * 属性委托（Delegation Properties）
 * 通常对于属性类型，我们是在每次需要的时候手动声明它们：
 */
class NormalPropertiesDemo {
    var content: String = "NormalProperties init content"
}

class DelegationPropertiesDemo {
    var content: String by Content()
}

class Content {
    operator fun getValue(delegationPropertiesDemo: DelegationPropertiesDemo, property: KProperty<*>): String {
        return "Balalala....."
    }

    operator fun setValue(delegationPropertiesDemo: DelegationPropertiesDemo, property: KProperty<*>, value: String) {


    }
}

fun main(args: Array<String>) {

}