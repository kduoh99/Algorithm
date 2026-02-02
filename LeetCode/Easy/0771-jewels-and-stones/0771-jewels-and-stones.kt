class Solution {
    fun numJewelsInStones(jewels: String, stones: String): Int {
        val jSet = HashSet<Char>()

        for (j in jewels) {
            jSet.add(j)
        }

        var answer = 0

        for (s in stones) {
            if (jSet.contains(s)) {
                answer++
            }
        }

        return answer
    }
}