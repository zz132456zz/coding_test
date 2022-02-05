// SWEA 1873 - 상호의 배틀필드

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class swea_1873 {
    static int H;  // 높이
    static int W;  // 너비

    static int r = -1;  // 현재위치r
    static int c = -1;  // 현재위치c
    static int d = -1;  // 1:left, 2:right, 3:up, 4:down
    static char[][] map;  // 맵

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());  // 테스트케이스 개수 입력받기
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());  // 높이
            W = Integer.parseInt(st.nextToken());  // 너비
            map = new char[H][];  // 맵
            for (int i = 0; i < H; i++) {
                map[i] = br.readLine().toCharArray();
            }
            int N = Integer.parseInt(br.readLine());  // 사용자 입력 개수
            char[] data = br.readLine().toCharArray();  // 입력의 종류

            // 전차찾기
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
                        if (map[i][j] == '<') {  // 왼쪽
                            r = i;
                            c = j;
                            d = 1;
                        } else if (map[i][j] == '>') {  // 오른쪽
                            r = i;
                            c = j;
                            d = 2;
                        } else if (map[i][j] == '^') {  // 위
                            r = i;
                            c = j;
                            d = 3;
                        } else if (map[i][j] == 'v') {  // 아래
                            r = i;
                            c = j;
                            d = 4;
                        }
                    }
                }
            }

            // 입력실행
            for (int i = 0; i < N; i++) {
                if (data[i] == 'U') {
                    U();
                } else if (data[i] == 'D') {
                    D();
                } else if (data[i] == 'L') {
                    L();
                } else if (data[i] == 'R') {
                    R();
                } else if (data[i] == 'S') {
                    S();
                }
            }

            // 출력
            bw.write("#" + tc + " ");
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    bw.write(map[i][j]);
                }
                bw.newLine();
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void U() {
        if (r - 1 >= 0 && map[r - 1][c] == '.') {  // 범위 안이면서 평지면
            map[r--][c] = '.';  // 원래있던곳 평지로
        }
        d = 3;  // 방향바꾸기
        map[r][c] = '^';  // 방향바꾸기
    }

    public static void D() {
        if (r + 1 < H && map[r + 1][c] == '.') {
            map[r++][c] = '.';
        }
        d = 4;
        map[r][c] = 'v';
    }

    public static void L() {
        if (c - 1 >= 0 && map[r][c - 1] == '.') {
            map[r][c--] = '.';
        }
        d = 1;
        map[r][c] = '<';
    }

    public static void R() {
        if (c + 1 < W && map[r][c + 1] == '.') {
            map[r][c++] = '.';
        }
        d = 2;
        map[r][c] = '>';
    }

    public static void S() {
        if (d == 1) {
            for (int i = c; i >= 0; i--) {
                if (map[r][i] == '*') {  // 벽돌벽
                    map[r][i] = '.';
                    break;
                } else if (map[r][i] == '#') {  // 강철벽
                    break;
                }
            }
        } else if (d == 2) {
            for (int i = c; i < W; i++) {
                if (map[r][i] == '*') {
                    map[r][i] = '.';
                    break;
                } else if (map[r][i] == '#') {
                    break;
                }
            }
        } else if (d == 3) {
            for (int i = r; i >= 0; i--) {
                if (map[i][c] == '*') {
                    map[i][c] = '.';
                    break;
                } else if (map[i][c] == '#') {
                    break;
                }
            }
        } else if (d == 4) {
            for (int i = r; i < H; i++) {
                if (map[i][c] == '*') {
                    map[i][c] = '.';
                    break;
                } else if (map[i][c] == '#') {
                    break;
                }
            }
        }
    }

}
