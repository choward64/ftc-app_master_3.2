package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;


/**
 * Created by choward on 12/14/2017.
 */

public class ServoManagement2 {
    Servo claw1;
    Servo claw2;

    public static double currentPos;
    public static double initPos;
    public static boolean l_claw = true;
    public static boolean r_claw = true;

    Telemetry telemetry;

    public ServoManagement2(HardwareMap hardwareMap, Telemetry telemetry) {
        claw1 = hardwareMap.servo.get("l_claw");
        claw2 = hardwareMap.servo.get("r_claw");

    }
    public void leftPusher(double pos) {
        claw1.setPosition(pos);
        if (pos > 50) {
            l_claw = true;
        } else {
            l_claw = false;
        }
    }

    public void rightPusher(double pos) {
        claw2.setPosition(pos);
        if (pos > 50) {
            r_claw = true;
        } else {
            r_claw = false;
        }
    }
    }
