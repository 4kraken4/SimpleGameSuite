package games.hed.model;

public class HuffmanNode implements Comparable<HuffmanNode> {

    char data;
    int freq;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(char character, int frequency) {
        data = character;
        freq = frequency;
        left = right = null;
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return freq - other.freq;
    }
}
