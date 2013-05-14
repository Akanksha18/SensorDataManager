package com.ubhave.datahandler.config;

import java.util.HashMap;
import java.util.HashSet;

import android.os.Environment;

import com.ubhave.datahandler.except.DataHandlerException;

public class DataHandlerConfig
{
	private static DataHandlerConfig instance;

	public static DataHandlerConfig getInstance()
	{
		if (instance == null)
		{
			instance = new DataHandlerConfig();
		}
		return instance;
	}

	private final HashSet<String> validKeys;
	private final HashMap<String, Object> config;

	public DataHandlerConfig()
	{
		config = new HashMap<String, Object>();
		config.putAll(DataStorageConfig.defaultValues());
		config.putAll(DataTransferConfig.defaultValues());

		validKeys = new HashSet<String>();
		validKeys.addAll(DataStorageConfig.validKeys());
		validKeys.addAll(DataTransferConfig.validKeys());
	}
	
	private void updateLocalUploadDirectoryPath()
	{
		String absoluteDir = (String) config.get(DataStorageConfig.LOCAL_STORAGE_ROOT_DIRECTORY_NAME);
		String uploadDir = absoluteDir +"/"+ config.get(DataStorageConfig.LOCAL_STORAGE_UPLOAD_DIRECTORY_NAME);
		config.put(DataStorageConfig.LOCAL_STORAGE_UPLOAD_DIRECTORY_PATH, uploadDir);
	}

	public void setConfig(final String key, final Object value) throws DataHandlerException
	{
		if (validKeys.contains(key))
		{
			if (key.equals(DataStorageConfig.LOCAL_STORAGE_ROOT_DIRECTORY_NAME))
			{
				String absoluteDir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + (String) value;
				config.put(key,  absoluteDir);
				updateLocalUploadDirectoryPath();
			}
			else if (key.equals(DataStorageConfig.LOCAL_STORAGE_UPLOAD_DIRECTORY_NAME))
			{
				config.put(key, value);
				updateLocalUploadDirectoryPath();
			}
			else
			{
				config.put(key, value);
			}
		}
		else
		{
			throw new DataHandlerException(DataHandlerException.UNKNOWN_CONFIG);
		}
	}

	public boolean containsConfig(final String key)
	{
		return config.containsKey(key);
	}

	public Object get(final String key) throws DataHandlerException
	{
		if (validKeys.contains(key))
		{
			return config.get(key);
		}
		else
		{
			System.err.println("Unknown config: "+key);
			throw new DataHandlerException(DataHandlerException.UNKNOWN_CONFIG);
		}
	}
}
