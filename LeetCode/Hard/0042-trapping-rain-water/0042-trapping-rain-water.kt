class Solution {
    fun trap(height: IntArray): Int {
        var volume = 0
        var left = 0
        var right = height.size - 1
        var maxLeft = height[left]
        var maxRight = height[right]

        while (left < right) {
            if (maxLeft <= maxRight) {
                left++
                maxLeft = maxOf(maxLeft, height[left])
                volume += maxLeft - height[left]
            } else {
                right--
                maxRight = maxOf(maxRight, height[right])
                volume += maxRight - height[right]
            }
        }

        return volume
    }
}