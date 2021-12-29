import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String inputArr = br.readLine();

            bw.append(executeFunction(command, n, parseArr(inputArr)));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static List<Integer> parseArr(String inputArr) {
        List<Integer> numList = new ArrayList<>();
        Arrays.stream(inputArr.substring(1, inputArr.length() - 1).split(","))
                .forEach(s -> {
                    if (!s.equals("")) numList.add(Integer.parseInt(s));
                });
        return numList;
    }

    public static String executeFunction(String command, int n, List<Integer> numList) {
        boolean reverseCount = false;
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'R') {
                reverseCount = !reverseCount;
            }

            if (command.charAt(i) == 'D') {
                try {
                    numList.remove(0);
                } catch (IndexOutOfBoundsException e) {
                    return "error\n";
                }
            }
        }

        if (reverseCount) {
            Collections.reverse(numList);
        }

        return makeResultString(numList);
    }

    public static String makeResultString(List<Integer> numList) {
        if (numList.isEmpty()) {
            return "[]\n";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        numList.stream()
                .forEach(integer -> {
                    sb.append(integer);
                    sb.append(",");
                });
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]\n");
        return sb.toString();
    }
}
