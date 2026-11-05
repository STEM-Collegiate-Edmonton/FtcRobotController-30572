package org.firstinspires.ftc.teamcode.example_code;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class windmill {
    private Servo windmillServo = null;
    private int rotate_stage = 0;

    public void init() {
        windmillServo.setPosition(0);
        windmillServo.setDirection(Servo.Direction.REVERSE);
    }

    public void rotate() {
        rotate_stage += 1;
        if (rotate_stage  == 5) {
            rotate_stage = 0;
        }
        windmillServo.setPosition(rotate_stage * 90);
    }

    public void set_angle(double angle) {
        windmillServo.setPosition(angle);
    }

    public windmill(HardwareMap hardwareMap) {
        windmillServo = hardwareMap.get(Servo.class, "windmillServo");
    }
}
