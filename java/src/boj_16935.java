// 백준 16935 - 배열 돌리기 3

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_16935 {

    static int N;
    static int M;
    static int[][] data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        List<Integer> R = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            R.add(Integer.parseInt(st.nextToken()));
        }

        for (int r : R) {
            switch (r) {
                case 1:
                    one();
                    break;
                case 2:
                    two();
                    break;
                case 3:
                    three();
                    break;
                case 4:
                    four();
                    break;
                case 5:
                    five();
                    break;
                case 6:
                    six();
                    break;
            }
        }

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                bw.write(data[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void one() {  // 상하 반전
        int[][] temp = new int[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                temp[i][j] = data[data.length - i - 1][j];
            }
        }
        data = temp;
    }

    public static void two() {  // 좌우 반전
        int[][] temp = new int[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                temp[i][j] = data[i][data[0].length - j - 1];
            }
        }
        data = temp;
    }

    public static void three() {  // 오른쪽 90도 회전
        int[][] temp = new int[data[0].length][data.length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                temp[j][i] = data[data.length - i - 1][j];
            }
        }
        data = temp;
    }

    public static void four() {  // 왼쪽 90도 회전
        int[][] temp = new int[data[0].length][data.length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                temp[j][i] = data[i][data[0].length - j - 1];
            }
        }
        data = temp;
    }

    public static void five() {  // 4개 그룹으로 나눠서 시계방향 회전
        int[][] temp = new int[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (i < data.length / 2 && j < data[0].length / 2) {
                    temp[i][j] = data[i + data.length / 2][j];
                } else if (i < data.length / 2) {
                    temp[i][j] = data[i][j - data[0].length / 2];
                } else if (j < data[0].length / 2) {
                    temp[i][j] = data[i][j + data[0].length / 2];
                } else {
                    temp[i][j] = data[i - data.length / 2][j];
                }
            }
        }
        data = temp;
    }

    public static void six() {  // 4개 그룹으로 나눠서 반시계방향 회전
        int[][] temp = new int[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (i < data.length / 2 && j < data[0].length / 2) {
                    temp[i][j] = data[i][j + data[0].length / 2];
                } else if (i < data.length / 2) {
                    temp[i][j] = data[i + data.length / 2][j];
                } else if (j < data[0].length / 2) {
                    temp[i][j] = data[i - data.length / 2][j];
                } else {
                    temp[i][j] = data[i][j - data[0].length / 2];
                }
            }
        }
        data = temp;
    }

}
