// SWEA 4012 - 요리사

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class swea_4012 {
    static int N;  // 식재료의 수
    static int[][] data;  // 시너지 값
    static int[] nums;  //조합 구하기 위한 배열
    static int[] result;  // 조합 결과 배열
    static List<int[]> combinationResult;  // 조합 결과 리스트

    public static void combination(int cnt, int n) {
        if (cnt == N / 2) {
            combinationResult.add(Arrays.copyOf(result, result.length));  // 조합 결과 리스트에 추가
            return;
        }

        for (int i = n; i < N; i++) {
            result[cnt] = nums[i];
            combination(cnt + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());  // 테스트케이스 개수
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());  // 식재료의 수
            data = new int[N][N];  // 시너지 값
            for (int i = 0; i < N; i++) {  // 시너지 값 입력받기
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            nums = new int[N];  // 조합 구하기 위한 배열
            result = new int[N / 2];  // 조합 결과 배열
            for (int i = 0; i < N; i++) {  // 0부터 N-1까지 넣어주기
                nums[i] = i;
            }

            combinationResult = new ArrayList<>();  // 조합 결과 리스트 초기화
            combination(0, 0);  // 조합 작업

            int minSum = Integer.MAX_VALUE;
            for (int i = 0, size = combinationResult.size(); i < size / 2; i++) {
                int sum1 = 0;  // 시너지 합 저장
                int sum2 = 0;  // 시너지 합 저장
                int[] cook1 = combinationResult.get(i);  // i번째 조합 가져오기
                int[] cook2 = combinationResult.get(size - i - 1);  // size-i-1번째 조합 가져오기

                for (int a = 0; a < cook1.length; a++) {  // i번째 조합들의 시너지 합
                    for (int b = 0; b < cook1.length; b++) {
                        sum1 += data[cook1[a]][cook1[b]];
                    }
                }

                for (int a = 0; a < cook2.length; a++) {  // size-i-1번째 조합들의 시너지 합
                    for (int b = 0; b < cook2.length; b++) {
                        sum2 += data[cook2[a]][cook2[b]];
                    }
                }

                minSum = Math.min(minSum, Math.abs(sum1 - sum2));  // 시너지 합의 차이를 구해 최소이면 업데이트한다.
            }

            answer.append("#").append(tc).append(" ").append(minSum).append("\n");
        }

        System.out.println(answer.toString());
    }

}
