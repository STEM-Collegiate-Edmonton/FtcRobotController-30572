package org.firstinspires.ftc.teamcode.drive_code_1;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "two driver teleop", group = "drive1")
public class two_driver_teleop extends OpMode {
    drivetrain drivetrain = null;
    intake intake = null;
    launcher launcher = null;
    windmill windmill = null;
    //underglow underglow = null;
    boolean fire;
    boolean field_relative = true;
    boolean spin_up= false;
    ElapsedTime inputTimer = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);
    @Override
    public void init() {
        drivetrain = new drivetrain(hardwareMap);
        intake = new intake(hardwareMap);
        launcher = new launcher(hardwareMap);
        windmill = new windmill(hardwareMap);
        //underglow = new underglow(hardwareMap);

        drivetrain.init();
        intake.init();
        launcher.init();
        windmill.init();
        telemetry.addLine("Initialized");
        telemetry.addLine("Two Driver Teleop V1.5.2");
        telemetry.update();
        inputTimer.reset();
    }

    @Override
    public void loop(){
        //underglow.update();
        telemetry.addLine("TeleOp active");
        if (field_relative) {
            telemetry.addLine("Field relative drive");
        } else {
            telemetry.addLine("Robot relative drive");
        }
        telemetry.addData("Axial", -gamepad1.left_stick_y);
        telemetry.addData("Lateral", gamepad1.left_stick_x);
        telemetry.addData("Yaw", gamepad1.right_stick_x);
        telemetry.addData("Intake", gamepad1.left_trigger - gamepad1.right_trigger);
        if (field_relative) {
            drivetrain.fieldRelativeDrive(-gamepad1.left_stick_y, gamepad1.left_stick_x, -gamepad1.right_stick_x);
        } else {
            drivetrain.mecanumDrive(-gamepad1.left_stick_y, gamepad1.left_stick_x, -gamepad1.right_stick_x);
        }
        intake.set_power(gamepad1.left_trigger - gamepad1.right_trigger);
        fire = gamepad2.b;
        telemetry.addLine("\nLauncher Data");
        if (gamepad1.xWasPressed() && gamepad1.left_bumper) {
            drivetrain.resetHeading();
        }
        if (gamepad1.x && gamepad1.right_bumper && !gamepad1.left_bumper && inputTimer.time() > 500) {
            inputTimer.reset();
            field_relative = !field_relative;
        }
        if (gamepad2.dpad_up) {
            windmill.set_power(-1);
        } else if (gamepad2.dpad_down) {
            windmill.set_power(1);
        } else {
            windmill.set_power(0);
        }
        if (gamepad2.dpadLeftWasPressed()) {
            launcher.set_target(launcher.LAUNCHER_TARGET_VELOCITY - 50, launcher.LAUNCHER_MIN_VELOCITY - 50, launcher.LAUNCHER_MAX_VELOCITY - 50);
        } else if (gamepad2.dpadRightWasPressed()) {
            launcher.set_target(launcher.LAUNCHER_TARGET_VELOCITY + 50, launcher.LAUNCHER_MIN_VELOCITY + 50, launcher.LAUNCHER_MAX_VELOCITY + 50);
        }

        if (gamepad2.yWasPressed()) {
            spin_up = !spin_up;
        }
        launcher.spin(spin_up || fire);

        if (fire) {
            if (launcher.get_velocity() > launcher.LAUNCHER_MIN_VELOCITY && launcher.get_velocity() < launcher.LAUNCHER_MAX_VELOCITY) {
                windmill.set_power(-1);
                telemetry.addData("Status", "FIRING");
            } else {
                telemetry.addData("Status", "ACCELERATING");
                windmill.set_power(0);
            }
        } else {
            windmill.set_power(0);
            if (spin_up) {
                if (launcher.get_velocity() > launcher.LAUNCHER_MIN_VELOCITY && launcher.get_velocity() < launcher.LAUNCHER_MAX_VELOCITY) {
                    telemetry.addData("Status", "STANDBY");
                } else {
                    telemetry.addData("Status", "ACCELERATING");
                }
            } else {
                if (launcher.get_velocity() <= 5) {
                    telemetry.addData("Status", "STATIONARY");
                } else {
                    telemetry.addData("Status", "DECELERATING");
                }
            }
        }

        telemetry.addData("Target", launcher.LAUNCHER_TARGET_VELOCITY);
        telemetry.addData("Velocity", launcher.get_velocity());
        telemetry.update();
    }
}
