class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()

        for (c in s) {
            when (c) {
                '(', '[', '{' -> stack.addFirst(c)
                ')' -> if (stack.removeFirstOrNull() != '(') return false
                ']' -> if (stack.removeFirstOrNull() != '[') return false
                '}' -> if (stack.removeFirstOrNull() != '{') return false
            }
        }

        return stack.isEmpty()
    }
}