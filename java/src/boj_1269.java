// 백준 1269 - 대칭 차집합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1269 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numA = Integer.parseInt(st.nextToken());
        int numB = Integer.parseInt(st.nextToken());
        int[] A = new int[numA];
        int[] B = new int[numB];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numA; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numB; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int cnt = 0;

        int idxA = 0;
        int idxB = 0;

        while (true) {
            if (A[idxA] < B[idxB]) {
                idxA++;
            } else if (A[idxA] > B[idxB]) {
                idxB++;
            } else {
                idxA++;
                idxB++;
                cnt++;
            }

            if (idxA == numA || idxB == numB) break;
        }

        System.out.println(numA + numB - cnt * 2);
    }

}
