class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letList = new ArrayList<>();
        List<String> digList = new ArrayList<>();

        for (String log : logs) {
            // 숫자, 문자 판별
            if (isLetter(log)) {
                letList.add(log);
            } else {
                digList.add(log);
            }
        }

        // 문자 정렬
        letList.sort((s1, s2) -> {
            // 식별자 분리
            String[] parts1 = s1.split(" ", 2);
            String[] parts2 = s2.split(" ", 2);

            // 내용 비교
            int compare = parts1[1].compareTo(parts2[1]);

            // 식별자 비교
            if (compare == 0) {
                return parts1[0].compareTo(parts2[0]);
            }
            return compare;
        });

        letList.addAll(digList);

        return letList.toArray(new String[0]);
    }

    private boolean isLetter(String str) {
        return !Character.isDigit(str.split(" ")[1].charAt(0));
    }
}