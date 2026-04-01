import java.util.*;

class Solution {
    public int compareVersion(String version1, String version2) {
        StringTokenizer st1 = new StringTokenizer(version1, ".");
        StringTokenizer st2 = new StringTokenizer(version2, ".");

        while (st1.hasMoreTokens() || st2.hasMoreTokens()) {
            int v1 = st1.hasMoreTokens() ? Integer.parseInt(st1.nextToken()) : 0;
            int v2 = st2.hasMoreTokens() ? Integer.parseInt(st2.nextToken()) : 0;

            if (v1 > v2) return 1;
            if (v1 < v2) return -1;
        }

        return 0;
    }
}