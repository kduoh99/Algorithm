class Solution {
    fun longestPalindrome(s: String): String {
        val ch = s.toCharArray()
        var answer = ch[0].toString()

        for (i in 2 .. ch.size) {
            for (j in 0 .. ch.size - i) {
                var left = j
                var right = j + i - 1
                var flag = true

                while (left < right) {
                    if (ch[left] != ch[right]) {
                        flag = false
                        break
                    }
                    left++
                    right--
                }

                if (flag) {
                    answer = s.substring(j, j + i)
                    break
                }
            }
        }

        return answer
    }
}