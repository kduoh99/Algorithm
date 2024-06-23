```java
// 문자열 배열
​String[] array = {"log1", "log2", "log3", "log4"};

// 문자열 배열을 리스트로 변환
List<String> arrToList = Arrays.asList(array);

// 리스트를 문자열 배열로 변환
String[] listToArray = arrToList.toArray(String[]::new);
```
