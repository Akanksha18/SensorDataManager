/* **************************************************
 Copyright (c) 2012, University of Cambridge
 Neal Lathia, neal.lathia@cl.cam.ac.uk
 Kiran Rachuri, kiran.rachuri@cl.cam.ac.uk

This application was developed as part of the EPSRC Ubhave (Ubiquitous and
Social Computing for Positive Behaviour Change) Project. For more
information, please visit http://www.emotionsense.org

Permission to use, copy, modify, and/or distribute this software for any
purpose with or without fee is hereby granted, provided that the above
copyright notice and this permission notice appear in all copies.

THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 ************************************************** */

package com.ubhave.datahandler.store;

// OLD CODE >> REFERENCE ONLY

public class DataLogger
{

//	private static final String TAG = "DataLogger";
//
//	private static DataLogger dataLogger;
//	private static Object lock = new Object();
//
//	private Timer timer;
//	private LogDataToFileTask logDataToFileTask;
//	private HashMap<String, DataHolder> dataMap;
//
//	class DataHolder
//	{
//		StringBuilder cache;
//		FileOutputStream fos;
//	}
//
//	public static DataLogger getDataLogger()
//	{
//		if (dataLogger == null)
//		{
//			synchronized (lock)
//			{
//				if (dataLogger == null)
//				{
//					dataLogger = new DataLogger();
//				}
//			}
//		}
//		return dataLogger;
//	}
//
//	private DataLogger()
//	{
//		dataMap = new HashMap<String, DataHolder>();
//		logDataToFileTask = new LogDataToFileTask();
//		timer = new Timer();
//		// run every 5 mins
//		timer.schedule(logDataToFileTask, 2 * 60 * 1000, 5 * 60 * 1000);
//	}
//
//	public void logData(String tag, String logString)
//	{
//		ESLogger.log(TAG, tag + " " + logString);
//		synchronized (dataMap)
//		{
//			DataHolder dh;
//			if (dataMap.containsKey(tag))
//			{
//				dh = dataMap.get(tag);
//			}
//			else
//			{
//				dh = new DataHolder();
//				dh.cache = new StringBuilder();
//				dh.fos = null;
//				dataMap.put(tag, dh);
//			}
//			dh.cache.append(logString + "\n");
//		}
//	}
//
//	public void moveFilesForUploading(String targetDir)
//	{
//		ESLogger.log(TAG, "moveFilesForUploading() called");
//		synchronized (dataMap)
//		{
//			logDataToFileTask.run();
//			for (String key : dataMap.keySet())
//			{
//				DataHolder dh = dataMap.get(key);
//				if (dh.fos != null)
//				{
//					try
//					{
//						// close
//						dh.fos.flush();
//						dh.fos.close();
//					}
//					catch (IOException e)
//					{
//						ESLogger.error(TAG, e);
//					}
//				}
//			}
//			// clear hash map
//			dataMap.clear();
//
//			// move all files to targetDir folder
//			File[] allLogFiles = Utilities.getAllFiles(Constants.DATA_LOGS_DIR, ".log");
//			for (File file : allLogFiles)
//			{
//				file.renameTo(new File(targetDir + "/" + file.getName()));
//			}
//		}
//	}
//
//	class LogDataToFileTask extends TimerTask
//	{
//		public void run()
//		{
//			ESLogger.log(TAG, " run(), logging cached data to files");
//			synchronized (dataMap)
//			{
//				// log the data in the data holder cache to
//				// corresponding files
//				for (String key : dataMap.keySet())
//				{
//					DataHolder dh = dataMap.get(key);
//					try
//					{
//						if (dh.fos == null)
//						{
//							String fileName = Constants.DATA_LOGS_DIR + "/" + Utilities.getImei() + "_" + key + "_" + System.currentTimeMillis() + ".log";
//							ESLogger.log(TAG, "Creating new log file: " + fileName);
//							dh.fos = new FileOutputStream(fileName);
//						}
//						if (dh.cache.length() > 0)
//						{
//							ESLogger.log(TAG, "writing cached data to file for tag: " + key);
//							// write to data log file
//							dh.fos.write(dh.cache.toString().getBytes());
//							dh.fos.flush();
//							// clear cache
//							dh.cache.delete(0, dh.cache.length());
//						}
//					}
//					catch (IOException exp)
//					{
//						ESLogger.error(TAG, exp);
//					}
//				}
//			}
//		}
//	}
}
