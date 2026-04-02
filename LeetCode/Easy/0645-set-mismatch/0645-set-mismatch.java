class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] counter = new int[nums.length + 1];
        for (int n : nums)
            counter[n]++;

        int a = -1, b = -1;
        for (int i = 1; i <= nums.length; i++) {
            if (counter[i] == 2)
                a = i;
            else if (counter[i] == 0)
                b = i;
        }

        return new int[] {a, b};
    }
}