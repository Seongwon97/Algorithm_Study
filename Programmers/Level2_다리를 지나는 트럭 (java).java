import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int arrivedTruck = 0;
        int sumOfTruckWeight = 0;
        int nextStartTruck = 0;

        int time = 0;

        while (arrivedTruck != truck_weights.length) {
            if (queue.size() == bridge_length) {
                int escapedTruck = queue.poll();
                if (escapedTruck != -1) {
                    sumOfTruckWeight -= truck_weights[escapedTruck];
                    arrivedTruck++;
                }
            }

            if (nextStartTruck < truck_weights.length &&
                    sumOfTruckWeight + truck_weights[nextStartTruck] <= weight) {
                queue.add(nextStartTruck);
                sumOfTruckWeight += truck_weights[nextStartTruck];
                nextStartTruck++;
            } else {
                queue.add(-1);
            }

            time++;
        }

        return time;
    }
}
