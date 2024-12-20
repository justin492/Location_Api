package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class utils {
	
	RequestSpecification baseurlreq;
	public RequestSpecification requestSpecification() throws IOException
	{
		PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
		baseurlreq=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURL")).addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		return baseurlreq;
	}
	
	public static String getGlobalValue(String key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fils=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		prop.load(fils);
		return prop.getProperty(key);
		
	}
}
