// SWEA 5644 - 무선 충전

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class swea_5644 {
    static final int N = 10;
    static int[][] map;
    static int sum;

    static int A;
    static BC[] BCInfo;

    static class BC implements Comparable<BC>{  // BC (Battery Charger)
        int X;  // X 좌표
        int Y;  // Y 좌표
        int C;  // 충전 범위
        int P;  // 처리량

        public BC(int x, int y, int c, int p) {
            super();
            X = x;
            Y = y;
            C = c;
            P = p;
        }

        @Override
        public int compareTo(BC o) {
            return o.P - this.P;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());  // 이동 시간
            A = Integer.parseInt(st.nextToken());  // BC의 개수
            int[] AInfo = new int[M];  // A의 이동 정보
            int[] BInfo = new int[M];  // B의 이동 정보
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                AInfo[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                BInfo[i] = Integer.parseInt(st.nextToken());
            }
            BCInfo = new BC[A];  // BC의 정보
            BC[][] BCMap = new BC[N + 1][N + 1];
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());  // X 좌표
                int y = Integer.parseInt(st.nextToken());  // Y 좌표
                int c = Integer.parseInt(st.nextToken());  // 충전 범위
                int p = Integer.parseInt(st.nextToken());  // 처리량
                BCInfo[i] = new BC(x, y, c, p);
            }

            Arrays.sort(BCInfo);
            map = new int[N + 1][N + 1];
            for (int i = 0; i < A; i++) {
                for (int row = BCInfo[i].X - BCInfo[i].C; row <= BCInfo[i].X + BCInfo[i].C; row++) {
                    for (int column = BCInfo[i].Y - BCInfo[i].C; column <= BCInfo[i].Y + BCInfo[i].C; column++) {
                        if (1 <= row && row <= N && 1 <= column && column <= N) {
                            if (Math.abs(BCInfo[i].X - row) + Math.abs(BCInfo[i].Y - column) <= BCInfo[i].C) {
                                map[column][row] += (1 << i);
                            }
                        }
                    }
                }
            }

            int[] ALoc = {1, 1};
            int[] BLoc = {10, 10};

            sum = 0;
            charge(ALoc, BLoc);
            for (int i = 0; i < M; i++) {
                ALoc = move(ALoc, AInfo[i]);
                BLoc = move(BLoc, BInfo[i]);
                charge(ALoc, BLoc);
            }

            answer.append("#").append(tc).append(" ").append(sum).append("\n");
        }

        System.out.println(answer.toString());
    }

    public static int[] move(int[] loc, int d) {
        switch (d) {
            case 1:
                loc[1]--;
                return loc;
            case 2:
                loc[0]++;
                return loc;
            case 3:
                loc[1]++;
                return loc;
            case 4:
                loc[0]--;
                return loc;
            default:
                return loc;
        }
    }

    public static void charge(int[] ALoc, int[] BLoc) {
        List<Integer> APossible = new ArrayList<>();
        List<Integer> BPossible = new ArrayList<>();

        int tempA = map[ALoc[1]][ALoc[0]];
        int tempB = map[BLoc[1]][BLoc[0]];
        for (int i = 0; i < A; i++) {
            if ((tempA & (1 << i)) != 0) {
                APossible.add(i);
            }
            if ((tempB & (1 << i)) != 0) {
                BPossible.add(i);
            }
        }

        if (APossible.size() == 0 && BPossible.size() == 0) {
            return;
        } else if (APossible.size() == 0) {
            sum += BCInfo[BPossible.get(0)].P;
        } else if (BPossible.size() == 0) {
            sum += BCInfo[APossible.get(0)].P;
        } else {
            if (APossible.get(0) == BPossible.get(0)) {
                if (APossible.size() == 1 && BPossible.size() == 1) {
                    sum += BCInfo[APossible.get(0)].P;
                } else if (APossible.size() == 1) {
                    sum += BCInfo[APossible.get(0)].P;
                    sum += BCInfo[BPossible.get(1)].P;
                } else if (BPossible.size() == 1) {
                    sum += BCInfo[APossible.get(1)].P;
                    sum += BCInfo[BPossible.get(0)].P;
                } else {
                    sum += BCInfo[APossible.get(0)].P;
                    sum += Math.max(BCInfo[APossible.get(1)].P, BCInfo[BPossible.get(1)].P);
                }
            } else {
                sum += BCInfo[APossible.get(0)].P;
                sum += BCInfo[BPossible.get(0)].P;
            }
        }
    }

}
