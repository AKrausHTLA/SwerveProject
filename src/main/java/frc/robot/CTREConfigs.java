package frc.robot;

import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.sensors.AbsoluteSensorRange;
import com.ctre.phoenix.sensors.CANCoderConfiguration;
import com.ctre.phoenix.sensors.SensorInitializationStrategy;
import com.ctre.phoenix.sensors.SensorTimeBase;

import frc.robot.constants.DriveConstants;

public final class CTREConfigs {
    public TalonFXConfiguration swerveAngleFXConfig;
    public TalonFXConfiguration swerveDriveFXConfig;
    public CANCoderConfiguration swerveCanCoderConfig;

    public CTREConfigs(){
        swerveAngleFXConfig = new TalonFXConfiguration();
        swerveDriveFXConfig = new TalonFXConfiguration();
        swerveCanCoderConfig = new CANCoderConfiguration();

        /* Swerve Angle Motor Configurations */
        SupplyCurrentLimitConfiguration angleSupplyLimit = new SupplyCurrentLimitConfiguration(
            DriveConstants.Swerve.angleEnableCurrentLimit, 
            DriveConstants.Swerve.angleContinuousCurrentLimit, 
            DriveConstants.Swerve.anglePeakCurrentLimit, 
            DriveConstants.Swerve.anglePeakCurrentDuration);

        swerveAngleFXConfig.slot0.kP = DriveConstants.Swerve.kAngleP;
        swerveAngleFXConfig.slot0.kI = DriveConstants.Swerve.kAngleI;
        swerveAngleFXConfig.slot0.kD = DriveConstants.Swerve.kAngleD;
        swerveAngleFXConfig.slot0.kF = DriveConstants.Swerve.kAngleF;
        swerveAngleFXConfig.supplyCurrLimit = angleSupplyLimit;

        /* Swerve Drive Motor Configuration */
        SupplyCurrentLimitConfiguration driveSupplyLimit = new SupplyCurrentLimitConfiguration(
            DriveConstants.Swerve.driveEnableCurrentLimit, 
            DriveConstants.Swerve.driveContinuousCurrentLimit, 
            DriveConstants.Swerve.drivePeakCurrentLimit, 
            DriveConstants.Swerve.drivePeakCurrentDuration);

        swerveDriveFXConfig.slot0.kP = DriveConstants.Swerve.kDriveP;
        swerveDriveFXConfig.slot0.kI = DriveConstants.Swerve.kDriveI;
        swerveDriveFXConfig.slot0.kD = DriveConstants.Swerve.kDriveD;
        swerveDriveFXConfig.slot0.kF = DriveConstants.Swerve.kDriveF;        
        swerveDriveFXConfig.supplyCurrLimit = driveSupplyLimit;
        swerveDriveFXConfig.openloopRamp = DriveConstants.Swerve.openLoopRamp;
        swerveDriveFXConfig.closedloopRamp = DriveConstants.Swerve.closedLoopRamp;
        
        /* Swerve CANCoder Configuration */
        swerveCanCoderConfig.absoluteSensorRange = AbsoluteSensorRange.Unsigned_0_to_360;
        swerveCanCoderConfig.sensorDirection = DriveConstants.Swerve.canCoderInvert;
        swerveCanCoderConfig.initializationStrategy = SensorInitializationStrategy.BootToAbsolutePosition;
        swerveCanCoderConfig.sensorTimeBase = SensorTimeBase.PerSecond;
    }
}