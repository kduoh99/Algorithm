class Solution {
    fun reorderLogFiles(logs: Array<String>): Array<String> {
        val letList = mutableListOf<String>()
        val digList = mutableListOf<String>()

        for (log in logs) {
            if (Character.isDigit(log.split(" ")[1][0])) {
                digList.add(log)
            } else {
                letList.add(log)
            }
        }

        letList.sortWith(Comparator { s1: String, s2: String ->
            var parts1 = s1.split(" ", limit = 2)
            var parts2 = s2.split(" ", limit = 2)

            var compare = parts1[1].compareTo(parts2[1])

            if (compare == 0) {
                parts1[0].compareTo(parts2[0])
            } else {
                compare
            }
        })

        letList.addAll(digList)

        return letList.toTypedArray()
    }
}