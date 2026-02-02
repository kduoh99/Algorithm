class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int[] counter = new int[58];

        for (char c : stones.toCharArray()) {
            counter[c - 'A']++;
        }

        int answer = 0;

        for (char c : jewels.toCharArray()) {
            answer += counter[c - 'A'];
        }

        return answer;
    }
}