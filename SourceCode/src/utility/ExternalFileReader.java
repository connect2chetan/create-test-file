package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ExternalFileReader {

	public String Directory = "";
	public String FileName = "";
	public String Extenstion = "";
	public long Required_File_Size = 0;
	public String validCharacters = "";
	String logs="";
	public ExternalFileReader() {

		try {

			Properties prp = null;
			prp = new Properties();
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "//config.txt");
			prp.load(fs);

			Directory = prp.getProperty("Directory");
			//System.out.println(Directory);
			FileName = prp.getProperty("FileName");
			Extenstion = prp.getProperty("Extenstion");
			Required_File_Size =  Long.parseLong(prp.getProperty("Required_File_Size"));
			validCharacters =  prp.getProperty("validCharacters");
			
			
		} catch (FileNotFoundException e) {
			//System.out.println("Some thing goes wrong!!");
			logs=logs+"\n Some thing goes wrong!! \n Config File not found!! Below is the strack trace \n";
			logs=e.getMessage();
			logs=logs+"\n Config File not found!! strack trace Ends!! \n";
		}
			catch (IOException e) {
			//System.out.println("Some thing goes wrong!!");
				logs=logs+"\n Some thing goes wrong!! \n Config File has an issue!! Below is the strack trace \n";
				logs=e.getMessage();
				logs=logs+"\n Config File has an issue!! strack trace Ends!! \n";
		}
	}

}
