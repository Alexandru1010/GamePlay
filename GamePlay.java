package P1;
import java.util.Scanner;
public class GamePlay {
	
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		PlayerStatus player = new PlayerStatus();
		PlayerStatus player2 = new PlayerStatus();
		
		System.out.println("Input Game Name");
		String newGameName = sc.nextLine();
		PlayerStatus.setGameName(newGameName);
		
		System.out.println("Setup first Player");
		System.out.println("Input nickname");
		String nickname = sc.next();
		System.out.println("Input number of lives");
		int lives = sc.nextInt();
		System.out.println("Input score");
		int score = sc.nextInt();
		System.out.println("Input health");
		int health = sc.nextInt();
		//player.initHealth(nbHealth);
		//player.initPlayer(nickname,nbLives,score);
		player = new PlayerStatus(nickname, lives,score, health);
		
		System.out.println("Input weapon(knife/kalashnikov/sniper) :");
		String inputWeapon = sc.next();
		if(player.getScore() <1000 || player2.getScore() < 1000) {
			System.out.println("Not enough points!N");
		} else {
			while ((!inputWeapon.equals("sniper")) && (!inputWeapon.equals("kalashnikov"))
					&& (!inputWeapon.equals("knife"))) {
				System.out.println("Input weapon(knife/kalashnikov/sniper) :");
				inputWeapon = sc.next();
				
			 }
			player.setWeaponInHand(inputWeapon);
			if(player.getWeaponInHand() == null) {
				System.out.println("Input weapon(knife/kalashnikov/sniper) :");
				inputWeapon = sc.next();
				while ((!inputWeapon.equals("sniper")) && (!inputWeapon.equals("kalashnikov"))
						&& (!inputWeapon.equals("knife"))) {
					System.out.println("Input weapon(knife/kalashnikov/sniper) :");
					inputWeapon = sc.next();
				 }
				player.setWeaponInHand(inputWeapon);
			}
		}
		
		System.out.println("Input X coordinate:");
		int posOnX = sc.nextInt();
		System.out.println("Input Y coordinate:");
		int posOnY = sc.nextInt();
		player.movePlayerTo(posOnX, posOnY);
		
		System.out.println("Player " + nickname + " found an artifact!" + 
		" Input artifact code:");
		int artifactCode = sc.nextInt();
		player.findArtifact(Methods.generateArtifact(artifactCode));
		
		System.out.print("Probability to win for player " + nickname + " ");
		System.out.println(player.probability(player.getHealth(), player.getScore()));
		if(player.getScore() > 1000 && player.getWeaponInHand() == null) {
			System.out.println("Input weapon(knife/kalashnikov/sniper) :");
			 inputWeapon = sc.next();
				while ((!inputWeapon.equals("sniper")) && (!inputWeapon.equals("kalashnikov"))
						&& (!inputWeapon.equals("knife"))) {
					System.out.println("Input weapon(knife/kalashnikov/sniper) :");
					inputWeapon = sc.next();
					
				 }
				player.setWeaponInHand(inputWeapon);
				if(player.getWeaponInHand() == null) {
					System.out.println("Input weapon(knife/kalashnikov/sniper) :");
					inputWeapon = sc.next();
					while ((!inputWeapon.equals("sniper")) && (!inputWeapon.equals("kalashnikov"))
							&& (!inputWeapon.equals("knife"))) {
						System.out.println("Input weapon(knife/kalashnikov/sniper) :");
						inputWeapon = sc.next();
					 }
					player.setWeaponInHand(inputWeapon);
				}
			}
		
		if (player.getLives() != 0) {
			System.out.println();
			System.out.println("Setup second Player");
			
			System.out.println("Input nickname");
			String nickname1 = sc.next();
			System.out.println("Input number of lives");
			int lives1 = sc.nextInt();
			System.out.println("Input score");
			int score1 = sc.nextInt();
			System.out.println("Input health");
			int health1 = sc.nextInt();
			//player2.initHealth(nbHealth1);
			//player2.initPlayer(nickname1, nbLives1 , score1);
			player2 = new PlayerStatus(nickname1, lives1, score1, health1);
			System.out.println("Input weapon(knife/kalashnikov/sniper) :");
			String inputWeapon1 = sc.next();
			if(player.getScore() <1000 || player2.getScore() < 1000) {
				System.out.println("Not enough points!N");
			} else {
				while ((!inputWeapon1.equals("sniper")) && (!inputWeapon1.equals("kalashnikov")) 
						&& (!inputWeapon1.equals("knife"))) {
					System.out.println("Input weapon(knife/kalashnikov/sniper) :");
					inputWeapon1 = sc.next();
				}
				player2.setWeaponInHand(inputWeapon1);
				if(player2.getWeaponInHand() == null) {
					System.out.println("Input weapon(knife/kalashnikov/sniper) :");
					inputWeapon1 = sc.next();
						while ((!inputWeapon1.equals("sniper")) && 
								(!inputWeapon1.equals("kalashnikov"))
								&& (!inputWeapon1.equals("knife"))) {
							System.out.println("Input weapon(knife/kalashnikov/sniper) :");
							inputWeapon1 = sc.next();
						 }
					player2.setWeaponInHand(inputWeapon);
				}
			}
			System.out.println("Input X coordinate:");
			int pos1OnX = sc.nextInt();
			System.out.println("Input Y coordinate:");
			int pos2OnY = sc.nextInt();
			player2.movePlayerTo(pos1OnX, pos2OnY);
			
			System.out.println("Player " + nickname1 + " found an artifact!" + 
			" Input artifact code:");
			int artifactCode1 = sc.nextInt();
			player2.findArtifact(Methods.generateArtifact(artifactCode1));
			if(player2.getScore() > 1000 && player2.getWeaponInHand() == null) {
				System.out.println("Input weapon(knife/kalashnikov/sniper) :");
				 inputWeapon = sc.next();
					while ((!inputWeapon.equals("sniper")) && (!inputWeapon.equals("kalashnikov"))
							&& (!inputWeapon.equals("knife"))) {
						System.out.println("Input weapon(knife/kalashnikov/sniper) :");
						inputWeapon = sc.next();
						
					 }
					player.setWeaponInHand(inputWeapon);
					if(player.getWeaponInHand() == null) {
						System.out.println("Input weapon(knife/kalashnikov/sniper) :");
						inputWeapon = sc.next();
						while ((!inputWeapon.equals("sniper")) && (!inputWeapon.equals("kalashnikov"))
								&& (!inputWeapon.equals("knife"))) {
							System.out.println("Input weapon(knife/kalashnikov/sniper) :");
							inputWeapon = sc.next();
						 }
						player.setWeaponInHand(inputWeapon);
					}
				}
			
			
			System.out.print("Probability to win for player " + nickname1 + " ");	 
			System.out.println(player2.probability(player2.getHealth(), player2.getScore()));
		}
		
		System.out.println("Do you want to start the game?? Press Y to start!!");
		String startGame = sc.next().toUpperCase();
		
		if (startGame.equals("Y")) {
		
		System.out.println("Start game : " + PlayerStatus.getGameName());
		System.out.print("Distance between the two player on battlefield is: ");
		System.out.println(player.distanceBetweenPlayers(player2));
		System.out.println("Can Player1 attack Player2 ?");
	
			if (player.shouldAttackOponent(player2)) {
				System.out.println(player.getNickname() + " has a really good chance to kill " 
			+ player2.getNickname());
				System.out.println(player.getNickname() + " started to attack " 
			+ player2.getNickname());
				player.attackTheOponent(player2);
				
			} else {
				System.out.println("It's not the right time for " + player.getNickname()  +
						" to attack " + player2.getNickname());
			}
		}
		
		
		 while (!startGame.equals("Y")) {
			 System.out.println("Please press Y to start the game!!");
			 System.out.println("Do you want to start the game?? Press Y to start!!");
			 startGame = sc.next().toUpperCase();
		 }
		 sc.close();
	}
	
		
}


