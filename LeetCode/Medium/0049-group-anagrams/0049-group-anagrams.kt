class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map: MutableMap<String, MutableList<String>> = mutableMapOf()

        for (str in strs) {
            val key = str.toCharArray().sorted().joinToString("")
            map.getOrPut(key) { mutableListOf() }.add(str)
        }

        return ArrayList<List<String>>(map.values)
    }
}