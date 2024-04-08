package demos;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.opencv.core.Rect;
import tellolib.camera.FaceDetection;
import tellolib.camera.TelloCamera;

import tellolib.communication.TelloConnection;
import tellolib.control.TelloControl;
import tellolib.drone.TelloDrone;

public class FlyGrid
{
	private final Logger logger = Logger.getGlobal(); 

	private TelloControl	telloControl;
	private TelloDrone		drone;
	private TelloCamera		camera;
	private FaceDetection   faceDectector;
	private boolean         detectFaces=false;
	
	public void execute()
	{
		
		boolean found= false;

		logger.info("start");
		
	    telloControl = TelloControl.getInstance();
	    
	    drone = TelloDrone.getInstance();

		
	    
	    camera = TelloCamera.getInstance();

		faceDectector=FaceDetection.getInstance();

	    telloControl.setLogLevel(Level.FINE);

	    try 
	    {
		    telloControl.connect();
		    
		    telloControl.enterCommandMode();
		    
		    telloControl.startStatusMonitor();
		    
		    telloControl.streamOn();
		    
		    camera.setStatusBar(this::updateWindow);
		    
		    camera.startVideoCapture(true);
		    
		    telloControl.takeOff();


			
			if(detectFaces)
		{
			found =faceDectector.detectFaces();

		    
		    // Now we will execute a series of movement commands to fly in a grid
		    // pattern. Distances in centimeters.
		    
		    for (int i = 0; i < 2; i++)
		    {
		    	telloControl.forward(100);

		    	telloControl.rotateRight(90);

		    	telloControl.forward(20);
		    	
		    	telloControl.rotateRight(90);
		    	
		    	telloControl.forward(100);
		    	
		    	telloControl.rotateLeft(90);

		    	telloControl.forward(20);
		    	
		    	telloControl.rotateLeft(90);
		    }
			if(found)
			{
				Rect[] faces= faceDectector.getFaces();
				camera.addTarget(null);
				camera.addTarget(faces[0]);
			}
	    }	
		}
	    catch (Exception e) {
	    	e.printStackTrace();
	    } finally 
	    {
	    	if (telloControl.getConnection() == TelloConnection.CONNECTED && drone.isFlying())
	    	{
	    		try
	    		{telloControl.land();}
	    		catch(Exception e) { e.printStackTrace();}
	    	}
	    }
		
	
    	telloControl.disconnect();
	    
	    logger.info("end");
	}
	
	// Return a string of info for the status area on video feed.
	
	private String updateWindow()
	{
    	return String.format("Batt: %d  Alt: %d  Hdg: %d  Rdy: %b  Detect: %b", drone.getBattery(), drone.getHeight(), 
    			drone.getHeading(), drone.isFlying(), detectFaces);
	}
}
