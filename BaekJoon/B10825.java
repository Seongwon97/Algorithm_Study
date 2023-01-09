package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 국영수
// https://www.acmicpc.net/problem/10825
public class B10825 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            List<Student> students = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String name = st.nextToken();
                int koreanScore = Integer.parseInt(st.nextToken());
                int englishScore = Integer.parseInt(st.nextToken());
                int mathScore = Integer.parseInt(st.nextToken());
                students.add(new Student(name, koreanScore, englishScore, mathScore));
            }

            Collections.sort(students);

            StringBuilder sb = new StringBuilder();
            for (Student student : students) {
                sb.append(student.name)
                        .append("\n");
            }

            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static class Student implements Comparable<Student> {
        String name;
        int koreanScore;
        int englishScore;
        int mathScore;

        public Student(String name, int koreanScore, int englishScore, int mathScore) {
            this.name = name;
            this.koreanScore = koreanScore;
            this.englishScore = englishScore;
            this.mathScore = mathScore;
        }

        @Override
        public int compareTo(Student o) {
            if (this.koreanScore != o.koreanScore) {
                return o.koreanScore - this.koreanScore;
            }
            if (this.englishScore != o.englishScore) {
                return this.englishScore - o.englishScore;
            }
            if (this.mathScore != o.mathScore) {
                return o.mathScore - this.mathScore;
            }
            return this.name.compareTo(o.name);
        }
    }
}

/*
Input
12
Junkyu 50 60 100
Sangkeun 80 60 50
Sunyoung 80 70 100
Soong 50 60 90
Haebin 50 60 100
Kangsoo 60 80 100
Donghyuk 80 60 100
Sei 70 70 70
Wonseob 70 70 90
Sanghyun 70 70 80
nsj 80 80 80
Taewhan 50 60 90

Output
Donghyuk
Sangkeun
Sunyoung
nsj
Wonseob
Sanghyun
Sei
Kangsoo
Haebin
Junkyu
Soong
Taewhan
 */
