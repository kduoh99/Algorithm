class Solution {
    fun letterCombinations(digits: String): List<String> {
        val map: Map<Int, List<Char>> = mapOf(
            2 to listOf('a', 'b', 'c'),
            3 to listOf('d', 'e', 'f'),
            4 to listOf('g', 'h', 'i'),
            5 to listOf('j', 'k', 'l'),
            6 to listOf('m', 'n', 'o'),
            7 to listOf('p', 'q', 'r', 's'),
            8 to listOf('t', 'u', 'v'),
            9 to listOf('w', 'x', 'y', 'z')
        )

        val result = mutableListOf<String>()

        fun dfs(index: Int, sb: StringBuilder) {
            if (index == digits.length) {
                result.add(sb.toString())
                return
            }

            for (c in map[digits[index] - '0']!!) {
                dfs(index + 1, StringBuilder(sb).append(c))
            }
        }

        dfs(0, StringBuilder())
        return result
    }
}