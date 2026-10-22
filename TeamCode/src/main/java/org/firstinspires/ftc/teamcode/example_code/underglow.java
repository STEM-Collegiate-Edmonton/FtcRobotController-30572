package org.firstinspires.ftc.teamcode.example_code;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class underglow {
    private Servo prismServo = null;

//    public void init() {
//        prismServo.setPosition(0);
//    }

    public static void set_position(double position) {
        prismServo.setPosition(position);
    }

    public underglow(HardwareMap hardwareMap) {
        prismServo = hardwareMap.get(Servo.class, "prismServo");
    }
}
