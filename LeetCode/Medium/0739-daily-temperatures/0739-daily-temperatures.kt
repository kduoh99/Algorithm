class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stack = ArrayDeque<Int>()
        val answer = IntArray(temperatures.size)

        for (i in temperatures.indices) {
            while (stack.isNotEmpty() && temperatures[stack.first()] < temperatures[i]) {
                val top = stack.removeFirst()
                answer[top] = i - top
            }
            stack.addFirst(i)
        }

        return answer
    }
}