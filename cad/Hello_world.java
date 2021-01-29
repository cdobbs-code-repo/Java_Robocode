package cad;
import robocode.*;
import java.awt.Color;
import java.lang.Math; 

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Hello_world - a robot by (your name here)
 */
public class Hello_world extends Robot
{
	/**
	 * run: Hello_world's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			turnRadarLeft(30);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(1);
		double myvar = e.getBearing();
		if (Math.abs(myvar) > 7) { 
			if (Math.random() < 0.7)
				turnLeft(myvar*-1-90);
			else
				turnRight(myvar*-1-90);
			ahead(100);
		}
		double absol_bearing = getHeading() + myvar;
		// turn gun towards enemy if necessary
		if (Math.abs(absol_bearing - getGunHeading()) > 3){
			double temp = absol_bearing - getGunHeading();
			if (temp > 0){
				turnGunRight(temp);
			}
			else{
				turnGunLeft(Math.abs(temp));
			}
		}
		fire(1);
		fire(1);
		fire(2);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		//f/ire(1);
		turnRadarLeft(30);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		//back(20000);
		double temp = e.getBearing();
		if (temp < 0){
			turnRight(85);
			turnRadarLeft(30);
		}
		else{
			turnLeft(85);
			turnRadarLeft(30);
		}
	}	
}
