import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		//File Output Stream 
		String data = "I Love India";

		try {
			FileOutputStream fos  = new FileOutputStream( "myFile.txt");
			byte[] byteData = data.getBytes();
			fos.write(byteData);
			fos.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


		//file inputStream to read data
		try {
			FileInputStream fi = new FileInputStream("myFile.txt");

			int i=0;
			while( (i = fi.read() ) !=-1){
				System.out.print((char) i); //we take out data in byte format from a txt file therefore we need to convert it into character
			}
			fi.close();
		}catch(IOException x){
			System.out.println(x);
		}


	}
}