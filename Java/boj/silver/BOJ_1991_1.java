package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * BOJ 1991 트리 순회
 * ?>
 * 트리, 재귀
 */

public class BOJ_1991_1 {

    /**
     * 이진 트리의 노드의 개수
     * 1 <= N <= 26
     */
    static int N;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // logic
        N = Integer.parseInt(br.readLine());

        Map<Character, Node> store = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char parent = st.nextToken().charAt(0);
            char leftChild = st.nextToken().charAt(0);
            char rightChild = st.nextToken().charAt(0);

            if (!store.containsKey(parent)) {
                store.put(parent, new Node(parent));
            }
            Node parentNode = store.get(parent);

            if (leftChild != '.') {
                if (!store.containsKey(leftChild)) {
                    store.put(leftChild, new Node(leftChild));
                }

                parentNode.addLeftNode(store.get(leftChild));
            }

            if (rightChild != '.') {
                if (!store.containsKey(rightChild)) {
                    store.put(rightChild, new Node(rightChild));
                }

                parentNode.addRightNode(store.get(rightChild));
            }
        }

        Node rootNode = store.get('A');

        preorder(rootNode);
        System.out.println();

        inorder(rootNode);
        System.out.println();

        postorder(rootNode);
        System.out.println();

        // io close
        br.close();
    }

    private static void postorder(Node parentNode) {
        Node leftNode = parentNode.getLeftNode();
        if (leftNode != null) {
            postorder(leftNode);
        }

        Node rightNode = parentNode.getRightNode();
        if (rightNode != null) {
            postorder(rightNode);
        }

        System.out.print(parentNode.getValue());
    }

    private static void inorder(Node parentNode) {
        Node leftNode = parentNode.getLeftNode();
        if (leftNode != null) {
            inorder(leftNode);
        }

        System.out.print(parentNode.getValue());

        Node rightNode = parentNode.getRightNode();
        if (rightNode != null) {
            inorder(rightNode);
        }
    }


    private static void preorder(Node parentNode) {
        System.out.print(parentNode.getValue());

        Node leftNode = parentNode.getLeftNode();
        if (leftNode != null) {
            preorder(leftNode);
        }

        Node rightNode = parentNode.getRightNode();
        if (rightNode != null) {
            preorder(rightNode);
        }
    }

    private static class Node {

        private final char value;

        private Node leftNode;

        private Node rightNode;

        public Node(char value) {
            this.value = value;
        }

        public char getValue() {
            return value;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void addLeftNode(Node node) {
            this.leftNode = node;
        }

        public void addRightNode(Node node) {
            this.rightNode = node;
        }
    }
}
