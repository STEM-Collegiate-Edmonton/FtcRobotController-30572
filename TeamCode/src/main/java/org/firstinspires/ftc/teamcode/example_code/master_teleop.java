package org.firstinspires.ftc.teamcode.example_code;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.util.Objects;

@TeleOp(name = "example teleop", group = "example")
public class master_teleop extends OpMode {
    drivetrain drivetrain = new drivetrain();
    intake intake = new intake();
    launcher launcher = new launcher();
    windmill windmill = new windmill();
    @Override
    public void init() {
        drivetrain.init();
        intake.init();
        launcher.init();
        windmill.init();
        telemetry.addLine("Initialized");
        telemetry.update();
    }

    @Override
    public void loop(){
        telemetry.addLine("TeleOp active");
        telemetry.addData("Axial", -gamepad1.left_stick_y);
        telemetry.addData("Lateral", gamepad1.left_stick_x);
        telemetry.addData("Yaw", gamepad1.right_stick_x);
        telemetry.addData("Intake", gamepad1.left_trigger - gamepad1.right_trigger);
        drivetrain.mecanumDrive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
        intake.set_power(gamepad1.left_trigger - gamepad1.right_trigger);
        telemetry.addLine("\nLauncher Data");
        if (gamepad1.a && launcher.get_velocity() > launcher.LAUNCHER_MIN_VELOCITY) {
            telemetry.addData("Status", "FIRING");
            windmill.set_power(1);
            intake.set_power(0.5);
        } else {
            windmill.set_power(0);
            if (gamepad1.right_bumper) {
                if (launcher.spin(true)) {
                    telemetry.addData("Status", "STANDBY");
                } else {
                    telemetry.addData("Status", "ACCELERATING");
                }
            } else {
                if (launcher.get_velocity() < 1) {
                    telemetry.addData("Status", "STATIONARY");
                } else {
                    telemetry.addData("Status", "DECELERATING");
                }
            }
        }
        telemetry.addData("Velocity", launcher.get_velocity());
        telemetry.update();
    }
}
