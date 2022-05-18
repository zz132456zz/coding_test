// 소프티어 625 - [21년 재직자 대회 예선] 좌석관리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class softeer_625 {

    static int N, M;
    static int[][] map;
    static int[] lunchStatus;
    static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        lunchStatus = new int[10001];  // 0:아직안먹음 1:먹고있음 2:다먹음

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int id = Integer.parseInt(st.nextToken());

            if (cmd.equals("In")) {
                if (lunchStatus[id] == 0) {
                    // 아직안먹음
                    int[] loc = find();
                    if (loc[0] == -1 && loc[1] == -1) {
                        answer.append("There are no more seats.\n");
                    } else {
                        answer.append(id).append(" gets the seat (").append(loc[0] + 1).append(", ").append(loc[1] + 1).append(").\n");
                        lunchStatus[id] = 1;
                        map[loc[0]][loc[1]] = id;
                    }
                } else if (lunchStatus[id] == 1) {
                    // 먹고있음
                    answer.append(id).append(" already seated.\n");
                } else if (lunchStatus[id] == 2) {
                    // 다먹음
                    answer.append(id).append(" already ate lunch.\n");
                }
            } else if (cmd.equals("Out")) {
                if (lunchStatus[id] == 0) {
                    // 아직안먹음
                    answer.append(id).append(" didn't eat lunch.\n");
                } else if (lunchStatus[id] == 1) {
                    // 먹고있음
                    fin:for (int r = 0; r < N; r++) {
                        for (int c = 0; c < M; c++) {
                            if (map[r][c] == id) {
                                answer.append(id).append(" leaves from the seat (").append(r + 1).append(", ").append(c + 1).append(").\n");
                                lunchStatus[id] = 2;
                                map[r][c] = 0;
                                break fin;
                            }
                        }
                    }
                } else if (lunchStatus[id] == 2) {
                    // 다먹음
                    answer.append(id).append(" already left seat.\n");
                }
            }
        }

        System.out.print(answer);
    }

    public static int[] find() {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            temp[i] = map[i].clone();
        }

        boolean available = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    temp[i][j] = Integer.MAX_VALUE;
                    for (int d = 0; d < 4; d++) {
                        int nr = i + delta[d][0];
                        int nc = j + delta[d][1];
                        if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                            temp[nr][nc] = Integer.MAX_VALUE;
                        }
                    }
                }
            }
        }

        int[][] safetyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] != Integer.MAX_VALUE) {
                    available = true;

                    int safety = Integer.MAX_VALUE;
                    for (int r = 0; r < N; r++) {
                        for (int c = 0; c < M; c++) {
                            if (map[r][c] != 0) {
                                int cal = Math.abs(i - r) * Math.abs(i - r) + Math.abs(j - c) * Math.abs(j - c);
                                if (safety > cal) {
                                    safety = cal;
                                }
                            }
                        }
                    }

                    safetyMap[i][j] = safety;
                }
            }
        }

        if (available) {
            int[] loc = {0, 0};
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (max < safetyMap[i][j]) {
                        loc[0] = i;
                        loc[1] = j;
                        max = safetyMap[i][j];
                    }
                }
            }
            return loc;
        } else {
            return new int[] {-1, -1};
        }
    }

}
