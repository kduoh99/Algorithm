문자열 배열로 변환하는 경우에는 toArray()를 사용했지만, 정수형​과 같은 primitive type은 toArray()를 사용할 수 없다.

```java
List<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);
list.add(3);

// 반복문 사용
int[] array1 = new int[list.size()];
for (int i = 0; i < list.size(); i++) {
   array1[i] = list.get(i).intValue();
}

// stream 사용
int[] array2 = list.stream().mapToInt(i -> i).toArray();   
```
