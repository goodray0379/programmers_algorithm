import java.util.*;

class Truck {
    int weight;
    int departTime;

    public Truck(int weight, int departTime) {
        this.weight = weight;
        this.departTime = departTime;
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> waiting = new LinkedList<>();
        Queue<Truck> bridge = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++)
            waiting.offer(new Truck(truck_weights[i], 0));

        int time = 0;
        int totalWeigth = 0;
        while (!waiting.isEmpty() || !bridge.isEmpty()) {
            time++;
            if (!bridge.isEmpty()) {
                if (time - bridge.peek().departTime >= bridge_length) {
                    totalWeigth -= bridge.peek().weight;
                    bridge.poll();
                }
            }
            if (!waiting.isEmpty()) {
                if (weight >= totalWeigth + waiting.peek().weight) {
                    totalWeigth += waiting.peek().weight;
                    waiting.peek().departTime = time;
                    bridge.offer(waiting.poll());
                }
            }
        }

        return time;
    }
}