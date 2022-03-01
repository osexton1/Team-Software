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
    public JTextArea DescriptionFooter;
    public JTextArea ascii;
    public JTextArea charInfo;
    public JLabel charInput;
    public JTextField textInput;
    public JTextArea err;
    public Layout() {


        DescriptionHeader = new JTextArea("Description");
        DescriptionHeader.setLineWrap(true);
        DescriptionHeader.setPreferredSize(new Dimension(470, 380));
        DescriptionHeader.setEditable(false);
        DescriptionHeader.setBackground(new Color(8, 0, 8)); //Text bg
        DescriptionHeader.setForeground(Color.white);
        DescriptionHeader.setWrapStyleWord(true);

        DescriptionFooter = new JTextArea("Choices");
        DescriptionFooter.setLineWrap(false);
        DescriptionFooter.setMinimumSize(new Dimension(470, 180));
        DescriptionHeader.setPreferredSize(new Dimension(470, 180));
        DescriptionFooter.setEditable(false);
        DescriptionFooter.setBackground(new Color(8,0,8));
        DescriptionFooter.setWrapStyleWord(false);
        DescriptionFooter.setForeground(Color.red);



        Description = new JPanel();
        Description.setBackground(new Color(8, 0, 0)); //Text bg
        Description.setPreferredSize(new Dimension(480, 400));
//        Description.setBounds(0, 0, 490, 100);
        Description.setBorder(BorderFactory.createMatteBorder(5, 5, 1, 1, new Color(226, 58, 36))); //Text border
        Description.add(DescriptionHeader);
        Description.add(DescriptionFooter);

        ascii = new JTextArea("Ascii");
        ascii.setEditable(false);
        ascii.setLineWrap(false);
        ascii.setPreferredSize(new Dimension(480, 380));
        ascii.setBackground(new Color(0, 8, 7)); //Ascii bg
        ascii.setOpaque(true);
        ascii.setFont(new java.awt.Font("Ariel", 0, 10));
        ascii.setForeground(Color.white);

        Ascii = new JPanel();
        Ascii.setFont(new java.awt.Font("Ariel", 0, 10));
        Ascii.setPreferredSize(new Dimension(490, 400));
//        Ascii.setBounds(501, 0, 490, 100);
        Ascii.setBorder(BorderFactory.createMatteBorder(5, 1, 1, 5, new Color(36, 204, 226))); //Ascii border
        Ascii.setBackground(new Color(0, 8, 7)); //Ascii bg
        Ascii.add(ascii);
        //Ascii.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));



        charInfo = new JTextArea("Character Info", 5, 10);
        charInfo.setLineWrap(true);
        charInfo.setPreferredSize(new Dimension(190, 130));
        charInfo.setEditable(false);
        charInfo.setBackground(new Color(3, 8, 0)); //info bg
        charInfo.setForeground(Color.white);

        Character = new JPanel();
        Character.setPreferredSize(new Dimension(200, 140));
//        Character.setBounds(0, 0, 1000, 100);
        Character.setBorder(BorderFactory.createMatteBorder(1, 5, 5, 1, new Color(5, 225, 109))); //info border
        Character.add(charInfo);
        Character.setBackground(new Color(3, 8, 0)); //info bg



        //Description.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));



        charInput = new JLabel("User Input");

        textInput = new JTextField("", 20);
        textInput.setMaximumSize(( new Dimension( 800, 100)));

        err = new JTextArea("");
        err.setLineWrap(true);
        err.setWrapStyleWord(true);
        err.setPreferredSize(new Dimension(700, 70));
        err.setEditable(false);

        Input = new JPanel();
        Input.setPreferredSize(new Dimension(770, 140));
//        Input.setBounds(10, 20, 800, 100);
        Input.setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, new Color(255, 5, 151))); //input border
        Input.setBackground(new Color(8, 1, 0));
        Input.add(charInput);
        Input.add(textInput);
        Input.add(err);
        //Input.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));



        outer = new JPanel();
        outer.setBackground(Color.black);
        outer.add(Description);
        outer.add(Ascii);
        outer.add(Character);

        outer.add(Input);

        frame = new JFrame("Cambrian Adventure");
        frame.add(outer);
        frame.pack();
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    public void setDesText(String In){
        DescriptionHeader.setText(In);
    }
    public void addDesText(String In){
        DescriptionHeader.append(In);
    }
    public void setFooterText(String In) {DescriptionFooter.setText(In);}
    public void addFooterText(String In){DescriptionFooter.append(In);}

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
