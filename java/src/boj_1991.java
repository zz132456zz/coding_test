// 백준 1991 - 트리 순회

import java.util.ArrayList;
import java.util.Scanner;

class Node {
    char now;
    Node left;
    Node right;

    public Node(char now) {
        this.now = now;
    }
}

public class boj_1991 {

    static ArrayList<Node> arr;

    public static void preOrder(char now) {
        if (now != '.') {
            int alpha = now - 'A';
            System.out.print(now);
            preOrder(arr.get(alpha).left.now);
            preOrder(arr.get(alpha).right.now);
        }
    }

    public static void inOrder(char now) {
        if (now != '.') {
            int alpha = now - 'A';
            inOrder(arr.get(alpha).left.now);
            System.out.print(now);
            inOrder(arr.get(alpha).right.now);
        }
    }

    public static void postOrder(char now) {
        if (now != '.') {
            int alpha = now - 'A';
            postOrder(arr.get(alpha).left.now);
            postOrder(arr.get(alpha).right.now);
            System.out.print(now);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            char alpha = (char)('A' + i);
            arr.add(new Node(alpha));
        }

        for (int i = 0; i < N; i++) {
            String[] strs = scanner.nextLine().split(" ");
            int alpha = strs[0].charAt(0) - 'A';
            arr.get(alpha).left = new Node(strs[1].charAt(0));
            arr.get(alpha).right = new Node(strs[2].charAt(0));
        }

        preOrder('A');
        System.out.println();
        inOrder('A');
        System.out.println();
        postOrder('A');

    }

}
