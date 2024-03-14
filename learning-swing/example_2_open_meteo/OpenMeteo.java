import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class OpenMeteo extends JFrame {
	OpenMeteo(){
	JTextField latitudeField = new JTextField(10);
	latitudeField.setText("48.858093");
	JTextField longitudeField = new JTextField(10);
	longitudeField.setText("2.294694");
	JButton apiButton = new JButton("Get Location Info");
	Font font = new Font("Arial", Font.BOLD, 16);
	JTextArea textArea = new JTextArea(10, 30);
	ImageIcon icon = new ImageIcon("icon.png");
	JPanel panel = new JPanel();
	JLabel lat_label = new JLabel("Latitude:");
	JLabel long_label = new JLabel("Longitude:");

	apiButton.setForeground(Color.black);
	apiButton.setBackground(Color.white);
	
	textArea.setBackground(Color.black);
	textArea.setForeground(Color.white);
	textArea.setFont(font);
	textArea.setEditable(true);
	
	apiButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String latitude = latitudeField.getText();
			String longitude = longitudeField.getText();
			String base_url = "https://api.open-meteo.com/v1/forecast?";
			String coordinates  = "latitude="  + latitude + "&" + "longitude="+ longitude + "&";
			String current = "current=temperature_2m,wind_speed_10m" + "&";
			String url_final = base_url + coordinates + current  ;
			try {
				@SuppressWarnings("deprecation")
				URL url = new URL(url_final);
				
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
	
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String line;
				StringBuilder response = new StringBuilder();
	
				while ((line = reader.readLine()) != null) {
					response.append(line);
				}
				reader.close();
				String result = response.toString().replace("{", "");			  
				result = result.replace("{", "");
				result = result.replace("}", "");
				result = result.replace(",", "\n");
				textArea.setText(result);
				connection.disconnect();
			} catch (IOException ez) {
				JOptionPane.showMessageDialog(textArea, "Somthing went wrong.\nCheck coordiantes or internet connection." );

			}
			
		}
	});

	
    
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setBounds(0, 0, 500, 200); 
	this.setMinimumSize(new Dimension(400, 400));
	
	lat_label.setForeground(Color.white);
	long_label.setForeground(Color.white);
	panel.setBackground(Color.gray);
	panel.add(lat_label);
	panel.add(latitudeField);
	panel.add(long_label);
	panel.add(longitudeField);
	panel.add(apiButton);
	this.setTitle("Weather by Location");
	this.setIconImage(icon.getImage());
	this.getContentPane().add(panel, BorderLayout.NORTH);
	this.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
	this.pack();
    this.setVisible(true); 
	}
}
