package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.Robot;


@Config
@TeleOp(name = "Mecanuprivatem Drive For Bio Buzz")
public class MecanumDriveClague extends LinearOpMode {

    volatile static double TURN_SPRINT_SPEED = 0.8;
    volatile static double TURN_SLOW_SPEED = 0.5;
    volatile static double MOVE_SPRINT_SPEED = 1;
    volatile static double MOVE_SLOW_SPEED = 0.6;
    final static double THROW_MOTOR_SPEED_IDLE = 0.4;
    final static double THROW_MOTOR_SPEED_LAUNCH = 0.8;
    final static long THROW_MOTOR_WARMUP_TIME_MS = 100;

    private Robot robot;


    private boolean isThrowing;
    private long throwDate;

    @Override
    public void runOpMode() {
        robot = new Robot();

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            tick();
            telemetry.update();
        }
    }

    private void tick() {
        // Moving
        double moveSpeed = gamepad1.a ? MOVE_SPRINT_SPEED : MOVE_SLOW_SPEED;
        double turnSpeed = gamepad1.a ? TURN_SPRINT_SPEED : TURN_SLOW_SPEED;

        double inputX = gamepad1.left_stick_x;
        double inputY = gamepad1.left_stick_y;
        double rot = gamepad1.right_stick_x;

        double powerFL = ((inputY + inputX) * moveSpeed) - rot;
        double powerBR = ((inputY - inputX) * moveSpeed) + (rot * turnSpeed);;
        double powerBL = ((inputY - inputX) * moveSpeed) - (rot * turnSpeed);
        double powerFR = ((inputY + inputX) * moveSpeed) + (rot * turnSpeed);;

        robot.motorFR.setPower(powerFR);
        robot.motorFL.setPower(powerFL);
        robot.motorBR.setPower(powerBR);
        robot.motorBL.setPower(powerBL);

        // Breaking
        if (gamepad1.b) {
            robot.motorBR.setPower(0);
            robot.motorBL.setPower(0);
            robot.motorFR.setPower(0);
            robot.motorFL.setPower(0);
            robot.motorBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            robot.motorBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            robot.motorFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            robot.motorFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        } else {
            robot.motorBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            robot.motorBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            robot.motorFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            robot.motorFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        }

        // Throwing
        long now = System.nanoTime();
        boolean throwInput = gamepad1.left_trigger > 0.5;
        if (throwInput && !isThrowing) {
            throwDate = now + THROW_MOTOR_WARMUP_TIME_MS * 1000;
        } else if (isThrowing && throwInput && now >= throwDate) {
            robot.servoThrowLeft.setPower(1);
            robot.servoThrowRight.setPower(1);
        } else {
            robot.servoThrowLeft.setPower(0);
            robot.servoThrowRight.setPower(0);
        }
        isThrowing = throwInput;

        robot.motorThrow.setPower(isThrowing ? THROW_MOTOR_SPEED_LAUNCH : THROW_MOTOR_SPEED_IDLE);
    }
}
