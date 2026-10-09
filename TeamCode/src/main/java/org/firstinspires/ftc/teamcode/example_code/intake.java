package org.firstinspires.ftc.teamcode.example_code;

import static com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.BRAKE;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

public class intake {
    private DcMotor intake = null;
    private CRServo leftIntakeServo = null;
    private CRServo rightIntakeServo = null;
    double intakePower;

    public void init() {
        intake.setZeroPowerBehavior(BRAKE);
        leftIntakeServo.setPower(0);
        rightIntakeServo.setPower(0);
    }

    public void set_power(double power) {
        intake.setPower(power);
        leftIntakeServo.setPower(power);
        rightIntakeServo.setPower(power);
    }
}
