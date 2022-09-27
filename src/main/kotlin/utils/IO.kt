package utils

fun readInt() = readLine()?.toInt() // single int
fun readStrings() = readLine()?.split(" ") // list of strings
fun readInts() = readLine()?.map { it.toInt() } // list of ints
fun <T> printMulti(vararg args:T){
    println(args.joinToString(", "))
}

fun <T> Array<T>.printArray(){
    println(joinToString(", ") { it.toString() })
}

fun Array<IntArray>.print2dArray(){
    for(i in 0 until this.size){
        println(this[i].joinToString(", ") { it.toString() })
    }
}

fun IntArray.printIntArray(){
    println(joinToString(", ") { it.toString() })
}