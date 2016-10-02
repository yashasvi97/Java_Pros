import java.lang.*;
import java.util.*;
import java.io.*;
public class MediaSystem {
	public static void main(String[] args) throws IOException, FileNotFoundException{
		BufferedReader movies = null, audios = null;
		ObjectOutputStream moviesOut = null, audiosOut = null;
		ObjectInputStream moviesIn = null, audiosIn = null;
		int movieListSize = 0, audioListSize = 0;
		try {
			movies = new BufferedReader(new FileReader("movie.txt"));
			audios = new BufferedReader(new FileReader("song.txt"));
			List<Audio> audioList = new ArrayList<Audio>();
			List<Movie> movieList = new ArrayList<Movie>();
			Movie tempMovie = null;
			Audio tempAudio = null;
			String line = null;
			String movieName = null, artistName = null, genre = null, duration = null, directorName = null, producerName = null, songName = null;
			char certification = ' ';
			int yearOfRelease = 0, rating = 0; 
			double size = 0.0;
			movies.readLine();
			// working wiht movie.txt
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
			// working with song.txt
			audios.readLine();
			while((line = audios.readLine()) != null) {
				int count = 0;
				String[] arr = line.split(",");
				songName = arr[count++];
				System.out.println(songName);
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
			// serialising files
			movieListSize = movieList.size();
			audioListSize = audioList.size();
			moviesOut = new ObjectOutputStream(new FileOutputStream("movies.ser"));
			audiosOut = new ObjectOutputStream(new FileOutputStream("songs.ser"));
			for ( Movie movieTemp : movieList ) {
				moviesOut.writeObject(movieTemp);
			}
			for ( Audio audioTemp : audioList ) {
				audiosOut.writeObject(audioTemp);
			}
			moviesOut.close();
			audiosOut.close();
			// deserialising files
			moviesIn = new ObjectInputStream(new FileInputStream("movies.ser"));
			audiosIn = new ObjectInputStream(new FileInputStream("songs.ser"));
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
			moviesIn.close();
			audiosIn.close();
			//printing data of these files
			int count = 1;
			for ( Movie movieTemp : movieList ) {
				System.out.println( "Movie Number :- " + count );
				System.out.println( "Movie Name :- " + movieTemp.getTitle() + "\nArtist :- " + movieTemp.getArtistName() + "\nYear of Release :- " + movieTemp.getYearOfRelease() + "\nGenre :- " + movieTemp.getGenre() + "\nSize :- " + movieTemp.getSize() + "\nRating :- " + movieTemp.getRating() + "\nDuration :- " + movieTemp.getDuration() + "\nDirector :- " + movieTemp.getDirector() + "\nProducer :- " + movieTemp.getProducer() + "\nCertification :- " + movieTemp.getCertification() + "\n");
				count++;
			}
			count = 1;
			for ( Audio audioTemp : audioList ) {
				System.out.println( "Song Number :- " + count );
				System.out.println( "Song Name :- " + audioTemp.getAudioName() + "\nMovie Name :- " + audioTemp.getTitle() + "\nArtist :- " + audioTemp.getArtistName() + "\nYear of Release :- " + audioTemp.getYearOfRelease() + "\nGenre :- " + audioTemp.getGenre() + "\nSize :- " + audioTemp.getSize() + "\nRating :- " + audioTemp.getRating() + "\nDuration :- " + audioTemp.getDuration() + "\n");
				count++;
			}

		}
		finally {
			if( movies != null )
				movies.close();
				audios.close();	
		}
	}
}