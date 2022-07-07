// 백준 25331 - Drop 7

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_25331 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int[][] map = new int[7][7];
        for (int i = 0; i < 7; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int dropBall = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 7; i++) {
            int[][] copyMap = deepcopy(map);
            for (int j = 6; j >= 0; j--) {
                if (copyMap[j][i] == 0) {
                    copyMap[j][i] = dropBall;
                    break;
                }
            }

            play(copyMap);

            int cnt = cntBall(copyMap);
            if (min > cnt) min = cnt;
        }

        System.out.println(min);
    }
    public static void play(int[][] copyMap) {
        while (true) {
            if (disappear(copyMap)) break;
            down(copyMap);
        }
    }

    public static boolean disappear(int[][] map) {
        Queue<int[]> queue = new LinkedList<>();

        // 세로 방향 그룹
        for (int c = 0; c < 7; c++) {
            int num = 7;
            for (int r = 6; r >= 0; r--) {
                if (map[r][c] == 0) {
                    num = 6 - r;
                    break;
                }
            }
            for (int j = 0; j < 7; j++) {
                if (num != 0 && map[j][c] == num) {
                    queue.add(new int[] {j, c});
                }
            }
        }

        // 가로 방향 그룹
        for (int r = 0; r < 7; r++) {
            Queue<int[]> check = new LinkedList<>();
            for (int c = 0; c < 7; c++) {
                if (map[r][c] != 0) {
                    check.add(new int[] {r, c, map[r][c]});
                } else {
                    int n = check.size();
                    while (!check.isEmpty()) {
                        int[] cur = check.poll();
                        if (cur[2] == n) {
                            queue.add(new int[] {cur[0], cur[1]});
                        }
                    }
                }
            }
            int n = check.size();
            while (!check.isEmpty()) {
                int[] cur = check.poll();
                if (cur[2] == n) {
                    queue.add(new int[] {cur[0], cur[1]});
                }
            }
        }

        if (queue.isEmpty()) {
            return true; // 아무것도 사라지지 않으면 true 반환
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            map[cur[0]][cur[1]] = 0;
        }

        return false;
    }

    // 확인
    public static void down(int[][] map) {
        for (int i = 0; i < 7; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < 7; j++) {
                if (map[j][i] != 0) {
                    stack.add(map[j][i]);
                }
                map[j][i] = 0;
            }
            int j = 6;
            while (!stack.isEmpty()) {
                map[j--][i] = stack.pop();
            }
        }
    }

    // 확인
    public static int[][] deepcopy(int[][] map) {
        int[][] temp = new int[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                temp[i][j] = map[i][j];
            }
        }
        return temp;
    }

    // 확인
    public static int cntBall(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (map[i][j] != 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

}
