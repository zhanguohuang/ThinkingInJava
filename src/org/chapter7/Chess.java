package org.chapter7;

class Game{
	Game(){
		System.out.println("Game constructor");
	}
	Game(String s){
		System.out.println("Game constructor "+s);
	}
}
class BoardGame extends Game{
	BoardGame(){
		System.out.println("Board constructor");
	}
	BoardGame(String s){

		System.out.println("Board constructor "+s);
	}
}
public class Chess extends BoardGame{
	Chess(){
		super("string1");
		System.out.println("Chess constructor");
	}
	public static void main(String[] args) {
		new Chess();
	}
}
