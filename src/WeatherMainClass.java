import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

public class WeatherMainClass {
    JPanel mainPanel;
    Object[][] data=new Object[10][5];
    int t=0;
    static String fileentrypath;
    WeatherMainClass()
    {
        mainPanel=new JPanel(null);
        mainPanel.setSize(550,600);
        JLabel temperature=new JLabel("Enter the temperature in Fahreheit:");
        JLabel windspeed=new JLabel("Enter the wind speed in mph:");
        JLabel dewpoint=new JLabel("Enter the Dewpoint temperature(Fahreheit):");
        JTextField temperatureTf=new JTextField();
        JTextField windspeedTf=new JTextField();
        JTextField dewpointTf=new JTextField();
        JButton fileentry=new JButton("File Entry");
        JButton compute=new JButton("Compute");


        temperature.setBounds(50,100,200,50);
        windspeed.setBounds(50,200,200,50);
        dewpoint.setBounds(50,300,200,50);
        temperatureTf.setBounds(350,100,100,50);
        windspeedTf.setBounds(350,200,100,50);
        dewpointTf.setBounds(350,300,100,50);
        fileentry.setBounds(50,450,150,100);
        compute.setBounds(300,450,150,100);

        mainPanel.add(temperature);
        mainPanel.add(temperatureTf);
        mainPanel.add(windspeed);
        mainPanel.add(windspeedTf);
        mainPanel.add(dewpoint);
        mainPanel.add(dewpointTf);
        mainPanel.add(fileentry);
        mainPanel.add(compute);

        compute.addActionListener(e -> {
            if(temperatureTf.getText().length()==0 || windspeedTf.getText().length()==0 || dewpointTf.getText().length()==0)
            {
                JFrame fr=new JFrame();
                JOptionPane.showMessageDialog(fr,"All fields should be filled","Invalid Input",JOptionPane.ERROR_MESSAGE);


            }
            else {


                double windchill = 35.74 + 0.6215 * Double.parseDouble(temperatureTf.getText()) - 35.75 * Math.pow(Double.parseDouble(windspeedTf.getText()), 0.16) + 0.4275 * Double.parseDouble(temperatureTf.getText()) * Math.pow(Double.parseDouble(windspeedTf.getText()), 0.16);
                double cloudbase = (Integer.parseInt(temperatureTf.getText()) - Integer.parseInt(dewpointTf.getText())) / 4.4 * 100;


                data[t][0] = new Double(Double.parseDouble(temperatureTf.getText()));
                data[t][1] = new Double(Double.parseDouble(windspeedTf.getText()));
                data[t][2] = new Double(Double.parseDouble(dewpointTf.getText()));
                data[t][3] = new Double(windchill);
                data[t][4] = new Double(cloudbase);
                t++;
                try {
                    if (!weatherDataOutput.frame.isActive()) {

                    } else {
                        weatherDataOutput.data = data;

                        weatherDataOutput.insert();

                    }
                } catch (Exception ev) {
                    new weatherDataOutput().data = data;
                    weatherDataOutput.insert();

                }

                weatherDataOutput.frame.validate();
            }
        });

        fileentry.addActionListener(e -> {

            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            // invoke the showsOpenDialog function to show the save dialog
            int r = j.showOpenDialog(null);

            // if the user selects a file
            if (r == JFileChooser.APPROVE_OPTION)

            {
                // set the label to the path of the selected file
                fileentrypath=(j.getSelectedFile().getAbsolutePath());
            }
            // if the user cancelled the operation

        });
    }
}
