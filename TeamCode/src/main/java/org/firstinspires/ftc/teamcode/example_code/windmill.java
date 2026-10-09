package org.firstinspires.ftc.teamcode.example_code;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class windmill {
    private CRServo windmillServo = null;

    public void init() {
        windmillServo.setPower(0);
        windmillServo.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void set_power(double power) {
        windmillServo.setPower(power);
    }
}
