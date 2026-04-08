class Solution {
    fun makeGood(s: String): String {
        val sb = StringBuilder()

        for (c in s) {
            val last = sb.lastOrNull()

            if (last != null && abs(last - c) == 32)
                sb.deleteAt(sb.length - 1)
            else
                sb.append(c)
        }

        return sb.toString()
    }
}