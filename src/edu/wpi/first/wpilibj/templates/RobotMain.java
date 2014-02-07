/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.SimpleRobot;

public class RobotMain extends SimpleRobot {
    
    
    Joystick stick = new Joystick(1);
    Compressor compressor = new Compressor(1, 1);
    Relay singleSolenoid;
    Relay doubleSolenoid;
    
    public void robotInit() {
        compressor.start();
        
        singleSolenoid = new Relay(2);
        doubleSolenoid = new Relay(3);
    }
    
    public void operatorControl() {
        while(this.isOperatorControl() && this.isEnabled()){
            singleSolenoid.set(stick.getRawButton(1)?Value.kForward:Value.kOff);
            doubleSolenoid.set(stick.getRawButton(1)?Value.kForward:Value.kReverse);
        }
    }
}
