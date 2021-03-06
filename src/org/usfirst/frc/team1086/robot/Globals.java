package org.usfirst.frc.team1086.robot;

import java.io.File;

import edu.wpi.first.wpilibj.DigitalInput;
import org.usfirst.frc.team1086.CameraCalculator.PixyCamera;
import org.usfirst.frc.team1086.MotionProfiling.MotionProfiling;
import org.usfirst.frc.team1086.subsystems.Arm;
import org.usfirst.frc.team1086.subsystems.Climber;
import org.usfirst.frc.team1086.subsystems.Drivetrain;
import org.usfirst.frc.team1086.subsystems.Elevator;
import org.usfirst.frc.team1086.subsystems.Intake;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Globals {
	public static boolean isFinal = true;
	public static Drivetrain drivetrain;
	public static Elevator elevator;
	public static Arm arm;
	public static Intake intake;
	public static Gyro gyro;
	public static Logger logger;
	public static Climber climber;
	public static PixyCamera pixy;
	public static BalanceChecker balanceChecker;
	public static InputManager im;
	public static DigitalInput cubeDetector;
	public static NetworkTableEntry heading, speed, acceleration, left1Output, right1Output, intakeCurrent,
			left2Output, right2Output, elevatorHeight, armLocation, armCurrent, elevatorCurrent;
	public static MotionProfiling mp;

	public static void init() {
        im = new InputManager();
		drivetrain = new Drivetrain();
		gyro = new Gyro();
		gyro.gyro.reset();
		arm = new Arm();
		intake = new Intake();
		elevator = new Elevator();
		climber = new Climber();
		mp = new MotionProfiling();
		balanceChecker = new BalanceChecker();
		cubeDetector = new DigitalInput(0);
		drivetrain.init();

		NetworkTableInstance tableInstance = NetworkTableInstance.getDefault();
		NetworkTable table = tableInstance.getTable("Telemetry");
		Globals.heading = table.getEntry("Heading");
		Globals.speed = table.getEntry("Speed");
		Globals.acceleration = table.getEntry("Acceleration");
		Globals.left1Output = table.getEntry("Left 1 Output");
		Globals.right1Output = table.getEntry("Right 1 Output");
		Globals.left2Output = table.getEntry("Left 2 Output");
		Globals.right2Output = table.getEntry("Right 2 Output");
		Globals.elevatorHeight = table.getEntry("Elevator Height");
		Globals.armLocation = table.getEntry("Arm Location");
		Globals.armCurrent = table.getEntry("Arm Current");
		Globals.elevatorCurrent = table.getEntry("Elevator Current");
		Globals.intakeCurrent = table.getEntry("Intake Current");
	}
}
