package com.loan.application.log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public final class GenerateLogs {
	
	
	/////class for generating the logs
	public static void writeLog(String message)
	{
		Logger logger = Logger.getLogger("myLogs");
		FileHandler fh;
		
		try {
			fh = new FileHandler("./logFile.log");
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			logger.info(message);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
