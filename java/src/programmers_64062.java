// 프로그래머스 64062 - 징검다리 건너기

public class programmers_64062 {

    public static int solution(int[] stones, int k) {
        int left = 1;
        int right = 200000000;
        int mid = 0;
        int answer = 0;

        while (left <= right) {
            mid = (left + right) / 2;

            if (check(stones.clone(), mid, k)) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public static boolean check(int[] stones, int m, int k) {
        int cnt = 0;
        int max = 0;
        for (int i = 0; i < stones.length; i++) {
            stones[i] = stones[i] - m + 1;
            if (stones[i] <= 0) {
                cnt++;
                if (max < cnt) max = cnt;
            } else {
                cnt = 0;
            }
        }

        if (max == 0) return true;
        if (k <= max) return false;

        return true;
    }

    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        int result = solution(stones, k);

        System.out.println(result);
    }

}
