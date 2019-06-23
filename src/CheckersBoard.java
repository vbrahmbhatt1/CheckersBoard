/*
 * The CheckersBoardFlowLayout Class draws the checkers board and places the checkers pieces on the board. 
 * The buttonColor HashMap pulls in the Map from the MoveLogic class that defines the placement of the checkers
 * after every move. 
 * The Action class listens for actions and passes data to MoveLogic. it also has some front-end validation. 
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class CheckersBoard extends JFrame
{

    // define sizes for JButton squares and text fields. 
    static Dimension preferredSize = new Dimension(75,75);
    static Dimension textFieldSize = new Dimension(75,30);

    // Images for checkers pieces
    static ImageIcon whitePiece =
            new ImageIcon("whitecircle.png");
    static ImageIcon whiteKingPiece =
            new ImageIcon("whitecrown.png");
    static ImageIcon redPiece =
            new ImageIcon("redcircle.png");
    static ImageIcon redKingPiece =
            new ImageIcon("redcrown.png");

    // JButtonMap stores the JButton objects
    static HashMap<String, JButton> JButtonMap = new HashMap<String, JButton>();
    static JButton s1;
    static JButton s2;
    static JTextField tf1;
    static JTextField tf2;
    static JButton g1b;
    static JButton e1b;
    static JButton c1b;
    static JButton a1b;
    static JButton h2b;
    static JButton f2b;
    static JButton d2b;
    static JButton b2b;
    static JButton e3b;
    static JButton g3b;
    static JButton c3b;
    static JButton a3b;
    static JButton h4b;
    static JButton f4b;
    static JButton d4b;
    static JButton b4b;
    static JButton g5b;
    static JButton e5b;
    static JButton c5b;
    static JButton a5b;
    static JButton h6b;
    static JButton f6b;
    static JButton d6b;
    static JButton b6b;
    static JButton g7b;
    static JButton e7b;
    static JButton c7b;
    static JButton a7b;
    static JButton h8b;
    static JButton f8b;
    static JButton d8b;
    static JButton b8b;
    static JLabel l4;
    static JLabel l5;
    static JLabel l6;

    // JButton status stories the String JButton ID and current JButton color
    static HashMap<String, String> ButtonColor = new HashMap<String, String>();
    static MoveLogic move;

    public static void main(String[] args)
    {

        JFrame frame = new JFrame("Checkers Game");
        frame.getContentPane().setBackground(Color.white);
        FlowLayout layout = new FlowLayout(0,0,0);
        frame.setLayout(layout);


        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.white);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.white);
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.white);
        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.white);
        JPanel panel5 = new JPanel();
        panel5.setBackground(Color.white);
        JPanel panel6 = new JPanel();
        panel6.setBackground(Color.white);
        JPanel panel7 = new JPanel();
        panel7.setBackground(Color.white);
        JPanel panel8 = new JPanel();
        panel8.setBackground(Color.white);
        JPanel panel9 = new JPanel();
        panel9.setBackground(Color.white);


        //Row 1
        JButton r1 = new JButton("1");
        r1.setPreferredSize(preferredSize);
        r1.setBackground(Color.white);
        r1.setOpaque(true);
        r1.setBorderPainted(false);
        panel1.add(r1);

        JButton h1 = new JButton();
        h1.setPreferredSize(preferredSize);
        h1.setBackground(Color.gray);
        h1.setOpaque(true);
        h1.setBorderPainted(false);
        panel1.add(h1);

        g1b = new JButton();
        g1b.setPreferredSize(preferredSize);
        g1b.setBackground(Color.black);
        g1b.setOpaque(true);
        g1b.setBorderPainted(false);
        panel1.add(g1b);
        String g1 = "G1";
        JButtonMap.put(g1, g1b);

        JButton f1 = new JButton();
        f1.setPreferredSize(preferredSize);
        f1.setBackground(Color.gray);
        f1.setOpaque(true);
        f1.setBorderPainted(false);
        panel1.add(f1);

        e1b = new JButton();
        e1b.setPreferredSize(preferredSize);
        e1b.setBackground(Color.black);
        e1b.setOpaque(true);
        e1b.setBorderPainted(false);
        panel1.add(e1b);
        String e1 = "E1";
        JButtonMap.put(e1, e1b);

        JButton d1 = new JButton();
        d1.setPreferredSize(preferredSize);
        d1.setBackground(Color.gray);
        d1.setOpaque(true);
        d1.setBorderPainted(false);
        panel1.add(d1);

        c1b = new JButton();
        c1b.setPreferredSize(preferredSize);
        c1b.setBackground(Color.black);
        c1b.setOpaque(true);
        c1b.setBorderPainted(false);
        panel1.add(c1b);
        String c1 = "C1";
        JButtonMap.put(c1, c1b);

        JButton b1 = new JButton();
        b1.setPreferredSize(preferredSize);
        b1.setBackground(Color.gray);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        panel1.add(b1);

        a1b = new JButton();
        a1b.setPreferredSize(preferredSize);
        a1b.setBackground(Color.black);
        a1b.setOpaque(true);
        a1b.setBorderPainted(false);
        panel1.add(a1b);
        String a1 = "A1";
        JButtonMap.put(a1, a1b);

        s1 = new JButton("Start");
        s1.setPreferredSize(textFieldSize);
        s1.setBackground(Color.green);
        panel1.add(s1);
        s1.addActionListener(new Action());


        //Row 2
        JButton r2 = new JButton("2");
        r2.setPreferredSize(preferredSize);
        r2.setBackground(Color.white);
        r2.setOpaque(true);
        r2.setBorderPainted(false);
        panel2.add(r2);

        h2b = new JButton();
        h2b.setPreferredSize(preferredSize);
        h2b.setBackground(Color.black);
        h2b.setOpaque(true);
        h2b.setBorderPainted(false);
        panel2.add(h2b);
        String h2 = "H2";
        JButtonMap.put(h2, h2b);

        JButton g2 = new JButton();
        g2.setPreferredSize(preferredSize);
        g2.setBackground(Color.gray);
        g2.setOpaque(true);
        g2.setBorderPainted(false);
        panel2.add(g2);

        f2b = new JButton();
        f2b.setPreferredSize(preferredSize);
        f2b.setBackground(Color.black);
        f2b.setOpaque(true);
        f2b.setBorderPainted(false);
        panel2.add(f2b);
        String f2 = "F2";
        JButtonMap.put(f2, f2b);

        JButton e2 = new JButton();
        e2.setPreferredSize(preferredSize);
        e2.setBackground(Color.gray);
        e2.setOpaque(true);
        e2.setBorderPainted(false);
        panel2.add(e2);

        d2b = new JButton();
        d2b.setPreferredSize(preferredSize);
        d2b.setBackground(Color.black);
        d2b.setOpaque(true);
        d2b.setBorderPainted(false);
        panel2.add(d2b);
        String d2 = "D2";
        JButtonMap.put(d2, d2b);

        JButton c2 = new JButton();
        c2.setPreferredSize(preferredSize);
        c2.setBackground(Color.gray);
        c2.setOpaque(true);
        c2.setBorderPainted(false);
        panel2.add(c2);

        b2b = new JButton();
        b2b.setPreferredSize(preferredSize);
        b2b.setBackground(Color.black);
        b2b.setOpaque(true);
        b2b.setBorderPainted(false);
        panel2.add(b2b);
        String b2 = "B2";
        JButtonMap.put(b2, b2b);

        JButton a2 = new JButton();
        a2.setPreferredSize(preferredSize);
        a2.setBackground(Color.gray);
        a2.setOpaque(true);
        a2.setBorderPainted(false);
        panel2.add(a2);

        JLabel l1 = new JLabel("Enter Letter-Number Combination");
        panel2.add(l1);



        //Row 3
        JButton r3 = new JButton("3");
        r3.setPreferredSize(preferredSize);
        r3.setBackground(Color.white);
        r3.setOpaque(true);
        r3.setBorderPainted(false);
        panel3.add(r3);

        JButton h3 = new JButton();
        h3.setPreferredSize(preferredSize);
        h3.setBackground(Color.gray);
        h3.setOpaque(true);
        h3.setBorderPainted(false);
        panel3.add(h3);

        g3b = new JButton();
        g3b.setPreferredSize(preferredSize);
        g3b.setBackground(Color.black);
        g3b.setOpaque(true);
        g3b.setBorderPainted(false);
        panel3.add(g3b);
        String g3 = "G3";
        JButtonMap.put(g3, g3b);

        JButton f3 = new JButton();
        f3.setPreferredSize(preferredSize);
        f3.setBackground(Color.gray);
        f3.setOpaque(true);
        f3.setBorderPainted(false);
        panel3.add(f3);

        e3b = new JButton();
        e3b.setPreferredSize(preferredSize);
        e3b.setBackground(Color.black);
        e3b.setOpaque(true);
        e3b.setBorderPainted(false);
        panel3.add(e3b);
        String e3 = "E3";
        JButtonMap.put(e3, e3b);

        JButton d3 = new JButton();
        d3.setPreferredSize(preferredSize);
        d3.setBackground(Color.gray);
        d3.setOpaque(true);
        d3.setBorderPainted(false);
        panel3.add(d3);

        c3b = new JButton();
        c3b.setPreferredSize(preferredSize);
        c3b.setBackground(Color.black);
        c3b.setOpaque(true);
        c3b.setBorderPainted(false);
        panel3.add(c3b);
        String c3 = "C3";
        JButtonMap.put(c3, c3b);

        JButton b3 = new JButton();
        b3.setPreferredSize(preferredSize);
        b3.setBackground(Color.gray);
        b3.setOpaque(true);
        b3.setBorderPainted(false);
        panel3.add(b3);

        a3b = new JButton();
        a3b.setPreferredSize(preferredSize);
        a3b.setBackground(Color.black);
        a3b.setOpaque(true);
        a3b.setBorderPainted(false);
        panel3.add(a3b);
        String a3 = "A3";
        JButtonMap.put(a3, a3b);

        JLabel l2 = new JLabel("Move Piece: ");
        panel3.add(l2);
        tf1 = new JTextField();
        tf1.setPreferredSize(textFieldSize);
        panel3.add(tf1);


        //Row 4
        JButton r4 = new JButton("4");
        r4.setPreferredSize(preferredSize);
        r4.setBackground(Color.white);
        r4.setOpaque(true);
        r4.setBorderPainted(false);
        panel4.add(r4);

        h4b = new JButton();
        h4b.setPreferredSize(preferredSize);
        h4b.setBackground(Color.black);
        h4b.setOpaque(true);
        h4b.setBorderPainted(false);
        panel4.add(h4b);
        String h4 = "H4";
        JButtonMap.put(h4, h4b);

        JButton g4 = new JButton();
        g4.setPreferredSize(preferredSize);
        g4.setBackground(Color.gray);
        g4.setOpaque(true);
        g4.setBorderPainted(false);
        panel4.add(g4);

        f4b = new JButton();
        f4b.setPreferredSize(preferredSize);
        f4b.setBackground(Color.black);
        f4b.setOpaque(true);
        f4b.setBorderPainted(false);
        panel4.add(f4b);
        String f4 = "F4";
        JButtonMap.put(f4, f4b);

        JButton e4 = new JButton();
        e4.setPreferredSize(preferredSize);
        e4.setBackground(Color.gray);
        e4.setOpaque(true);
        e4.setBorderPainted(false);
        panel4.add(e4);

        d4b = new JButton();
        d4b.setPreferredSize(preferredSize);
        d4b.setBackground(Color.black);
        d4b.setOpaque(true);
        d4b.setBorderPainted(false);
        panel4.add(d4b);
        String d4 = "D4";
        JButtonMap.put(d4, d4b);

        JButton c4 = new JButton();
        c4.setPreferredSize(preferredSize);
        c4.setBackground(Color.gray);
        c4.setOpaque(true);
        c4.setBorderPainted(false);
        panel4.add(c4);

        b4b = new JButton();
        b4b.setPreferredSize(preferredSize);
        b4b.setBackground(Color.black);
        b4b.setOpaque(true);
        b4b.setBorderPainted(false);
        panel4.add(b4b);
        String b4 = "B4";
        JButtonMap.put(b4, b4b);

        JButton a4 = new JButton();
        a4.setPreferredSize(preferredSize);
        a4.setBackground(Color.gray);
        a4.setOpaque(true);
        a4.setBorderPainted(false);
        panel4.add(a4);

        JLabel l3 = new JLabel("To Position: ");
        panel4.add(l3);
        tf2 = new JTextField();
        tf2.setPreferredSize(textFieldSize);
        panel4.add(tf2);


        //Row 5
        JButton r5 = new JButton("5");
        r5.setPreferredSize(preferredSize);
        r5.setBackground(Color.white);
        r5.setOpaque(true);
        r5.setBorderPainted(false);
        panel5.add(r5);

        JButton h5 = new JButton();
        h5.setPreferredSize(preferredSize);
        h5.setBackground(Color.gray);
        h5.setOpaque(true);
        h5.setBorderPainted(false);
        panel5.add(h5);

        g5b = new JButton();
        g5b.setPreferredSize(preferredSize);
        g5b.setBackground(Color.black);
        g5b.setOpaque(true);
        g5b.setBorderPainted(false);
        panel5.add(g5b);
        String g5 = "G5";
        JButtonMap.put(g5, g5b);

        JButton f5 = new JButton();
        f5.setPreferredSize(preferredSize);
        f5.setBackground(Color.gray);
        f5.setOpaque(true);
        f5.setBorderPainted(false);
        panel5.add(f5);

        e5b = new JButton();
        e5b.setPreferredSize(preferredSize);
        e5b.setBackground(Color.black);
        e5b.setOpaque(true);
        e5b.setBorderPainted(false);
        panel5.add(e5b);
        String e5 = "E5";
        JButtonMap.put(e5, e5b);

        JButton d5 = new JButton();
        d5.setPreferredSize(preferredSize);
        d5.setBackground(Color.gray);
        d5.setOpaque(true);
        d5.setBorderPainted(false);
        panel5.add(d5);

        c5b = new JButton();
        c5b.setPreferredSize(preferredSize);
        c5b.setBackground(Color.black);
        c5b.setOpaque(true);
        c5b.setBorderPainted(false);
        panel5.add(c5b);
        String c5 = "C5";
        JButtonMap.put(c5, c5b);

        JButton b5 = new JButton();
        b5.setPreferredSize(preferredSize);
        b5.setBackground(Color.gray);
        b5.setOpaque(true);
        b5.setBorderPainted(false);
        panel5.add(b5);

        a5b = new JButton();
        a5b.setPreferredSize(preferredSize);
        a5b.setBackground(Color.black);
        a5b.setOpaque(true);
        a5b.setBorderPainted(false);
        panel5.add(a5b);
        String a5 = "A5";
        JButtonMap.put(a5, a5b);

        s2 = new JButton("Submit");
        s2.setPreferredSize(textFieldSize);
        s2.setBackground(Color.green);
        panel5.add(s2);
        s2.addActionListener(new Action());

        //Row 6
        JButton r6 = new JButton("6");
        r6.setPreferredSize(preferredSize);
        r6.setBackground(Color.white);
        r6.setOpaque(true);
        r6.setBorderPainted(false);
        panel6.add(r6);

        h6b = new JButton();
        h6b.setPreferredSize(preferredSize);
        h6b.setBackground(Color.black);
        h6b.setOpaque(true);
        h6b.setBorderPainted(false);
        panel6.add(h6b);
        String h6 = "H6";
        JButtonMap.put(h6, h6b);

        JButton g6 = new JButton();
        g6.setPreferredSize(preferredSize);
        g6.setBackground(Color.gray);
        g6.setOpaque(true);
        g6.setBorderPainted(false);
        panel6.add(g6);

        f6b = new JButton();
        f6b.setPreferredSize(preferredSize);
        f6b.setBackground(Color.black);
        f6b.setOpaque(true);
        f6b.setBorderPainted(false);
        panel6.add(f6b);
        String f6 = "F6";
        JButtonMap.put(f6, f6b);

        JButton e6 = new JButton();
        e6.setPreferredSize(preferredSize);
        e6.setBackground(Color.gray);
        e6.setOpaque(true);
        e6.setBorderPainted(false);
        panel6.add(e6);

        d6b = new JButton();
        d6b.setPreferredSize(preferredSize);
        d6b.setBackground(Color.black);
        d6b.setOpaque(true);
        d6b.setBorderPainted(false);
        panel6.add(d6b);
        String d6 = "D6";
        JButtonMap.put(d6, d6b);

        JButton c6 = new JButton();
        c6.setPreferredSize(preferredSize);
        c6.setBackground(Color.gray);
        c6.setOpaque(true);
        c6.setBorderPainted(false);
        panel6.add(c6);

        b6b = new JButton();
        b6b.setPreferredSize(preferredSize);
        b6b.setBackground(Color.black);
        b6b.setOpaque(true);
        b6b.setBorderPainted(false);
        panel6.add(b6b);
        String b6 = "B6";
        JButtonMap.put(b6, b6b);

        JButton a6 = new JButton();
        a6.setPreferredSize(preferredSize);
        a6.setBackground(Color.gray);
        a6.setOpaque(true);
        a6.setBorderPainted(false);
        panel6.add(a6);

        l4 = new JLabel();
        panel6.add(l4);


        //Row 7
        JButton r7 = new JButton("7");
        r7.setPreferredSize(preferredSize);
        r7.setBackground(Color.white);
        r7.setOpaque(true);
        r7.setBorderPainted(false);
        panel7.add(r7);

        JButton h7 = new JButton();
        h7.setPreferredSize(preferredSize);
        h7.setBackground(Color.gray);
        h7.setOpaque(true);
        h7.setBorderPainted(false);
        panel7.add(h7);

        g7b = new JButton();
        g7b.setPreferredSize(preferredSize);
        g7b.setBackground(Color.black);
        g7b.setOpaque(true);
        g7b.setBorderPainted(false);
        panel7.add(g7b);
        String g7 = "G7";
        JButtonMap.put(g7, g7b);

        JButton f7 = new JButton();
        f7.setPreferredSize(preferredSize);
        f7.setBackground(Color.gray);
        f7.setOpaque(true);
        f7.setBorderPainted(false);
        panel7.add(f7);

        e7b = new JButton();
        e7b.setPreferredSize(preferredSize);
        e7b.setBackground(Color.black);
        e7b.setOpaque(true);
        e7b.setBorderPainted(false);
        panel7.add(e7b);
        String e7 = "E7";
        JButtonMap.put(e7, e7b);

        JButton d7 = new JButton();
        d7.setPreferredSize(preferredSize);
        d7.setBackground(Color.gray);
        d7.setOpaque(true);
        d7.setBorderPainted(false);
        panel7.add(d7);

        c7b = new JButton();
        c7b.setPreferredSize(preferredSize);
        c7b.setBackground(Color.black);
        c7b.setOpaque(true);
        c7b.setBorderPainted(false);
        panel7.add(c7b);
        String c7 = "C7";
        JButtonMap.put(c7, c7b);

        JButton b7 = new JButton();
        b7.setPreferredSize(preferredSize);
        b7.setBackground(Color.gray);
        b7.setOpaque(true);
        b7.setBorderPainted(false);
        panel7.add(b7);

        a7b = new JButton();
        a7b.setPreferredSize(preferredSize);
        a7b.setBackground(Color.black);
        a7b.setOpaque(true);
        a7b.setBorderPainted(false);
        panel7.add(a7b);
        String a7 = "A7";
        JButtonMap.put(a7, a7b);

        l6 = new JLabel();
        panel7.add(l6);

        //Row 8
        JButton r8 = new JButton("8");
        r8.setPreferredSize(preferredSize);
        r8.setBackground(Color.white);
        r8.setOpaque(true);
        r8.setBorderPainted(false);
        panel8.add(r8);

        h8b = new JButton();
        h8b.setPreferredSize(preferredSize);
        h8b.setBackground(Color.black);
        h8b.setOpaque(true);
        h8b.setBorderPainted(false);
        panel8.add(h8b);
        String h8 = "H8";
        JButtonMap.put(h8, h8b);

        JButton g8 = new JButton();
        g8.setPreferredSize(preferredSize);
        g8.setBackground(Color.gray);
        g8.setOpaque(true);
        g8.setBorderPainted(false);
        panel8.add(g8);

        f8b = new JButton();
        f8b.setPreferredSize(preferredSize);
        f8b.setBackground(Color.black);
        f8b.setOpaque(true);
        f8b.setBorderPainted(false);
        panel8.add(f8b);
        String f8 = "F8";
        JButtonMap.put(f8, f8b);

        JButton e8 = new JButton();
        e8.setPreferredSize(preferredSize);
        e8.setBackground(Color.gray);
        e8.setOpaque(true);
        e8.setBorderPainted(false);
        panel8.add(e8);

        d8b = new JButton();
        d8b.setPreferredSize(preferredSize);
        d8b.setBackground(Color.black);
        d8b.setOpaque(true);
        d8b.setBorderPainted(false);
        panel8.add(d8b);
        String d8 = "D8";
        JButtonMap.put(d8, d8b);

        JButton c8 = new JButton();
        c8.setPreferredSize(preferredSize);
        c8.setBackground(Color.gray);
        c8.setOpaque(true);
        c8.setBorderPainted(false);
        panel8.add(c8);

        b8b = new JButton();
        b8b.setPreferredSize(preferredSize);
        b8b.setBackground(Color.black);
        b8b.setOpaque(true);
        b8b.setBorderPainted(false);
        panel8.add(b8b);
        String b8 = "B8";
        JButtonMap.put(b8, b8b);

        JButton a8 = new JButton();
        a8.setPreferredSize(preferredSize);
        a8.setBackground(Color.gray);
        a8.setOpaque(true);
        a8.setBorderPainted(false);
        panel8.add(a8);

        l5 = new JLabel();
        panel8.add(l5);

        //Row 9
        JButton r9 = new JButton();
        r9.setPreferredSize(preferredSize);
        r9.setBackground(Color.white);
        r9.setOpaque(true);
        r9.setBorderPainted(false);
        panel9.add(r9);

        JButton r9h = new JButton("H");
        r9h.setPreferredSize(preferredSize);
        r9h.setBackground(Color.white);
        r9h.setOpaque(true);
        r9h.setBorderPainted(false);
        panel9.add(r9h);

        JButton r9g = new JButton("G");
        r9g.setPreferredSize(preferredSize);
        r9g.setBackground(Color.white);
        r9g.setOpaque(true);
        r9g.setBorderPainted(false);
        panel9.add(r9g);

        JButton r9f = new JButton("F");
        r9f.setPreferredSize(preferredSize);
        r9f.setBackground(Color.white);
        r9f.setOpaque(true);
        r9f.setBorderPainted(false);
        panel9.add(r9f);

        JButton r9e = new JButton("E");
        r9e.setPreferredSize(preferredSize);
        r9e.setBackground(Color.white);
        r9e.setOpaque(true);
        r9e.setBorderPainted(false);
        panel9.add(r9e);

        JButton r9d = new JButton("D");
        r9d.setPreferredSize(preferredSize);
        r9d.setBackground(Color.white);
        r9d.setOpaque(true);
        r9d.setBorderPainted(false);
        panel9.add(r9d);

        JButton r9c = new JButton("C");
        r9c.setPreferredSize(preferredSize);
        r9c.setBackground(Color.white);
        r9c.setOpaque(true);
        r9c.setBorderPainted(false);
        panel9.add(r9c);

        JButton r9b = new JButton("B");
        r9b.setPreferredSize(preferredSize);
        r9b.setBackground(Color.white);
        r9b.setOpaque(true);
        r9b.setBorderPainted(false);
        panel9.add(r9b);

        JButton r9a = new JButton("A");
        r9a.setPreferredSize(preferredSize);
        r9a.setBackground(Color.white);
        r9a.setOpaque(true);
        r9a.setBorderPainted(false);
        panel9.add(r9a);


        //add panels to the frame
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        frame.add(panel5);
        frame.add(panel6);
        frame.add(panel7);
        frame.add(panel8);
        frame.add(panel9);

        frame.setSize(975,830);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    public static class Action implements ActionListener
    {

        static String playerOne = "White Player Turn";
        static String playerTwo = "Red Player Turn";
        int playerTurn;


        @Override
        public void actionPerformed(ActionEvent e)
        {
            // s1 is the start JButton
            if (e.getSource() == s1)
            {
                // declare a MoveLogic object
                move = new MoveLogic();
			
			/* get the Map from the MoveLogic object, which defines the placement of the checkers
			 * for the start of the game. 
			 */
                ButtonColor = move.getButtonStatus();
                // use a set t get the individual JButton key from the Map and use the keys to set the JButton colors
                Set<Entry<String,String>> id = ButtonColor.entrySet();
                for (Entry<String, String> s : id) {
                    String key = s.getKey();
                    String c = ButtonColor.get(key);

                    // get the JButton object based on the key and the set the color using c
                    JButton set = JButtonMap.get(key);
                    if (c == "white")
                    {
                        set.setIcon(whitePiece);
                    }
                    else if (c == "wKing")
                    {
                        set.setIcon(whiteKingPiece);
                    }
                    else if (c == "red")
                    {
                        set.setIcon(redPiece);
                    }
                    else if (c == "rKing")
                    {
                        set.setIcon(redKingPiece);
                    }
                    else
                    {
                        set.setIcon(null);
                    }
                }
                // set player 1 as the first player and display on the board
                move.setPlayerTurn(1);
                l5.setText(playerOne);
            }
            // s2 is the Submit JButton from the form
            if (e.getSource() == s2)
            {
                // clear l4, which displays error messages from each submission
                l4.setText(" ");
                // get the to and from JButton definitions from the form
                String moveFrom = tf1.getText().toUpperCase();
                String moveTo = tf2.getText().toUpperCase();

                //if JButton is null it is a grey square, so invalid
                JButton to = JButtonMap.get(moveTo);

                if (to != null)
                {

                    // get color of JButton moving from
                    String toColor = ButtonColor.get(moveTo);

                    // confirm moveTo space is available (black). If occupied, show message
                    if (toColor == "black")
                    {
                        // get color of the piece that is moving (red or white)
                        String fromColor = ButtonColor.get(moveFrom);

                        //get the player turn and validate the colors matches the player
                        playerTurn = move.getPlayerTurn();
                        if (((playerTurn == 1 && (fromColor == "white") || fromColor == "wKing"))
                            || ((playerTurn == 2 && fromColor == "red") || fromColor == "rKing"))
                        {

                            // call MoveLogic class to  confirm move is legal
                            boolean result = move.validateMove(moveFrom, moveTo);

                            if (result == true)
                            {

                                // get the updates Map after the move and redraw the board
                                ButtonColor = move.getButtonStatus();
                                Set<Entry<String,String>> id = ButtonColor.entrySet();
                                for (Entry<String, String> s : id)
                                {
                                    String key = s.getKey();
                                    String c = ButtonColor.get(key);

                                    // get the JButton object based on the key and the set the color using c
                                    JButton set = JButtonMap.get(key);
                                    if (c == "white")
                                    {
                                        set.setIcon(whitePiece);
                                    }
                                    else if (c == "wKing")
                                    {
                                        set.setIcon(whiteKingPiece);
                                    }
                                    else if (c == "red")
                                    {
                                        set.setIcon(redPiece);
                                    }
                                    else if (c == "rKing")
                                    {
                                        set.setIcon(redKingPiece);
                                    }
                                    else
                                    {
                                        set.setIcon(null);
                                    }
                                    
                                }
                                // display the correct player and determine if the game is over or if a jump is available for the current player
                                playerTurn = move.getPlayerTurn(); 
                                
                                if (playerTurn == 1)
                                {
                                	if (move.getPieceCount("white") == 0)
                                	{
                                		move.setPlayerTurn(1);
                                		l5.setText("Player 2 Wins!");
                                	}
                                	else 
                                		l5.setText(playerOne);
                                	
                                    boolean jump = move.jumpOpp("white");
                                    if (jump == true)
                                    {
                                        l6.setText("You must jump");
                                    }
                                    else
                                        l6.setText(null);
                                }
                                if (playerTurn == 2)
                                {
                                	if (move.getPieceCount("red") == 0)
                                	{
                                		move.setPlayerTurn(2);
                                		 l5.setText("Player 1 Wins!");
                                	}
                                	else l5.setText(playerTwo);
                                	
                                    boolean jump = move.jumpOpp("red");
                                    if (jump == true)
                                    {
                                        l6.setText("You must jump");
                                    }
                                    else
                                        l6.setText(null);
                                }
                            }
                            // if validateMove returns false, display message
                            else
                                l4.setText("Invalid Move");

                        }
                        // if wrong player moved display message and define current player
                        else
                        {
                            playerTurn = move.getPlayerTurn();

                            if (playerTurn == 1)
                                l4.setText(playerOne);
                            if (playerTurn ==2)
                                l4.setText(playerTwo);

                        }

                    }
                    // message is the to square is already occupied
                    else l4.setText("The square is occupied");
                }
                // message if the user tried to move to a grey square
                else l4.setText("You can only move to black squares");
                // clear the form fields for next move	
                tf1.setText(null);
                tf2.setText(null);

            }
        }
    }
}
