package app.main;

import app.Utils.*;
import app.Utils.TextField;
import app.model.Knapsack;
import app.model.KnapsackItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Objects;

public class Main extends JFrame {
    private final Toaster toaster;
    public static JTextArea console;
    TextField nField = new TextField("OBJECT");
    TextField mField = new TextField("BOX");
    TextField kField = new TextField("WEIGHT");
    TextField iField = new TextField("INPUT (example:5 2 1 4 2)");

    public static void main(String[] args) {
        new Main();


    }

    private Main() {
        JPanel mainJPanel = getMainJPanel();
        console = addConsole(mainJPanel);
        addSeparator(mainJPanel);
        addTitle(mainJPanel);
        addObjectTextField(mainJPanel);
        addBoxTextField(mainJPanel);
        addBoxWeightTextField(mainJPanel);
        addInputTextField(mainJPanel);
        addButton(mainJPanel);
        addCloseButton(mainJPanel);
        this.add(mainJPanel);
        this.pack();
        this.setVisible(true);
        this.toFront();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width / 2 - getWidth() / 2, screenSize.height / 2 - getHeight() / 2);

        toaster = new Toaster(mainJPanel);
    }

    private void addTitle(JPanel panel1) {
        panel1.add(new HyperlinkTextTitle(UIUtils.BUTTON_TEXT_TITLE, 10, 10, () -> {
        }));
    }

    private JTextArea addConsole(JPanel panel1) {
        JTextArea textArea = new JTextArea();
        setLocationRelativeTo(null);
        textArea.setEditable(false);
        textArea.setAutoscrolls(true);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBounds(5, 5, 250, 300);
        JScrollPane jScrollPane = new JScrollPane(textArea);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setBounds(0, 40, 280, 340);
        panel1.add(jScrollPane);

        return textArea;
    }

    private void addCloseButton(JPanel panel1) {
        panel1.add(new HyperlinkError(UIUtils.BUTTON_TEXT_CLOSE, 750, 10, () -> {
            System.exit(0);
        }));
    }

    private JPanel getMainJPanel() {
        this.setUndecorated(true);
        Dimension size = new Dimension(800, 400);
        JPanel panel1 = new JPanel();
        panel1.setSize(size);
        panel1.setPreferredSize(size);
        panel1.setBackground(UIUtils.COLOR_BACKGROUND);
        panel1.setLayout(null);
        MouseAdapter ma = new MouseAdapter() {
            int lastX, lastY;

            @Override
            public void mousePressed(MouseEvent e) {
                lastX = e.getXOnScreen();
                lastY = e.getYOnScreen();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(getLocationOnScreen().x + x - lastX, getLocationOnScreen().y + y - lastY);
                lastX = x;
                lastY = y;
            }
        };

        panel1.addMouseListener(ma);
        panel1.addMouseMotionListener(ma);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        return panel1;
    }

    private void addSeparator(JPanel panel1) {
        JSeparator separator1 = new JSeparator();
        separator1.setOrientation(SwingConstants.VERTICAL);
        separator1.setForeground(UIUtils.COLOR_OUTLINE);
        panel1.add(separator1);
        separator1.setBounds(310, 80, 1, 240);
    }

    private void addLogo(JPanel panel1) {
        JLabel label1 = new JLabel();
        label1.setFocusable(false);
        label1.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("src/logo/rasa_logo.jpg")).getFile()));
        panel1.add(label1);
        label1.setBounds(55, 146, 200, 110);
    }

    private void addObjectTextField(JPanel panel1) {

        nField.setBounds(423, 59, 250, 44);
        nField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (nField.getText().equals(UIUtils.PLACEHOLDER_TEXT_OBJECT)) {
                    nField.setText("");
                }
                nField.setForeground(Color.white);
                nField.setBorderColor(UIUtils.COLOR_INTERACTIVE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (nField.getText().isEmpty()) {
                    nField.setText(UIUtils.PLACEHOLDER_TEXT_OBJECT);
                }
                nField.setForeground(UIUtils.COLOR_OUTLINE);
                nField.setBorderColor(UIUtils.COLOR_OUTLINE);
            }
        });

        panel1.add(nField);
    }

    private void addBoxTextField(JPanel panel1) {

        mField.setBounds(423, 118, 250, 44);

        mField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (mField.getText().equals(UIUtils.PLACEHOLDER_TEXT_BOX)) {
                    mField.setText("");
                }
                mField.setForeground(Color.white);
                mField.setBorderColor(UIUtils.COLOR_INTERACTIVE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (mField.getText().isEmpty()) {
                    mField.setText(UIUtils.PLACEHOLDER_TEXT_BOX);
                }
                mField.setForeground(UIUtils.COLOR_OUTLINE);
                mField.setBorderColor(UIUtils.COLOR_OUTLINE);
            }
        });


        panel1.add(mField);
    }


    private void addBoxWeightTextField(JPanel panel1) {

        kField.setBounds(423, 177, 250, 44);
        kField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (kField.getText().equals(UIUtils.PLACEHOLDER_TEXT_BOX_WEIGHT)) {
                    kField.setText("");
                }
                kField.setForeground(Color.white);
                kField.setBorderColor(UIUtils.COLOR_INTERACTIVE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (kField.getText().isEmpty()) {
                    kField.setText(UIUtils.PLACEHOLDER_TEXT_BOX_WEIGHT);
                }
                kField.setForeground(UIUtils.COLOR_OUTLINE);
                kField.setBorderColor(UIUtils.COLOR_OUTLINE);
            }
        });

        panel1.add(kField);
    }


    private void addInputTextField(JPanel panel1) {

        iField.setBounds(423, 236, 250, 44);
        iField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (iField.getText().equals(UIUtils.PLACEHOLDER_TEXT_INPUT)) {
                    iField.setText("");
                }
                iField.setForeground(Color.white);
                iField.setBorderColor(UIUtils.COLOR_INTERACTIVE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (iField.getText().isEmpty()) {
                    iField.setText(UIUtils.PLACEHOLDER_TEXT_INPUT);
                }
                iField.setForeground(UIUtils.COLOR_OUTLINE);
                iField.setBorderColor(UIUtils.COLOR_OUTLINE);
            }
        });

        panel1.add(iField);
    }


    private void addButton(JPanel panel1) {
        final Color[] loginButtonColors = {UIUtils.COLOR_INTERACTIVE, Color.white};

        JLabel loginButton = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = UIUtils.get2dGraphics(g);
                super.paintComponent(g2);
                Insets insets = getInsets();
                int w = getWidth() - insets.left - insets.right;
                int h = getHeight() - insets.top - insets.bottom;
                g2.setColor(loginButtonColors[0]);
                g2.fillRoundRect(insets.left, insets.top, w, h, UIUtils.ROUNDNESS, UIUtils.ROUNDNESS);
                FontMetrics metrics = g2.getFontMetrics(UIUtils.FONT_GENERAL_UI);
                int x2 = (getWidth() - metrics.stringWidth(UIUtils.BUTTON_TEXT_LOGIN)) / 2 - 10;
                int y2 = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
                g2.setFont(UIUtils.FONT_GENERAL_UI);
                g2.setColor(loginButtonColors[1]);
                g2.drawString(UIUtils.BUTTON, x2, y2);
            }
        };

        loginButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                DEEventHandler();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                loginButtonColors[0] = UIUtils.COLOR_INTERACTIVE_DARKER;
                loginButtonColors[1] = UIUtils.OFFWHITE;
                loginButton.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                loginButtonColors[0] = UIUtils.COLOR_INTERACTIVE;
                loginButtonColors[1] = Color.white;
                loginButton.repaint();
            }
        });

        loginButton.setBackground(UIUtils.COLOR_BACKGROUND);
        loginButton.setBounds(450, 297, 200, 44);
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel1.add(loginButton);
    }

    private void DEEventHandler() {
        MultipleKnapsack knapsacks = new MultipleKnapsack();
        LinkedList<KnapsackItem> items = new LinkedList<>();
        try {
            Integer m = Integer.valueOf(mField.getText());
            Integer k = Integer.valueOf(kField.getText());
            Integer n = Integer.valueOf(nField.getText());
            String i = (iField.getText().toString());
            String[] split = i.split(" ");
            for (int ip = 0; ip < m; ip++) {
                knapsacks.addKnapsack(new Knapsack(k, "s"+(ip+1)));
            }
            if(split.length==n){
                for (int i1 = 0, splitLength = split.length; i1 < splitLength; i1++) {
                    String s = split[i1];
                    items.add(new KnapsackItem(Integer.valueOf(s), "i"+(i1+1)));
                }
            }else throw new Exception("input is not equals with n");

        } catch (Exception e) {
            toaster.error("error: " + e.getMessage());
        }
        knapsacks.greedyMultipleKnapsack(items);
        knapsacks.calculateValue();
        MultipleKnapsack result = knapsacks.neighborSearch(knapsacks);
        result.printResult();
        toaster.success("success");
    }
}
