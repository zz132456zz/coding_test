// 백준 20299 - 3대 측정

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_20299 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  // 입력 받기 위한 BufferedReader
        StringTokenizer st = new StringTokenizer(br.readLine());  // 한줄에 있는 여러개의 데이터를 나누기 위한 StringTokenizer로 다음줄 입력받기
        StringBuilder answer = new StringBuilder();  // 가입된 학생의 능력치를 넣을 StringBuilder
        int answerCnt = 0;  // 가입 가능한 동아리 수 카운트 변수

        int N = Integer.parseInt(st.nextToken());  // 신청한 동아리 수
        int S = Integer.parseInt(st.nextToken());  // 팀원 능력 합에 대한 가입조건
        int M = Integer.parseInt(st.nextToken());  // 개인 능력치에 대한 가입 조건

        for (int n = 0; n < N; n++) {  // N번만큼 반복
            st = new StringTokenizer(br.readLine());  // st에 다음줄 입력받기
            int x1 = Integer.parseInt(st.nextToken());  // 동아리원1 능력치 입력받기
            int x2 = Integer.parseInt(st.nextToken());  // 동아리원2 능력치 입력받기
            int x3 = Integer.parseInt(st.nextToken());  // 동아리원3 능력치 입력받기

            if (x1 >= M && x2 >= M && x3 >= M) {  // 각 동아리원의 능력치가 M이상이고
                if (x1 + x2 + x3 >= S) {  // 3명의 능력치의 합이 S이상이면
                    answerCnt++;  // 가입가능 동아리수 카운트
                    answer.append(x1).append(" ").append(x2).append(" ").append(x3).append(" ");  // 각 동아리원의 능력치 넣어주기
                }
            }
        }

        System.out.println(answerCnt);  // 가입 가능한 동아리의 수 출력
        System.out.println(answer.toString());  // 가입된 학생들의 능력치를 입력 받은 순서대로 출력
    }

}
