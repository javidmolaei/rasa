package app.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import static app.Utils.UIUtils.COLOR_INTERACTIVE_DARKER;
import static app.Utils.UIUtils.FONT_FORGOT_PASSWORD;
import static java.awt.Cursor.HAND_CURSOR;
import static java.awt.Cursor.getPredefinedCursor;

public class HyperlinkTextTitle extends JLabel {
    public HyperlinkTextTitle(String hyperlinkText, int xPos, int yPos, Runnable hyperlinkAction) {
        super(hyperlinkText);
        setForeground(COLOR_INTERACTIVE_DARKER);
        setFont(FONT_FORGOT_PASSWORD);
        setCursor(getPredefinedCursor(HAND_CURSOR));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                hyperlinkAction.run();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(COLOR_INTERACTIVE_DARKER.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(COLOR_INTERACTIVE_DARKER);
            }
        });

        Dimension prefSize = getPreferredSize();
        setBounds(xPos, yPos, prefSize.width, prefSize.height);
    }
}