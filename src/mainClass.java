import javax.swing.*;

public class mainClass {
    static JFrame frame;
    public static void main(String[] args)
    {
        frame=new JFrame("Start Page");
        JButton createAccount=new JButton("Create Account");
        createAccount.setBounds(100, 100, 200, 100);

        JButton login=new JButton("Login");
        login.setBounds(100, 250, 200, 100);

        JButton cancel=new JButton("Cancel");
        cancel.setBounds(100, 400, 200, 100);
        frame.add(createAccount);
        frame.add(login);
        frame.add(cancel);


        createAccount.addActionListener(e -> {
            new createAccount();
        });
        login.addActionListener(e -> {
            new loginintoaccount();
        });
        cancel.addActionListener(e -> {
            frame.dispose();
        });

        frame.setSize(400,700);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);



    }
}
