package games.hed.model;

import java.util.PriorityQueue;

public class HuffmanCodes {

    static final int MAX_SIZE = 100;

    static HuffmanNode generateTree(PriorityQueue<HuffmanNode> queue) {
        while (queue.size() != 1) {
            HuffmanNode left = queue.poll();
            HuffmanNode right = queue.poll();
            HuffmanNode node = new HuffmanNode('$', left.freq + right.freq);
            queue.add(node);
        }
        return queue.poll();
    }

    static void huffmanCodes(char[] data, int[] freq, int size) {
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>();
        for (int i = 0; i < size; i++) {
            HuffmanNode node = new HuffmanNode(data[i], freq[i]);
            queue.add(node);
        }
        HuffmanNode root = generateTree(queue);
        int[] arr = new int[MAX_SIZE];
        int top = 0;
        printCodes(root, arr, top);
    }

    static void printCodes(HuffmanNode root, int[] arr, int top) {
        if (root.left != null) {
            arr[top] = 0;
            printCodes(root.left, arr, top + 1);
        }
        if (root.right != null) {
            arr[top] = 1;
            printCodes(root.right, arr, top + 1);
        }
        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
            for (int i = 0; i < top; ++i) {
                System.out.print(arr[i]);
            }
            System.out.println();
        }
    }
}
