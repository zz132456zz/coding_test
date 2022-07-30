public class programmers_test_2_2 {

    public static int solution(int[] topping) {
        int n = topping.length;
        int answer = 0;

        boolean[] visitedLeft = new boolean[10001];
        boolean[] visitedRight = new boolean[10001];
        int[] dpLeft = new int[n];
        int[] dpRight = new int[n];

        dpLeft[0] = 1;
        visitedLeft[topping[0]] = true;
        for (int i = 1; i < n; i++) {
            if (!visitedLeft[topping[i]]) {
                visitedLeft[topping[i]] = true;
                dpLeft[i] = dpLeft[i - 1] + 1;
            } else {
                dpLeft[i] = dpLeft[i - 1];
            }
        }

        dpRight[n - 1] = 1;
        visitedRight[topping[n - 1]] = true;
        for (int i = n - 2; i >= 0; i--) {
            if (!visitedRight[topping[i]]) {
                visitedRight[topping[i]] = true;
                dpRight[i] = dpRight[i + 1] + 1;
            } else {
                dpRight[i] = dpRight[i + 1];
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (dpLeft[i] == dpRight[i + 1]) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        int result = solution(topping);

        System.out.println(result);
    }

}
