package string

//2124

private fun checkString(s: String): Boolean {
    var toCheck = 'a'
    val indices = s.indices
    for(i in indices){
        if(s[i]=='a' && toCheck=='b')
            return false
        if(s[i]=='b')
            toCheck = 'b'
    }
    return true
}

fun main(){
    val res = checkString("aba")
    println(res)
}