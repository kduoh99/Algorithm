class Solution {
    public int singleNumber(int[] nums) {
        int singleBit = 0, doubleBit = 0;
        
        for (int num : nums) {
            singleBit = (singleBit ^ num) & ~doubleBit;
            doubleBit = (doubleBit ^ num) & ~singleBit;
        }
        
        return singleBit;
    }
}