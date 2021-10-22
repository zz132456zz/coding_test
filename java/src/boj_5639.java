// 백준 5639 - 이진 검색 트리

import java.util.Scanner;

public class boj_5639 {

    static class Node {
        int now;
        Node left;
        Node right;

        public Node(int now) {
            this.now = now;
        }
    }

    static void insertNode(Node node, int num) {
        if (node.now > num) {
            if (node.left == null) {
                node.left = new Node(num);
            } else {
                insertNode(node.left, num);
            }
        } else if (node.now < num) {
            if (node.right == null) {
                node.right = new Node(num);
            } else {
                insertNode(node.right, num);
            }
        }
    }

    static void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.now);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        Node root = new Node(num);
        while (true) {
            insertNode(root, num);
            try {
                num = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                break;
            }
        }
        postOrder(root);
    }

}
