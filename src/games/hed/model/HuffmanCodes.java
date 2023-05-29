package games.hed.model;

import java.util.*;

public class HuffmanCodes {

    public static Map<Character, String> encode(String input) {
        // Step 1: Calculate frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Create priority queue
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.offer(new HuffmanNode(entry.getKey(), entry.getValue(), null, null));
        }

        // Step 3: Build Huffman tree
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency, left, right);
            pq.offer(parent);
        }

        // Step 4: Generate Huffman codes
        HuffmanNode root = pq.poll();
        Map<Character, String> huffmanCodes = new HashMap<>();
        generateCodes(root, "", huffmanCodes);

        return huffmanCodes;
    }

    private static void generateCodes(HuffmanNode node, String code, Map<Character, String> huffmanCodes) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            huffmanCodes.put(node.character, code);
        }

        generateCodes(node.left, code + "0", huffmanCodes);
        generateCodes(node.right, code + "1", huffmanCodes);
    }

    public static String decode(String encodedString, Map<Character, String> huffmanCodes) {
        StringBuilder decodedString = new StringBuilder();
        StringBuilder currentCode = new StringBuilder();

        for (char c : encodedString.toCharArray()) {
            currentCode.append(c);

            for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
                if (entry.getValue().equals(currentCode.toString())) {
                    decodedString.append(entry.getKey());
                    currentCode = new StringBuilder();
                    break;
                }
            }
        }
        return decodedString.toString();
    }

    public static void main(String[] args) {
        // String input = "HUFFMAN PUFF";
        String input = "HIMSARA PUFF";
        Map<Character, String> huffmanCodes = encode(input);

        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        String encodedString = "";
        for (char c : input.toCharArray()) {
            encodedString += huffmanCodes.get(c);
        }

        System.out.println("Encoded string: " + encodedString);

        String decodedString = decode(encodedString, huffmanCodes);
        System.out.println("Decoded string: " + decodedString);
    }
}
