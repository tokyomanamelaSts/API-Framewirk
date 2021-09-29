package Utilities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ApiHelper {
	public String converFileToString(InputStream inputStream) throws IOException {
	      //Creating an InputStream object
	      //creating an InputStreamReader object
	      InputStreamReader isReader = new InputStreamReader(inputStream);
	      //Creating a BufferedReader object
	      BufferedReader reader = new BufferedReader(isReader);
	      StringBuffer sb = new StringBuffer();
	      String str;
	      while((str = reader.readLine())!= null){
	         sb.append(str);
	      }
	      return sb.toString();
	   }

}
