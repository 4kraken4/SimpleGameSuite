
package games.unitTests;

import games.hed.model.HuffmanCodes;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class HuffmanCodingTest {
   
     @Test
    public void testHuffmanCoding() {
        String input = "abracadabra";

        Map<Character, String> huffmanCodes = HuffmanCodes.encode(input);

        StringBuilder encodedString = new StringBuilder();
        for (char c : input.toCharArray()) {
            encodedString.append(huffmanCodes.get(c));
        }
        String decodedString = HuffmanCodes.decode(encodedString.toString(), huffmanCodes);

        Assertions.assertEquals(input, decodedString);
    }
}
