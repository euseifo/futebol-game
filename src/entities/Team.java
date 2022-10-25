package entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Team {

	private String id;
	private String name;
	private int strength;
	private String stadium;
	
	private static int nTeams;
	private static List<Team> teams = new ArrayList<>();
	private static String pathTeams = "D:\\Users\\eusei\\Documents\\Javaa\\futebolgame\\teams.txt";
	
	public Team(String id, String name, int strength, String stadium) {
		this.id = id;
		this.name = name;
		this.strength = strength;
		this.stadium = stadium;
		nTeams += 1;
	}

	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}
	
	@Override
	public String toString() {
		return "Team name: " + name + "\nTeam strength: " + strength + "\nStadium: " + stadium;
	}
	
	public String teamFormat() {
		return id + ";" + name + ";" + strength + ";" + stadium; 
	}
	
	public static int getTeams() {
		return nTeams;
	}
	
	public static void importTeams() {
		try (BufferedReader br = new BufferedReader(new FileReader(pathTeams))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				String info[] = line.split(";");
				Team team = new Team(info[0], info[1], Integer.parseInt(info[2]), info[3]);
				teams.add(team);
			}
		}
		catch (InputMismatchException e) {
			System.out.println("Invalid option!");
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public static void showTeams() {
		System.out.println("Total teams: " + Team.getTeams() + "\n\n---------------------");
		for (Team team : teams) {
			System.out.println("\n" + team + "\n\n---------------------");
		}
	}
	
	public static void createTeam(String id, String name, int strength, String stadium) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathTeams, true))) {
			Team team = new Team(id, name, strength, stadium);
			teams.add(team);
			bw.newLine();
			bw.write(team.teamFormat());
		}
		catch (InputMismatchException e) {
			System.out.println("Invalid option!");
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
}
