// 백준 17406 - 배열 돌리기 4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_17406 {
    static int N, M, T ;
    static int map[][];
    static int[] answer;
    static int min;
    static ArrayList<Integer[]> rotate;

    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        min =Integer.MAX_VALUE;

        for(int i=0;i<N;i++) {
            st= new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rotate = new ArrayList<>();
        answer= new int[T];
        for(int i=0; i<T;i++) {
            st= new StringTokenizer(bf.readLine());
            rotate.add(new Integer[] {Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())});
        }

        permu(0,0);
        System.out.println(min);
    }
    public static void permu(int n , int flag) {
        if(n ==T) {
            calc();
            return;
        }
        for(int i=0; i<T;i++) {

            if((flag & 1<<i)==0) {
                answer[n]=i;
                permu(n+1, flag | 1<<i);
            }
        }
    }
    private static void calc() {
        int[][] calc_map= new int[N][M];
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                calc_map[i][j]=map[i][j];
            }
        }

        for(int i=0; i<T;i++) {
            Integer[] temp = rotate.get(answer[i]);
            for(int j=1; j<=temp[2];j++) {
                int y = temp[0]-j;
                int x= temp[1]-j;

                Deque<Integer> q = new LinkedList<>();
                q.add(calc_map[y][x]);

                int count = 2*j+1; //오른쪽
                for(int k=1;k<count;k++) {
                    x=x+1;
                    q.add(calc_map[y][x]);
                }

                count = 2*j; //아래
                for(int k=1;k<count;k++) {
                    y=y+1;
                    q.add(calc_map[y][x]);
                }
                y=y+1;
                q.add(calc_map[y][x]);

                count = 2*j+1; //왼쪽
                for(int k=1;k<count;k++) {
                    x=x-1;
                    q.add(calc_map[y][x]);
                }

                count = 2*j; //위
                for(int k=1;k<count;k++) {
                    y=y-1;
                    q.add(calc_map[y][x]);
                }

                q.addFirst(q.pollLast());

                y = temp[0]-j;
                x= temp[1]-j;

                calc_map[y][x] = q.poll();
                count = 2*j+1; //오른쪽
                for(int k=1;k<count;k++) {
                    x=x+1;
                    calc_map[y][x] = q.poll();
                }

                count = 2*j; //아래
                for(int k=1;k<count;k++) {
                    y=y+1;
                    calc_map[y][x] = q.poll();
                }
                y=y+1;
                calc_map[y][x] = q.poll();

                count = 2*j+1; //왼쪽
                for(int k=1;k<count;k++) {
                    x=x-1;
                    calc_map[y][x] = q.poll();
                }

                count = 2*j; //위
                for(int k=1;k<count;k++) {
                    y=y-1;
                    calc_map[y][x] = q.poll();
                }
            }
        }

        int min_calc= Integer.MAX_VALUE;
        for(int a =0;a <N ;a++) {
            int sum =0;
            for(int m=0;m<M;m++) {
                sum = sum+calc_map[a][m];
            }
            min_calc = Math.min(sum, min_calc);
        }
        min = Math.min(min,min_calc);
    }
}