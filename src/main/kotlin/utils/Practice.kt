package utils

fun main() {
//    try {
//        listOf(1, 2, 3, 4, 5, 6, 7, 8, 9).takeTillWithEx(9).printListTill(4)
//    } catch (ex: RuntimeException) {
//        println("Exception ${ex::class.simpleName} --> ${ex.message}")
//    }
    for(i in 0.until(15) ){
        println(i)
    }
}

fun <T> List<T>.printListTill(threshold: T) {
    run jump@{
        forEachIndexed { index, item ->
            println("start")
            println("$index: $item")
            if (item == 2)
                return@forEachIndexed
            if (item == threshold)
                return@jump // acts as break in lambdas
            println("stop")
        }
        println("Printed all items")
        return
    }
    for(i in 1 until size){

    }
    println("Printed till threshold")
}

inline fun <reified T, reified P> List<T>.takeTillWithEx(thresholdItem: P): List<T> {
    if (P::class.java !== T::class.java)
        throw TypeMismatchException("List was of ${T::class.simpleName} but got ${P::class.simpleName} to compare")

    (thresholdItem as T).let {
        if (it !in this)
            return this
        return take(lastIndexOf(it) + 1)
    }
}

fun <T> List<T>.takeTillWithoutEx(thresholdItem: T): List<T> {
    if (thresholdItem !in this)
        return this
    return take(lastIndexOf(thresholdItem) + 1)
}

class TypeMismatchException(message: String) : RuntimeException(message)