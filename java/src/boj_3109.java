// 백준 3109 - 빵집

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_3109 {

    static int R, C;
    static char[][] data;
    static int answer;
    static int[][] delta = {{-1, 1}, {0, 1}, {1, 1}};  // 우상, 우, 우하
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        data = new char[R][C];
        for (int i = 0; i < R; i++) {
            data[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            findPath(i, 0);
            flag = false;
        }

        System.out.println(answer);
    }

    public static void findPath(int rowNum, int colNum) {
        if (colNum == C - 1) {
            answer++;
            flag = true;
            return;
        }

        for (int i = 0; i < delta.length; i++) {
            if (isPossible(rowNum + delta[i][0], colNum + delta[i][1])) {
                data[rowNum + delta[i][0]][colNum + delta[i][1]] = 'x';
                findPath(rowNum + delta[i][0], colNum + delta[i][1]);
            }
            if (flag) return;
        }
    }

    public static boolean isPossible(int rowNum, int colNum) {  // 갈 곳이 가능?
        if (0 <= rowNum && rowNum < R && 0 <= colNum && colNum < C && data[rowNum][colNum] == '.')
            return true;
        return false;
    }

}
