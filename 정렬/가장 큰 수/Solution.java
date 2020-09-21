import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> list = new ArrayList<String>();
        for(int i=0; i<numbers.length; i++){
            list.add(Integer.toString(numbers[i]));
        }

        //Collections.sort(list, (num1, num2)-> (num2+num1).compareTo(num1+num2) );
        Collections.sort(list, new Comparator<String>(){ //익명클래스 사용
            @Override
            public int compare(String num1, String num2){
                return (num2+num1).compareTo(num1+num2);
            }
        });

        if(list.get(0).equals("0")){
            return "0";
        }
        for(int i=0; i<list.size(); i++){
            answer += list.get(i);
        }
        return answer;
    }
}
