package org.firstinspires.ftc.teamcode.example_code;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;
import org.firstinspires.ftc.teamcode.Prism.GoBildaPrismDriver;

public class underglow {
    GoBildaPrismDriver prism;

    // ===== CHANGE THESE TO YOUR HARDWARE =====
    private static final int I2C_ADDRESS = 0x38;   // Example only
    private static final int REG_MODE = 0x00;      // Example only
    private static final int REG_BRIGHTNESS = 0x01; // Example only
    // ========================================

    private final int[] brightnessPattern = {0, 32, 64, 96, 128, 160, 192, 224, 255};
    private int patternIndex = 0;
    private double lastUpdate = 0.0;
    private static final double UPDATE_INTERVAL_SECONDS = 0.15; // 150 ms

    public underglow(HardwareMap hardwareMap) {
        prism = hardwareMap.get(GoBildaPrismDriver.class, "prism");

//        // Set a default state
//        setMode(1);
//        setBrightness(0);
    }

    public void setBrightness(int brightness) {
        int safeValue = Math.max(0, Math.min(255, brightness));
    }

    public void on() {
        setBrightness(255);
    }

//    public void off() {
//        setBrightness(0);
//    }

    public void update() {
        double now = System.currentTimeMillis() / 1000.0;

        if (now - lastUpdate >= UPDATE_INTERVAL_SECONDS) {
            lastUpdate = now;
            patternIndex = (patternIndex + 1) % brightnessPattern.length;
            setBrightness(brightnessPattern[patternIndex]);
        }
    }
}