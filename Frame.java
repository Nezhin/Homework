import javax.swing.*;
import java.awt.*;

class Frame extends JFrame {

    Frame() {
        setTitle("Chat");
        setSize(new Dimension(400, 400));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Panel panel = new Panel();
        SendPanel sendPanel = new SendPanel(panel.getTextArea());

        add(panel, BorderLayout.CENTER);
        add(sendPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
