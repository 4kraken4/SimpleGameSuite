/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package games.HPED.model;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

/**
 *
 * @author Acer
 */
public class HedModel {

    public HedModel(int length) {
        this.stringLength=length;
        generateString();
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getEncodedString() {
        return encodedString;
    }

    public void setEncodedString(String encodedString) {
        this.encodedString = encodedString;
    }

    public String getDecodedSring() {
        return decodedSring;
    }

    public void setDecodedSring(String decodedSring) {
        this.decodedSring = decodedSring;
    }

    public Map<Character,String> getHuffmancodes() {
        return huffmancodes;
    }

    public void setHuffmancodes(Map<Character,String> huffmancodes) {
        this.huffmancodes = huffmancodes;
    }
     public static Map<Character, String> encode(String input) {

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.offer(new HuffmanNode(entry.getKey(), entry.getValue(), null, null));
        }

        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency, left, right);
            pq.offer(parent);
        }
        
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
    
    private void generateString()
    {
        String characters ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(stringLength);
        for (int i = 0; i < stringLength; i++) {
            int ranind = random.nextInt(characters.length());
            char ranchar = characters.charAt(ranind);
            sb.append(ranchar);
        }
        this.setInput(sb.toString());
        
    
    }
    
    
    private int stringLength =5;
    private String input;
    private String encodedString;
    private String decodedSring;
    private Map<Character,String> huffmancodes ;
    
    
}
