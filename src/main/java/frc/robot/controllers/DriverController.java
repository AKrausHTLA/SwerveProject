package frc.robot.controllers;

import frc.robot.constants.ControllerConstants;

import edu.wpi.first.wpilibj.XboxController;

public class DriverController {
    private final XboxController mController;

    public DriverController() {
        mController = new XboxController(ControllerConstants.kDriverControllerPort);
    }
    
    public double getTranslationAxis() {
        return mController.getLeftY();
    }

    public double getStrafeAxis() {
        return mController.getLeftX();
    }

    public double getRotationAxis() {
        return mController.getRightX();
    }

    public boolean getZeroGyro() {
        return mController.getYButton();
    }

    public boolean getRobotCentric() {
        return mController.getLeftBumper();
    }
    
    public XboxController getController() {
        return mController;
    }
}


