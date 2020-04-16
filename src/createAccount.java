import javafx.scene.control.PasswordField;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class createAccount {

    createAccount()
    {
        JFrame frame=new JFrame("Add Account");
        JLabel username=new JLabel("Username");
        JLabel password=new JLabel("Password");
        JTextField usernameTf=new JTextField();
        JPasswordField passwordPf=new JPasswordField();
        JButton createAccount=new JButton("Create Account");

        username.setBounds(60,70,100,100);
        usernameTf.setBounds(210,70,240,100);
        password.setBounds(60,220,100,100);
        passwordPf.setBounds(210,220,240,100);
        username.setFont(username.getFont().deriveFont(20f));
        password.setFont(username.getFont().deriveFont(20f));
        createAccount.setBounds(100,420,300,150);

        usernameTf.setFont(usernameTf.getFont().deriveFont(20f));
        passwordPf.setFont(passwordPf.getFont().deriveFont(20f));
        createAccount.setFont(createAccount.getFont().deriveFont(30f));


        frame.add(username);
        frame.add(usernameTf);
        frame.add(password);
        frame.add(passwordPf);
        frame.add(createAccount);


        createAccount.addActionListener(e -> {
            int[] passwordcheck=new int[3];
            passwordcheck[0]=passwordcheck[1]=passwordcheck[2]=0;
            for(int i=0;i<passwordPf.getText().length();i++)
            {
                if((int)passwordPf.getText().charAt(i)>=48 && (int)passwordPf.getText().charAt(i)<=57)
                    passwordcheck[0]=1;
                else if((int)passwordPf.getText().charAt(i)>=65 && (int)passwordPf.getText().charAt(i)<=90)
                    passwordcheck[1]=1;
                else if((int)passwordPf.getText().charAt(i)>=97 && (int)passwordPf.getText().charAt(i)<=122)
                    passwordcheck[2]=1;
            }

            if(passwordPf.getText().length()<9)
            {
                JFrame f=new JFrame();
                JOptionPane.showMessageDialog(f,"Password should have atleast 9 characters","Password Warning",JOptionPane.WARNING_MESSAGE);
            }
            else if(passwordcheck[0]!=1 || passwordcheck[1]!=1 || passwordcheck[2]!=1)
            {
                JFrame f=new JFrame();
                JOptionPane.showMessageDialog(f,"Password should contain digit,lowercase and uppercase characters","Password Warning",JOptionPane.WARNING_MESSAGE);
            }
            else {

                File file = new File("login.txt");
                FileWriter fr = null;
                BufferedWriter br = null;
                try {
                    // to append to file, you need to initialize FileWriter using below constructor
                    fr = new FileWriter(file, true);
                    br = new BufferedWriter(fr);


                    br.write(usernameTf.getText() + " ");
                    br.append(passwordPf.getText());
                    br.newLine();
                    br.flush();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                frame.dispose();
            }
        });


        frame.setSize(500,650);
        frame.setLayout(null);
        frame.setVisible(true);
        //frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    }
}
