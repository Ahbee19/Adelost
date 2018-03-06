package org.usfirst.frc.team1086.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Ultrasonic implements PIDSource {
	AnalogInput a;
	public Ultrasonic(int p){
		a = new AnalogInput(p);
	}
	public double get(){
		return a.getValue() / 89.0 * 12.0;
	}
	public double pidGet(){
		return get();
	}
	public void setPIDSourceType(PIDSourceType p){}
	public PIDSourceType getPIDSourceType(){
		return PIDSourceType.kDisplacement;
	}
	public void log() {
		SmartDashboard.putNumber("ultrasonic", get());
	}
}
