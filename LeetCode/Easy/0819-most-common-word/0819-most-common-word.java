import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // 공백과 명시된 기호를 구분자로 지정
        String delimiters = " !?',;.";
        StringTokenizer st = new StringTokenizer(paragraph.toLowerCase(), delimiters);
        
        // 단어 빈도 저장할 Map
        Map<String, Integer> map = new HashMap<>();

        while (st.hasMoreTokens()) {
            boolean flag = false;
            String word = st.nextToken();

            for (String ban : banned) {
                if (word.equals(ban)) {
                    flag = true;
                    break;
                }
            }

            // 해당 단어가 Map에 존재하면 기존 값에 1을 더하고, 그렇지 않으면 1을 저장
            if (!flag) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        // 가장 빈도 높은 단어 찾기
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}