package org.team2168.subsystems;

import org.team2168.RobotMap;
import org.team2168.commands.DriveRobot;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
	
	private static Drivetrain instance = null;
	
	private static Victor LeftMotorVictor;
	private static Victor RightMotorVictor;
	
	private static Talon RightMotorTalons;
	private static Talon LeftMotorTalons;
	
	private static Encoder RightEncoder;
	private static Encoder LeftEncoder;
	
	private Drivetrain() {
		LeftMotorVictor = new Victor(RobotMap.LEFT_MOTOR_VICTOR);
		LeftMotorTalons = new Talon(RobotMap.LEFT_MOTOR_TALONS);
		
		RightMotorVictor = new Victor(RobotMap.RIGHT_MOTOR_VICTOR);
		RightMotorTalons = new Talon(RobotMap.RIGHT_MOTOR_TALONS);
		
		RightEncoder = new Encoder(RobotMap.RIGHT_MOTOR_ENCODER_A,
				RobotMap.RIGHT_MOTOR_ENCODER_B);
		LeftEncoder = new Encoder(RobotMap.LEFT_MOTOR_ENCODER_A,
				RobotMap.LEFT_MOTOR_ENCODER_B);
		
	}
	
	/**
	 * Singleton design pattern. Only allow one drivetrain to be created, EVER!
	 * @return The instance of the Drivetrain class
	 */
	public static Drivetrain getInstance() {
		if(instance == null) {
			instance = new Drivetrain();
		}
		
		return instance;
	}
    
    public void driveLeftMotor(double speed) {
    	LeftMotorVictor.set(speed);
    	LeftMotorTalons.set(speed);
    }
    
    public void driveRightMotor(double speed) {
    	RightMotorVictor.set(speed);
    	RightMotorTalons.set(speed);
    }
    
    public void driveRobot(double leftSpeed, double rightSpeed) {
    	driveLeftMotor(leftSpeed);
    	driveRightMotor(rightSpeed);
    }

    public int getLeftEncoder() {
    	return LeftEncoder.get();
    }
    
    public int getRightEncoder() {
    	return RightEncoder.get();
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new DriveRobot());
    }
    
    
}

