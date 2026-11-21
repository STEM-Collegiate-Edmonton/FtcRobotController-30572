package org.firstinspires.ftc.teamcode.drive_code_1.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.drive_code_1.drivetrain;

@Autonomous(name="auto2", group="auto2")
public class auto_2 extends OpMode {
    drivetrain drivetrain = null;
    private void pause(double time) {
        ElapsedTime timer = new ElapsedTime();
        timer.reset();
        while (timer.time() < time) {
            telemetry.addData("Time remaining", timer.time());
            telemetry.update();
        }
    }
    public void init() {
        drivetrain = new drivetrain(hardwareMap);
        drivetrain.init();
        telemetry.addLine("Initialized");
        telemetry.addLine("Timed Autonomous V1.1");
        telemetry.update();
    }
    public void start() {
        telemetry.addLine("Auto started");
        telemetry.update();
        drivetrain.mecanumDrive(1, 0, 0);
        pause(0.15);
        drivetrain.mecanumDrive(0, 0, 0);
        pause(0.25);
        drivetrain.mecanumDrive(0, -1, 0);
        pause(0.35);
        drivetrain.mecanumDrive(0, 0, 0);
        telemetry.addLine("Auto complete");
        telemetry.update();
    }
    public void loop() {}
}
