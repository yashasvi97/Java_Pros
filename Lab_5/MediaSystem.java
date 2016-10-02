import java.lang.*;
import java.util.*;
import java.io.*;
public class MediaSystem {
	public static void main(String[] args) throws IOException, FileNotFoundException{
		int movieListSize = 0, audioListSize = 0;
								
		// working wiht movie.txt
		List<Movie> movieList = MediaSystem.getMovieList();
		
		// working with song.txt
		List<Audio> audioList = MediaSystem.getAudioList();
		
		// serialising files
		movieListSize = movieList.size();
		audioListSize = audioList.size();

		MediaSystem.showMenu();
		Scanner scanner = new Scanner(System.in);
		int input = Integer.parseInt(scanner.next());
		while(input != 0) {
			switch (input) {
				case 1 : {
					System.out.println("1. 	Audio");
					System.out.println("2. 	Movie");
					int x = scanner.nextInt();
					if(x == 1) {
						System.out.println("1. 	Read");
						System.out.println("2. 	Write");
						int y = scanner.nextInt();
						if(y == 1) {
							//audio read
							audioList = MediaSystem.audioReadSerialisable(audioList);
							System.out.println("After serialisation :-");
							printAudioList(audioList);
						}
						else if(y == 2) {
							//audop write
							MediaSystem.audioMakeSerialisable(audioList);
						}
						else {
							System.out.println("Wrong input!");
						}
					}
					else if (x == 2) {
						System.out.println("1. 	Read");
						System.out.println("2. 	Write");
						int y = scanner.nextInt();
						if(y == 1) {
							//movie read
							movieList = MediaSystem.movieReadSerialisable(movieList);
							System.out.println("After serialisation :-");
							printMovieList(movieList);
						}
						else if(y == 2) {
							//movie write
							MediaSystem.movieMakeSerialisable(movieList);
						}
						else {
							System.out.println("Wrong input!");
						}
					}
					else {
						System.out.println("Wrong input!");
					}
					break;
				}
				case 2 : {
					printMovieList(movieList);
					printAudioList(audioList);
					break;
				}
				case 3 : {
					System.out.print("Enter number of top entries you want to see :- ");
					int k = scanner.nextInt();
					System.out.println();
					audioList = sortAudioList(audioList);
					movieList = sortMovieList(movieList);
					int count = 1;
					System.out.println("Top " + k + " movies based on their rating are :- \n");
					for ( Movie movieTemp : movieList ) {
						System.out.println( "Movie Number :- " + count );
						System.out.println( "Movie Name :- " + movieTemp.getTitle() + "\nRating :- " + movieTemp.getRating() + "\n");
						count++;
						if( count > k ) {
							break;
						}
					}
					count = 1;
					System.out.println("Top " + k + " songs based on their rating are :- \n");
					for ( Audio audioTemp : audioList ) {
						System.out.println( "Song Number :- " + count );
						System.out.println( "Song Name :- " + audioTemp.getAudioName() + "\nMovie Name :- " + audioTemp.getTitle() + "\nRating :- " + audioTemp.getRating() + "\n");
						count++;
						if( count > k ) {
							break;
						}
					}
					break;
				}
				case 4 : {
					boolean exists = false;
					System.out.print("Enter a genre you want to search :- ");
					String genreToBeSearched = scanner.next();
					System.out.println();
					for ( Audio audioTemp : audioList ) {
						if( audioTemp.getGenre().equals(genreToBeSearched) ) {
							System.out.println( "Song Name :- " + audioTemp.getAudioName() + "\nMovie Name :- " + audioTemp.getTitle() + "\nArtist :- " + audioTemp.getArtistName() + "\nYear of Release :- " + audioTemp.getYearOfRelease() + "\nGenre :- " + audioTemp.getGenre() + "\nSize :- " + audioTemp.getSize() + " MB\nRating :- " + audioTemp.getRating() + "\nDuration(min) :- " + audioTemp.getDuration() + "\n");
							exists = true;
						}
					}
					if( exists == false ) {
						System.out.println("No such genre exists.\n"); // potential exception
					}
					break;
				}
				case 5 : {
					boolean exists = false;
					System.out.print("Enter director's name :- ");
					String directorToBeSearched = scanner.next();
					System.out.println();
					for ( Movie movieTemp : movieList ) {
						if( movieTemp.getDirector().equals(directorToBeSearched) ) {
							System.out.println( "Movie Name :- " + movieTemp.getTitle() + "\nArtist :- " + movieTemp.getArtistName() + "\nYear of Release :- " + movieTemp.getYearOfRelease() + "\nGenre :- " + movieTemp.getGenre() + "\nSize :- " + movieTemp.getSize() + " GB\nRating :- " + movieTemp.getRating() + "\nDuration(hrs) :- " + movieTemp.getDuration() + "\nDirector :- " + movieTemp.getDirector() + "\nProducer :- " + movieTemp.getProducer() + "\nCertification :- " + movieTemp.getCertification() + "\n");
							exists = true;
						}
					}
					if( exists == false ) {
						System.out.println("No movie has a director " + directorToBeSearched + ".\n"); // potential exception
					}
					break;
				}
				case 6 : {

				}
				case 7 : {
					System.out.println();
					System.out.println("Number of songs in the library :- " + audioListSize );
					System.out.println("Number of movies in the library :- " + movieListSize + "\n");
					break;
				}
				case 8 : {
					boolean exists = false;
					System.out.print("Enter a movie whose songs you want to see :- ");
					String movieIntersectionSongs = scanner.next();
					System.out.println();
					for ( Audio audioTemp : audioList ) {
						if( audioTemp.getTitle().equals(movieIntersectionSongs) ) {
							System.out.println( "Song Name :- " + audioTemp.getAudioName() + "\nMovie Name :- " + audioTemp.getTitle() + "\nArtist :- " + audioTemp.getArtistName() + "\nYear of Release :- " + audioTemp.getYearOfRelease() + "\nGenre :- " + audioTemp.getGenre() + "\nSize :- " + audioTemp.getSize() + " MB\nRating :- " + audioTemp.getRating() + "\nDuration(min) :- " + audioTemp.getDuration() + "\n");
							exists = true;
						}
					}
					if( exists == false ) {
						System.out.println("There is no song form the movie " + movieIntersectionSongs + ".\n"); // potential exception
					}
					break;
				}
			}
			MediaSystem.showMenu();
			input = scanner.nextInt();
		}
		
		
		
		// deserialising files
	}
	public static void showMenu() {
		System.out.println("1. 	Serialize and deserialize MediaSystem class.");
	 	System.out.println("2. 	View a list of all the songs/movies in the library");
	 	System.out.println("3. 	View a list of top “k” songs/movies by their rating");
	 	System.out.println("4. 	Search and display songs based on genre");
	 	System.out.println("5. 	Search and display movies based on director");
	 	System.out.println("6. 	Edit the rating of a song/movie");
	 	System.out.println("7. 	Display the count of number of songs/movies");
	 	System.out.println("8. 	Search and display all the songs of a given movie");
	 	System.out.println("0. 	Exit\n");
	}
	public static List<Audio> sortAudioList( List<Audio> audioList ) {
		Collections.sort( audioList, new Comparator<Audio>() {
				public int compare( Audio audio1, Audio audio2 ) {
					return -1 * (audio1.compareTo(audio2));
				}
			});
		return audioList;
	}
	public static List<Movie> sortMovieList( List<Movie> movieList ) {
		Collections.sort( movieList, new Comparator<Movie>() {
				public int compare( Movie movie1, Movie movie2 ) {
					return -1 * (movie1.compareTo(movie2));
				}
			});
		return movieList;
	}
	public static void movieMakeSerialisable(List<Movie> movieList) throws IOException, FileNotFoundException {
		System.out.println("Making Movie serialisable");
		ObjectOutputStream moviesOut = null;
		try {
			moviesOut = new ObjectOutputStream(new FileOutputStream("movies.ser"));
			for ( Movie movieTemp : movieList ) {
				moviesOut.writeObject(movieTemp);
			}
		}
		finally {
			if(moviesOut != null) {
				moviesOut.close();
				System.out.println("Movie serialisable made");
			}
		}
	}
	public static void audioMakeSerialisable(List<Audio> audioList) throws IOException, FileNotFoundException {
		System.out.println("Making Audio serialisable");
		ObjectOutputStream audiosOut = null;
		try {
			audiosOut = new ObjectOutputStream(new FileOutputStream("songs.ser"));
			for ( Audio audioTemp : audioList ) {
				audiosOut.writeObject(audioTemp);
			}
		}
		finally {
			if(audiosOut != null) {
				audiosOut.close();
				System.out.println("Audio serialisable made");
			}
		}
	}
	public static List<Movie> movieReadSerialisable(List<Movie> movieList) throws IOException, FileNotFoundException {
		ObjectInputStream moviesIn = null;
		try {
			moviesIn = new ObjectInputStream(new FileInputStream("movies.ser"));
			int movieListSize = movieList.size();
			for(int i = 0; i < movieListSize; i++ ){
				try {
					movieList.set( i, (Movie)moviesIn.readObject() );
				}
				catch( EOFException e ) {
					System.out.println("File ended unexpectedly. ");
				}
				catch( ClassNotFoundException e ) {
					System.out.println(" Movie class was not found. ");
				}
			}
		}
		finally {
			if(moviesIn != null) {
				moviesIn.close();
				System.out.println("Movie list updated (serially)");
			}
		}
		return movieList;
	}
	public static List<Audio> audioReadSerialisable(List<Audio> audioList) throws IOException, FileNotFoundException {
		ObjectInputStream audiosIn = null;
		try {
			audiosIn = new ObjectInputStream(new FileInputStream("songs.ser"));
			int audioListSize = audioList.size();
			for(int i = 0; i < audioListSize; i++) {
				try {
					audioList.set(i, (Audio)audiosIn.readObject());
				}
				catch( EOFException e) {
					System.out.println("File ended unexpectedly");
				}
				catch( ClassNotFoundException e) {
					System.out.println(" Audio class was not found. ");
				}
			}
		}
		finally {
			if(audiosIn != null) {
				audiosIn.close();
				System.out.println("Audio list updated (serially)");
			}
		}
		return audioList;
	}
	public static void printAudioList(List<Audio> list) {
		int count = 1;
		for (Audio audioTemp : list) {
			System.out.println( "Song Number :- " + count );
			System.out.println( "Song Name :- " + audioTemp.getAudioName() + "\nMovie Name :- " + audioTemp.getTitle() + "\nArtist :- " + audioTemp.getArtistName() + "\nYear of Release :- " + audioTemp.getYearOfRelease() + "\nGenre :- " + audioTemp.getGenre() + "\nSize :- " + audioTemp.getSize() + " MB\nRating :- " + audioTemp.getRating() + "\nDuration(min) :- " + audioTemp.getDuration() + "\n");
			count++;	
		}
	}
	public static void printMovieList(List<Movie> list) {
		int count = 1;
		for (Movie movieTemp : list) {
			System.out.println( "Movie Number :- " + count );
			System.out.println( "Movie Name :- " + movieTemp.getTitle() + "\nArtist :- " + movieTemp.getArtistName() + "\nYear of Release :- " + movieTemp.getYearOfRelease() + "\nGenre :- " + movieTemp.getGenre() + "\nSize :- " + movieTemp.getSize() + " GB\nRating :- " + movieTemp.getRating() + "\nDuration(hrs) :- " + movieTemp.getDuration() + "\nDirector :- " + movieTemp.getDirector() + "\nProducer :- " + movieTemp.getProducer() + "\nCertification :- " + movieTemp.getCertification() + "\n");
			count++;
		}
	}
	public static List<Audio> getAudioList() throws IOException, FileNotFoundException {
		BufferedReader audios = null;
		try {
			audios = new BufferedReader(new FileReader("song.txt"));
			List<Audio> audioList = new ArrayList<Audio>();
			Audio tempAudio = null;
			String line = null;
			String movieName = null;
			String artistName = null;
			String genre = null;
			String duration = null;
			String directorName = null;
			String producerName = null;
			String songName = null;
			char certification = ' ';
			int yearOfRelease = 0, rating = 0; 
			double size = 0.0;
			audios.readLine();
			while((line = audios.readLine()) != null) {
				int count = 0;
				String[] arr = line.split(",");
				songName = arr[count++];
				// System.out.println(songName);
				movieName = arr[count++];
				tempAudio = 	new Audio(movieName);
				tempAudio.setAudioName(songName);
				artistName = arr[count++];
				tempAudio.setArtistName(artistName);
				yearOfRelease = Integer.parseInt(arr[count++]);
				tempAudio.setYearOfRelease(yearOfRelease);
				genre = arr[count++];
				tempAudio.setGenre(genre);
				size = Double.parseDouble(arr[count++]);
				tempAudio.setSize(size);
				rating = Integer.parseInt(arr[count++]);
				tempAudio.setRating(rating);
				duration = arr[count++];
				tempAudio.setDuration(duration);
				audioList.add(tempAudio);
			}
			return audioList;
		}
		finally {
			if (audios != null) {
				audios.close();
			}
		}
	}
	public static List<Movie> getMovieList() throws IOException, FileNotFoundException {
		BufferedReader movies = null;
		try {
			movies = new BufferedReader(new FileReader("movie.txt"));
			List<Movie> movieList = new ArrayList<Movie>();
			Movie tempMovie = null;
			String line = null;
			String movieName = null;
			String artistName = null;
			String genre = null;
			String duration = null;
			String directorName = null;
			String producerName = null;
			String songName = null;
			char certification = ' ';
			int yearOfRelease = 0, rating = 0; 
			double size = 0.0;
			movies.readLine();
			while((line = movies.readLine()) != null) {
				int count = 0;
				String[] arr = line.split(",");
				movieName = arr[count++];
				tempMovie = 	new Movie(movieName);
				artistName = arr[count++];
				tempMovie.setArtistName(artistName);
				yearOfRelease = Integer.parseInt(arr[count++]);
				tempMovie.setYearOfRelease(yearOfRelease);
				genre = arr[count++];
				tempMovie.setGenre(genre);
				size = Double.parseDouble(arr[count++]);
				tempMovie.setSize(size);
				rating = Integer.parseInt(arr[count++]);
				tempMovie.setRating(rating);
				duration = arr[count++];
				tempMovie.setDuration(duration);
				directorName = arr[count++];
				tempMovie.setDirector(directorName);
				producerName = arr[count++];
				tempMovie.setProducer(producerName);
				certification = arr[count++].charAt(0);
				tempMovie.setCertification(certification);
				movieList.add(tempMovie);
			}
			return movieList;
		}
		finally {
			if(movies != null) {
				movies.close();
			}
		}
	}
}