class Solution {

    //나올 수 있는 최대 답이 50이므로 51로 임시 지정
    private static int answer = 51;

    public int solution(String begin, String target, String[] words) {
        boolean[] check = new boolean[words.length];
        dfs(0, begin, target, words, check);
        return answer==51?0:answer;
    }

    public void dfs(int depth, String begin, String target, String[] words, boolean[] check){
        //begin과 target이 같아지면 현재 깊이와 답 비교 후 return
        if( begin.equals(target) ){
            answer = answer>depth?depth:answer;
            return;
        }

        //아직 방문하지 않았다면 문자열 차이 판별 후 재귀호출
        for(int i=0; i<check.length; i++){
            if( !check[i] && isRight(begin, words[i]) ){
                check[i]=true;
                dfs(depth+1, words[i], target, words, check);
                check[i]=false; //함수에서 빠져 나온 경우 단어사용여부를 false로 바꿔주어야 합니다.
            }
        }
    }

    //두 문자열이 한 글자만 차이나는지 판별하는 메소드
    public boolean isRight(String s1, String s2){
        int count = 0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)==s2.charAt(i))
                count++;
        }
        return count==s1.length()-1?true:false;
    }
}