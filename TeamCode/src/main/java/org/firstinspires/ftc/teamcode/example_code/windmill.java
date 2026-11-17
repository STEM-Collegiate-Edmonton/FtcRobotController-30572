package org.firstinspires.ftc.teamcode.example_code;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class windmill {
<<<<<<< Updated upstream
    private Servo windmillServo = null;
    private int rotate_stage = 0;
=======
    private CRServo windmillServo = null;
>>>>>>> Stashed changes

    public void init() {
        windmillServo.setPower(0);
        windmillServo.setDirection(DcMotorSimple.Direction.REVERSE);
    }

<<<<<<< Updated upstream
    public void rotate() {
        rotate_stage += 1;
        if (rotate_stage  == 5) {
            rotate_stage = 0;
        }
        windmillServo.setPosition(rotate_stage * 90);
=======
    public void set_power(double power) {
        windmillServo.setPower(power);
>>>>>>> Stashed changes
    }

    public void set_power(int power) {
        windmillServo.setPower(power);
    }

    public windmill(HardwareMap hardwareMap) {
        windmillServo = hardwareMap.get(CRServo.class, "windmillServo");
    }
}
