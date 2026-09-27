package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.CRServo;


public class Robot {
    public DcMotor motorFL;
    public DcMotor motorBL;
    public DcMotor motorFR;
    public DcMotor motorBR;
    public DcMotor motorThrow;
    public DcMotor motorIn1;
    public DcMotor motorIn2;
    public CRServo servoThrowLeft;
    public CRServo servoThrowRight;
    public Robot() {
        // Initialize the motor using the hardware map
        motorBR = hardwareMap.get(DcMotor.class, "MotorBR");
        motorBL = hardwareMap.get(DcMotor.class, "MotorBL");
        motorFR = hardwareMap.get(DcMotor.class, "MotorFR");
        motorFL = hardwareMap.get(DcMotor.class, "MotorFL");
        motorThrow = hardwareMap.get(DcMotor.class, "MotorThrow");
        motorIn1 = hardwareMap.get(DcMotor.class, "MotorIn1");
        motorIn2 = hardwareMap.get(DcMotor.class, "MotorIn2");
        servoThrowLeft = hardwareMap.get(CRServo.class, "ServoThrowLeft");
        servoThrowRight = hardwareMap.get(CRServo.class, "ServoThrowRight");


        motorBR.setDirection(DcMotorSimple.Direction.REVERSE);
        motorFR.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBL.setDirection(DcMotorSimple.Direction.REVERSE);
        motorThrow.setDirection(DcMotorSimple.Direction.REVERSE);

        // North = front of bot
        // For motors BR FR BL and FL, positive power means clockwise rotation when view on the east side of the bot.
        // That means it will move forward. if all 4 motors are powered positively
        // Intake is on the southern side. Outtake is on the northern side.
        // Limelight is mounted at the NORTH.
        // For motors Throw, In1, and In2, and servos ThrowLeft and Throw Right positive power means balls being launched
        // From south to north, intake to outtake.
        // Intake is on the southern side. Outtake is on the northern side.
    }
}
