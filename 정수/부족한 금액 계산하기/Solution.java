class Solution {
    public long solution(int price, int money, int count) {
        long sum = (long)price * count * (count + 1) / 2;
        return sum-money>=0?sum-money:0;
    }
}