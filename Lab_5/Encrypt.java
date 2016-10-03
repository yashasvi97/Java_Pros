/*
	@author (s):
					Viraj Parimi 2015068
					Yashasvi Baweja 2015116 
*/
import java.util.*;
import java.io.*;
class Encrypt extends OutputStream{
	FileOutputStream str;
	public Encrypt(FileOutputStream str) {
		this.str = str;
	}
	public void write(int key) {
		try {
			if(key == 255) {
				key = 0;
			}
			else {
				key = key + 1;
			}
			str.write(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}