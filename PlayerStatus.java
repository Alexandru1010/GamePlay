package P1;


public class PlayerStatus {
	
	private String nickname;
	private int score;
	private int lives;
	private int health;
	private int artifactCode;
	private String weaponInHand;
	private double positionX;
	private double positionY;
	private static String gameName;
	
	
	
	// Initialization
	public void initHealth(int newHealth) {
		this.health = newHealth;
	}
	
	public PlayerStatus() {
		
	}
	public  PlayerStatus(String newNickname) {
		this.nickname = newNickname;
	}
	
	public  PlayerStatus(String newNickname, int newLives) {
		this.nickname = newNickname;
		this.lives = newLives;
	}
	
	public  PlayerStatus(String newNickname, int newLives, 
						int newScore, int newHealth) {
		this.nickname = newNickname;
		this.score = newScore;
		this.lives = newLives;
		this.health = newHealth;
			if (this.health > 100) {
				this.health = 100;
			}
		System.out.println("Player " + getNickname() + " has " 
							+ getLives() + " lives " + ", " + getScore() +
							" points " + "and " + getHealth() + " health");
	}
	
	public int getScore() {
		return this.score;
	}
	public int getHealth() {
		return this.health;
	}
	public String getNickname() {
		return this.nickname;
	}
	
	public int getLives() {
		return this.lives;
	}
	
	// find Artifact
			 
	public int findArtifact(int artifactCode) {
		if (Methods.isPerfect(artifactCode)) {
			this.score += 5000;
			this.lives += 1;
			this.health = 100;
			System.out.println("Bonus! Now, player " + this.nickname + " has " 
			+ this.score + " points and " + this.health + " health!" );
		} else if (Methods.isPrime(artifactCode)) {
			this.score += 1000;
			this.lives += 2;
			this.health += 25;
				if (health > 100) {
					health =100;
				}
			System.out.println("Bonus! Now, player " + this.nickname + " has " 
				+ this.score + " points and " + this.health +  " health!" );
		} else if ((artifactCode % 2 == 0) && (Methods.digitSum(artifactCode) % 3 == 0)) {
			this.score -= 3000;
			this.health -= 25;
			
				if (this.health <= 0) {
					this.lives -= 1;
					this.health = 100;
				}
					if (this.lives == 0) {
						System.out.println("Game Over!");
						System.exit(0);
					}
					System.out.println("It's a Trap! Now, player " + this.nickname + " has "
							+ this.score + " points and " + this.health + " health!" );
		} else {
			this.score += artifactCode;
			System.out.println("Nothing special! Your score has been upgraded"
					+ " with artifact value: " + this.score );
		}
		
		return artifactCode;
		
	}
	
	// probability to win
	public int probability(int health, int score) {
		return (3 * this.health + this.score / 1000) / 4;
	}
	
	
	// Set weapon
	public String getWeaponInHand() {
		return this.weaponInHand;
	}


	public boolean setWeaponInHand(String weaponInHand) {
		if ((this.score > 999) && (weaponInHand.equals("knife"))) {
			this.weaponInHand = weaponInHand;
			this.score -= 1000;
			System.out.println("Player has a new weapon: " + weaponInHand);
			System.out.println("New score: " + this.score);
			return true;
		} else if (this.score < 999) {
			System.out.println("Not enough points!");
			return false;
		}
		
		if ((this.score > 9999) && (weaponInHand.equals("sniper"))) {
			this.weaponInHand = weaponInHand;
			this.score -= 10000;
			System.out.println("Player has a new weapon: " + weaponInHand);
			System.out.println("New score: " + this.score);
			return true;
		} else if ((this.score < 9999) && (this.score > 999)) {
			System.out.println("Not enough points!");
			return false;
		}
		
		if ((this.score > 19999) && (weaponInHand.equals("kalashnikov"))) {
			this.weaponInHand = weaponInHand;
			this.score -= 20000;
			System.out.println("Player has a new weapon: " + weaponInHand);
			System.out.println("New score: " + this.score);
			return true;
		} else if ((this.score < 19999) && (this.score > 9999)) {
			System.out.println("Not enough points!");
			return false;
		}
		
		return false;
		
	}
	
	// Position
	
	public double getPositionX() {
		return this.positionX;
	}

	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}

	public double getPositionY() {
		return this.positionY;
	}

	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	public void movePlayerTo(double positionX, double positionY) {
		setPositionX(positionX);
		setPositionY(positionY);
		System.out.println("Player position is: " + "(" + getPositionX() + 
							", " + getPositionY() + ")");
	}
	
	
	 public double distanceBetweenPlayers(PlayerStatus newPlayer)  {
			double coordinateDiferenceOnX = this.getPositionX() - newPlayer.getPositionX();
			double coordinateDiferenceOnY = this.getPositionY() - newPlayer.getPositionY();
			return Math.sqrt((Math.pow(coordinateDiferenceOnX, 2) +
							 Math.pow(coordinateDiferenceOnY, 2)));
	 }
	 
	// gameName - class properties
	
	 static String getGameName() {
		return PlayerStatus.gameName;
	}
	
	 static void setGameName(String newGameName) {
		PlayerStatus.gameName = newGameName;
	}
	
	// battle
	 public boolean shouldAttackOponent(PlayerStatus oponent) {
		String weaponForPlayer1 = this.getWeaponInHand();
		String weaponForPlayer2 = oponent.getWeaponInHand();
		String weapon1 = "sniper";
		String weapon2 = "kalashnikov";
		String weapon3 = "knife";
		int probabilityP1 = this.probability(this.getHealth(), this.getScore());
		int probabilityP2 = oponent.probability(oponent.getHealth(), oponent.getScore());
		
		if( (weaponForPlayer1.equals(weaponForPlayer2)) && (probabilityP1 > probabilityP2) ) {
			return true;
		}
		
		if ((!weaponForPlayer1.equals(weaponForPlayer2)) && (distanceBetweenPlayers(oponent) > 1000)) {
			if  ((weaponForPlayer1.equals(weapon1)) && ((weaponForPlayer2.equals(weapon2)) || 
					(weaponForPlayer2.equals(weapon3)))) {
				return true;
			} else if ((weaponForPlayer1.equals(weapon2)) && (weaponForPlayer2.equals(weapon3))) {
				return true;
			}
		}
		
		if ((!weaponForPlayer1.equals(weaponForPlayer2)) && (distanceBetweenPlayers(oponent) <= 1000)) {
			if ((weaponForPlayer1.equals(weapon2)) && ((weaponForPlayer2.equals(weapon1)) ||
					(weaponForPlayer2.equals(weapon3)))) {
				return true;
			} else if ((weaponForPlayer1.equals(weapon1)) && (weaponForPlayer2.equals(weapon3))) {
				return true;
			}
		}
		return false;
	 }
	 
	 public void attackTheOponent(PlayerStatus otherPlayer) {
		 if (this.shouldAttackOponent(otherPlayer)) {
			 if (Methods.isPerfect(this.artifactCode)) {
				 System.out.println(("Head Shot!"));
				 otherPlayer.lives -= 3;
				 otherPlayer.score -= 3500;
				 if (otherPlayer.lives <= 0) {
						System.out.println(otherPlayer.getNickname() + " has died!");
						System.out.println("Game Over!");
						System.exit(0);
				 }
			 } else if (Methods.isPrime(this.artifactCode)) {
				 System.out.println("Body Shot!");
				 otherPlayer.lives -= 2;
				 otherPlayer.score -= 2500;
				 if (otherPlayer.lives <= 0) {
						System.out.println(otherPlayer.getNickname() + " has died!");
						System.out.println("Game Over!");
						System.exit(0);
				 }
			 } else {
				 System.out.println("Minor hit!");
				 otherPlayer.health -= 50;
				 otherPlayer.score -= 1500;
				 	if ((otherPlayer.health <= 0) || (otherPlayer.health < 0)){
						otherPlayer.lives -= 1;
						otherPlayer.health = 100;
					}
						if (otherPlayer.lives <= 0) {
							System.out.println(otherPlayer.getNickname() + " has died!");
							System.out.println("Game Over!");
							System.exit(0);
						}
			 }
		}
		 System.out.println("Succesfull Attack!!" + "\n" + "After attack, player: " + 
				 			otherPlayer.getNickname() + " has " + otherPlayer.getLives() +
				 			" lives " +  otherPlayer.getHealth()+ " health " + 
				 			" and " +  otherPlayer.getScore() + " score!");
	} 
}
