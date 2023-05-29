package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HuffmanNode implements Comparable<HuffmanNode> {
    int frequency;
    char data;
    HuffmanNode left, right;

    @Override
    public int compareTo(HuffmanNode node) {
        return frequency - node.frequency;
    }
}

class HuffmanTree {
    public static HuffmanNode buildTree(int[] charFreqs) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
        for (int i = 0; i < 256; i++) {
            if (charFreqs[i] > 0) {
                HuffmanNode node = new HuffmanNode();
                node.data = (char) i;
                node.frequency = charFreqs[i];
                node.left = null;
                node.right = null;
                pq.offer(node);
            }
        }

        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode parent = new HuffmanNode();
            parent.frequency = left.frequency + right.frequency;
            parent.data = '\0';
            parent.left = left;
            parent.right = right;
            pq.offer(parent);
        }

        return pq.poll();
    }

    public static void generateCodes(HuffmanNode root, String code, Map<Character, String> codes) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            codes.put(root.data, code);
        }

        generateCodes(root.left, code + "0", codes);
        generateCodes(root.right, code + "1", codes);
    }
}

class HuffmanCodingGUI extends JFrame {
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;
    private final JButton encodeButton;
    private final JButton decodeButton;

    public HuffmanCodingGUI() {
        setTitle("Huffman Coding");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inputTextArea = new JTextArea();
        outputTextArea = new JTextArea();
        encodeButton = new JButton("Encode");
        decodeButton = new JButton("Decode");

        JPanel topPanel = new JPanel(new GridLayout(1, 2));
        topPanel.add(new JScrollPane(inputTextArea));
        topPanel.add(new JScrollPane(outputTextArea));

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(encodeButton);
        bottomPanel.add(decodeButton);

        add(topPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        encodeButton.addActionListener((ActionEvent e) -> {
            String input = inputTextArea.getText();
            int[] charFreqs = new int[256];
            for (char c : input.toCharArray()) {
                charFreqs[c]++;
            }
            
            HuffmanNode root = HuffmanTree.buildTree(charFreqs);
            Map<Character, String> codes = new HashMap<>();
            HuffmanTree.generateCodes(root, "", codes);
            
            StringBuilder encodedString = new StringBuilder();
            for (char c : input.toCharArray()) {
                encodedString.append(codes.get(c));
            }
            
            outputTextArea.setText(encodedString.toString());
        });

        decodeButton.addActionListener((ActionEvent e) -> {
            String encodedString = inputTextArea.getText();
            String input = JOptionPane.showInputDialog("Enter the Huffman codes (character:code):");
            
            Map<Character, String> codes = new HashMap<>();
            String[] pairs = input.split("\\s+");
            for (String pair : pairs) {
                char character = pair.charAt(0);
                String code = pair.substring(2);
                codes.put(character, code);
            }
            
            StringBuilder decodedString = new StringBuilder();
            StringBuilder currentCode = new StringBuilder();
            for (char c : encodedString.toCharArray()) {
                currentCode.append(c);
                for (Map.Entry<Character, String> entry : codes.entrySet()) {
                    if (entry.getValue().equals(currentCode.toString())) {
                        decodedString.append(entry.getKey());
                        currentCode = new StringBuilder();
                        break;
                    }
                }
            }
            
            outputTextArea.setText(decodedString.toString());
        });

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HuffmanCodingGUI::new);
    }
}
