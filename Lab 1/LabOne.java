import java.util.*;
public class LabOne {
	public LabOne() {

	}
	public static void main(String[] args) {
		Board game = new Board();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Choice from menu :- ");
		System.out.println("1. User vs User");
		System.out.println("2. User vs Computer");
		System.out.println("3. Computer vs AI User");
		System.out.println("4. AI Computer vs User");
		int choice = in.nextInt();
		int turn = 1, x = 0, y = 0,flag = 1;
		switch(choice) {
			case 1: System.out.println("Player 1, do you want to go first. (y or n) :- ");
					char k = in.next().charAt(0);
					if(k == 'y') {
						while(flag == 1) {
							if(turn == 1) {
								System.out.println("Player 1's(o) turn. Please enter co-ordinates.");
								x = in.nextInt();
								y = in.nextInt();
								int suc = game.put(x,y,'o');
								while(suc != 0) {
									x = in.nextInt();
									y = in.nextInt();
									suc = game.put(x,y,'o');
								}
								game.print();
								int status = game.checkState();
								if(status == 1){
									flag = 0;
								}
								turn = 2;
							}
							else {
								System.out.println("Player 2's(x) turn. Please enter co-ordinates.");
								x = in.nextInt();
								y = in.nextInt();
								int suc = game.put(x,y,'x');
								while(suc != 0) {
									x = in.nextInt();
									y = in.nextInt();
									suc = game.put(x,y,'x');
								}
								game.print();
								int status = game.checkState();
								if(status == 1){
									flag = 0;
								}
								turn = 1;
							}
						}	
					}
					else {
						while( flag == 1 ){ 
							if(turn == 1) {
								System.out.println("Player 2's(o) turn. Please enter co-ordinates.");
								x = in.nextInt();
								y = in.nextInt();
								int suc = game.put(x,y,'o');
								while(suc != 0) {
									x = in.nextInt();
									y = in.nextInt();
									suc = game.put(x,y,'o');
								}
								game.print();
								int status = game.checkState();
								if(status == 1){
									flag = 0;
								}
								turn = 2;
							}
							else {
								System.out.println("Player 1's(x) turn. Please enter co-ordinates.");
								x = in.nextInt();
								y = in.nextInt();
								int suc = game.put(x,y,'x');
								while(suc != 0) {
									x = in.nextInt();
									y = in.nextInt();
									suc = game.put(x,y,'x');
								}
								game.print();
								int status = game.checkState();
								if(status == 1){
									flag = 0;
								}
								turn = 1;
							}
						}	
					}
					break;
			case 2:	System.out.println("User, do you want to go first. (y or n) :- ");
					char k1 = in.next().charAt(0);
					if(k1 == 'y') {
						while(flag == 1) {
							if(turn == 1) {
								System.out.println("User's(o) turn. Please enter co-ordinates.");
								x = in.nextInt();
								y = in.nextInt();
								int suc = game.put(x,y,'o');
								while(suc != 0) {
									x = in.nextInt();
									y = in.nextInt();
									suc = game.put(x,y,'o');
								}
								game.print();
								int status = game.checkState();
								if(status == 1){
									flag = 0;
								}
								turn = 2;
							}
							else {
								System.out.println("Computer's(x) turn. Please wait.");
								Random pos = new Random();
								int suc = 1;
								while(suc != 0) {
									int position = pos.nextInt(9);
									switch(position) {
										case 0: x = y = 0;
												break;
										case 1: x = 0;
												y = 1;
												break;
										case 2: x = 0;
												y = 2;
												break;
										case 3: x = 1;
												y = 0;
												break;
										case 4: x = 1;
												y = 1;
												break;
										case 5: x = 1;
												y = 2;
												break;
										case 6: x = 2;
												y = 0;
												break;
										case 7: x = 2;
												y = 1;
												break;
										case 8: x = 2;
												y = 2;
												break;
									}
									suc = game.put(x,y,'x');
								}
								game.print();
								int status = game.checkState();
								if(status == 1){
									flag = 0;
								}
								turn = 1;
							}	
						}
					}
					else {
						while(flag == 1) {
							if(turn == 1) {
								System.out.println("Computer's(x) turn. Please wait.");
								Random pos = new Random();
								int suc = 1;
								while(suc != 0) {
									int position = pos.nextInt(9);
									switch(position) {
										case 0: x = y = 0;
												break;
										case 1: x = 0;
												y = 1;
												break;
										case 2: x = 0;
												y = 2;
												break;
										case 3: x = 1;
												y = 0;
												break;
										case 4: x = 1;
												y = 1;
												break;
										case 5: x = 1;
												y = 2;
												break;
										case 6: x = 2;
												y = 0;
												break;
										case 7: x = 2;
												y = 1;
												break;
										case 8: x = 2;
												y = 2;
												break;
									}
									suc = game.put(x,y,'x');
								}
								game.print();
								int status = game.checkState();
								if(status == 1){
									flag = 0;
								}
								turn = 2;
							}
							else {
								System.out.println("User's(o) turn. Please enter co-ordinates.");
								x = in.nextInt();
								y = in.nextInt();
								int suc = game.put(x,y,'o');
								while(suc != 0) {
									x = in.nextInt();
									y = in.nextInt();
									suc = game.put(x,y,'o');
								}
								game.print();
								int status = game.checkState();
								if(status == 1){
									flag = 0;
								}
								turn = 1;
							}	
						}	
					}
					break;
			case 3: //It does not matter who goes first in this case as the user is not involved at all
					while(flag == 1) {
						if(turn == 1) {
							System.out.println("Computer's(o) turn. Please wait.");
							Random pos = new Random();
							int suc = 1;
							while(suc != 0) {
								int position = pos.nextInt(9);
								switch(position) {
									case 0: x = y = 0;
											break;
									case 1: x = 0;
											y = 1;
											break;
									case 2: x = 0;
											y = 2;
											break;
									case 3: x = 1;
											y = 0;
											break;
									case 4: x = 1;
											y = 1;
											break;
									case 5: x = 1;
											y = 2;
											break;
									case 6: x = 2;
											y = 0;
											break;
									case 7: x = 2;
											y = 1;
											break;
									case 8: x = 2;
											y = 2;
											break;
								}
								suc = game.put(x,y,'o');
							}
							game.print();
							int status = game.checkState();
							if(status == 1){
								flag = 0;
							}
							turn = 2;
						}
						else {
							int check = 0;
							System.out.println("AI's(x) turn. Please wait.");
							char[][] grid = game.get();
							//Trying to win or block
							for(int i = 0; i < 3; i++) {
								if((grid[i][0] == grid[i][1] && grid[i][0] != '-') || (grid[i][0] == grid[i][2] && grid[i][0] != '-') || (grid[i][1] == grid[i][2] && grid[i][1] != '-')) {
									if(grid[i][0] == '-') {
										int suc = game.put(i,0,'x');
										game.print();
										int status = game.checkState();
										if(status == 1){
											flag = 0;
										}
										turn = 1;
										check = 1;
										break;
									}
									else if(grid[i][1] == '-') {
										int suc = game.put(i,1,'x');
										game.print();
										int status = game.checkState();
										if(status == 1){
											flag = 0;
										}
										turn = 1;
										check = 1;
										break;
									}
									else if(grid[i][2] == '-') {
										int suc = game.put(i,2,'x');
										game.print();
										int status = game.checkState();
										if(status == 1){
											flag = 0;
										}
										turn = 1;
										check = 1;
										break;
									}
								}
							}
							if(check == 1) {
								continue;
							}
							for(int i = 0; i < 3; i++) {
								if((grid[0][i] == grid[1][i] && grid[0][i] != '-') || (grid[0][i] == grid[2][i] && grid[0][i] != '-') || (grid[1][i] == grid[2][i] && grid[1][i] != '-')) {
									if(grid[0][i] == '-') {
										int suc = game.put(0,i,'x');
										game.print();
										int status = game.checkState();
										if(status == 1){
											flag = 0;
										}
										turn = 1;
										check = 1;
										break;
									}
									else if(grid[1][i] == '-') {
										int suc = game.put(1,i,'x');
										game.print();
										int status = game.checkState();
										if(status == 1){
											flag = 0;
										}
										turn = 1;
										check = 1;
										break;
									}
									else if(grid[2][i] == '-') {
										int suc = game.put(2,i,'x');
										game.print();
										int status = game.checkState();
										if(status == 1){
											flag = 0;
										}
										turn = 1;
										check = 1;
										break;
									}
								}	
							}
							if(check == 1) {
								continue;
							}
							if((grid[0][0] == grid[1][1] && grid[0][0] != '-') || (grid[1][1] == grid[2][2] && grid[1][1] != '-') || (grid[0][0] == grid[2][2] && grid[0][0] != '-')) {
								if(grid[0][0] == '-') {
									int suc = game.put(0,0,'x');
									game.print();
									int status = game.checkState();
									if(status == 1){
										flag = 0;
									}
									turn = 1;
									continue;
								}
								else if(grid[1][1] == '-') {
									int suc = game.put(1,1,'x');
									game.print();
									int status = game.checkState();
									if(status == 1){
										flag = 0;
									}
									turn = 1;
									continue;
								}
								else if(grid[2][2] == '-') {
									int suc = game.put(2,2,'x');
									game.print();
									int status = game.checkState();
									if(status == 1){
										flag = 0;
									}
									turn = 1;
									continue;
								}
							}
							if((grid[0][2] == grid[1][1] && grid[0][2] != '-') || (grid[1][1] == grid[2][0] && grid[1][1] != '-') || (grid[0][2] == grid[2][0] && grid[0][2] != '-')) {
								if(grid[0][2] == '-') {
									int suc = game.put(0,2,'x');
									game.print();
									int status = game.checkState();
									if(status == 1){
										flag = 0;
									}
									turn = 1;
									continue;
								}
								else if(grid[1][1] == '-') {
									int suc = game.put(1,1,'x');
									game.print();
									int status = game.checkState();
									if(status == 1){
										flag = 0;
									}
									turn = 1;
									continue;
								}
								else if(grid[2][0] == '-') {
									int suc = game.put(2,0,'x');
									game.print();
									int status = game.checkState();
									if(status == 1){
										flag = 0;
									}
									turn = 1;
									continue;
								}
							}
							Random pos = new Random();
							int suc = 1;
							while(suc != 0) {
								int position = pos.nextInt(9);
								switch(position) {
									case 0: x = y = 0;
											break;
									case 1: x = 0;
											y = 1;
											break;
									case 2: x = 0;
											y = 2;
											break;
									case 3: x = 1;
											y = 0;
											break;
									case 4: x = 1;
											y = 1;
											break;
									case 5: x = 1;
											y = 2;
											break;
									case 6: x = 2;
											y = 0;
											break;
									case 7: x = 2;
											y = 1;
											break;
									case 8: x = 2;
											y = 2;
											break;
								}
								suc = game.put(x,y,'x');
							}
							game.print();
							int status = game.checkState();
							if(status == 1){
								flag = 0;
							}	
							turn = 1;
						}
					}
					break;
			case 4: System.out.println("User, do you want to go first. (y or n) :- ");
					char k2 = in.next().charAt(0);
					int count = 0;
					if(k2 == 'n') {
						while(flag == 1) {
							if(turn == 1) {
								if(count == 0) {
									System.out.println("AI's(o) turn. Please wait.");
									int suc = game.put(1,1,'o');
									game.print();
									count = 1;
									turn = 2;
									continue;
								}
								int check = 0;
								System.out.println("AI's(o) turn. Please wait.");
								char[][] grid = game.get();
								//Trying to win or block
								for(int i = 0; i < 3; i++) {
									if((grid[i][0] == grid[i][1] && grid[i][0] != '-') || (grid[i][0] == grid[i][2] && grid[i][0] != '-') || (grid[i][1] == grid[i][2] && grid[i][1] != '-')) {
										if(grid[i][0] == '-') {
											int suc = game.put(i,0,'o');
											game.print();
											int status = game.checkState();
											if(status == 1){
												flag = 0;
											}
											turn = 2;
											check = 1;
											break;
										}
										else if(grid[i][1] == '-') {
											int suc = game.put(i,1,'o');
											game.print();
											int status = game.checkState();
											if(status == 1){
												flag = 0;
											}
											turn = 2;
											check = 1;
											break;
										}
										else if(grid[i][2] == '-') {
											int suc = game.put(i,2,'o');
											game.print();
											int status = game.checkState();
											if(status == 1){
												flag = 0;
											}
											turn = 2;
											check = 1;
											break;
										}
									}
								}
								if(check == 1) {
									continue;
								}
								for(int i = 0; i < 3; i++) {
									if((grid[0][i] == grid[1][i] && grid[0][i] != '-') || (grid[0][i] == grid[2][i] && grid[0][i] != '-') || (grid[1][i] == grid[2][i] && grid[1][i] != '-')) {
										if(grid[0][i] == '-') {
											int suc = game.put(0,i,'o');
											game.print();
											int status = game.checkState();
											if(status == 1){
												flag = 0;
											}
											turn = 2;
											check = 1;
											break;
										}
										else if(grid[1][i] == '-') {
											int suc = game.put(1,i,'o');
											game.print();
											int status = game.checkState();
											if(status == 1){
												flag = 0;
											}
											turn = 2;
											check = 1;
											break;
										}
										else if(grid[2][i] == '-') {
											int suc = game.put(2,i,'o');
											game.print();
											int status = game.checkState();
											if(status == 1){
												flag = 0;
											}
											turn = 2;
											check = 1;
											break;
										}
									}	
								}
								if(check == 1) {
									continue;
								}
								if((grid[0][0] == grid[1][1] && grid[0][0] != '-') || (grid[1][1] == grid[2][2] && grid[1][1] != '-') || (grid[0][0] == grid[2][2] && grid[0][0] != '-')) {
									if(grid[0][0] == '-') {
										int suc = game.put(0,0,'o');
										game.print();
										int status = game.checkState();
										if(status == 1){
											flag = 0;
										}
										turn = 2;
										continue;
									}
									else if(grid[1][1] == '-') {
										int suc = game.put(1,1,'o');
										game.print();
										int status = game.checkState();
										if(status == 1){
											flag = 0;
										}
										turn = 2;
										continue;
									}
									else if(grid[2][2] == '-') {
										int suc = game.put(2,2,'o');
										game.print();
										int status = game.checkState();
										if(status == 1){
											flag = 0;
										}
										turn = 2;
										continue;
									}
								}
								if((grid[0][2] == grid[1][1] && grid[0][2] != '-') || (grid[1][1] == grid[2][0] && grid[1][1] != '-') || (grid[0][2] == grid[2][0] && grid[0][2] != '-')) {
									if(grid[0][2] == '-') {
										int suc = game.put(0,2,'o');
										game.print();
										int status = game.checkState();
										if(status == 1){
											flag = 0;
										}
										turn = 2;
										continue;
									}
									else if(grid[1][1] == '-') {
										int suc = game.put(1,1,'o');
										game.print();
										int status = game.checkState();
										if(status == 1){
											flag = 0;
										}
										turn = 2;
										continue;
									}
									else if(grid[2][0] == '-') {
										int suc = game.put(2,0,'o');
										game.print();
										int status = game.checkState();
										if(status == 1){
											flag = 0;
										}
										turn = 2;
										continue;
									}
								}
								Random pos = new Random();
								int suc = 1;
								while(suc != 0) {
									int position = pos.nextInt(9);
									switch(position) {
										case 0: x = y = 0;
												break;
										case 1: x = 0;
												y = 1;
												break;
										case 2: x = 0;
												y = 2;
												break;
										case 3: x = 1;
												y = 0;
												break;
										case 4: x = 1;
												y = 1;
												break;
										case 5: x = 1;
												y = 2;
												break;
										case 6: x = 2;
												y = 0;
												break;
										case 7: x = 2;
												y = 1;
												break;
										case 8: x = 2;
												y = 2;
												break;
									}
									suc = game.put(x,y,'o');
								}
								game.print();
								int status = game.checkState();
								if(status == 1){
									flag = 0;
								}	
								turn = 2;
							}
							else {
								System.out.println("User's(x) turn. Please enter co-ordinates.");
								x = in.nextInt();
								y = in.nextInt();
								int suc = game.put(x,y,'x');
								while(suc != 0) {
									x = in.nextInt();
									y = in.nextInt();
									suc = game.put(x,y,'x');
								}
								game.print();
								int status = game.checkState();
								if(status == 1){
									flag = 0;
								}
								turn = 1;
							}
						}
					}
					else {
						while(flag == 1) {
							if(turn == 1) {
								System.out.println("User's(o) turn. Please enter co-ordinates.");
								x = in.nextInt();
								y = in.nextInt();
								int suc = game.put(x,y,'o');
								while(suc != 0) {
									x = in.nextInt();
									y = in.nextInt();
									suc = game.put(x,y,'o');
								}
								game.print();
								int status = game.checkState();
								if(status == 1){
									flag = 0;
								}
								turn = 2;
							}
							else {
								char[][] grid = game.get();
								if(count == 0) {
									if(grid[1][1] == 'o') {
										System.out.println("AI's(x) turn. Please wait.");
										int suc = game.put(0,2,'x');
										game.print();
										count = 1;
										turn = 1;
										continue;
									}
									else if(grid[0][0] == 'o' || grid[0][2] == 'o' || grid[2][0] == 'o' || grid[2][2] == 'o') {
										System.out.println("AI's(x) turn. Please wait.");
										int suc = game.put(1,1,'x');
										game.print();
										count = 1;
										turn = 1;
										continue;	
									}
								}
								int check = 0;
								System.out.println("AI's(x) turn. Please wait.");
								//Trying to win or block
								for(int i = 0; i < 3; i++) {
									if((grid[i][0] == grid[i][1] && grid[i][0] != '-') || (grid[i][0] == grid[i][2] && grid[i][0] != '-') || (grid[i][1] == grid[i][2] && grid[i][1] != '-')) {
										if(grid[i][0] == '-') {
											int suc = game.put(i,0,'x');
											game.print();
											int status = game.checkState();
											if(status == 1){
												flag = 0;
											}
											turn = 1;
											check = 1;
											break;
										}
										else if(grid[i][1] == '-') {
											int suc = game.put(i,1,'x');
											game.print();
											int status = game.checkState();
											if(status == 1){
												flag = 0;
											}
											turn = 1;
											check = 1;
											break;
										}
										else if(grid[i][2] == '-') {
											int suc = game.put(i,2,'x');
											game.print();
											int status = game.checkState();
											if(status == 1){
												flag = 0;
											}
											turn = 1;
											check = 1;
											break;
										}
									}
								}
								if(check == 1) {
									continue;
								}
								for(int i = 0; i < 3; i++) {
									if((grid[0][i] == grid[1][i] && grid[0][i] != '-') || (grid[0][i] == grid[2][i] && grid[0][i] != '-') || (grid[1][i] == grid[2][i] && grid[1][i] != '-')) {
										if(grid[0][i] == '-') {
											int suc = game.put(0,i,'x');
											game.print();
											int status = game.checkState();
											if(status == 1){
												flag = 0;
											}
											turn = 1;
											check = 1;
											break;
										}
										else if(grid[1][i] == '-') {
											int suc = game.put(1,i,'x');
											game.print();
											int status = game.checkState();
											if(status == 1){
												flag = 0;
											}
											turn = 1;
											check = 1;
											break;
										}
										else if(grid[2][i] == '-') {
											int suc = game.put(2,i,'x');
											game.print();
											int status = game.checkState();
											if(status == 1){
												flag = 0;
											}
											turn = 1;
											check = 1;
											break;
										}
									}	
								}
								if(check == 1) {
									continue;
								}
								if((grid[0][0] == grid[1][1] && grid[0][0] != '-') || (grid[1][1] == grid[2][2] && grid[1][1] != '-') || (grid[0][0] == grid[2][2] && grid[0][0] != '-')) {
									if(grid[0][0] == '-') {
										int suc = game.put(0,0,'x');
										game.print();
										int status = game.checkState();
										if(status == 1){
											flag = 0;
										}
										turn = 1;
										continue;
									}
									else if(grid[1][1] == '-') {
										int suc = game.put(1,1,'x');
										game.print();
										int status = game.checkState();
										if(status == 1){
											flag = 0;
										}
										turn = 1;
										continue;
									}
									else if(grid[2][2] == '-') {
										int suc = game.put(2,2,'x');
										game.print();
										int status = game.checkState();
										if(status == 1){
											flag = 0;
										}
										turn = 1;
										continue;
									}
								}
								if((grid[0][2] == grid[1][1] && grid[0][2] != '-') || (grid[1][1] == grid[2][0] && grid[1][1] != '-') || (grid[0][2] == grid[2][0] && grid[0][2] != '-')) {
									if(grid[0][2] == '-') {
										int suc = game.put(0,2,'x');
										game.print();
										int status = game.checkState();
										if(status == 1){
											flag = 0;
										}
										turn = 1;
										continue;
									}
									else if(grid[1][1] == '-') {
										int suc = game.put(1,1,'x');
										game.print();
										int status = game.checkState();
										if(status == 1){
											flag = 0;
										}
										turn = 1;
										continue;
									}
									else if(grid[2][0] == '-') {
										int suc = game.put(2,0,'x');
										game.print();
										int status = game.checkState();
										if(status == 1){
											flag = 0;
										}
										turn = 1;
										continue;
									}
								}
								Random pos = new Random();
								int suc = 1;
								while(suc != 0) {
									int position = pos.nextInt(9);
									switch(position) {
										case 0: x = y = 0;
												break;
										case 1: x = 0;
												y = 1;
												break;
										case 2: x = 0;
												y = 2;
												break;
										case 3: x = 1;
												y = 0;
												break;
										case 4: x = 1;
												y = 1;
												break;
										case 5: x = 1;
												y = 2;
												break;
										case 6: x = 2;
												y = 0;
												break;
										case 7: x = 2;
												y = 1;
												break;
										case 8: x = 2;
												y = 2;
												break;
									}
									suc = game.put(x,y,'x');
								}
								game.print();
								int status = game.checkState();
								if(status == 1){
									flag = 0;
								}	
								turn = 1;
							}
						}
					}
					break;			
		}
	}
}