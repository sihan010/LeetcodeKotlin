// 1041
// https://leetcode.com/problems/robot-bounded-in-circle/

private fun isRobotBounded(instructions: String): Boolean {
    val ins = instructions.toCharArray()
    var x = 0
    var y=0
    var direction = 'N'
    for(i in ins){
        when (i) {
            'G' -> {
                when (direction) {
                    'N' -> y+=1
                    'S' -> y-=1
                    'E' -> x+=1
                    'W' -> x-=1
                }
            }
            'L' , 'R' -> {
                direction = getDirection(direction, i)
            }
        }
    }
    if(x==0 && y==0) return true
    if(direction!='N') return true
    return false
}

private fun getDirection (currentDirection:Char, instruction:Char):Char{
    when (instruction) {
        'L' -> {
            return when (currentDirection) {
                'N' -> 'E'
                'S' -> 'W'
                'E' -> 'S'
                'W' -> 'N'
                else -> '0'
            }
        }
        'R' -> {
            return when (currentDirection) {
                'N' -> 'W'
                'S' -> 'E'
                'E' -> 'N'
                'W' -> 'S'
                else -> '0'
            }
        }
        else -> return '0'
    }
}

fun main(){
    val res = isRobotBounded("GL")
    println(res)
}