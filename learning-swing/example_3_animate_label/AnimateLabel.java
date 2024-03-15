import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class AnimateLabel extends JFrame {
	private List<BufferedImage> images;
	private int currentImageIndex = 0;
	private String folderPath;
	
	private int delay;

	public AnimateLabel(String folderPath, int delay) {
		this.folderPath = folderPath;
		this.delay = delay;
		setIconImage(new ImageIcon("icon.png").getImage());
  	setTitle("Animate JLabel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		loadImagesFromFolder(this.folderPath);
		setTitle(this.folderPath);
		displayCurrentImage();
		Timer timer = new Timer(delay, e -> {
      //set next image to display index
			currentImageIndex = (currentImageIndex + 1) % images.size();
      //set image
			displayCurrentImage();
		});
		
		timer.start();
		setVisible(true);
	}

	private void loadImagesFromFolder(String folderPath) {
    //load images 
		images = new ArrayList<>();
		File folder = new File(folderPath);
		File[] imageFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg"));

		if (imageFiles != null) {
			for (File file : imageFiles) {
				try {
					BufferedImage image = ImageIO.read(file);
					images.add(image);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void displayCurrentImage() {
    //display image
		if (!images.isEmpty()) {
			BufferedImage currentImage = images.get(currentImageIndex);
			JLabel imageLabel = new JLabel(new ImageIcon(currentImage));
			getContentPane().removeAll();
			getContentPane().add(imageLabel, BorderLayout.CENTER);
			revalidate();
			repaint();
		}
	}

	public static void main(String[] args) {
		if (args.length > 0) {
			String folderPath = args[0];
			Path path = Paths.get(folderPath);
			int flag = 1;
			int delay = 300;
			if (Files.exists(path)) {
				File[] files = path.toFile().listFiles();
				if (files != null) {
					for (File file : files) {
						if (file.isFile() && file.getName().toLowerCase().endsWith(".jpg")) {
							flag = 0;
							break;
						} else {
							flag = 1;
							continue;
						}
					}
					if (flag == 0){
						SwingUtilities.invokeLater(() -> new AnimateLabel(folderPath, delay));
					} else {
						System.out.println("No JPG files found in the directory.");
					}
				} else { 
					System.out.println("No JPG files found in the directory.");
				}
			} else {
				System.out.println("Directory does not exist: " + folderPath);
			}
		} else {
			System.out.println("No Directory path provided.");
		}
	}
}


