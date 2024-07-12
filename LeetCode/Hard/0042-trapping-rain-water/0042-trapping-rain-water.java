class Solution {
    public int trap(int[] height) {
        int volume = 0;
        int left = 0, right = height.length - 1;
        int maxLeft = height[left], maxRight = height[right];
        
        while (left < right) {
            if (maxLeft <= maxRight) {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                volume += maxLeft - height[left];
            } else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                volume += maxRight - height[right];
            }
        }
        
        return volume;
    }
}