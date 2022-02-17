package com.CambrianAdventure.app;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
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
    public JLabel charInfo;
    public JLabel charInput;
    public JTextField textInput;
    public JLabel err;
    public ActionListener Listen;
    public Layout() {
        frame = new JFrame("Cambrian Adventure");
        DescriptionHeader = new JTextArea("Description");
        DescriptionHeader.setLineWrap(true);
        DescriptionHeader.setPreferredSize(new Dimension(950, 180));
        DescriptionHeader.setEditable(false);

        outer = new JPanel();
        Ascii = new JPanel();
        Description = new JPanel();
        DescriptionHeader.setBackground(new Color(255, 240, 220));
        Description.setBackground(new Color(255, 240, 220));

        Ascii.setPreferredSize(new Dimension(770, 200));
        Ascii.setBounds(10, 20, 1000, 100);
        Ascii.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(50, 168, 143)));
        ascii = new JTextArea("Ascii");
        ascii.setEditable(false);
        ascii.setLineWrap( true );
        ascii.setPreferredSize(new Dimension(750, 180));
        Ascii.setBackground(new Color(200, 255, 255));
        ascii.setBackground(new Color(200, 255, 255));

        Ascii.add(ascii);

        Character = new JPanel();
        Character.setPreferredSize(new Dimension(200, 200));
        Character.setBounds(10, 20, 1000, 100);
        Character.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 200, 0)));
        charInfo = new JLabel("Character Info");
        Character.add(charInfo);
        Character.setBackground(new Color(225, 255, 200));
        charInfo.setBackground(new Color(225, 255, 200));

        Description.setPreferredSize(new Dimension(975, 200));
        Description.setBounds(10, 20, 1000, 100);
        Description.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(235, 203, 75)));

        Input = new JPanel();
        Input.setPreferredSize(new Dimension(975, 120));
        Input.setBounds(10, 20, 1000, 100);
        Input.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(235, 107, 75)));
        charInput = new JLabel("Character Info");
        Input.add(charInput);
        textInput = new JTextField("", 20);
        textInput.setMaximumSize(( new Dimension( 1000, 100)));
        Listen = new ActionListener(){
           public void actionPerformed(ActionEvent e){
               System.out.println(textInput.getText());
               err.setText(textInput.getText());
               textInput.setText("");
           }
       };
        textInput.addActionListener(Listen);
        Input.add(textInput);
        err = new JLabel("");
        Input.add(err);

        ascii.setOpaque(true);
        ascii.setForeground(Color.blue);
        Description.add(DescriptionHeader);

        outer.add(Ascii);
        outer.add(Character);
        outer.add(Description);
        outer.add(Input);

        frame.add(outer);
        Ascii.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        Description.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        Input.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
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

    public void setError(String In){
        err.setText(In);
    }

}
