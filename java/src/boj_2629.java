// 백준 2629 - 양팔저울

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2629 {

    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int C = Integer.parseInt(br.readLine());  // 추의 개수
        int[] dataC = new int[C];  // 추의 무게
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            dataC[i] = Integer.parseInt(st.nextToken());
        }
        int R = Integer.parseInt(br.readLine());  // 구슬의 개수
        int[] dataR = new int[R];  // 구슬의 무개
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            dataR[i] = Integer.parseInt(st.nextToken());
        }

        // 추의 최대 합인 15000을 기준으로 두배크기의 배열
        boolean[] visited1 = new boolean[30001];
        boolean[] visited2 = new boolean[30001];
        // 첫번째 추를 저울에 올려놓지 않거나 왼쪽저울에 올려놓거나 오른쪽저울에 올려놓는 경우를 체크
        visited1[15000] = true;
        visited1[15000 - dataC[0]] = true;
        visited1[15000 + dataC[0]] = true;

        for (int i = 1; i < C; i++) {  // 두번째 추부터 반복
            visited2 = visited1.clone();  // visited2 배열에 전에 체크된 상황을 복사하고
            for (int j = 0; j <= 30000; j++) {  // 배열의 처음부터 끝까지 보면서
                if (visited1[j]) {  // 체크되어있으면 현재 추를 왼쪽저울에 올리거나 오른쪽 저울에 올린다.
                    visited2[j - dataC[i]] = true;
                    visited2[j + dataC[i]] = true;
                }
            }
            visited1 = visited2.clone();  // 다시 visited1 배열에 복사
        }

        for (int i = 0; i < R; i++) {
            if (dataR[i] <= 15000) {
                // 구슬을 왼쪽 저울에 올리거나 오른쪽 저울에 올렸을때 체크되어있는 무게면 Y
                if (visited1[15000 - dataR[i]] || visited1[15000 + dataR[i]]) {
                    sb.append("Y ");
                    continue;
                }
            }
            sb.append("N ");  // 아니면 N
        }

        System.out.println(sb);  // 결과 출력
    }

}
