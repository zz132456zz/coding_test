// 백준 2239 - 스도쿠

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj_2239 {

    static final int N = 9;
    static int[][] map;
    static ArrayList<int[]> zeroList;
    static int zeroCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[N][N];
        zeroList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
                if (map[i][j] == 0) {
                    zeroList.add(new int[] {i, j});
                }
            }
        }

        zeroCnt = zeroList.size();

        sudoku(0);

        for (int i = 0; i < N; i++) {  // 결과 출력
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean sudoku(int depth) {
        if (depth == zeroCnt) {
            return true; // 끝. 다 나가기
        }

        int[] loc = zeroList.get(depth);  // 현재위치

        // ArrayList
//        ArrayList<Integer> possible = findPossible(zeroList.get(depth));  // 현재위치에서 가능한 숫자들
//        for (int p : possible) {  // 가능한 숫자들 작은수부터 하나씩 시도
//            map[loc[0]][loc[1]] = p;
//            if (sudoku(depth + 1)) return true;
//            map[loc[0]][loc[1]] = 0;
//        }

        // 비트마스킹
        int possible = findPossible(zeroList.get(depth));  // 현재위치에서 가능한 숫자들
        for (int i = 1; i <= N; i++) {
            if ((possible & (1 << i)) != 0) continue;
            map[loc[0]][loc[1]] = i;
            if (sudoku(depth + 1)) return true;
            map[loc[0]][loc[1]] = 0;
        }

        return false;
    }

    // 비트마스킹
    public static int findPossible(int[] loc) {
        int mask = 0;
        for (int i = 0; i < N; i++) {
            mask |= 1 << map[loc[0]][i];
            mask |= 1 << map[i][loc[1]];
        }

        int x = loc[0] / 3 * 3;
        int y = loc[1] / 3 * 3;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                mask |= 1 << map[i][j];
            }
        }

        return mask;
    }

    // ArrayList
//    public static ArrayList<Integer> findPossible(int[] loc) {
//        boolean[] visited = new boolean[N + 1];
//        for (int i = 0; i < N; i++) {
//            visited[map[loc[0]][i]] = true;
//            visited[map[i][loc[1]]] = true;
//        }
//
//        int x = loc[0] / 3 * 3;
//        int y = loc[1] / 3 * 3;
//
//        for (int i = x; i < x + 3; i++) {
//            for (int j = y; j < y + 3; j++) {
//                visited[map[i][j]] = true;
//            }
//        }
//
//        ArrayList<Integer> result = new ArrayList<>();
//
//        for (int i = 1; i < 10; i++) {
//            if(!visited[i]) result.add(i);
//        }
//
//        return result;
//    }

}
