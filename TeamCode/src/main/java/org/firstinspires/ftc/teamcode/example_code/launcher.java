package org.firstinspires.ftc.teamcode.example_code;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

public class launcher {
    public final int LAUNCHER_TARGET_VELOCITY = 1250; //2678 RPM
    public final int LAUNCHER_MIN_VELOCITY = 1200; //2571 RPM
    private DcMotorEx launcher = null;

    public void init() {
        launcher.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        launcher.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, new PIDFCoefficients(40, 0, 0, 12.5));
    }

    public void set_velocity(double velocity) {
        launcher.setVelocity(velocity);
    }

    public boolean spin(boolean accelerate) {
        if (accelerate) {
            launcher.setVelocity(LAUNCHER_TARGET_VELOCITY);
        } else {
            launcher.setVelocity(0);
        }
        return (launcher.getVelocity() > LAUNCHER_MIN_VELOCITY);
    }

    public double get_velocity() {
        return (launcher.getVelocity());
    }
}
