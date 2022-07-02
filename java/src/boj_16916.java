// 백준 16916 - 부분 문자열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_16916 {

    // 실패함수 찾기
    public static int[] findPi(String P) {
        int[] result = new int[P.length()]; // KMP 알고리즘 실행 중 일치하지 않는 문자가 있을 때 어디서부터 검색을 해야할지 알려주는 배열
        int begin = 0;
        for (int i = 1; i < P.length(); i++) {
            while (begin > 0 && P.charAt(i) != P.charAt(begin)) {
                begin = result[begin - 1];
            }
            if (P.charAt(i) == P.charAt(begin)) {
                result[i] = ++begin;
            }
        }
        return result;
    }

    public static int KMP(String S, String P) {
        int[] pi = findPi(P); // pi 배열
        int begin = 0;
        for (int i = 0; i < S.length(); i++) {
            while (begin > 0 && S.charAt(i) != P.charAt(begin)) {
                begin = pi[begin - 1];
            }
            if (S.charAt(i) == P.charAt(begin)) {
                if (begin == P.length() - 1) {
                    return i - P.length() + 2;
                } else {
                    begin++;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String P = br.readLine();

        if (KMP(S, P) < 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }

}
