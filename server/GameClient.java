package server;

import java.io.*;
import java.net.*;
import java.util.*;

// Client-side gritty details for the Player 
public class GameClient {
	private Socket socket;
	private BufferedReader reader;
	private PrintWriter output;
	private Scanner scanner = new Scanner(System.in);
	
	public GameClient(String address, int port) {		
		// tying sockets together...
		try {
			// establishing connection and input/output
			socket = new Socket(address, port);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream());
			
			// if we connect...
			String connected = reader.readLine();
			System.out.println(connected);
			
			// giving user option to close the server
			String input = scanner.nextLine();
			output.println(input);
			output.flush();
			
			socket.close();
			
		} catch (IOException e) {
			System.out.println("Client could not connect!");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		GameClient player = new GameClient("192.168.0.16", 8300);
	}
}
