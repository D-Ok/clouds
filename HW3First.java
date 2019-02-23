/*
/ * Дарина Олійник
 * 4 група
 * шахи
 */
import stanford.karel.*;

public class HW3First extends SuperKarel{

	public void run(){
		go();
		goHome();
	}

// Шлях через весь світ
	private void go() {
		if (frontIsClear()){
		while (frontIsClear()){
			putTheBeepers();
			if (leftIsBlocked()){
				break;
			}
			turnWhileMoveEast();
			putTheBeepers();
			if (rightIsBlocked()){
				break;
			}
			turnWhileMoveWest();
			}
		} else {
			putTheBeepers();
		}
		
	}
	
// Карел розставляє біпери
	private void putTheBeepers() {
		putBeeper();
		if ( frontIsBlocked() ) {
			turnLeft();
		}
		while (frontIsClear()) {
			move();
			if (frontIsClear()){
			move();
			putBeeper();
			}
		}
		
		
	}
// поворот Карела, якщо він дивиться на Схід
	private void turnWhileMoveEast() {
		if (beepersPresent()) {
			turnEast();
			move();
		} else {
			turnEast();
		}
		
	}
// за яких умов відбувається поворот наліво
	private void turnEast() {
		turnLeft();
		if (frontIsClear()){
			move();
			}
			turnLeft();
		
	}

// Поворот Карела, якщо він дивиться на Захід
	private void turnWhileMoveWest() {
		if (beepersPresent()) {
			turnWest();
			move();
		} else {
			turnWest();
		}
		
	}
// за яких умов відбувається поворот направо
	private void turnWest() {
			turnRight();
			if (frontIsClear()){
				move();
				}  
				turnRight();
		
	}
//Карел стає у верхню праву клітинку
	private void goHome() {
		if (facingWest()) {
			turnAround();
			while (frontIsClear()){
				move();
			}
		}
		if (facingNorth()){
			turnRight();
		}
		
	}
}
