/*	
	@author(s) :	
					Yashasvi Baweja		2015116
					Viraj Parimi		2015068
*/
import java.util.*;
import java.io.*;
import java.lang.*;
class Graph {
	private ArrayList<String> nodes = new ArrayList<String>();
	private Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	public void addEdge(String user, String friend) {
		if( !map.containsKey(user)) {
			ArrayList<String> friends = new ArrayList<String>();
			friends.add(friend);
			map.put(user, friends);
			/*System.out.println("bpbpbpbpbpb");
			System.out.println(friends);
			System.out.println(user);*/
		}
		else {
			ArrayList<String> prevFriends = map.get(user);
			//System.out.println("I am hererere");
			//System.out.println(prevFriends);
			int i = 0;
			while( (i != prevFriends.size()) && (!prevFriends.get(i).equals(friend)) ) {
				i += 1;
			}
			if( i == prevFriends.size() ) {
				prevFriends.add(friend);
				/*System.out.println("toworgoegn");
				System.out.println(prevFriends);
				System.out.println(user);*/
				map.put(user, prevFriends);
			}
		}
		storeUsers(user, friend);
	}
	private void storeUsers(String user, String friend) {
		if( !user.equals(friend) ) {
			if( !nodes.contains(friend) ) {
				nodes.add(friend);
			}
		}
		if( !nodes.contains(user) ) {
			nodes.add(user);
		}
	}
	public ArrayList<String> getFriends(String user) {
		ArrayList<String> friends;
		Set<String> keys = map.keySet();
		for (String val : keys ) {
			if(val.equals(user) ) {
				friends = map.get(val);
				return new ArrayList<String>(friends);
			}
		}
		return new ArrayList<String>();
	}
	public boolean memberOf(String node) {
		return nodes.contains(node);
	}
<<<<<<< HEAD
	public String toString() {
		int i = 0;
		String string = "";
		Set<String> keys = map.keySet();
		for ( String key : keys ) {
			if( i == 0 ) {
				string += key + "-->" + map.get(key).toString();
			}
			else {
				string += "\n" + key + "-->" + map.get(key).toString();	
			}
			i += 1;
		}
		return string;
	}
=======
>>>>>>> 878577df245febd2699f6acfaae618dbbeea7aef
}
class BreadthFirstSearch {
	private ArrayList<String> shortestPath = new ArrayList<String>();
	public ArrayList<String> findShortestPath( Graph graph, String user, String friend ) {
		shortestPath.clear();
		ArrayList<String> tempPath = new ArrayList<String>();
		if( user.equals(friend) && graph.memberOf(user) ) {
			tempPath.add(user);
			return tempPath;
		}
		ArrayDeque<String> queue = new ArrayDeque<String>();
		ArrayDeque<String> visitedFriends = new ArrayDeque<String>();
		queue.add(user);
		while( !queue.isEmpty() ) {
			String currVertex = queue.poll();
			visitedFriends.add(currVertex);
			ArrayList<String> friendsList = graph.getFriends(currVertex);
			for (String friendName : friendsList ) {
				tempPath.add(friendName);
				tempPath.add(currVertex);
				if( friendName.equals(friend) ) {
					return getPath(user, friend, tempPath);
				}
				else {
					if( !visitedFriends.contains(friendName) ) {
						queue.add(friendName);
					}
				}
			}
		}
		return null;
	}
	public ArrayList<String> getPath(String user, String friend, ArrayList<String> tempPath) {
		int i = tempPath.indexOf(friend);
		String source = tempPath.get(i + 1);
		shortestPath.add(0,friend);
		if( source.equals(user) ) {
			shortestPath.add(0,user);
			return shortestPath;
		}
		else {
			return getPath(user, source, tempPath);
		}
	}
}