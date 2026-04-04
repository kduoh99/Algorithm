class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        for (int n : nums) {
            if (n % 2 == 0)
                even.add(n);
            else
                odd.add(n);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length / 2; i++) {
            result.add(even.get(i));
            result.add(odd.get(i));
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}