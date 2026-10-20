package org.firstinspires.ftc.teamcode.example_code;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "example teleop", group = "example")
public class master_teleop extends OpMode {
    drivetrain drivetrain = null;
    intake intake = null;
    launcher launcher = null;
    windmill windmill = null;
    @Override
    public void init() {
        drivetrain = new drivetrain(hardwareMap);
        intake = new intake(hardwareMap);
        launcher = new launcher(hardwareMap);
        windmill = new windmill(hardwareMap);
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
        drivetrain.mecanumDrive(-gamepad1.left_stick_y, gamepad1.left_stick_x, -gamepad1.right_stick_x);
        intake.set_power(gamepad1.left_trigger - gamepad1.right_trigger);
        telemetry.addLine("\nLauncher Data");
        if (gamepad1.a && launcher.get_velocity() > launcher.LAUNCHER_MIN_VELOCITY) {
            telemetry.addLine("FIRING");
            windmill.set_power(-1);
            intake.set_power(0.5);
        } else {
            windmill.set_power(0);
            telemetry.addLine("STANDBY");
            }
        if (gamepad1.right_bumper) {
            telemetry.addLine("ACCELERATING");
             launcher.spin(true);
        } else {
            telemetry.addLine("DECELERATING");
            launcher.spin(false);
        }
        telemetry.addData("Velocity", launcher.get_velocity());
        telemetry.update();
    }
}
