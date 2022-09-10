// 프로그래머스 92344 - 파괴되지 않은 건물

public class programmers_92344 {

    public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int R = board.length;
        int C = board[0].length;
        int[][] dp = new int[R + 1][C + 1];

        for (int i = 0; i < skill.length; i++) {
            int type = skill[i][0], r1 = skill[i][1], c1 = skill[i][2], r2 = skill[i][3], c2 = skill[i][4], degree = skill[i][5];

            if (type == 1) degree *= -1;

            dp[r1][c1] += degree;
            dp[r2 + 1][c1] -= degree;
            dp[r1][c2 + 1] -= degree;
            dp[r2 + 1][c2 + 1] += degree;
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                dp[r + 1][c] += dp[r][c];
            }
        }

        for (int c = 0; c < C; c++) {
            for (int r = 0; r < R; r++) {
                dp[r][c + 1] += dp[r][c];
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (board[r][c] + dp[r][c] > 0) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
        int[][] skill = {{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}};
        int result = solution(board, skill);

        System.out.println(result);
    }

}
