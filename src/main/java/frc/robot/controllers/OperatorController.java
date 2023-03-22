package frc.robot.controllers;

import frc.robot.constants.ControllerConstants;

import edu.wpi.first.wpilibj.XboxController;

public class OperatorController {
    private final XboxController mController;

    public OperatorController(){
        mController = new XboxController(ControllerConstants.kOperatorControllerPort);
    }
}
