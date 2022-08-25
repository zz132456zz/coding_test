public class programmers_test_3_3 {

    public static int solution(int distance, int[][] scope, int[][] times) {
        int answer = distance;

        boolean[] catched = new boolean[distance + 1];

        for (int i = 0; i < scope.length; i++) {
            int cycle = times[i][0] + times[i][1];

            if (scope[i][0] < scope[i][1]) {
                // 증가
                for (int j = scope[i][0]; j <= scope[i][1]; j++) {
                    int loc = j % cycle;
                    if (1 <= loc && loc <= times[i][0]) catched[j] = true;
                }
            } else {
                // 감소
                for (int j = scope[i][1]; j <= scope[i][0]; j++) {
                    int loc = j % cycle;
                    if (1 <= loc && loc <= times[i][0]) catched[j] = true;
                }
            }
        }

        for (int i = 0; i <= distance; i++) {
            if (catched[i]) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int distance = 10;
        int[][] scope = {{3, 4}, {5, 8}};
        int[][] times = {{2, 5}, {4, 3}};
        int result = solution(distance, scope, times);

        System.out.println(result);
    }

}
