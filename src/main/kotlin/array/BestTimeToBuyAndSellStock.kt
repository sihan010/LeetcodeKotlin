package array
import kotlin.math.max

// 121

private fun maxProfit(prices: IntArray): Int {
    var buy=0
    var sell=1
    var profit = 0
    while(sell<prices.size){
        val currentProfit = prices[sell]-prices[buy]
        profit = max(profit, currentProfit)
        if(currentProfit<0)
            buy=sell
        sell++
    }
    return profit
}

fun main() {
    val res = maxProfit(intArrayOf(9,2,4,2,5,7,2,4,9,10,9))
    println(res)
}