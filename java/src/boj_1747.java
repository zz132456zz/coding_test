// 백준 1747 - 소수&팰린드롬

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_1747 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        boolean[] prime = new boolean[1005001];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i <= 1002; i++) {
            if (prime[i]) {
                int j = 2;
                while (i * j <= 1005000) {
                    prime[i * j] = false;
                    j++;
                }
            }
        }

        for (int i = N; i <= 1005000; i++) {
            if (prime[i] && isPalindrome(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    public static boolean isPalindrome(int n) {
        StringBuilder sb1 = new StringBuilder(Integer.toString(n));
        sb1.reverse();
        StringBuilder sb2 = new StringBuilder(Integer.toString(n));

        return sb1.toString().equals(sb2.toString());
    }

}
