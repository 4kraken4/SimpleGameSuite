package games.hed.view;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import common.events.GameWin;
import games.hed.model.HuffmanCodes;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import util.GameConfiguration;
import util.GameSuiteLogger;
import util.Utilities;

public class HedAnswerPanel extends javax.swing.JPanel {

    public HedAnswerPanel() {
        initComponents();
        txtAnswer.setSelectionColor(new Color(48, 170, 63, 200));
        txtAnswer.setForeground(Color.decode("#1E1E1E"));
        txtQuestion.setSelectionColor(new Color(48, 170, 63, 200));
        txtQuestion.setForeground(Color.decode("#1E1E1E"));
        txtQuestion.setEditable(false);
        configuration = GameConfiguration.getInstance();
        logger = GameSuiteLogger.getInstance();
        setBackBtnActions();
    }

    public GameWin getWin() {
        return win;
    }

    public void setWin(GameWin win) {
        this.win = win;
    }

    private void setBackBtnActions() {
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource(iconBackNormal)));
    }

    public void onBack(ActionListener evt) {
        btnBack.addActionListener(evt);
    }

    public boolean isIsOptEncode() {
        return isOptEncode;
    }

    public void setIsOptEncode(boolean isOptEncode) {
        this.isOptEncode = isOptEncode;
        setupUI();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnBack = new common.viewmodel.CustomButton();
        labelSchema = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        scrollPaneWin111 = new common.viewmodel.ScrollPaneWin11();
        hintPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        popupActionButton1 = new common.viewmodel.PopupActionButton();
        txtTitle = new javax.swing.JLabel();
        txtQuestion = new javax.swing.JTextPane();
        txtAnswer = new javax.swing.JTextPane();

        setPreferredSize(new java.awt.Dimension(630, 582));
        setLayout(new java.awt.BorderLayout());

        jPanel10.setLayout(new java.awt.GridBagLayout());

        jPanel8.setPreferredSize(new java.awt.Dimension(630, 582));
        jPanel8.setLayout(new java.awt.BorderLayout());

        btnBack.setActionCommand("undo");
        btnBack.setIconSize(new java.awt.Dimension(24, 24));
        btnBack.setMaximumSize(new java.awt.Dimension(30, 30));
        btnBack.setMinimumSize(new java.awt.Dimension(30, 30));
        btnBack.setPreferredSize(new java.awt.Dimension(30, 30));
        btnBack.setRoundness(100);

        labelSchema.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSchema.setText("jLabel1");
        labelSchema.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSchema, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labelSchema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel8.add(jPanel6, java.awt.BorderLayout.NORTH);

        scrollPaneWin111.setBorder(null);

        hintPanel.setPreferredSize(new java.awt.Dimension(500, 200));
        hintPanel.setRequestFocusEnabled(false);
        hintPanel.setVerifyInputWhenFocusTarget(false);
        hintPanel.setLayout(new java.awt.GridLayout());
        scrollPaneWin111.setViewportView(hintPanel);

        jPanel1.setPreferredSize(new java.awt.Dimension(700, 200));

        popupActionButton1.setBackground(new java.awt.Color(48, 170, 63));
        popupActionButton1.setForeground(new java.awt.Color(255, 255, 255));
        popupActionButton1.setText("Submit");
        popupActionButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        popupActionButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupActionButton1ActionPerformed(evt);
            }
        });

        txtTitle.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        txtTitle.setForeground(new java.awt.Color(51, 51, 51));
        txtTitle.setText("jLabel1");
        txtTitle.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        txtQuestion.setEditable(false);
        txtQuestion.setBorder(null);
        txtQuestion.setMargin(new java.awt.Insets(2, 10, 2, 10));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addComponent(txtQuestion))
                .addGap(2, 2, 2)
                .addComponent(popupActionButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(popupActionButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        txtAnswer.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        txtAnswer.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtAnswer.setCaretColor(new java.awt.Color(40, 47, 57));
        txtAnswer.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtAnswer.setMargin(new java.awt.Insets(5, 10, 5, 10));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAnswer)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel8.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel10.add(jPanel8, new java.awt.GridBagConstraints());

        add(jPanel10, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void popupActionButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupActionButton1ActionPerformed
        if (encodedString.equals(txtAnswer.getText())
                || decodedString.equals(txtAnswer.getText())) {
            if (isOptEncode) {
                win.onGameWin(encodedString, huffmanCodes);
            } else {
                win.onGameWin(encodedString, huffmanCodes);
            }
        } else {
            System.out.println("You lose");
        }
    }//GEN-LAST:event_popupActionButton1ActionPerformed

    private void resetUI() {
        txtQuestion.setText("");
        setupUI();
    }

    private void setupUI() {
        String generatedString = generateRandomStringFromJson();
        huffmanCodes = HuffmanCodes.encode(generatedString);
        encodedString = "";
        for (char c : generatedString.toCharArray()) {
            encodedString += huffmanCodes.get(c);
        }
        decodedString = HuffmanCodes.decode(encodedString, huffmanCodes);
        labelSchema.setText("Encoding schema".toUpperCase());
        labelSchema.setFont(new java.awt.Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        printHints();
        txtAnswer.setRequestFocusEnabled(true);
        txtQuestion.setFont(new java.awt.Font("Arial Rounded MT Bold", Font.ITALIC, 14));
        if (isOptEncode) {
            txtTitle.setText("Try to encode the string using given schema.");
            txtQuestion.setText(decodedString);
            txtAnswer.setText("");
            txtAnswer.requestFocus(true);
            return;
        }
        txtQuestion.setText(encodedString);
        txtTitle.setText("Try to decode the string encoded given schema.");
        txtAnswer.setText("");
        txtAnswer.requestFocus(true);
    }

    private void printHints() {
        if (!huffmanCodes.isEmpty()) {
            hintPanel.removeAll();
            hintPanel.setLayout(new GridLayout(3, 10, 5, 5));
            for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
                JLabel l = new JLabel(entry.getKey() + " -> " + entry.getValue(), SwingConstants.CENTER);
                l.setOpaque(true);
                l.setSize(new Dimension(100, 50));
                l.setBackground(Color.WHITE);
                l.setFont(new java.awt.Font("Arial Rounded MT Bold", Font.PLAIN, 14));
                l.setVerticalTextPosition(SwingConstants.CENTER);
                l.setHorizontalTextPosition(SwingConstants.CENTER);
                hintPanel.add(l);
            }
            hintPanel.repaint();
            revalidate();
        }
    }

    public String generateRandomStringFromJson() {
        String BASEDIR = System.getProperty("user.dir");
        String WORDLISTFILEDIR = configuration.getProperty("WORDLISTFILEDIR");
        try ( FileReader reader = new FileReader(BASEDIR.concat("/") + WORDLISTFILEDIR.concat("/") + "wordlist.json")) {
            JsonElement jsonElement = JsonParser.parseReader(reader);
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            Random random = new Random();
            int wordsCount = random.nextInt(4) + 2;
            List<String> selectedWords = getRandomWords(jsonArray, wordsCount);
            StringBuilder concatenatedString = new StringBuilder();
            for (String word : selectedWords) {
                concatenatedString.append(capitalizeFirstLetter(word));
            }
            return truncateString(concatenatedString.toString(), 30);
        } catch (IOException e) {
            logger.logError(Utilities.class.getName(), e);
        } catch (Exception e) {
            logger.logError(Utilities.class.getName(), e);
        }
        return "";
    }

    private static List<String> getRandomWords(JsonArray jsonArray, int count) {
        List<String> words = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int randomIndex = random.nextInt(jsonArray.size());
            String word = jsonArray.get(randomIndex).getAsString();
            words.add(word);
        }

        return words;
    }

    private static String capitalizeFirstLetter(String value) {
        if (value == null || value.isEmpty()) {
            return value;
        }
        return Character.toUpperCase(value.charAt(0)) + value.substring(1);
    }

    private static String truncateString(String inputString, int maxLength) {
        if (inputString.length() <= maxLength) {
            return inputString;
        }
        String[] words = inputString.split("\\s+");
        Random random = new Random();
        int wordsToRemove = random.nextInt(2) + 1;
        List<String> truncatedWords = new ArrayList<>(Arrays.asList(words));
        while (truncatedWords.size() > wordsToRemove && !truncatedWords.isEmpty()) {
            int indexToRemove = random.nextInt(truncatedWords.size());
            truncatedWords.remove(indexToRemove);
        }
        StringBuilder truncatedString = new StringBuilder();
        for (String word : truncatedWords) {
            truncatedString.append(word).append(" ");
        }
        return truncatedString.toString().trim();
    }

    private final String iconBackNormal = "/common/icons/back-line.png";
    private boolean isOptEncode;
    private String encodedString;
    private String decodedString;
    private Map<Character, String> huffmanCodes;
    private GameWin win;
    private final GameConfiguration configuration;
    private final GameSuiteLogger logger;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private common.viewmodel.CustomButton btnBack;
    private javax.swing.JPanel hintPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel labelSchema;
    private common.viewmodel.PopupActionButton popupActionButton1;
    private common.viewmodel.ScrollPaneWin11 scrollPaneWin111;
    private javax.swing.JTextPane txtAnswer;
    private javax.swing.JTextPane txtQuestion;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
