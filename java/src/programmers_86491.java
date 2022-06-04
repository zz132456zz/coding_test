// 프로그래머스 86491 - 최소직사각형

public class programmers_86491 {

    public static int solution(int[][] sizes) {
        int answer = 0;
        int max = 0;

        for (int i = 0; i < sizes.length; i++) {
            if (max < sizes[i][0]) max = sizes[i][0];
            if (max < sizes[i][1]) max = sizes[i][1];
        }

        answer = max;
        max = 0;
        for (int i = 0; i < sizes.length; i++) {
            int min = Math.min(sizes[i][0], sizes[i][1]);
            if (max < min) max = min;
        }

        answer *= max;

        return answer;
    }

    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int result = solution(sizes);

        System.out.println(result);
    }

}
