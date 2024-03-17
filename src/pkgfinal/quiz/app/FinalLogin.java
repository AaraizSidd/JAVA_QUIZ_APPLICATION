package pkgfinal.quiz.app;
//JFrame hamari swing package main hota haii and swing package extended java main se aata haii.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author A.K.TECH
 */


public class FinalLogin extends JFrame implements ActionListener {

    //Declared this globally taake hamari nichy di hoi if else condition properly work kry
    // q k pehly humne inko locally declare kia tha and wo kaam nahi krskta tha.
        private JButton rules, back;
     private JTextField tfname;
    //-------------------------------------------------------------------------
    //Constructor banaya haii frame ko run krne k liye 

    FinalLogin() {

        //Content pane hamare frame k aander ki cheez ko edit krne k liye use kiya jaata haii mtlb k frame k content ko change krne k liye
        getContentPane().setBackground(Color.WHITE);
        //image layout k liye custom layout
        setLayout(null);

        //Class loader class is used in old jdk to add a picture
        ImageIcon i1 = new ImageIcon("C:\\Users\\A.K.TECH\\OneDrive\\Documents\\NetBeansProjects\\Final Quiz App\\src\\pkgfinal\\Resources\\java.jpeg");

        //Image ko frame pe show krane k liye humne add ka component use kiya but wo
        // hum direclty nahi kr skte iss liye jlabel use kiya
        JLabel image = new JLabel(i1);
        image.setBounds(3, 0, 550, 500);
        add(image);

        //JLabel frame k aander kuch bhe likhne k liye istmal hota haii.
        JLabel heading = new JLabel("JQuizzer");
        heading.setBounds(700, 60, 300, 45);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
        heading.setForeground(Color.BLACK);
        add(heading);

        //---------------------------------------------------------------------
        //Another label
        JLabel name = new JLabel("Enter Your Name: ");
        name.setBounds(689, 150, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(Color.BLACK);
        add(name);

        tfname = new JTextField();
        tfname.setBounds(620, 180, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(tfname);

        //------------------RULES BUTTON--------------------------------------------------
        rules = new JButton("Rules");
        rules.setBounds(620, 250, 120, 25);
        //second method to define a color using rgb codes
        rules.setBackground(new Color(114, 219, 237));
        rules.setForeground(Color.BLACK);
        //Yea event handler jesy function kryga jesy react main hota haii
        //onclick function ki tarhn k kisi click pe kya cheez trigger honi chahiyea.
        rules.addActionListener(this);
        add(rules);

        //--------------------BACK BUTTON---------------------------------------------------
        back = new JButton("Back");
        back.setBounds(800, 250, 120, 25);
        //second method  to define a color using rgb codes
        back.setBackground(new Color(114, 219, 237));
        back.setForeground(Color.BLACK);
        //Yea event handler jesy function kryga jesy react main hota haii
        //onclick function ki tarhn k kisi click pe kya cheez trigger honi chahiyea.
        back.addActionListener(this);
        add(back);
//Frame edits---------------------------------------------------------------------------

        setSize(1000, 500);
        setLocation(250, 250);
        setVisible(true);
    }

public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == rules) {
        // Get the user's name from the text field
        String name = tfname.getText().trim();

        // Check if the name contains only alphabetic characters
        if (!name.matches("^[a-zA-Z]+$")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid name (only alphabetic characters are allowed).", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Set visible to false to close the current screen
            setVisible(false);

            // Open the new Rules screen with the user's name
            new Rules(name);
        }
    } else if (ae.getSource() == back) {
        // Set visible to false to close the current screen
        setVisible(false);
    }
}

    public static void main(String[] args) {
        new FinalLogin();

    }

}
//agr apni class main interface ko implement krate hain tow 
//oss main jitne bhe unimplemeted methods hote hain and abstraction
// hoti haii tow hamain un sbko override krana paarega.
