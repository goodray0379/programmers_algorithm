import java.util.*;

class Solution {
    public int[] solution(int[] heights) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(heights[0]);

        int[] answer = new int[heights.length];
        answer[0] = 0;

        for (int i = 1; i < heights.length; i++) {

            for (int j = list.size() - 1; j >= 0; j--) {
                if (list.get(j) > heights[i]) {
                    answer[i] = j + 1;
                    break;
                }
            }
            list.add(heights[i]);
        }
        return answer;
    }
}