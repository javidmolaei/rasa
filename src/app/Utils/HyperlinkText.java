package app.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import static app.Utils.UIUtils.COLOR_OUTLINE;
import static app.Utils.UIUtils.FONT_FORGOT_PASSWORD;
import static java.awt.Cursor.HAND_CURSOR;
import static java.awt.Cursor.getPredefinedCursor;

public class HyperlinkText extends JLabel {
    public HyperlinkText(String hyperlinkText, int xPos, int yPos, Runnable hyperlinkAction) {
        super(hyperlinkText);
        setForeground(COLOR_OUTLINE);
        setFont(FONT_FORGOT_PASSWORD);
        setCursor(getPredefinedCursor(HAND_CURSOR));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                hyperlinkAction.run();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(COLOR_OUTLINE.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(COLOR_OUTLINE);
            }
        });

        Dimension prefSize = getPreferredSize();
        setBounds(xPos, yPos, prefSize.width, prefSize.height);
    }
}