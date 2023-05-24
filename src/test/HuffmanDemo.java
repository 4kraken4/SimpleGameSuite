package test;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

class HuffmanDecoderUI extends JFrame {

    private JTextArea encodedText;
    private JTextArea decodedText;
    private Map<String, String> huffmanMap;

    public HuffmanDecoderUI() {
        setTitle("Huffman Decoder");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Load the word dictionary from a JSON file
        try {
            huffmanMap = loadDictionary("dictionary.json");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Failed to load dictionary: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            huffmanMap = new HashMap<>();
        }

        // Create a panel for the input and output components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 2));

        JLabel encodedLabel = new JLabel("Encoded Text:");
        mainPanel.add(encodedLabel);

        encodedText = new JTextArea();
        JScrollPane encodedScrollPane = new JScrollPane(encodedText);
        mainPanel.add(encodedScrollPane);

        JLabel decodedLabel = new JLabel("Decoded Text:");
        mainPanel.add(decodedLabel);

        decodedText = new JTextArea();
        decodedText.setEditable(false);
        JScrollPane decodedScrollPane = new JScrollPane(decodedText);
        mainPanel.add(decodedScrollPane);

        add(mainPanel, BorderLayout.CENTER);

        // Create a button to perform the decoding
        JButton decodeButton = new JButton("Decode");
        decodeButton.addActionListener((ActionEvent e) -> {
            String encodedString = encodedText.getText();
            try {
                String decodedString = decodeHuffman(encodedString);
                decodedText.setText(decodedString);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(HuffmanDecoderUI.this, ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(decodeButton, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    private Map<String, String> loadDictionary(String filename) throws IOException {
        try ( FileReader fileReader = new FileReader(filename)) {
            Gson gson = new Gson();
            java.lang.reflect.Type type = new TypeToken<Map<String, String>>() {
            }.getType();
            return gson.fromJson(fileReader, type);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Dictionary file not found: " + filename);
        } catch (JsonSyntaxException e) {
            throw new IllegalArgumentException("Invalid JSON format in the dictionary file: " + filename);
        } catch (IOException e) {
            throw new IOException("Failed to read the dictionary file: " + filename, e);
        }
    }

    private String decodeHuffman(String encodedString) {
        StringBuilder decodedString = new StringBuilder();
        StringBuilder currentCode = new StringBuilder();
        for (int i = 0; i < encodedString.length(); i++) {
            currentCode.append(encodedString.charAt(i));
            if (huffmanMap.containsKey(currentCode.toString())) {
                String word = huffmanMap.get(currentCode.toString());
                decodedString.append(word).append(" ");
                currentCode.setLength(0);
            }
        }
        return decodedString.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FlatLaf.setup(new FlatLightLaf());
            HuffmanDecoderUI decoderUI = new HuffmanDecoderUI();
            decoderUI.setVisible(true);
        });
    }
}
