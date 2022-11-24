/***
C1: https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/
C2:
Amazon Academy recently organized a scholarship test on its platform. A total of n students
participated in the test. Each student received a unique roll number, i. Each student's rank is
stored at rank[i]. Each student gets a unique rank, so rank is a permutation of values 1 through n.

For improved collaboration, the students are to be divided into groups. Use the following rules to
find the imbalance of a group of students.

• A group has k students where 1<=k<=n.
• Groups are formed of k students in ranks with consecutive roll numbers, i.e., i, (i + 1), . (i+ k - 1).
• The ranks of the students in a group are then sorted ascending to an array, here named sorted_rank.
• The imbalance of the group is then defined as the number of students j, who are more than 1 rank
beneath the rank of the student just ahead of them, i.e, sorted_rank[i] - sorted_rank[i- 1] > 1.

For example, the ranks in a group are [1, 5, 4] so sorted_rank = [1, 4, 5].
• 4-1 =3, and 3 > 1. This adds 1 to the imbalance.
• 5-4 = 1, and 1 = 1. This does not add to the imbalance.
The imbalance is 1.

Given the ranks of n students, find the total sum of the imbalance of all possible groups.

Example
rank = [3, 1, 2]
The corresponding imbalances are:
[3] -> [3] -> imbalance = 0
[1] -> [1] -> imbalance = 0
[2] -> [2] -> imbalance = 0
[3, 1] -> [1, 3] -> imbalance = 1
[1, 2] -> [1, 2] -> imbalance = 0
[3, 1, 2] -> [1, 2, 3] -> imbalance = 0
The total imbalance is 1.

rank = [4, 1, 3, 2]
[4] -> [4] -> imbalance = 0
[1] -> [1] -> imbalance = 0
[3] -> [3] -> imbalance = 0
[2] -> [2] -> imbalance = 0
[4, 1] -> [1, 4] -> imbalance = 1
[1, 3] -> [1, 3] -> imbalance = 1
[3, 2] -> [2, 3] -> imbalance = 0
[4, 1, 3] -> [1, 3, 4] -> imbalance = 1
[1, 3, 2] -> [1, 2, 3] -> imbalance = 0
[4, 1, 3, 2] -> [1, 2, 3, 4] -> imbalance = 0
The total imbalance is 3.

Catch: Solve it with complexity O(n^2)
 */

private fun printAllSubArrays(array: Array<Int>): List<List<Int>> {
    val n = array.size
    val subArrays = mutableListOf<List<Int>>()
    for (i in 0 until n) {
        val subArrayTillNow = mutableListOf<Int>()
        for (j in i until n) {
            subArrayTillNow.add(array[j])
            // println(subArrayTillNow)
            subArrays.add(subArrayTillNow.toList())
        }
    }
    return subArrays.toList()
}

private fun findTotalImbalanceO2(rank: Array<Int>): Long {
    var totalImbalance = 0L
    val n = rank.size
    for (i in 0 until n) {
        val group = mutableListOf<Int>()
        for (j in i until n) {
            group.add(rank[j])
            // We don't care about size 1 because imbalance is always 0
            if (group.size >= 2)
                totalImbalance += calculateImbalanceForGroup(group.toList())
        }
    }
    return totalImbalance
}

private fun findTotalImbalanceO3(rank: Array<Int>): Long {
    var totalImbalance = 0L
    val n = rank.size
    // We don't care about range 1 because imbalance is always 0
    for (i in 2..rank.size) {
        totalImbalance += calculateImbalanceForRange(rank, n, i)
    }
    return totalImbalance
}

private fun calculateImbalanceForRange(rank: Array<Int>, n: Int, range: Int): Long {
    var imbalanceForRange = 0L
    for (i in 0..n - range) {
        val group = mutableListOf<Int>()
        for (j in i until range + i) {
            group.add(rank[j])
        }
        imbalanceForRange += calculateImbalanceForGroup(group.toList())
    }
    return imbalanceForRange
}

private fun calculateImbalanceForGroup(group: List<Int>): Long {
    val sortedGroup = group.sorted()
    val groupSize = group.size
    var imbalance = 0L
    for (i in 1 until groupSize) {
        if (sortedGroup[i] - sortedGroup[i - 1] > 1)
            imbalance++
    }
    println("$group -> $sortedGroup -> imbalance = $imbalance")
    return imbalance
}

fun main() {
    val input = arrayOf(3, 20, 30)
//    val resO3= findTotalImbalanceO3(input)
//    println("Result: $resO3")
    val resO2 = findTotalImbalanceO2(input)
    println("Result: $resO2")
//    println(printAllSubArrays(input))
}
