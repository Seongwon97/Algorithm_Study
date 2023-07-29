package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1826
// 연료 채우기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<OilStation> oilStations = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int position = Integer.parseInt(st.nextToken());
            int amount = Integer.parseInt(st.nextToken());
            oilStations.add(new OilStation(position, amount));
        }

        oilStations.sort(Comparator.comparingInt(o -> o.position));
        Queue<OilStation> pq = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int destination = Integer.parseInt(st.nextToken());
        int currentAmount = Integer.parseInt(st.nextToken());

        int currentPosition = currentAmount;
        int nextIdx = 0;
        for (int i = 0; i < N; i++) {
            OilStation oilStation = oilStations.get(i);
            if (oilStation.position > currentPosition) {
                nextIdx = i;
                break;
            }

            pq.add(oilStation);
        }

        int answer = 0;
        while (currentPosition < destination) {
            if (pq.isEmpty()) {
                answer = -1;
                break;
            }

            OilStation station = pq.poll();
            currentPosition += station.amount;
            answer++;

            for (int i = nextIdx; i < N; i++) {
                OilStation oilStation = oilStations.get(i);
                if (oilStation.position > currentPosition) {
                    nextIdx = i;
                    break;
                }

                pq.add(oilStation);
            }
        }

        System.out.println(answer);
    }

    static class OilStation implements Comparable<OilStation> {
        int position;
        int amount;

        public OilStation(int position, int amount) {
            this.position = position;
            this.amount = amount;
        }

        @Override
        public int compareTo(OilStation o) {
            return o.amount - this.amount;
        }
    }
}
/*
Input
4
4 4
5 2
11 5
15 10
25 10

Output
3
*/
