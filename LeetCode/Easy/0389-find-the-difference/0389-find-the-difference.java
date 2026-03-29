class Solution {
    public char findTheDifference(String s, String t) {
        char[] chS = s.toCharArray();
        char[] chT = t.toCharArray();

        Arrays.sort(chS);
        Arrays.sort(chT);

        for (int i = 0; i < chS.length; i++)
            if (chS[i] != chT[i]) return chT[i];

        return chT[chT.length - 1];
    }
}