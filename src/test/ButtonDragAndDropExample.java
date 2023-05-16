package test;

import java.awt.datatransfer.*;
import java.awt.*;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class ButtonDragAndDropExample extends JFrame {
    private JPanel sourcePanel;
    private JPanel targetPanel;

    public ButtonDragAndDropExample() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Create the source panel with a button
        sourcePanel = new JPanel();
        JButton sourceButton = new JButton("Drag me!");
        sourceButton.setTransferHandler(new ButtonTransferHandler());
        sourcePanel.add(sourceButton);

        // Create the target panel
        targetPanel = new JPanel();
        targetPanel.setDropTarget(new ButtonDropTarget());
        targetPanel.setLayout(new BoxLayout(targetPanel, BoxLayout.Y_AXIS));

        // Add the panels to the frame
        add(sourcePanel, BorderLayout.WEST);
        add(targetPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ButtonDragAndDropExample();
    }

    private class ButtonTransferHandler extends TransferHandler {
        @Override
        public int getSourceActions(JComponent c) {
            return TransferHandler.MOVE;
        }

        @Override
        protected Transferable createTransferable(JComponent c) {
            JButton button = (JButton)c;
            return new ButtonTransferable(button.getText());
        }

        @Override
        public boolean canImport(TransferHandler.TransferSupport support) {
            if (!support.isDrop()) {
                return false;
            }

            return support.getComponent() instanceof JPanel;
        }

        @Override
        public boolean importData(TransferHandler.TransferSupport support) {
            if (!canImport(support)) {
                return false;
            }

            Transferable transferable = support.getTransferable();
            String data;
            try {
                data = (String)transferable.getTransferData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException | IOException e) {
                return false;
            }

            JPanel panel = (JPanel)support.getComponent();
            JButton button = new JButton(data);
            panel.add(button);
            panel.revalidate();
            panel.repaint();

            return true;
        }
    }

    private class ButtonDropTarget extends DropTarget {
        @Override
        public void drop(DropTargetDropEvent event) {
            try {
                Transferable transferable = event.getTransferable();
                if (transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                    String data = (String)transferable.getTransferData(DataFlavor.stringFlavor);
                    JButton button = new JButton(data);
                    targetPanel.add(button);
                    targetPanel.revalidate();
                    targetPanel.repaint();
                    event.dropComplete(true);
                } else {
                    event.rejectDrop();
                }
            } catch (UnsupportedFlavorException | IOException e) {
                event.rejectDrop();
            }
        }
    }

    private class ButtonTransferable implements Transferable {
        private String text;

        public ButtonTransferable(String text) {
            this.text = text;
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[] { DataFlavor.stringFlavor };
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return flavor.equals(DataFlavor.stringFlavor);
        }

        @Override
        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
            if (isDataFlavorSupported(flavor)) {
                return text;
            } else {
                throw new UnsupportedFlavorException(flavor);
            }
        }
    }
}
