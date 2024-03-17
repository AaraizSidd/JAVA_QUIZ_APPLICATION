package pkgfinal.quiz.app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Common interface for GUI components
interface GUIComponent {
    void configureComponent();
}

// Abstract class implementing GUIComponent for common behavior
abstract class AbstractGUIComponent extends JFrame implements ActionListener, GUIComponent {
    // Common code for setting up frame
    AbstractGUIComponent() {
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
    }

    // Method from GUIComponent interface
    public void configureComponent() {
        // Implement common configuration here
    }

    // ActionListener implementation
    public abstract void actionPerformed(ActionEvent ae);
}

// Rules class implementing GUIComponent and inheriting from AbstractGUIComponent
public class Rules extends AbstractGUIComponent {

    // Globally defining the buttons
    String name;
    JButton start, back;

    Rules(String name) {
        super(); // Call the constructor of the superclass (AbstractGUIComponent)

        this.name = name;
        configureComponent(); // Call the common configuration method

        JLabel heading = new JLabel("Welcome " + name + "To Java Quiz ");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(Color.BLACK);
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 180);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rules.setForeground(Color.BLACK);
        rules.setText(
                "<html>"
                        + "1. Evaluate each option thoroughly before selecting an answer.\n" + "<br><br>"
                        
                        + "2. If the question involves code snippets, understand the code's purpose, and predict its output accurately." + "<br><br>"
                        
                        + "3. Be wary of tricky language or double-negatives in the question that might change the meaning of the options." + "<br><br>"
                       
                        + "<html>"
        );
        add(rules);

        back = new JButton("Back");
        back.setBounds(250, 500, 100, 25);
        back.setBackground(new Color(114, 219, 237));
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setBounds(400, 500, 100, 25);
        start.setBackground(new Color(114, 219, 237));
        start.setForeground(Color.BLACK);
        start.addActionListener(this);
        add(start);
        
        setSize(800, 650);
        setLocation(300, 150);
        setVisible(true);
    }

    // ActionListener implementation
    @Override
    public void actionPerformed(ActionEvent ae) {
        JOptionPane.showMessageDialog(this, "This is oop lab", "Error", JOptionPane.ERROR_MESSAGE);
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name);
        } else {
            setVisible(false);
            new FinalLogin();
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }
}
