// 백준 10430 - 나머지

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        answer.append((A + B) % C).append("\n");
        answer.append(((A % C) + (B % C)) % C).append("\n");
        answer.append((A * B) % C).append("\n");
        answer.append(((A % C) * (B % C)) % C).append("\n");

        System.out.print(answer);
    }

}
