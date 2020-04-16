import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class weatherDataOutput {
    static Object data[][]={{new Integer(25),new Integer(25),new Integer(25),new Integer(25),new Integer(25)}};
    static JFrame frame;
    static JTable table;
    static String[] column={"Temperature","Wind Speed","Dew Point","Wind Chill","Cloud Base"};
    weatherDataOutput()
    {
        frame=new JFrame("Weather Data");
        frame.setSize(600,500);
        frame.setBackground(Color.WHITE);
       JLabel weathertitle=new JLabel("Weather Data Output");
        JLabel temperature=new JLabel("Temperature");
        JLabel windspeed=new JLabel("Wind Speed");
        JLabel dewpoint=new JLabel("Dew Point");
        JLabel windchill=new JLabel("Wind Chill");
        JLabel cloudbase=new JLabel("Cloud Base");

        weathertitle.setBounds(100,0,500,150);
        temperature.setBounds(50,180,100,50);
        windspeed.setBounds(150,180,100,50);
        dewpoint.setBounds(250,180,100,50);
        windchill.setBounds(350,180,100,50);
        cloudbase.setBounds(450,180,100,50);

        weathertitle.setFont(weathertitle.getFont().deriveFont(35f));

        frame.add(weathertitle);
        frame.add(temperature);
        frame.add(windspeed);
        frame.add(dewpoint);
        frame.add(windchill);
        frame.add(cloudbase);

        frame.setLayout(null);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void insert()
    {
        table = new JTable(data,column) {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };

        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        table.setFillsViewportHeight(true);
        table.setCellSelectionEnabled(false);

        table.setAutoCreateRowSorter(true);
        table.setCellSelectionEnabled(false);
        table.setBounds(50,230,500,200);
        weatherDataOutput.frame.invalidate();
        frame.add(table);
        frame.setVisible(true);

    }
}
