class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0; i<answer.length-1; i++){
            for(int j=i+1; j<answer.length; j++){
                if(prices[i]>prices[j]||j==answer.length-1){
                    answer[i] = j-i;
                    break;
                }
            }
        }
        return answer;
    }
}