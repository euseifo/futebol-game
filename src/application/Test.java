package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Team;

public class Test {

	public static void main(String[] args) {
		
		List<Team> teams = new ArrayList<>();
		String path = "d:\\Futebol Game\\teams.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				String info[] = line.split(";");
				Team team = new Team(info[0], info[1], Integer.parseInt(info[2]), info[3]);
				teams.add(team);
			}
			
			for (Team team : teams) {
				System.out.println(team);
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}

}
