class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // 특수문자 공백으로 대체, 소문자로 변환, 단어로 분리
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
        
        // 금지 단어들을 저장할 Set
        Set<String> ban = new HashSet<>();
        for (String word : banned) {
            ban.add(word);
        }
        
        // 단어 빈도를 저장할 Map
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (!ban.contains(word)) {
                // 해당 단어가 Map에 이미 존재하면 기존 값에 1을 더하고, 그렇지 않으면 1을 저장
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        
        // 가장 빈도 높은 단어 찾기
        return wordCount.entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .get()
            .getKey();
    }
}