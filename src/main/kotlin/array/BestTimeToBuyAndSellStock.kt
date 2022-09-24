package array
import kotlin.math.max

// 121

fun maxProfit(prices: IntArray): Int {
    var l = 0
    var r = 1
    var p = 0
    val s = prices.size
    while(r<s){
        if(prices[r]>prices[l])
            p = max(p, prices[r]-prices[l])
        else l=r
        r+=1
    }
    return p
}

fun main() {
    val res = maxProfit(intArrayOf(1,2,4,2,5,7,2,4,9,0,9))
    println(res)
}