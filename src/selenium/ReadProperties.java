package selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties
{
	String filePath; //null
	public ReadProperties(String path)
	{
		filePath = path;
	}
	public String readApsrtcData(String key) throws IOException
	{
		FileInputStream myfile = new FileInputStream("Data/ApsrtcData.properties");
		Properties prop = new Properties();
		prop.load(myfile);
		String value = prop.getProperty(key);
		return value;
	}
	
	public String readData(String key) throws IOException
	{
		FileInputStream myfile = new FileInputStream(filePath);
		Properties prop = new Properties();
		prop.load(myfile);
		String value = prop.getProperty(key);
		return value;
	}


}
