package tello;

import tello.cs420.MainScreen;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

// Main class contains the method main(), which is what Java JRE 
// calls to begin execution when a Java program is run.
public class Main 
{
	// Get references to Java's built-in logging classes.
	private static final Logger 		logger = Logger.getGlobal();
	private static final ConsoleHandler handler = new ConsoleHandler();
	// private static JTextField txtSearchAndRescue;

	// Main always called to start a Java program.
	public static void main(String[] args) throws Exception 
	{
		// Configure global logger for console logging.
		logger.addHandler(handler);
		logger.setUseParentHandlers(false);
		
		// Set default logging level to a bit more detailed than INFO. Logging
		// statements at or above the set logging level will be output to
		// the console window. INFO level is typically used to show high
		// level informational messages. FINE is for logging of more detail, FINER
		// for logging a lot of detail. Due to a quirk in the design of the Java
		// logger, we have to set the desired log level in both the logger and 
		// handler instances. The logger is used by the calling program to create
		// log messages and the handler is used by the logger to send log messages
		// to a destination (like the console or a file).
		
	  	logger.setLevel(Level.FINE);
		handler.setLevel(Level.FINE);

	    logger.info("start");
	    
	    // Create an instance of the drone program (class) we want to run.
	    
	    MainScreen demo = new MainScreen();


	    // demo.execute();
	    
	    logger.info("end");
	
	
	// 	JFrame frame = new JFrame("My Frame");
    //     frame.getContentPane().setBackground(new Color(112, 128, 144));
    //     frame.setSize(800, 600);
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //     JPanel MainPage = new JPanel();
    //     MainPage.setBackground(new Color(255, 200, 153));
    //     MainPage.setLayout(null);
    //     frame.getContentPane().add(MainPage);
        
        
    //             JButton btn1 = new JButton("Enter Coordinates");
    //             btn1.setBounds(330, 200, 140, 29);
    //             MainPage.add(btn1);
                
                
    //             JLabel titleLabel = new JLabel("SEARCH AND RESCUE");
    //             titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
    //             titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    //             titleLabel.setBounds(283, 10, 227, 26);
    //             MainPage.add(titleLabel);
                
    //             JButton btnNewButton = new JButton("Scan Parameter");
    //             MainPage.add(btnNewButton);
    //             btnNewButton.setBounds(330, 260, 140, 29);
                
    //             JButton prBtn = new JButton("Previous Results");
    //             MainPage.add(prBtn);
    //             prBtn.addActionListener(new ActionListener() {
    //             	public void actionPerformed(ActionEvent e) {
    //             	}
    //             });
    //             prBtn.setBounds(330, 290, 140, 29);
                
    //             JButton ssBtn = new JButton("Screenshot");
    //             MainPage.add(ssBtn);
    //             ssBtn.setBounds(330, 230, 140, 29);
                
    //             JButton BasicBtn = new JButton("Basic Functions");
    //             MainPage.add(BasicBtn);
    //             BasicBtn.setBounds(330, 320, 140, 29);
                
                
    //             JLabel lblNewLabel = new JLabel("New label");
    //             lblNewLabel.setIcon(new ImageIcon("/Users/sadieyoung/Downloads/fire2.jpg"));
    //             lblNewLabel.setBounds(364, 48, 70, 65);
    //             MainPage.add(lblNewLabel);
                
    //             JButton btnNewButton_1_1 = new JButton("Emergency Land");
    //             btnNewButton_1_1.setBackground(new Color(255, 99, 71));
    //             btnNewButton_1_1.addActionListener(new ActionListener() {
    //             	public void actionPerformed(ActionEvent e) {
    //             	}
    //             });
    //             btnNewButton_1_1.setBounds(450, 398, 140, 50);
    //             MainPage.add(btnNewButton_1_1);
                
    //             JButton btnNewButton_1_2 = new JButton("Return To Base");
    //             btnNewButton_1_2.setBounds(240, 398, 140, 50);
    //             MainPage.add(btnNewButton_1_2);
                
    //             JPanel CoordinatesPanel = new JPanel();
    //             CoordinatesPanel.setBackground(new Color(192, 192, 192));
    //             frame.getContentPane().add(CoordinatesPanel, BorderLayout.NORTH);
    //             btn1.addActionListener(new ActionListener() {
    //                 public void actionPerformed(ActionEvent e) {
    //                     showCoordinatesPage(frame);
    //                 }
    //             });

    //             btnNewButton.addActionListener(new ActionListener() {
    //                 public void actionPerformed(ActionEvent e) {
    //                     showScanPerimeterPage(frame);
    //                 }
    //             });
    //             ssBtn.addActionListener(new ActionListener() {
    //                 public void actionPerformed(ActionEvent e) {
    //                     showScreenshot(frame);
    //                 }
    //             });
    //             prBtn.addActionListener(new ActionListener() {
    //                 public void actionPerformed(ActionEvent e) {
    //                     showPrevious(frame);
    //                 }
    //             });
    //             BasicBtn.addActionListener(new ActionListener() {
    //                 public void actionPerformed(ActionEvent e) {
    //                     showBasicFxns(frame);
    //                 }
    //             });
    //             frame.setVisible(true);
    //         }
	
    // private static void showCoordinatesPage(JFrame parentFrame) {
    //     JDialog dialog = new JDialog(parentFrame, "Coordinates Page", true);
    //     dialog.getContentPane().setLayout(new BorderLayout());

    //     CoordinatesPagePanel coordinatesPagePanel = new CoordinatesPagePanel();
    //     dialog.getContentPane().add(coordinatesPagePanel, BorderLayout.CENTER);

    //     dialog.setSize(800, 800);
    //     dialog.setLocationRelativeTo(parentFrame);
    //     dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    //     dialog.setVisible(true);
    // }

    // private static void showScanPerimeterPage(JFrame parentFrame) {
    //     ScanPerimeterPagePanel scanPerimeterPagePanel = new ScanPerimeterPagePanel();

    //     JDialog dialog = new JDialog(parentFrame, "Scan Perimeter Page", true);
    //     dialog.getContentPane().setLayout(new BorderLayout());
    //     dialog.getContentPane().add(scanPerimeterPagePanel, BorderLayout.CENTER);
    //     dialog.setSize(800, 600);
    //     dialog.setLocationRelativeTo(parentFrame);
    //     dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    //     dialog.setVisible(true);

    //     scanPerimeterPagePanel.repaint();
    // }
    // private static void showScreenshot(JFrame parentFrame) {
    // 	TakeScreenshotPage takeScreenshotPage = new TakeScreenshotPage();

    //     JDialog dialog = new JDialog(parentFrame, "Screenshot Page", true);
    //     dialog.getContentPane().setLayout(new BorderLayout());
    //     dialog.getContentPane().add(takeScreenshotPage, BorderLayout.CENTER);
    //     dialog.setSize(800, 700);
    //     dialog.setLocationRelativeTo(parentFrame);
    //     dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    //     dialog.setVisible(true);   
    // }
    // private static void showPrevious(JFrame parentFrame) {
    // 	PreviousResults previousResults = new PreviousResults();

    //     JDialog dialog = new JDialog(parentFrame, "Previous Results", true);
    //     dialog.getContentPane().setLayout(new BorderLayout());
    //     dialog.getContentPane().add(previousResults, BorderLayout.CENTER);
    //     dialog.setSize(800, 700);
    //     dialog.setLocationRelativeTo(parentFrame);
    //     dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    //     dialog.setVisible(true);
    // }
    // private static void showBasicFxns(JFrame parentFrame) {
    // 	BasicFxnsPage basicfxns = new BasicFxnsPage();

    //     JDialog dialog = new JDialog(parentFrame, "Basic Functions", true);
    //     dialog.getContentPane().setLayout(new BorderLayout());
    //     dialog.getContentPane().add(basicfxns, BorderLayout.CENTER);
    //     dialog.setSize(800, 700);
    //     dialog.setLocationRelativeTo(parentFrame);
    //     dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    //     dialog.setVisible(true);
    // }
}
}