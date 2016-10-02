/*	
	@author(s) :	
					Yashasvi Baweja		2015116
					Viraj Parimi		2015068
*/
import java.util.*;
import java.io.*;
import java.lang.*;
class UserDoesNotExists extends Exception {
	public UserDoesNotExists(String error) {
		super(error);
	}
}
class UserExistsInDB extends Exception {
	public UserExistsInDB(String error) {
		super(error);
	}
}