import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        // 의상의 종류, 개수
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            if (map.containsKey(clothes[i][1]))
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            else
                map.put(clothes[i][1], 1);
        }

        // 최종 답
        for (String key : map.keySet())
            answer *= (map.get(key) + 1);

        return answer - 1;
    }
}