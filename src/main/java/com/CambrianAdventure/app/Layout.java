package com.CambrianAdventure.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Layout {
    public JPanel outer;
    public JPanel Ascii;
    public JPanel Description;
    public JPanel Character;
    public JPanel Input;

    public JFrame frame;
    public JTextArea DescriptionHeader;
    public JTextArea ascii;
    public JTextArea charInfo;
    public JLabel charInput;
    public JTextField textInput;
    public JTextArea err;
    public ActionListener Listen;
    public Layout() {
        ascii = new JTextArea("Ascii");
        ascii.setEditable(false);
        ascii.setLineWrap( true );
        ascii.setPreferredSize(new Dimension(750, 180));
        ascii.setBackground(new Color(200, 255, 255));
        ascii.setOpaque(true);
        ascii.setForeground(Color.blue);

        Ascii = new JPanel();
        Ascii.setPreferredSize(new Dimension(770, 200));
        Ascii.setBounds(10, 20, 1000, 100);
        Ascii.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(50, 168, 143)));
        Ascii.setBackground(new Color(200, 255, 255));
        Ascii.add(ascii);
        Ascii.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));



        charInfo = new JTextArea("Character Info", 10, 10);
        charInfo.setLineWrap(true);
        charInfo.setPreferredSize(new Dimension(180, 180));
        charInfo.setEditable(false);
        charInfo.setBackground(new Color(225, 255, 200));

        Character = new JPanel();
        Character.setPreferredSize(new Dimension(200, 200));
        Character.setBounds(10, 20, 1000, 100);
        Character.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 200, 0)));
        Character.add(charInfo);
        Character.setBackground(new Color(225, 255, 200));



        DescriptionHeader = new JTextArea("Description");
        DescriptionHeader.setLineWrap(true);
        DescriptionHeader.setPreferredSize(new Dimension(950, 180));
        DescriptionHeader.setEditable(false);
        DescriptionHeader.setBackground(new Color(255, 240, 220));

        Description = new JPanel();
        Description.setBackground(new Color(255, 240, 220));
        Description.setPreferredSize(new Dimension(975, 200));
        Description.setBounds(10, 20, 1000, 100);
        Description.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(235, 203, 75)));
        Description.add(DescriptionHeader);
        Description.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));



        charInput = new JLabel("User Input");

        textInput = new JTextField("", 20);
        textInput.setMaximumSize(( new Dimension( 1000, 100)));

        err = new JTextArea("");
        err.setLineWrap(true);
        err.setPreferredSize(new Dimension(700, 70));
        err.setEditable(false);

        Input = new JPanel();
        Input.setPreferredSize(new Dimension(975, 120));
        Input.setBounds(10, 20, 1000, 100);
        Input.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(235, 107, 75)));
        Input.add(charInput);
        Input.add(textInput);
        Input.add(err);
        Input.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));



        outer = new JPanel();
        outer.add(Ascii);
        outer.add(Character);
        outer.add(Description);
        outer.add(Input);

        frame = new JFrame("Cambrian Adventure");
        frame.add(outer);
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    public void setDesText(String In){
        DescriptionHeader.setText(In);
    }
    public void addDesText(String In){
        DescriptionHeader.append(In);
    }

    public void setAscText(String In){
        ascii.setText(In);
    }

    public void setCharText(String In){
        charInfo.setText(In);
    }
    public void addCharText(String In){charInfo.append(In);}

    public void setError(String In){
        err.setText(In);
    }

}
