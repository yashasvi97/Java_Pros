/*
	@author (s):
					Viraj Parimi 2015068
					Yashasvi Baweja 2015116 
*/
import java.util.*;
import java.io.*;
class Decrypt extends InputStream {
	FileInputStream str;
	public Decrypt(FileInputStream str) {
		this.str = str;
	}
	public int read() throws IOException{
		int key = 0;
		try {
			key = str.read();
			if(key == 0) {
				key = 255;
			}
			else {
				key = key - 1;
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return key;
	}
}