/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  /**
   * Creates a new DriveSubsystem.
   */
  public WPI_TalonSRX leftMaster = new WPI_TalonSRX(Constants.leftMasterPort) ; 
  public WPI_TalonSRX leftSlave = new WPI_TalonSRX(Constants.leftSlavePort) ; 
  public WPI_TalonSRX rightMaster = new WPI_TalonSRX(Constants.rightMasterPort) ; 
  public WPI_TalonSRX rightSlave = new WPI_TalonSRX(Constants.rightSlavePort) ; 

  public DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);
   
  public DriveSubsystem() {
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);
  }

  public void arcadeDrive(double move, double turn){
    drive.arcadeDrive(move, turn);
  }
  
  public void manualDrive(double move, double turn) {
    if (Math.abs(move) < 0.1) move = 0;
    if (Math.abs(turn) < 0.1) turn = 0;
    drive.arcadeDrive(move, turn);
  } 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
