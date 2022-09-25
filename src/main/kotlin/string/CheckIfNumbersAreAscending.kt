package string

// 2042

private fun areNumbersAscending(s: String): Boolean {
    val tokens = s.split(" ")
    var toCheck = -1
    for(token in tokens){
        with(token.toIntOrNull()){
            if(this!=null){
                if(this<=toCheck)
                    return false
                else toCheck = this
            }
        }
    }
    return true
}

fun main(){
    val res = areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles")
    println(res)
}