class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] key = str.toCharArray();
            Arrays.sort(key);

            // 현재 키에 해당하는 리스트가 없다면 새로 생성, 있다면 기존 리스트에 추가
            map.computeIfAbsent(String.valueOf(key), k -> new ArrayList<>()).add(str);
        }

        // HashMap의 값들을 리스트로 반환
        return new ArrayList<>(map.values());
    }
}