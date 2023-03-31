package scientificcalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Cursor;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class ScientificCalculator extends JFrame {

    ImageIcon radical = new ImageIcon(getClass().getResource("radical.png"));
    Image image = radical.getImage().getScaledInstance(30, 20, java.awt.Image.SCALE_SMOOTH);
    
   
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, multi, expo, sin, cos, tan, log, rad, ln,clear, cancel, equal, plus, minus, times, divide, dot, bracket1, bracket2;
    static JButton inverse, deg, factorial, degree, module;
    static String number = "", number1 = "", bracketin = "";//store the number entered from keyboard  
    JTextArea area;
    static boolean tvcompute;//if there is no operator return that number without any operation
    static String store = "", store1 = "";//it store all equation for further calculation
    int indexholder = 0, count = 0, inversecounter = 2; //inverse counter is used to change when the inverse button pressed
    int degreecounter = 2; // change the button radian to degree or vice versa
    JPanel p1;

    //this method used for displaying GUI
    ScientificCalculator() {

        super("Scientific Calculator");

        area = new JTextArea(5, 25);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setFont(new Font("Monospaced", 1, 20));
        area.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        area.setBorder(new LineBorder(Color.BLACK));
        area.setEditable(false);

        JScrollPane pane = new JScrollPane(area);

        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b0 = new JButton("0");
        minus = new JButton("-");
        plus = new JButton("+");
        times = new JButton("*");
        divide = new JButton("/");
        dot = new JButton(".");
        cancel = new JButton("DEL");
        clear = new JButton("C");
        equal = new JButton("=");
        multi = new JButton("^");
        factorial = new JButton("!");
        sin = new JButton("sin");
        cos = new JButton("cos");
        tan = new JButton("tan");
        log = new JButton("log");
        ImageIcon icon = new ImageIcon(image);
        
        rad = new JButton("sqrt");
        rad.setIcon(icon);
        inverse = new JButton("INV");
        deg = new JButton("DEG");
        ln = new JButton("ln");
        expo = new JButton("ex");
        bracket1 = new JButton("(");
        bracket2 = new JButton(")");

        JPanel bracket = new JPanel(new GridLayout(1, 2));
        bracket.add(bracket1);
        bracket.add(bracket2);

        p1 = new JPanel(new GridLayout(7, 4));
        
        /* from line 92 to 179 is only for decoring.you can scape this line if ypu went*/
        
        equal.setFont(new Font("Monospaced", 1, 30));
        dot.setFont(new Font("Monospaced", 1, 30));
        clear.setFont(new Font("plain", 1, 30));
        cancel.setFont(new Font("plain", 1, 15));
        cancel.setBackground(Color.LIGHT_GRAY);
        clear.setBackground(Color.LIGHT_GRAY);

        p1.setBorder(new LineBorder(Color.BLACK, 2));
        p1.setCursor(new Cursor(Cursor.HAND_CURSOR));

        deg.setFont(new Font("Plain", 1, 15));
        inverse.setFont(new Font("Plain", 1, 15));
        equal.setBackground(Color.DARK_GRAY);
        equal.setForeground(Color.WHITE);
        equal.setFont(new Font("Monospaced", 1, 30));
        dot.setBackground(Color.DARK_GRAY);
        dot.setForeground(Color.WHITE);
        dot.setFont(new Font("Monospaced", 1, 30));
        clear.setFont(new Font("plain", 1, 30));
        cancel.setFont(new Font("plain", 1, 15));
        cancel.setBackground(Color.LIGHT_GRAY);
        clear.setBackground(Color.LIGHT_GRAY);
        rad.setBackground(Color.DARK_GRAY);
        rad.setForeground(Color.WHITE);
        rad.setFont(new Font("plain", 1, 15));
        tan.setBackground(Color.DARK_GRAY);
        tan.setForeground(Color.WHITE);
        tan.setFont(new Font("plain", 1, 15));
        cos.setBackground(Color.DARK_GRAY);
        cos.setForeground(Color.WHITE);
        cos.setFont(new Font("plain", 1, 15));
        sin.setBackground(Color.DARK_GRAY);
        sin.setForeground(Color.WHITE);
        sin.setFont(new Font("plain", 1, 15));
        expo.setBackground(Color.DARK_GRAY);
        expo.setForeground(Color.WHITE);
        expo.setFont(new Font("plain", 1, 15));
        ln.setBackground(Color.DARK_GRAY);
        ln.setForeground(Color.WHITE);
        ln.setFont(new Font("plain", 1, 15));
        log.setBackground(Color.DARK_GRAY);
        log.setForeground(Color.WHITE);
        log.setFont(new Font("plain", 1, 15));
        minus.setBackground(Color.DARK_GRAY);
        minus.setForeground(Color.WHITE);
        minus.setFont(new Font("plain", 1, 20));
        plus.setBackground(Color.DARK_GRAY);
        plus.setForeground(Color.WHITE);
        plus.setFont(new Font("plain", 1, 20));
        times.setBackground(Color.DARK_GRAY);
        times.setForeground(Color.WHITE);
        times.setFont(new Font("plain", 1, 20));
        multi.setBackground(Color.DARK_GRAY);
        multi.setForeground(Color.WHITE);
        multi.setFont(new Font("plain", 1, 20));
        factorial.setBackground(Color.DARK_GRAY);
        factorial.setForeground(Color.WHITE);
        factorial.setFont(new Font("plain", 1, 20));
        divide.setBackground(Color.DARK_GRAY);
        divide.setForeground(Color.WHITE);
        divide.setFont(new Font("plain", 1, 20));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("plain", 1, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("plain", 1, 15));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("plain", 1, 15));
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setFont(new Font("plain", 1, 15));
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setFont(new Font("plain", 1, 15));
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.setFont(new Font("plain", 1, 15));
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.setFont(new Font("plain", 1, 15));
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);
        b8.setFont(new Font("plain", 1, 15));
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.WHITE);
        b9.setFont(new Font("plain", 1, 15));
        b0.setBackground(Color.BLACK);
        b0.setForeground(Color.WHITE);
        b0.setFont(new Font("plain", 1, 15));
        bracket1.setBackground(Color.DARK_GRAY);
        bracket1.setForeground(Color.WHITE);
        bracket1.setFont(new Font("plain", 1, 20));
        bracket2.setBackground(Color.DARK_GRAY);
        bracket2.setForeground(Color.WHITE);
        bracket2.setFont(new Font("plain", 1, 20));

        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(inverse);
        panel.add(deg);

        p1.add(clear);
        p1.add(panel);
        p1.add(bracket);
        p1.add(cancel);
        p1.add(sin);
        p1.add(cos);
        p1.add(tan);
        p1.add(log);
        p1.add(ln);
        p1.add(rad);
        p1.add(divide);
        p1.add(times);
        p1.add(b7);
        p1.add(b8);
        p1.add(b9);
        p1.add(minus);
        p1.add(b4);
        p1.add(b5);
        p1.add(b6);
        p1.add(plus);
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(multi);
        p1.add(factorial);
        p1.add(b0);
        p1.add(dot);
        p1.add(equal);

        add(pane, BorderLayout.NORTH);
        add(p1, BorderLayout.CENTER);

        ButtonHandler handler = new ButtonHandler();

        b0.addActionListener(handler);
        b1.addActionListener(handler);
        b2.addActionListener(handler);
        b3.addActionListener(handler);
        b4.addActionListener(handler);
        b5.addActionListener(handler);
        b6.addActionListener(handler);
        b7.addActionListener(handler);
        b8.addActionListener(handler);
        b9.addActionListener(handler);
        plus.addActionListener(handler);
        minus.addActionListener(handler);
        times.addActionListener(handler);
        divide.addActionListener(handler);
        sin.addActionListener(handler);
        cos.addActionListener(handler);
        tan.addActionListener(handler);
        log.addActionListener(handler);
        expo.addActionListener(handler);
        ln.addActionListener(handler);
        multi.addActionListener(handler);
        dot.addActionListener(handler);
        clear.addActionListener(handler);
        cancel.addActionListener(handler);
        equal.addActionListener(handler);
        rad.addActionListener(handler);
        deg.addActionListener(handler);
        inverse.addActionListener(handler);
        factorial.addActionListener(handler);
        bracket1.addActionListener(handler);
        bracket2.addActionListener(handler);
    }
    public class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b0) {
                store = store + b0.getText();
                store1 = store1 + b0.getText();
                area.setText(store);
            } else if (e.getSource() == b1) {
                store = store + b1.getText();
                store1 = store1 + b1.getText();
                area.setText(store);
            } else if (e.getSource() == b2) {
                store = store + b2.getText();
                store1 = store1 + b2.getText();
                area.setText(store);
            } else if (e.getSource() == b3) {
                store = store + b3.getText();
                store1 = store1 + b3.getText();
                area.setText(store);
            } else if (e.getSource() == b4) {
                store = store + b4.getText();
                store1 = store1 + b4.getText();
                area.setText(store);
            } else if (e.getSource() == b5) {
                store = store + b5.getText();
                store1 = store1 + b5.getText();
                area.setText(store);
            } else if (e.getSource() == b6) {
                store = store + b6.getText();
                store1 = store1 + b6.getText();
                area.setText(store);
            } else if (e.getSource() == b7) {
                store = store + b7.getText();
                store1 = store1 + b7.getText();
                area.setText(store);
            } else if (e.getSource() == b8) {
                store = store + b8.getText();
                store1 = store1 + b8.getText();
                area.setText(store);
            } else if (e.getSource() == b9) {
                store = store + b9.getText();
                store1 = store1 + b9.getText();
                area.setText(store);
            } else if (e.getSource() == bracket1) {
                store = store + bracket1.getText();
                store1 = store1 + bracket1.getText();
                area.setText(store);
            } else if (e.getSource() == bracket2) {
                store = store + bracket2.getText();
                store1 = store1 + bracket2.getText();
                area.setText(store);
            } else if (e.getSource() == divide) {
                store = store + divide.getText();
                store1 = store1 + divide.getText();
                area.setText(store);
            } else if (e.getSource() == minus) {
                store = store + minus.getText();
                store1 = store1 + minus.getText();
                area.setText(store);
            } else if (e.getSource() == plus) {
                store = store + plus.getText();
                store1 = store1 + plus.getText();
                area.setText(store);
            } else if (e.getSource() == times) {
                store = store + times.getText();
                store1 = store1 + times.getText();
                area.setText(store);
            } else if (e.getSource() == dot) {
                store = store + dot.getText();
                store1 = store1 + dot.getText();
                area.setText(store);
            } else if (e.getSource() == multi) {
                store = store + multi.getText();
                store1 = store1 + multi.getText();
                area.setText(store);
            } else if (e.getSource() == factorial) {
                store = store + factorial.getText();
                store1 = store1 + factorial.getText();
                area.setText(store);
            } else if (e.getSource() == inverse) {
                if (inversecounter % 2 == 0) {
                    inverse.setForeground(Color.GRAY);
                    sin.setText("sin-l");
                    cos.setText("cos-l");
                    tan.setText("tan-l");
                    ln.setText("ex");
                    log.setText("lOx");
                } else {
                    inverse.setForeground(Color.BLACK);
                    sin.setText("sin");
                    cos.setText("cos");
                    tan.setText("tan");
                    ln.setText("ln");
                    log.setText("log");
                }
                inversecounter++;
            } else if (e.getSource() == deg) {
                if (degreecounter % 2 == 0) {
                    deg.setText("RAD");

                } else {
                    deg.setText("DEG");
                }
                degreecounter++;

            } else if (e.getSource() == rad) {
                store = store + rad.getText();
                store1 = store1 + "r";
                area.setText(store);
            } else if (e.getSource() == sin) {
                store = store + sin.getText();
                if ("sin-l".equals(sin.getText())) {
                    store1 = store1 + "S";
                } else {
                    store1 = store1 + "s";
                }
                area.setText(store);
            } else if (e.getSource() == cos) {
                store = store + cos.getText();
                if ("cos-l".equals(cos.getText())) {
                    store1 = store1 + "C";
                } else {
                    store1 = store1 + "c";
                }
                area.setText(store);
            } else if (e.getSource() == tan) {
                store = store + tan.getText();
                if ("tan-l".equals(tan.getText())) {
                    store1 = store1 + "T";
                } else {
                    store1 = store1 + "t";
                }
                area.setText(store);
            } else if (e.getSource() == ln) {
                store = store + ln.getText();
                if ("ex".equals(ln.getText())) {
                    store1 = store1 + "L";
                } else {
                    store1 = store1 + "l";
                }
                area.setText(store);
            } else if (e.getSource() == log) {
                store = store + log.getText();
                if ("lOx".equals(log.getText())) {
                    store1 = store1 + "G";
                } else {
                    store1 = store1 + "g";
                }
                area.setText(store);
            } else if (e.getSource() == clear) {
                store = "";
                store1 = "";
                area.setText(store);
            } else if (e.getSource() == equal) {

                number = store1;

                char charnumber1[] = number.toCharArray();
                String numberstar = "";

                //if there is no any operator between bracket like ()() the program automatically add star between two brackets
                for (int i = 0; i < number.length(); i++) {
                    if (charnumber1[i] == '(' && i != 0) {
                        if (charnumber1[i - 1] != 'r' && charnumber1[i - 1] != 'g' && charnumber1[i - 1] != 'L' && charnumber1[i - 1] != 'l' && charnumber1[i - 1] != 'T' && charnumber1[i - 1] != 'C' && charnumber1[i - 1] != 'S' && charnumber1[i - 1] != 't' && charnumber1[i - 1] != 'c' && charnumber1[i - 1] != 's' && charnumber1[i - 1] != '+' && charnumber1[i - 1] != '-' && charnumber1[i - 1] != '*' && charnumber1[i - 1] != '/' && charnumber1[i - 1] != '^') {
                            numberstar += "*";
                        }
                    }
                    numberstar += charnumber1[i];

                    if (charnumber1[i] == ')' && i != 0 && i != (number.length() - 1)) {
                        if (charnumber1[i - 1] != 'r' && charnumber1[i - 1] != 'G' && charnumber1[i - 1] != 'g' && charnumber1[i - 1] != 'L' && charnumber1[i - 1] != 'l' && charnumber1[i - 1] != 'T' && charnumber1[i - 1] != 'C' && charnumber1[i - 1] != 'S' && charnumber1[i - 1] != 't' && charnumber1[i - 1] != 'c' && charnumber1[i - 1] != 's' && charnumber1[i + 1] != '+' && charnumber1[i + 1] != '-' && charnumber1[i + 1] != '*' && charnumber1[i + 1] != '/' && charnumber1[i + 1] != '^' && charnumber1[i + 1] != '!') {
                            numberstar += "*";
                        }
                    }
                }
                
                number = numberstar;

                if (charnumber1[0] != '(') {
                    // to embed bracket
                    String s = "(";
                    s += number;
                    number = s;
                    number += ')';
                }
                getEquation();
                area.setText(number1);

                //used for clear after equal sign are clicked and store the result
                store = number1;
                store1 = number1;
            } else if (e.getSource() == cancel) {
                /*
                 change the string to arrays of character and get the length of the array,
                 then decrement length of the array by one and store the value to ch3 and assign again to store1.
                 store1 variable used for inner calculation and
                 store displaying on the textarea and used for control user interaction
                 */

                //check if the string is empty
                if (store.length() - 1 < 1) {
                    store = "";
                    area.setText(store);
                } else {
                    /* the if else if statement delete sin,cos ... from textarea*/

                    char char1[] = store1.toCharArray();

                    if (char1[char1.length - 1] == 's' || char1[char1.length - 1] == 'c' || char1[char1.length - 1] == 't' || char1[char1.length - 1] == 'g' || char1[char1.length - 1] == 'G') {
                        char[] char2 = new char[store.length() - 3];
                        char[] char3 = store.toCharArray();

                        System.arraycopy(char3, 0, char2, 0, char2.length);
                        store = String.valueOf(char2);
                        area.setText(store);
                    } else if (char1[char1.length - 1] == 'l' || char1[char1.length - 1] == 'L') {
                        char[] char2 = new char[store.length() - 2];
                        char[] char3 = store.toCharArray();

                        System.arraycopy(char3, 0, char2, 0, char2.length);
                        store = String.valueOf(char2);
                        area.setText(store);
                    } else if (char1[char1.length - 1] == 'S' || char1[char1.length - 1] == 'C' || char1[char1.length - 1] == 'T') {
                        char[] char2 = new char[store.length() - 5];
                        char[] char3 = store.toCharArray();

                        System.arraycopy(char3, 0, char2, 0, char2.length);
                        store = String.valueOf(char2);
                        area.setText(store);
                    } else if (char1[char1.length - 1] == 'r') {
                        char[] char2 = new char[store.length() - 4];
                        char[] char3 = store.toCharArray();

                        System.arraycopy(char3, 0, char2, 0, char2.length);
                        store = String.valueOf(char2);
                        area.setText(store);
                    } else {
                        char[] char3 = store.toCharArray();

                        char[] ch3 = new char[(store.toCharArray().length - 1)];
                        System.arraycopy(char3, 0, ch3, 0, store.toCharArray().length - 1);
                        store = String.valueOf(ch3);// change arrays of character back to string
                        area.setText(store);
                    }
                    char[] ch3 = new char[(store1.toCharArray().length - 1)];
                    System.arraycopy(char1, 0, ch3, 0, store1.toCharArray().length - 1);
                    store1 = String.valueOf(ch3);
                }
            }
        }
    }
    public static void main(String[] args) {
        ScientificCalculator frame = new ScientificCalculator();

            frame.setSize(350, 500);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
    }
    static void getEquation() {

        char charnum[] = number.toCharArray();
        boolean tv = false;
        tvcompute = true;

        for (int i = 0; i < number.length(); i++) {

            String num1 = "", num2 = "", num3 = "";//used fore temporarly storage num1 for bracket num2 for before bracket num3 after bracket

            if (charnum[i] == ')') {

                for (int j = i - 1; j >= 0; j--) {
                    if (charnum[j] != '(') {
                        num1 += String.valueOf(charnum[j]);
                    } else {
                        StringBuilder builder = new StringBuilder();

                        builder.append(num1);
                        builder.reverse();
                        num1 = builder.toString();

                        for (int k = 0; k < j; k++) {
                            num2 += String.valueOf(charnum[k]);
                        }

                        for (int k = (i + 1); k < charnum.length; k++) {
                            num3 += String.valueOf(charnum[k]);
                        }

                        number1 = "";
                        num2 += bracket(num1);
                        num2 += num3;
                        number = num2;

                        getEquation();

                        tv = true;
                        break;
                    }
                }
            }
            if (tv) {
                bracket(number);
                break;
            }
        }
    }
    static String bracket(String s){

        try{
            //jj start with 1 b/c a number start with *and/ rather than +- lead an error
        bracketin = s;
        /*bracketin is a temporary variable for bracket, its value changed each time the if statement is excuted
         it helps not calling bracket method recursively */
        for (int jj = 0; jj < bracketin.length(); jj++) {
            char ch[] = bracketin.toCharArray();
            if (ch[jj] == 'c') {
                right(ch, jj);
                bracketin = number1;
                tvcompute = false;
                jj = -1;
            }
        }
        for (int jj = 0; jj < bracketin.length(); jj++) {
            char ch[] = bracketin.toCharArray();
            if (ch[jj] == 's') {
                right(ch, jj);
                bracketin = number1;
                tvcompute = false;
                jj = -1;
            }
        }
        for (int jj = 0; jj < bracketin.length(); jj++) {
            char ch[] = bracketin.toCharArray();
            if (ch[jj] == 't') {
                right(ch, jj);
                bracketin = number1;
                tvcompute = false;
                jj = -1;
            }
        }
        for (int jj = 0; jj < bracketin.length(); jj++) {
            char ch[] = bracketin.toCharArray();
            if (ch[jj] == 'C') {
                right(ch, jj);
                bracketin = number1;
                tvcompute = false;
                jj = -1;
            }
        }
        for (int jj = 0; jj < bracketin.length(); jj++) {
            char ch[] = bracketin.toCharArray();
            if (ch[jj] == 'S') {
                right(ch, jj);
                bracketin = number1;
                tvcompute = false;
                jj = -1;
            }
        }
        for (int jj = 0; jj < bracketin.length(); jj++) {
            char ch[] = bracketin.toCharArray();
            if (ch[jj] == 'T') {
                right(ch, jj);
                bracketin = number1;
                tvcompute = false;
                jj = -1;
            }
        }
        for (int jj = 0; jj < bracketin.length(); jj++) {
            char ch[] = bracketin.toCharArray();
            if (ch[jj] == 'l') {
                right(ch, jj);
                bracketin = number1;
                tvcompute = false;
                jj = -1;
            }
        }
        for (int jj = 0; jj < bracketin.length(); jj++) {
            char ch[] = bracketin.toCharArray();
            if (ch[jj] == 'g') {
                right(ch, jj);
                bracketin = number1;
                tvcompute = false;
                jj = -1;
            }
        }
        for (int jj = 0; jj < bracketin.length(); jj++) {
            char ch[] = bracketin.toCharArray();
            if (ch[jj] == 'G') {
                right(ch, jj);
                bracketin = number1;
                tvcompute = false;
                jj = -1;
            }
        }
        for (int jj = 0; jj < bracketin.length(); jj++) {
            char ch[] = bracketin.toCharArray();
            if (ch[jj] == 'L') {
                right(ch, jj);
                bracketin = number1;
                tvcompute = false;
                jj = -1;
            }
        }
        for (int jj = 0; jj < bracketin.length(); jj++) {
            char ch[] = bracketin.toCharArray();
            if (ch[jj] == 'r') {//squareroot
                right(ch, jj);
                bracketin = number1;
                tvcompute = false;
                jj = -1;
            }
        }
        for (int jj = 1; jj < bracketin.length(); jj++) {
            char ch[] = bracketin.toCharArray();
            if (ch[jj] == '!') {
                factorial(ch, jj);
                bracketin = number1;
                tvcompute = false;
                jj = 0;
            }
        }

        for (int jj = 1; jj < bracketin.length(); jj++) {
            char ch[] = bracketin.toCharArray();
            if (ch[jj] == '^') {
                compute(ch, jj);
                bracketin = number1;
                tvcompute = false;
                jj = 0;
            }
        }

        for (int jj = 1; jj < bracketin.length(); jj++) {
            char ch[] = bracketin.toCharArray();
            if (ch[jj] == '/') {
                compute(ch, jj);
                bracketin = number1;
                tvcompute = false;
                jj = 0;
            }
        }
        for (int jj = 1; jj < bracketin.length(); jj++) {
            char ch[] = bracketin.toCharArray();
            if (ch[jj] == '*') {
                compute(ch, jj);
                bracketin = number1;
                tvcompute = false;
                jj = 0;
            }
        }

        for (int jj = 1; jj < bracketin.length(); jj++) {
            char ch[] = bracketin.toCharArray();
            if (ch[jj] == '-') {
                if (ch[jj - 1] == '*' || ch[jj - 1] == '/') {
                    break;
                } else if (ch[jj - 1] == '+') {//if the + sign   appear before - sign ignore + sign b/c no change in computing
                     
                    char ch1[] = new char[bracketin.length() - 1];
                    for (int i = 0; i < ch1.length; i++) {
                        if (i >= (jj - 1)) {
                            ch1[i] = ch[i + 1];
                        } else {
                            ch1[i] = ch[i];
                        }  
                    }
                     
                    compute(ch1, jj - 1);
                    bracketin = number1;
                    tvcompute = false;
                    jj = 0;
                } else {
                    compute(ch, jj);
                    bracketin = number1;
                    tvcompute = false;
                    jj = 0;
                }
            }
        }

        for (int jj = 1; jj < bracketin.length(); jj++) {
            char cha[] = bracketin.toCharArray();
            if (cha[jj] == '+') {
                if (cha[jj - 1] == '*' || cha[jj - 1] == '/' || cha[jj - 1] == '-') {
                    break;
                }
                compute(cha, jj);
                bracketin = number1;
                tvcompute = false;
                jj = 0;
            }
        }

        // if there is no any computation from the above return the entered number
        if (tvcompute) {
            number1 = s;
        }

        
        }catch(RuntimeException  ex){
            JOptionPane.showMessageDialog(null, "Math error\n"+ex.getMessage());
             
            store = "";
            store1 = "";
            return "";
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Math error\n"+ex.getMessage());
            store = "";
            store1 = "";
            return "";
        }
        return number1;
    }
    static String divide(String left, String right) {
        double value = (Double.parseDouble(left)) / (Double.parseDouble(right));
        return String.valueOf(value);
    }

    static String addition(String left, String right) {
        double value = (Double.parseDouble(left)) + (Double.parseDouble(right));
        return String.valueOf(value);
    }

    static String subtraction(String left, String right) {
        double value = (Double.parseDouble(left)) - (Double.parseDouble(right));
        return String.valueOf(value);
    }

    static String multiplication(String left, String right) {
        double value = (Double.parseDouble(left)) * (Double.parseDouble(right));
        return String.valueOf(value);
    }

    static void compute(char ch[], int jj) {

        String num1 = "", num3 = "";
        String concright = "";//after operator or from rightside
        String concleft = "";//before operator from leftside
        int right = 0, left = 0;

        //getting number after operator
        for (int ic = jj + 1; ic < ch.length; ic++) {
            if ((ch[ic - 1] == '^' || ch[ic - 1] == '*' || ch[ic - 1] == '+' || ch[ic - 1] == '-' || ch[ic - 1] == '/') && (ch[ic] == '+' || ch[ic] == '-')) {
                concright += String.valueOf(ch[ic]);
                right++;
            } else if (ch[ic] == '.' || ch[ic] == '1' || ch[ic] == '2' || ch[ic] == '3' || ch[ic] == '4' || ch[ic] == '4' || ch[ic] == '5' || ch[ic] == '6' || ch[ic] == '7' || ch[ic] == '8' || ch[ic] == '9' || ch[ic] == '0') {
                concright += String.valueOf(ch[ic]);
                right++;
            } else {
                break;
            }
        }

        for (int ic = jj - 1; ic >= 0; ic--) {
            if ((ic == 0) && (ch[ic] == '+' || ch[ic] == '-')) {
                concleft += String.valueOf(ch[ic]);
                left++;
            } else if (ch[ic] == '.' || ch[ic] == '1' || ch[ic] == '2' || ch[ic] == '3' || ch[ic] == '4' || ch[ic] == '4' || ch[ic] == '5' || ch[ic] == '6' || ch[ic] == '7' || ch[ic] == '8' || ch[ic] == '9' || ch[ic] == '0') {
                concleft += String.valueOf(ch[ic]);
                left++;
            } else {
                break;
            }
        }

        StringBuilder builder = new StringBuilder();

        builder.append(concleft);
        builder.reverse();
        concleft = builder.toString();

        for (int t = 0; t < (jj - left); t++) {
            num1 += String.valueOf(ch[t]);
        }
        /* +1 is added because it start from the next one. right and left priviously occupied 
         (jj -left means from the first index before left the +1 mean after (jj-left)and left and right*/
        for (int t = (left + right + (jj - left) + 1); t < ch.length; t++) {
            num3 += String.valueOf(ch[t]);
        }

        number1 = num1;
        
        
        switch (ch[jj]) {
            case '+':
                number1 += addition(concleft, concright);
                break;
            case '/':
                number1 += divide(concleft, concright);
                break;
            case '*':
                number1 += multiplication(concleft, concright);
                break;
            case '-':
                number1 += subtraction(concleft, concright);
                break;
            case '^':
                number1 += Math.pow(Double.parseDouble(concleft), Double.parseDouble(concright));
                break;
        }

        number1 += num3;
    }

    static void factorial(char ch[], int jj) {
        String num1 = "", num3 = "",concleft = "";
        int left = 0;

        //getting number before / operator
        for (int ic = jj - 1; ic >= 0; ic--) {
            if (ch[ic] == '.' || ch[ic] == '1' || ch[ic] == '2' || ch[ic] == '3' || ch[ic] == '4' || ch[ic] == '4' || ch[ic] == '5' || ch[ic] == '6' || ch[ic] == '7' || ch[ic] == '8' || ch[ic] == '9' || ch[ic] == '0') {
                concleft += String.valueOf(ch[ic]);
                left++;
            } else {
                break;
            }
        }

        StringBuilder builder = new StringBuilder();

        builder.append(concleft);
        builder.reverse();
        concleft = builder.toString();

        for (int t = 0; t < (jj - left); t++) {
            num1 += String.valueOf(ch[t]);
        }
        /* +1 is added because it start from the next one. right and left priviously occupied 
         (jj -left means from the first index before left the +1 mean after (jj-left)and left and right*/
        for (int t = (left + (jj - left) + 1); t < ch.length; t++) {
            num3 += String.valueOf(ch[t]);
        }

        number1 = num1;
              
        double fact = 1;
        double doubleleft = Double.parseDouble(concleft);
        int integerleft = (int) (doubleleft);

        for (int i = 1; i <= integerleft; i++) {
            fact *= i;
        }

        number1 += String.valueOf(fact);
        number1 += num3;

    }

    static void right(char ch[], int jj) {
        String num1 = "", num3 = "",concright = "";
        int right = 0;

        for (int ic = jj + 1; ic < ch.length; ic++) {
            if (ch[jj + 1] == '+' || ch[jj + 1] == '-') {
                concright += String.valueOf(ch[ic]);
                right++;
            } else if (ch[ic] == '.' || ch[ic] == '1' || ch[ic] == '2' || ch[ic] == '3' || ch[ic] == '4' || ch[ic] == '4' || ch[ic] == '5' || ch[ic] == '6' || ch[ic] == '7' || ch[ic] == '8' || ch[ic] == '9' || ch[ic] == '0') {
                concright += String.valueOf(ch[ic]);
                right++;
            } else {
                break;
            }
        }

        for (int t = 0; t < (jj); t++) {
            num1 += String.valueOf(ch[t]);
        }
         
        for (int t = (right + (jj) + 1); t < ch.length; t++) {
            num3 += String.valueOf(ch[t]);
        }

        number1 = num1;

        double doubleleft = Double.parseDouble(concright);

        DecimalFormat df = new DecimalFormat();

        df.setMaximumFractionDigits(5);

        switch (ch[jj]) {
            case 'c':
                if ("DEG".equals(deg.getText())) {
                    number1 += String.valueOf(df.format(Math.cos(Math.toRadians(doubleleft))));
                } else {
                    number1 += String.valueOf(df.format(Math.cos(doubleleft)));
                }
                break;
            case 's':
                if ("DEG".equals(deg.getText())) {
                    number1 += String.valueOf(df.format(Math.sin(Math.toRadians(doubleleft))));
                } else {
                    number1 += String.valueOf(df.format(Math.sin(doubleleft)));
                }
                break;
            case 't':
                if ("DEG".equals(deg.getText())) {
                    number1 += String.valueOf(df.format(Math.tan(Math.toRadians(doubleleft))));
                } else {
                    number1 += String.valueOf(df.format(Math.tan(doubleleft)));
                }
                break;
            case 'C':
                if ("RAD".equals(deg.getText())) {
                    number1 += String.valueOf(df.format(Math.acos(doubleleft)));
                } else {
                    number1 += String.valueOf(df.format(Math.toDegrees(Math.acos(doubleleft))));
                }
                break;
            case 'S':
                if ("RAD".equals(deg.getText())) {
                    number1 += String.valueOf(df.format(Math.asin(doubleleft)));
                } else {
                    number1 += String.valueOf(df.format(Math.toDegrees(Math.asin(doubleleft))));
                }
                break;
            case 'T':
                if ("RAD".equals(deg.getText())) {
                    number1 += String.valueOf(df.format(Math.atan(doubleleft)));
                } else {
                    number1 += String.valueOf(df.format(Math.toDegrees(Math.atan(doubleleft))));
                }
                break;
            case 'g':
                number1 += String.valueOf(df.format(Math.log10(doubleleft)));
                break;
            case 'l':
                number1 += String.valueOf(df.format(Math.log(doubleleft)));
                break;
            case 'L':
                number1 += String.valueOf(df.format(Math.exp(doubleleft)));
                break;
            case 'G':
                number1 += String.valueOf(Math.pow(10, doubleleft));
                break;
            case 'r':
                number1 += String.valueOf(Math.sqrt(doubleleft));
                break;
        }

        number1 += num3;

    }

}
