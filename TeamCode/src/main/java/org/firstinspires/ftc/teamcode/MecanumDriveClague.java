package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Mecanum Drive For Bio Buzz wowowowowowowowowowowowowowowowowowowowoowowowowwowowowowowowowo")
public class MecanumDriveClague extends LinearOpMode {
    private DcMotor motorFL;
    private DcMotor motorBL;
    private DcMotor motorFR;
    private DcMotor motorBR;

    @Override
    public void runOpMode() {
        // Initialize the motor using the hardware map
        motorBR = hardwareMap.get(DcMotor.class, "MotorBR");
        motorBL = hardwareMap.get(DcMotor.class, "MotorBL");
        motorFR = hardwareMap.get(DcMotor.class, "MotorFR");
        motorFL = hardwareMap.get(DcMotor.class, "MotorFL");

        motorBR.setDirection(DcMotorSimple.Direction.REVERSE);
        motorFR.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBL.setDirection(DcMotorSimple.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            // Get Input And process
            double inputX = gamepad1.left_stick_x;
            double inputY = gamepad1.left_stick_y;
            double rot = gamepad1.right_stick_x;

            double powerFL = inputY + inputX - rot;
            double powerBR = inputY - inputX + rot;
            double powerBL = inputY - inputX - rot;
            double powerFR = inputY + inputX + rot;

            motorFR.setPower(powerFR);
            motorFL.setPower(powerFL);
            motorBR.setPower(powerBR);
            motorBL.setPower(powerBL);

            telemetry.update();
        }
    }
}
