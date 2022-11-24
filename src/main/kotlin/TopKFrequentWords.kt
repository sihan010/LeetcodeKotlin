import java.util.PriorityQueue

fun topKFrequent(words: Array<String>, k: Int): List<String> {
    val frequency = mutableMapOf<String, Int>()
    words.forEach { word ->
        frequency.getOrDefault(word, 0).let {
            frequency[word] = it + 1
        }
    }

    return frequency
        .toList()
        .sortedWith(
            compareBy(
                {
                    - frequency[it.first]!!
                },
                {
                    it.first
                }
            )
        ).map { it.first }.take(k)


//    val p = PriorityQueue<String>(object:Comparator<String>{
//        override fun compare(o1: String, o2: String): Int {
//            val f1 = frequency[o1]!!
//            val f2 = frequency[o2]!!
//            if(f1==f2) return o2.compareTo(o1)
//            return f1-f2
//        }
//    })
//    frequency.entries.forEach{
//        p.add(it.key)
//        if(p.size>k) p.poll()
//    }
//
//    val r = mutableListOf<String>()
//    while(p.isNotEmpty()){
//        r.add(p.poll())
//    }
//    return r.reversed()
}

fun main() {
    val res = topKFrequent(arrayOf("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"), 4)
    println(res)
}