import javax.swing.*;
import java.io.*;

public class loginintoaccount {
    loginintoaccount()
    {
        JFrame frame=new JFrame("Add Account");
        JLabel username=new JLabel("Username");
        JLabel password=new JLabel("Password");
        JTextField usernameTf=new JTextField();
        JPasswordField passwordPf=new JPasswordField();
        JButton loginAccount=new JButton("Login");

        username.setBounds(60,70,100,100);
        usernameTf.setBounds(210,70,240,100);
        password.setBounds(60,220,100,100);
        passwordPf.setBounds(210,220,240,100);
        username.setFont(username.getFont().deriveFont(20f));
        password.setFont(username.getFont().deriveFont(20f));
        loginAccount.setBounds(100,420,300,150);

        usernameTf.setFont(usernameTf.getFont().deriveFont(20f));
        passwordPf.setFont(passwordPf.getFont().deriveFont(20f));
        loginAccount.setFont(loginAccount.getFont().deriveFont(35f));


        frame.add(username);
        frame.add(usernameTf);
        frame.add(password);
        frame.add(passwordPf);
        frame.add(loginAccount);
        /////////////////////////////////////////////////////////////////





        loginAccount.addActionListener(e -> {
            File f=new File("login.txt");
            boolean login=false;
            boolean user=false;
            BufferedReader reader=null;
            try {
                reader = new BufferedReader(new FileReader(f));
                String line = reader.readLine();
                while (line != null) {
                    String[] credentials=line.split(" ");
                    //System.out.println(credentials[0]+" "+credentials[1]);
                    if(usernameTf.getText().equals(credentials[0])) {
                        user=true;
                        if(passwordPf.getText().equals(credentials[1])) {
                            System.out.println("Login successful");
                            login=true;
                            break;
                        }

                    }

                    line = reader.readLine();
                }
               if(login)
               {

                   mainClass.frame.getContentPane().removeAll();
                   mainClass.frame.invalidate();
                   mainClass.frame.setTitle("Weather Data Entry");
                   mainClass.frame.setSize(550,600);
                   mainClass.frame.add(new WeatherMainClass().mainPanel);
                   mainClass.frame.validate();
                   frame.dispose();

               }
               else
               {
                   if(user)
                   {
                       JFrame fr=new JFrame();
                       JOptionPane.showMessageDialog(fr,"Password Incorrect","Wrong Password",JOptionPane.WARNING_MESSAGE);

                   }
                   else
                   {
                       JFrame fr=new JFrame();
                       JOptionPane.showMessageDialog(fr,"Account does not exist","Error",JOptionPane.ERROR_MESSAGE);

                   }
               }



            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


        frame.setSize(500,650);
        frame.setLayout(null);
        frame.setVisible(true);

        //frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);


    }
}
