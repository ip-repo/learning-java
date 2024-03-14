import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;
import java.awt.Dimension;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    



class DateAndTime extends JFrame {
    DateAndTime(){
		//window icon
        ImageIcon icon = new ImageIcon("icon.png");
		
		//date and time objects
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
		//font
        Font font = new Font("Algerian", Font.BOLD, 30);
		//date and time label
        JLabel label = new JLabel("");
        label.setFont(font);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(Color.white);

		//update label every second with new time and date
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");  
                LocalDateTime now = LocalDateTime.now();  
               label.setText(dtf.format(now));
            }
        });
		//set time and dite when program start
        label.setText( dtf.format(now));
		//window properties
        this.setTitle("Date & Time");
        this.setMinimumSize(new Dimension(400, 400));
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(new Color(76,60,130));
        this.setName("JFrame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(label);
        timer.start();
        this.pack();
        this.setVisible(true);


    }
}
