class Solution {
    private int SIZE;
    
    public void duplicateZeros(int[] arr) {
        SIZE = arr.length;
        
        int idx = 0;
        while (idx < SIZE) {
            if (arr[idx] == 0) {
                shift(arr, idx);
                idx++;
            }
            idx++;
        }
    }
    
    private void shift(int[] arr, int idx) {
        for (int i = SIZE - 1; i > idx; i--) {
            arr[i] = arr[i - 1];
        }
    }
}