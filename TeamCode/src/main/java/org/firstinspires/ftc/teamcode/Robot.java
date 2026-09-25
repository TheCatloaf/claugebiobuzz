package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Robot {
    public DcMotor motorFL;
    public DcMotor motorBL;
    public DcMotor motorFR;
    public DcMotor motorBR;
    public DcMotor motorThrow;
    public Robot() {
        // Initialize the motor using the hardware map
        motorBR = hardwareMap.get(DcMotor.class, "MotorBR");
        motorBL = hardwareMap.get(DcMotor.class, "MotorBL");
        motorFR = hardwareMap.get(DcMotor.class, "MotorFR");
        motorFL = hardwareMap.get(DcMotor.class, "MotorFL");
        motorThrow = hardwareMap.get(DcMotor.class, "MotorThrow");

        motorBR.setDirection(DcMotorSimple.Direction.REVERSE);
        motorFR.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBL.setDirection(DcMotorSimple.Direction.REVERSE);
        motorThrow.setDirection(DcMotorSimple.Direction.REVERSE);
    }
}
