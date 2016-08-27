import java.util.*;
public class Board {
	char[][] grid = new char[3][3];
	public Board() {
		for(int i = 0; i < 3; i++) {
			for( int j = 0; j < 3; j++) {
				grid[i][j] = '-';
			}
		}
	}
	public int put(int x, int y, char val) {
		if((x >= 0 && x < 3) && (y >= 0 && y < 3) && (grid[x][y] == '-')) {
			if(val == 'o') {
				grid[x][y] = val;
			}
			else {
				grid[x][y] = val;
			}
			return 0;
		}
		else {
			System.out.println("Invalid co-ordinates. Try again!!");
			return 1;
		}
	}
	public char[][] get() {
		return grid;
	}
	public void print() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println("\n");
		}
	}
	public int checkState() {
		for(int i = 0; i < 3; i++) {
			if((grid[i][0] == grid[i][1]) && (grid[i][1] == grid[i][2])) {
				if(grid[i][0] == 'x') {
					System.out.println("x wins!!");
					return 1;
				}
				else if(grid[i][0] == 'o') {
					System.out.println("o wins!!");
					return 1;
				}
			}
		}
		for(int i = 0; i < 3; i++) {
			if((grid[0][i] == grid[1][i]) && (grid[1][i] == grid[2][i])) {
				if(grid[0][i] == 'x') {
					System.out.println("x wins!!");
					return 1;
				}
				else if(grid[0][i] == 'o')  {
					System.out.println("o wins!!");
					return 1;
				}
			}			
		}
		if(grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != '-') {
			if(grid[0][0] == 'x') {
				System.out.println("x wins!!");
				return 1;
			}
			else {
				System.out.println("o wins!!");
				return 1;
			}
		}
		if(grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] != '-') {
			if(grid[0][2] == 'x') {
				System.out.println("x wins!!");
				return 1;
			}
			else {
				System.out.println("o wins!!");
				return 1;
			}
		}
		int count = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(grid[i][j] == 'o' || grid[i][j] == 'x') {
					count++;
				}
			}
		}
		if(count == 9) {
			System.out.println("You draw.");
			return 1;
		}
		return 0;
	}
}