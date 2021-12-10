// 백준 2581 - 소수

import java.io.*;
import java.util.Arrays;

public class boj_2581 {

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

          int M = Integer.parseInt(br.readLine());
          int N = Integer.parseInt(br.readLine());

          boolean[] prime = new boolean[N + 1];
          Arrays.fill(prime, true);
          prime[1] = false;

          for (int i = 2; i < (int) Math.sqrt(N) + 1; i++) {
               if (prime[i]) {
                    int j = 2;
                    while (i * j <= N) {
                         prime[i * j] = false;
                         j++;
                    }
               }
          }

          int first = 0;
          int sum = 0;
          for (int i = M; i <= N; i++) {
               if (prime[i]) {
                    if (first == 0) {
                         first = i;
                         sum += i;
                    } else {
                         sum += i;
                    }
               }
          }

          if (first == 0) {
               bw.write("-1\n");
          } else {
               bw.write(sum + "\n");
               bw.write(first + "\n");
          }
          bw.flush();
          bw.close();
     }

}
