// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Encoder;

import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.CANCoder;

public class SwerveModule extends SubsystemBase {
  private WPI_TalonFX driveMotor;
  private WPI_TalonFX steerMotor;

  private final CANCoder driveEncoder;
  private final CANCoder steerEncoder;

  private final PIDController steerPID;

  private final AnalogInput absoluteEncoder;
  private final boolean absoluteEncoderReversed;
  private final double absoluteEncoderOffsetRad;
  
  public SwerveModule(int driveMotorID, int steerMotorID, boolean driveMotorReversed, boolean steerMotorReversed, int absoluteEncoderID, double absoluteEncoderOffset, boolean absoluteEncoderReversed) {
    
    this.absoluteEncoderOffsetRad = absoluteEncoderOffset;
    this.absoluteEncoderReversed = absoluteEncoderReversed;
    absoluteEncoder = new AnalogInput(Constants.SwerveModuleConstants.absoluteEncoderID);

    driveMotor = new WPI_TalonFX(Constants.SwerveModuleConstants.driveMotorID);
    steerMotor = new WPI_TalonFX(Constants.SwerveModuleConstants.steerMotorID);

    driveMotor.setInverted(driveMotorReversed);
    steerMotor.setInverted(steerMotorReversed);

    driveMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    steerMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);

    driveEncoder = new CANCoder(Constants.SwerveModuleConstants.driveEncoderID);
    steerEncoder = new CANCoder(Constants.SwerveModuleConstants.steerEncoderID);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
