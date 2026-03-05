class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val merged = mutableListOf<IntArray>()
        intervals.sortBy { it[0] }

        for (i in intervals) {
            if (merged.isNotEmpty() && i[0] <= merged.last()[1]) {
                merged.last()[1] = maxOf(merged.last()[1], i[1])
            } else {
                merged.add(i)
            }
        }

        return merged.toTypedArray()
    }
}