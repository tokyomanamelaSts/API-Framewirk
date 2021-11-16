package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class DataProvider {

	public static String propertyFilePath= "configs//config.properties";
	
	public static String GetPropVal(String propFilePath,String propertyRetrived) throws IOException {
		 String val = null;

		 try (InputStream input = new FileInputStream(propFilePath)) {

		 Properties prop = new Properties();
		 prop.load(input);
		 val = prop.getProperty(propertyRetrived);

		 } catch (IOException ex) {
		 ex.printStackTrace();
		 }
		 return val;  
		 }
	
	public static Recordset getDataFromExcelbyQuery(String FilePath,String query) throws FilloException {
		
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection(FilePath);
		
		Recordset recordset=connection.executeQuery(query);
		return recordset; 
	}
	 
	
	
	
}
