import java.util.*;

class Solution {
    fun mostCommonWord(paragraph: String, banned: Array<String>): String {
        val delimiters = " !?',;."
        val st = StringTokenizer(paragraph.lowercase(), delimiters)
        val map: MutableMap<String, Int> = mutableMapOf()

        while (st.hasMoreTokens()) {
            var flag = false
            val word = st.nextToken()

            for (ban in banned) {
                if (word == ban) {
                    flag = true
                    break
                }
            }

            if (!flag) {
                map[word] = map.getOrDefault(word, 0) + 1
            }
        }
        
        return map.maxByOrNull { it.value }!!.key
    }
}