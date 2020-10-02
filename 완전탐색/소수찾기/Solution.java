import java.util.*;

class Solution {
	
    public static Set<Integer> set = new HashSet<>(); //소수 답안
    
    public int solution(String numbers) {
        int[] arr = new int[numbers.length()];
        for(int i=0; i<numbers.length(); i++) {
        	arr[i] = numbers.charAt(i)-48;
        }
        for(int i=1; i<=numbers.length(); i++){
        	perm(arr, 0, i);
        }
        return set.size();
    }
    
    //arr: 수 배열, depth: 현재 깊이, k: 뽑아 낼 수의 길이
    public void perm(int[] arr, int depth, int k){
        if(depth == k) {
        	toNumber(arr, k);
        	return;
        }
        else {
        	for(int i = depth; i< arr.length; i++) {
        		swap(arr, i, depth);
        		perm(arr, depth+1, k);
        		swap(arr, i, depth);
        	}
        }
    }
    
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void toNumber(int[] arr, int k) {
    	int number = 0;
    	for(int i=0; i<k; i++)
    		number += arr[i] * Math.pow(10, k-i-1);
    	prime(number);
    }
    
    public void prime(int n){
    	boolean isPrime = true;
    	if(n<=1)
    		return;
        for(int i=2; i*i<=n; i++){
            if(n%i==0){
                isPrime = false;
                
            }
        }
        if(isPrime==true)
        	set.add(n); //소수라면 Hashset에 추가
    }
}