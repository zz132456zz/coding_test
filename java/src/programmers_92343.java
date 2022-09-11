// 프로그래머스 92343 - 양과 늑대

import java.util.ArrayList;
import java.util.List;

public class programmers_92343 {
    static int answer;
    static Node[] tree;

    public static class Node {
        int left = -1;
        int right = -1;
    }

    public static int solution(int[] info, int[][] edges) {
        int N = info.length;

        tree = new Node[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new Node();
        }

        for (int i = 0; i < edges.length; i++) {
            if (tree[edges[i][0]].left == -1) {
                tree[edges[i][0]].left = edges[i][1];
            } else {
                tree[edges[i][0]].right = edges[i][1];
            }
        }

        answer = 0;

        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0, 0, 0, info, list);

        return answer;
    }

    public static void dfs(int node, int sheep, int wolf, int[] info, List<Integer> next) {
        if (info[node] == 0) {
            sheep++;
        } else {
            wolf++;
        }

        if (sheep <= wolf) {
            return;
        }

        if (answer < sheep) answer = sheep;

        List<Integer> list = new ArrayList<>();
        list.addAll(next);
        list.remove(Integer.valueOf(node));

        if (tree[node].left != -1) {
            list.add(tree[node].left);
        }
        if (tree[node].right != -1) {
            list.add(tree[node].right);
        }

        for (int i = 0; i < list.size(); i++) {
            dfs(list.get(i), sheep, wolf, info, list);
        }
    }

    public static void main(String[] args) {
        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edges = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}};
        int result = solution(info, edges);

        System.out.println(result);
    }

}
