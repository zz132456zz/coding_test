// 백준 1292 - 쉽게 푸는 문제

import java.io.*;
import java.util.StringTokenizer;

public class boj_1292 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int answer = 0;

        int cnt = 1;
        for (int i = 1; ; i++) {
            for (int j = 0; j < i; j++) {
                if (A <= cnt && cnt <= B) {
                    answer += i;
                }
                cnt++;
            }
            if (B < cnt) {
                break;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

}
