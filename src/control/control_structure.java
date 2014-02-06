package control;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import logging.Log;
import basics.DEFINE;

public class control_structure {
	public static void main(String[] args){
		System.out.println("Starting Grade Automation Engine.");
		System.out.println("Starting logger.");
		Log ll = new Log(DEFINE.LOGGING_LEVEL, DEFINE.LOG_FILE_PATH);
		ll.write(2, "\r\nStarting Grade Automation Engine v0.0\r\n");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		ll.write(2, "Starting at " + dateFormat.format(new Date()) + "\r\n");
		long time_start = System.currentTimeMillis(), time_elapsed;
		
		time_elapsed = System.currentTimeMillis();
		ll.write(2, "Creating Student Structure.\r\n");
		
		ll.write(2, "Student structure ready. Took " + (System.currentTimeMillis() - time_elapsed) + "ms.\r\n");
	
		

		
		

		ll.write(2, "All operations complete at " + dateFormat.format(new Date()) + ". Took " + (System.currentTimeMillis() - time_start) + "ms.\r\n");
		ll.write(2, "Performing cleanup.\r\n\r\n");
		time_elapsed = System.currentTimeMillis();
		
		//cc.close();
		ll.close();
		
		System.out.println("Cleanup complete. Took " + (System.currentTimeMillis() - time_elapsed) + "ms.");
		System.out.println("All operations complete.");
		
		
	}
}

