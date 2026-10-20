package org.firstinspires.ftc.teamcode.example_code;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class windmill {
    private CRServo windmillServo = null;

    public void init() {
        windmillServo.setPower(0);
        windmillServo.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void set_power(double power) {
        windmillServo.setPower(power);
    }

    public windmill(HardwareMap hardwareMap) {
        windmillServo = hardwareMap.get(CRServo.class, "windmillServo");
    }
}
