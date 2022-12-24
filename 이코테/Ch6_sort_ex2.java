package chapter3_greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// 성적이 낮은 순서로 학생 출력하기
public class Ch6_sort_ex2 {

    public static void main(String[] args) {
        String[] name = {"홍길동", "이순신"};
        int[] score = {95, 77};

        String[] answer = solution(name, score);
        for (String i : answer) {
            System.out.print(i + "  ");
        }
    }

    private static String[] solution(String[] name, int[] score) {
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < name.length; i++) {
            students.add(new Student(name[i], score[i]));
        }

        Collections.sort(students);

        String[] answer = new String[students.size()];
        for (int i = 0; i < students.size(); i++) {
            answer[i] = students.get(i).name;
        }

        return answer;
    }

    static class Student implements Comparable<Student> {
        String name;
        int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            return this.score - o.score;
        }
    }
}
