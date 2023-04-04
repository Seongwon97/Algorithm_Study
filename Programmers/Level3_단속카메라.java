import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        List<Car> cars = new ArrayList<>();
        for (int[] route : routes) {
            cars.add(new Car(route[0], route[1]));
        }

        cars.sort(Comparator.comparing(car -> car.start));

        Car car = cars.get(0);
        int shortestEndPosition = car.end;
        for (int i = 1; i < cars.size(); i++) {
            Car c = cars.get(i);
            if (c.start > shortestEndPosition) {
                shortestEndPosition = c.end;
                answer++;
            }

            if (c.end < shortestEndPosition) {
                shortestEndPosition = c.end;
            }
        }

        return ++answer;
    }

    static class Car {
        int start;
        int end;

        public Car(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
