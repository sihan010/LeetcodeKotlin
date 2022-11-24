package binary

import kotlin.math.abs

// https://leetcode.com/problems/number-of-1-bits/
// 191

private fun hammingWeight(n:Int):Int {
    var res = 0
    val s = toBinaryString(n, 32)
    s.forEach { ch ->
        if(ch=='1')
            res++
    }
    return res
}

private fun toBinaryString (n: Int, bit:Int = 32):String{
    var res = ""
    return if(n>=0){
        var num = n
        while(num>0){
            res = "${num%2}$res"
            num/=2
        }
        res.padStart(bit,'0')
    }
   else{
        var num = abs(n)-1
        while(num>0){
            res = if(num%2==0) "1$res" else "0$res"
            num/=2
        }
        res.padStart(bit,'1')
    }
}

fun main(){
    val res = hammingWeight(-3)
    println(res)
}