package utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FileCreate {
	private static final String	FILENAME	= System.getProperty("user.dir") + "//log.txt";
	static String				logs		= "";

	public static void main(String[] args) throws IOException {
		try {

			ExternalFileReader efr = new ExternalFileReader();

			String Directory = efr.Directory;
			String FileName = efr.FileName;
			String Extenstion = efr.Extenstion;
			String validCharacters = new String(efr.validCharacters);
			long Required_File_Size = efr.Required_File_Size;

			logs = logs + efr.logs;

			// Specify the length of the required String
			int length = 10000;

			// Processing starts Here!!
			// *************************

			int n = validCharacters.length();
			String result = new String();
			Random r = new Random(); // 11

			// Generates random String for specified length
			for (int i = 0; i < length; i++) // 12
				result = result + validCharacters.charAt(r.nextInt(n)); // 13
			// System.out.println(result);

			File file = new File(Directory + FileName + Extenstion);
			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			Required_File_Size = Required_File_Size * 105;

			for (int i = 0; i < Required_File_Size; i++)
				bw.write(result);

			bw.close();
			logs = logs + "\n Your File '" + FileName + Extenstion + "' of " + efr.Required_File_Size
					+ " MB is created in the Directory '" + Directory + "'";
			System.out.println(logs);
			// Processing Ends Here!!
			// ***************************

		} catch (Exception e) {
			logs = logs + "\n Please Check the File Parameters!! \n Below is the strack trace \n";
			logs = e.getMessage();
			logs = logs + "\n Strack trace Ends!! \n";
			System.out.println(logs);
		} finally {
			BufferedWriter bw = null;
			FileWriter fw = null;
			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(logs);
			bw.close();
			fw.close();
		}

	}

}
