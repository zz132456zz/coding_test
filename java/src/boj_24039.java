// 백준 24039 - 2021은 무엇이 특별할까?

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class boj_24039 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int n = 103;
        boolean[] array = new boolean[n + 1];
        Arrays.fill(array, true);

        for (int i = 2; i < (int)Math.sqrt(n) + 1; i++) {
            if (array[i]) {
                int j = 2;
                while (i * j <= n) {
                    array[i * j] = false;
                    j++;
                }
            }
        }

        List<Integer> prime = new ArrayList<>();
        List<Integer> primeMul = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (array[i]) {
                prime.add(i);
            }
        }

        for (int i = 0; i < prime.size() - 1; i++) {
            primeMul.add(prime.get(i) * prime.get(i + 1));
        }

        for (int i = 0; i < primeMul.size(); i++) {
            if (N < primeMul.get(i)) {
                bw.write(primeMul.get(i) + "\n");
                break;
            }
        }
        bw.flush();
        bw.close();
    }

}
