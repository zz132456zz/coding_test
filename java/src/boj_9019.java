// 백준 9019 - DSLR

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_9019 {

    static class info {
        private int num;
        private String cmd;

        public info(int num, String cmd) {
            this.num = num;
            this.cmd = cmd;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getCmd() {
            return cmd;
        }

        public void setCmd(String cmd) {
            this.cmd = cmd;
        }
    }

    static int D(int n) {
        return n * 2 % 10000;
    }

    static int S(int n) {
        return (n + 9999) % 10000;
    }

    static int L(int n) {
        return n % 1000 * 10 + n / 1000;
    }

    static int R(int n) {
        return n % 10 * 1000 + n / 10;
    }

    static String bfs(int A, int B) {
        Queue<info> q = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        q.offer(new info(A, ""));
        visited[A] = true;

        while (!q.isEmpty()) {
            info now = q.poll();
            if (now.getNum() == B) {
                q.clear();
                return now.getCmd();
            }
            if (!visited[D(now.getNum())]) {
                visited[D(now.getNum())] = true;
                q.offer(new info(D(now.getNum()), now.getCmd() + "D"));
            }
            if (!visited[S(now.getNum())]) {
                visited[S(now.getNum())] = true;
                q.offer(new info(S(now.getNum()), now.getCmd() + "S"));
            }
            if (!visited[L(now.getNum())]) {
                visited[L(now.getNum())] = true;
                q.offer(new info(L(now.getNum()), now.getCmd() + "L"));
            }
            if (!visited[R(now.getNum())]) {
                visited[R(now.getNum())] = true;
                q.offer(new info(R(now.getNum()), now.getCmd() + "R"));
            }
        }
        return "fail";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();

            System.out.println(bfs(A, B));
        }
    }
}
