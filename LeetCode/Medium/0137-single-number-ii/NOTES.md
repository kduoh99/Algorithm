배열에서 한 번만 등장하는 숫자를 찾기 위해 XOR(`^`)과 AND NOT(`& ~`) 비트 연산을 사용한다.
`singleBit`은 한 번 등장한 비트를, `doubleBit`은 두 번 등장한 비트를 기록하고, 세 번 등장하면 제거된다.
이 방법은 `Map`보다 시간, 공간면에서 더 효율적이다.
