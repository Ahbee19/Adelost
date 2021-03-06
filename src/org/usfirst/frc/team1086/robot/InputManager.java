package org.usfirst.frc.team1086.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Utility;

/**
 * Manages inputs for code. Not truly necessary, but it clears a lot up.
 */
public class InputManager {

    Joystick leftStick;
    Joystick rightStick;
    Joystick auxStick;

    boolean elevatorOverrideToggle;
    boolean turningOverrideToggle;
    boolean tippingOverrideToggle;

    public InputManager(){
        leftStick = new Joystick(0);
        rightStick = new Joystick(1);
        auxStick = new Joystick(5);
    }

    public boolean getSafety() {
        return leftStick.getRawButton(ButtonMap.SAFETY);
    }
    public double getDrive() {
        return -leftStick.getY() * Math.abs(leftStick.getY());
    }
    public double getTurn() {
        return rightStick.getX() * Math.abs(rightStick.getX());
    }
    public boolean getIntake(){
        return auxStick.getRawButton(ButtonMap.INTAKE);
    }
    public boolean getEvict() {
        return auxStick.getRawButton(ButtonMap.EVICT);
    }
    public boolean getElevatorSafety() { return auxStick.getRawButton(ButtonMap.SAFETY); }
    public double getElevator(){
        return Math.abs(auxStick.getY()) * auxStick.getY();
    }
    public boolean getElevatorGround() { return auxStick.getRawButton(ButtonMap.ELEVATOR_1);}
    public boolean getElevatorScale() { return auxStick.getRawButton(ButtonMap.ELEVATOR_SCALE); }
    public boolean getElevatorSwitch() { return auxStick.getRawButton(ButtonMap.ELEVATOR_SWITCH); }
    public boolean getClimber() {
    	return rightStick.getRawButton(ButtonMap.CLIMBER);
    }
    public boolean getKick() {
    	return rightStick.getRawButton(ButtonMap.KICK);
    }
    public boolean unKick() {
    	return rightStick.getRawButton(ButtonMap.UNKICK);
    }
    public boolean getClimberRelease(){
        return Utility.getUserButton();
    }
    public boolean getElevatorOverride(){
        return auxStick.getRawButtonPressed (ButtonMap.ELEVATOR_OVERRIDE) ? elevatorOverrideToggle = !elevatorOverrideToggle : elevatorOverrideToggle;
    }
    public boolean getDriveStraightOverride(){
        return rightStick.getRawButtonPressed (ButtonMap.DRIVE_STRAIGHT_OVERRIDE) ? turningOverrideToggle = !turningOverrideToggle: turningOverrideToggle;
    }
    public boolean getTipCorrectionOverride(){
        return rightStick.getRawButtonPressed (ButtonMap.TIP_CORRECTION_OVERRIDE) ? tippingOverrideToggle = !tippingOverrideToggle: tippingOverrideToggle;
    }
    public int getDeltaArm(){
        return (auxStick.getRawButton(ButtonMap.ARM_UP) ? 1 : 0) - (auxStick.getRawButton(ButtonMap.ARM_DOWN) ? 1 : 0);
    }
    public double manualArm(){
        return (auxStick.getRawButton(ButtonMap.MANUAL_ARM_DOWN)) ? 0.5 : 0;

    }
    public double getOuttakeSpeed(){
        return (auxStick.getZ() + 1.0) / 2.0;
    }
}
