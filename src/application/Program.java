package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Team;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int u = 1;
		
		Team.importTeams();
		
		try {
			while (u != 0) {
				int esc = 0;
				System.out.print(
						"\nWELCOME TO THE MENU\n1- Create a team\n2- Visualize the teams\n0- Exit" + "\n\nChoose: ");
				esc = sc.nextInt();

				if (esc == 1) {
					sc.nextLine();
					System.out.println("TEAM INFO:");
					System.out.print("Team name: ");
					String name = sc.nextLine();
					System.out.print("Team strength (0 to 100): ");
					int strength = sc.nextInt();
					sc.nextLine();
					System.out.print("Home stadium: ");
					String stadium = sc.nextLine();
					System.out.print("Unique ID: ");
					String id = sc.next();
					Team.createTeam(id, name, strength, stadium);
				} else if (esc == 2) {
					Team.showTeams();
				} else if (esc == 0) {
					u = 0;
				} else {
					System.out.println("Invalid option!");
				}

			}
		} catch (InputMismatchException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();

	}

}
