package frc.robot.commands;

import frc.robot.constants.DriveConstants;
import frc.robot.constants.ControllerConstants;
import frc.robot.subsystems.Swerve;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class TeleopSwerve extends CommandBase {    
    private Swerve m_Swerve;    
    private DoubleSupplier translationSup;
    private DoubleSupplier strafeSup;
    private DoubleSupplier rotationSup;
    private BooleanSupplier robotCentric;

    public TeleopSwerve(Swerve m_Swerve, DoubleSupplier translationSup, DoubleSupplier strafeSup, DoubleSupplier rotationSup, BooleanSupplier robotCentric) {
        this.m_Swerve = m_Swerve;
        addRequirements(m_Swerve);

        this.translationSup = translationSup;
        this.strafeSup = strafeSup;
        this.rotationSup = rotationSup;
        this.robotCentric = robotCentric;
    }

    @Override
    public void execute() {
        /* Get Values, Deadband*/
        double translationVal = MathUtil.applyDeadband(translationSup.getAsDouble(), ControllerConstants.kJoystickThreshold);
        double strafeVal = MathUtil.applyDeadband(strafeSup.getAsDouble(), ControllerConstants.kJoystickThreshold);
        double rotationVal = MathUtil.applyDeadband(rotationSup.getAsDouble(), ControllerConstants.kJoystickThreshold);

        /* Drive */
        m_Swerve.drive(
            new Translation2d(translationVal, strafeVal).times(DriveConstants.Swerve.maxSpeed), 
            rotationVal * DriveConstants.Swerve.maxAngularVelocity, 
            !robotCentric.getAsBoolean(), 
            true
        );
    }
}