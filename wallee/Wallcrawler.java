package wallee;
import robocode.*;
import java.lang.Math; 
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Wallcrawler - a robot by (your name here)
 */
public class Wallcrawler extends Robot
{
	/**
	 * run: Wallcrawler's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		setColors(Color.black,Color.yellow,Color.gray); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			//ahead(100);
			//turnGunRight(360);
			//back(100);
			//turnGunRight(360);
			ahead(100);
			turnGunRight(360);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		
		// turn gun towards enemy!
		//double angle_change = getGunHeading() - getRadarHeading();
		//if (Math.abs(angle_change) > 4){
		//	turnGunRight(angle_change-180);
		//}
		//...THEN fire.
		//fire_spread();
		for(int i = 0; i < 3; i += 1){
			fire_spread();
		}
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		//back(10);
		double bullet_angle = e.getHeading();
		double gun_angle = getGunHeading();
		turnGunRight(bullet_angle - gun_angle);
		fire_spread();
	}
	
	public void fire_spread(){
		fire(1);
		turnGunLeft(5);
		fire(1);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		
		// First, turn parallel to the wall 
		//IMPORTANT: we can just keep radar AND gun at getHeading()+90
		double wall_angle = e.getBearing();
		if (wall_angle > 0){
			turnLeft(10+90 - wall_angle);//sub 10 to make wallcrawler
		}else{
			turnRight(10+90 - Math.abs(wall_angle));//sub 10 to make wallcrawler
		}
		//double next_radar_ang = getHeading() + 90;
		//t/urnRadarRight(next_radar_ang - getRadarHeading());
		//turnGunRight(next_radar_ang - getGunHeading());
		
		// now move foward and spin radar at same time
		//while(true){
		//	ahead(10);
		//	turnRadarRight(30);
		//}
	}	
}
