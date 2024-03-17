package pkgfinal.quiz.app;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    //Array for Questions and saving answers---------------------------
    String questions[][] = new String[11][6];
    String answers[][] = new String[11][3];
   
    //Array for selected answers-------------------------------------------
    String useranswers[][] = new String[10][1];
   
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4, opt5;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;

    public static int timer = 25;
   
    //Flag--------------------------------------------------------------------------
    public static int ans_given = 0;
    //Cannot hardcode the selected answer value issliye global varialbe main he value 0 declare krdi
    public static int count = 0;
    public static int score = 0;

    String name;

    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //Cannot hardcode the selected answer value issliye global varialbe main he value 0 declare krdii
        ImageIcon i1 = new ImageIcon("C:\\Users\\A.K.TECH\\OneDrive\\Documents\\NetBeansProjects\\Final Quiz App\\src\\pkgfinal\\Resources\\quizz.jpg");
       
        //Image ko frame pe show krane k liye humne add ka component use kiya but wo
        // hum direclty nahi kr skte iss liye jlabel use kiya
        JLabel image = new JLabel(i1);
       
        //Yea image ko edit krne k liye commands hain.
        image.setBounds(0, 0, 1440, 392);
        add(image);

        //------Question Numbering--------------------------------------------------------------------------
        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        //-------Actual Questions-----------------------------------------------------------------
        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        //-------Questions------------------------------------------------------------------------
        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";
        questions[0][5] = "JFE";
        
        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        //-------Buttons---------------------------------------------------
        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);
        
        opt5 = new JRadioButton();
        opt5.setBounds(170, 680, 700, 30);
        opt5.setBackground(Color.WHITE);
        opt5.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt5);
   
   
        //---------Grouped The Buttons so only 1 gets selected at a time------------------------------------------------------------
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        groupoptions.add(opt5);

        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 630, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1100, 710, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        //Start hamara counter haii mtlb start 0 ka mtlb haii 0+1 ---------------------------------------------------------
        start(count);

        setVisible(true);
    }

    //Iss block of code main bhe same cheez ho rahi haii hum check
    //kr rahe hain k agr user ne kuch select kiya haii yaa nahi agr
    //kiya haii tow hum ossko save kr rahe hain nahi tow hum null value bhej
    //rahe hain.
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            //repaint se value update hogi
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            opt5.setEnabled(true);

            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                //groupoptions se saare answers aayinge
//                //selection se answers select honge
//                //action command se opton ki value aayg
//                //and yea sb store hoga useranswer main
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
           
            //Count ko humne isske equal iss liye agr lifeline use hoti haii tow 2 option cancel honge
            // counting 0 se start hoti haii iss hisaab se 2 jo haii wo hamara 0 1 2 (3) count hota haii.

            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
                opt5.setEnabled(true);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }


            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 20;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
           new Score(name, score);
        }
    }

    // Timer Code-------------------------------------------------------------  
    // Graphic and paint ki class issliye lagai haii taake frame ko baar baar reprint krskain mtlb baar baar update krne k liye.
    //We dont need to call paint method it call itself
    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.BLACK);
        g.setFont(new Font("Tahoma", Font.PLAIN, 18));

        if (timer > 0) {
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }

        //-----------------------------------------------------------------------------
        //Reverse timer logic thread sleep is a function to delay tier or any execution
        //repaint function is used to call and reupdate the value 15, 14, 13,
        // we already know the critical block of code try and catch
        timer--; // 14

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
       
      //-----------------------------------------------------------------------------------------
//Agr user ne answer kia hoga ==1 tow question next hogaiga amd timer start hojaiga but agr user ne answer nahi kiya hoga tow ==0 tow timer khud 15 se 0 tk aakr band hojaiga
//And automatically next question pr chala jaiga or osska bhe reverse timer start krdega.
       
        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
           
    //-Next question pr jaane pe hamari lifeline se jo bhe options disable  hoay thy wo
    //Wo options wa pis enable hojainge----------------------------------------------------------------
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            opt5.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
        //Agr submit pe click kiye baghair timer khatam hogaya tow wo automtcally submit hojaiga
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }

        //Score logic------------------------------------------------------------------------
                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                //new Score(name, score);
            } else {
//------------------------------------------------------------------------------
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    //groupoptions se saare answers aayinge
                    //selection se answers select honge
                    //action command se opton ki value aayg
                    //and yea sb store hoga useranswer main
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // initial value 0 + 1 tow iss se hamain nxt value question dekhega.  
                start(count);
            }
        }

    }

    //---Yea method humne answers and questions ki selection k liye banaya haii  taakee unke options yahn shown hon--------
    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
       
    //Jb get action kringe tow obviously set action bhe krna paarega mtlb value store bhe tow krni hogi
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        opt5.setText(questions[count][5]);
        opt5.setActionCommand(questions[count][5]);

    //Jb hamara quiz next question kryga tb selection update honi chahiyea mtlb pehly wale question ka option ki selection clear hogi iss se
        groupoptions.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("User");
    }
}

