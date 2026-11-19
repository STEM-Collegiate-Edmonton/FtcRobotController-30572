package org.firstinspires.ftc.teamcode.drive_code_1.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.drive_code_1.drivetrain;

@Autonomous(name="auto1R", group="auto1")
public class auto_1R extends OpMode {
    drivetrain drivetrain = null;
    public void init() {
        drivetrain = new drivetrain(hardwareMap);
        drivetrain.init();
        telemetry.addLine("Initialized");
        telemetry.addLine("Timed Autonomous V1");
        telemetry.update();
    }
    public void loop() {
        telemetry.addLine("Auto started");
        telemetry.update();
        drivetrain.mecanumDrive(0, -1, 0);
        try {
            wait(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        drivetrain.mecanumDrive(0, 0, 0);
        telemetry.addLine("Auto complete");
        telemetry.update();
    }
}
