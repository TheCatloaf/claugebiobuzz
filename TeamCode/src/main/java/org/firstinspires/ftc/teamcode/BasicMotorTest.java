package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Simple Motor Control", group = "Linear OpMode")
public class SimpleMotorOpMode extends LinearOpMode {

    private DcMotor motor1;

    @Override
    public void runOpMode() {
        // Initialize the motor using the hardware map
        motor1 = hardwareMap.get(DcMotor.class, "motor1");

        // Set the motor to brake when power is set to 0
        motor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            // Calculate motor power using the trigger values
            double power = (0.2 * gamepad1.left_trigger) + gamepad1.right_trigger;

            // Send the power to the motor
            motor1.setPower(power);

            // Display the current power on the Driver Station
            telemetry.addData("Motor Power", power);
            telemetry.update();
        }
    }
}
