class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Integer, List<Character>> map = new HashMap<>();

        map.put(2, List.of('a', 'b', 'c'));
        map.put(3, List.of('d', 'e', 'f'));
        map.put(4, List.of('g', 'h', 'i'));
        map.put(5, List.of('j', 'k', 'l'));
        map.put(6, List.of('m', 'n', 'o'));
        map.put(7, List.of('p', 'q', 'r', 's'));
        map.put(8, List.of('t', 'u', 'v'));
        map.put(9, List.of('w', 'x', 'y', 'z'));

        List<String> result = new ArrayList<>();
        dfs(result, map, digits, 0, new StringBuilder());

        return result;
    }

    private void dfs(List<String> result, Map<Integer, List<Character>> map, String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        for (Character c : map.get(digits.charAt(index) - '0')) {
            dfs(result, map, digits, index + 1, new StringBuilder(sb).append(c));
        }
    }
}