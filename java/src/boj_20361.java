// 백준 20361 - 일우는 야바위꾼

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_20361 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  // 입력 받기 위한 BufferedReader
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  // 출력하기 위한 BufferdWriter
        StringTokenizer st;  // 한줄에 있는 여러개의 데이터를 나누기 위한 StringTokenizer

        st = new StringTokenizer(br.readLine());  // st에 다음줄 입력받기
        int N = Integer.parseInt(st.nextToken());  // 종이컵의 수
        int X = Integer.parseInt(st.nextToken());  // 몇 번째 종이컵인지
        int K = Integer.parseInt(st.nextToken());  // 위치를 바꾸는 횟수

        for (int k = 0; k < K; k++) {  // 위치를 바꾸는 횟수인 K번만큼 반복
            st = new StringTokenizer(br.readLine());  // st에 다음줄 입력받기
            int A = Integer.parseInt(st.nextToken());  // 바꿀 두 컵의 위치
            int B = Integer.parseInt(st.nextToken());  // 바꿀 두 컵의 위치

            if (X == A) {  // A와 X와 같다면
                X = B;  // B로 위치 이동
            } else if (X == B) {  // B와 X와 같다면
                X = A;  // A로 위치 이동
            }
        }

        bw.write(X + "\n");  // 주어진 조건대로 작성

        bw.flush();  // 출력
        bw.close();  // BufferedWriter close
        br.close();  // BufferedReader close
    }

}
