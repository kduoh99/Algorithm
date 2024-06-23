class Solution {
    public String[] reorderLogFiles(String[] logs) {
        ArrayList<String> letter = new ArrayList<>();
        ArrayList<String> digit = new ArrayList<>();
        
        for (String log : logs) {
            // 식별자 외 첫 글자로 로그 종류 확인
            if (!Character.isDigit(log.split(" ")[1].charAt(0))) {
                letter.add(log);
            } else {
                digit.add(log);
            }
        }
        
        letter.sort((o1, o2) -> {
            // 식별자와 식별자 외로 구분
            String[] s1 = o1.split(" ", 2);
            String[] s2 = o2.split(" ", 2);
            
            int compare = s1[1].compareTo(s2[1]);
            if (compare == 0) {
                return s1[0].compareTo(s2[0]);
            } else {
                return compare;
            }
        });
        
        letter.addAll(digit);
        
        // 리스트를 문자열 배열로 변환
        return letter.toArray(String[]::new);
    }
}