package org.firstinspires.ftc.teamcode.example_code;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class windmill {
    private Servo windmillServo = null;

    public void init() {
        windmillServo.setPosition(0);
        windmillServo.setDirection(Servo.Direction.REVERSE);
    }

    public void rotate(int direction) {
        windmillServo.setPosition(windmillServo.getPosition() + (90 * direction));
    }

    public void set_angle(double angle) {
        windmillServo.setPosition(angle);
    }

    public windmill(HardwareMap hardwareMap) {
        windmillServo = hardwareMap.get(Servo.class, "windmillServo");
    }
}
