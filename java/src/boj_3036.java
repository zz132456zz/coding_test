// 백준 3036 - 링

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_3036 {

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            int gcdNum = gcd(Math.max(data[0], data[i]), Math.min(data[0], data[i]));
            sb.append(data[0] / gcdNum).append("/").append(data[i] / gcdNum).append("\n");
        }

        System.out.print(sb);
    }

}
