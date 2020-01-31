package P1;
import java.util.Random;
public class Main2 {
	public static int generateRandomInt(int upperRange){
	    Random random = new Random();
	    return random.nextInt(upperRange);
	}
	public static void main(String[] args) {
		
		PlayerStatus Player = new PlayerStatus("alex", 10, 88800, 100);
		PlayerStatus Player2 = new PlayerStatus();
		
		//Player.initHealth(25);
		Player2.initHealth(20);
		//Player.initPlayer("alex",4,22000);
		//Player2.initPlayer("pl2", 4, 25000);
		
		
		System.out.println(Player.setWeaponInHand("sniper"));
		System.out.println(Player.getWeaponInHand());
		System.out.println(generateRandomInt(12));
	
		/*Player2.setWeaponInHand("kalashnikov");
		System.out.println(Player.getWeaponInHand());
		Player.findArtifact(12);
		Player2.findArtifact(13);
		System.out.println(Player.getScore());
		System.out.println(Player.getHealth());
		System.out.println(Player.probability(Player.getHealth(), Player.getScore()));
		System.out.println(Player2.probability(Player2.getHealth(),Player2.getScore()));
		Player.movePlayerTo(30,100);
		Player2.movePlayerTo(10,30);
		System.out.println(Player.distanceBetweenPlayers(Player2) );
		System.out.println(Player.shouldAttackOponent(Player2));
		*/
	}

}
