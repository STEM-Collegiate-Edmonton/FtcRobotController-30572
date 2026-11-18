package org.firstinspires.ftc.teamcode.drive_code_1;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class launcher {
    public final int LAUNCHER_TARGET_VELOCITY = 1175; //2678 RPM
    public final int LAUNCHER_MIN_VELOCITY = 1150; //2571 RPM

    private DcMotorEx launcher = null;

    public void init() {
        launcher.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
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

    public launcher(HardwareMap hardwareMap) {
        launcher = hardwareMap.get(DcMotorEx.class, "launcher");
        launcher.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
    }
}
