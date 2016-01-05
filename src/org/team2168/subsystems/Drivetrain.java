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
	
	Victor LeftMotorVictor;
	Victor RightMotorVictor;
	
	Talon RightMotorTalons;
	Talon LeftMotorTalons;
	
	Encoder RightEncoder;
	Encoder LeftEncoder;
	
	public Drivetrain() {
		
		LeftMotorVictor = new Victor(RobotMap.LEFT_MOTOR_VICTOR);
		LeftMotorTalons = new Talon(RobotMap.LEFT_MOTOR_TALONS);
		
		RightMotorVictor = new Victor(RobotMap.RIGHT_MOTOR_VICTOR);
		RightMotorTalons = new Talon(RobotMap.RIGHT_MOTOR_TALONS);
		
		RightEncoder = new Encoder(RobotMap.RIGHT_MOTOR_ENCODER_A, RobotMap.RIGHT_MOTOR_ENCODER_B);
		LeftEncoder = new Encoder(RobotMap.LEFT_MOTOR_ENCODER_A, RobotMap.LEFT_MOTOR_ENCODER_B);
		
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

