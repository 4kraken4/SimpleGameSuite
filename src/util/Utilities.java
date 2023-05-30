package util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Utilities {

    private static final GameSuiteLogger logger = GameSuiteLogger.getInstance();

    public static ImageIcon scaleIcon(ImageIcon icn, int maxWidth, int maxHeight) {
        BufferedImage image = new BufferedImage(icn.getIconWidth(), icn.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.drawImage(icn.getImage(), 0, 0, null);
        g2d.dispose();
        int originalWidth = image.getWidth();
        int originalHeight = image.getHeight();
        double scaleFactor = Math.min((double) maxWidth / originalWidth, (double) maxHeight / originalHeight);
        int newWidth = (int) Math.round(originalWidth * scaleFactor);
        int newHeight = (int) Math.round(originalHeight * scaleFactor);
        Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    public static void setUI(JPanel container, JPanel panel) {
        container.removeAll();
        container.add(panel);
        container.repaint();
        container.revalidate();
    }

    public static String getValueFromJsonFile(String filePath, String key) {
        String BASEDIR = System.getProperty("user.dir");
        try ( FileReader reader = new FileReader(BASEDIR.concat("/") + filePath)) {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            String value = jsonObject.get(key).getAsString();
            return value;
        } catch (IOException e) {
            logger.logError(Utilities.class.getName(), e);
        } catch (Exception e) {
            logger.logError(Utilities.class.getName(), e);
        }
        return null;
    }

    public static byte[] serialize(Object object) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(object);
            oos.flush();
            return bos.toByteArray();
        } catch (IOException e) {
            logger.logError(Utilities.class.getName(), e);
        }
        return null;
    }

    public static Object deserialize(byte[] data) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(bis);
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            logger.logError(Utilities.class.getName(), e);
        }
        return null;
    }
}
