package games.unitTests;

import games.hed.model.HuffmanCodes;
import java.util.Map;

public class HuffmanCodingTest {

    public void testHuffmanCoding() {
        String input = "abracadabra";

        Map<Character, String> huffmanCodes = HuffmanCodes.encode(input);

        StringBuilder encodedString = new StringBuilder();
        for (char c : input.toCharArray()) {
            encodedString.append(huffmanCodes.get(c));
        }
        String decodedString = HuffmanCodes.decode(encodedString.toString(), huffmanCodes);

        System.out.println(input + ", " + decodedString);
    }
}
