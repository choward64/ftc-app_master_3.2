package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.subsystems.ServoManagement2;

/**
 * Created by choward64 on 12/14/2017.
 */

//code needs comments ALWAYS comment code
    @TeleOp(name = "Main TeleOp", group = "Hyperactive")
public class Hyperactive_1 extends OpMode{
    DcMotor left_back_drive;
    DcMotor left_front_drive;
    DcMotor right_back_drive;
    DcMotor right_front_drive;
    DcMotor arm;
    Servo l_claw;
    Servo r_claw;
    ServoManagement2 srvo;


    public void init(){
        //naming drive motors and setting their direction
        left_back_drive = hardwareMap.dcMotor.get("1");
        left_front_drive = hardwareMap.dcMotor.get("2");
        left_back_drive.setDirection(DcMotor.Direction.FORWARD);
        left_front_drive.setDirection(DcMotor.Direction.FORWARD);


        right_back_drive = hardwareMap.dcMotor.get("3");
        right_front_drive = hardwareMap.dcMotor.get("4");
        right_back_drive.setDirection(DcMotor.Direction.REVERSE);
        right_front_drive.setDirection(DcMotor.Direction.REVERSE);
    }
    public void loop(){

        float throttle_left = gamepad1.left_stick_y;
        float throttle_right = gamepad1.right_stick_y;

        left_back_drive.setPower(throttle_left);
        left_front_drive.setPower(throttle_left);
        right_back_drive.setPower(throttle_right);
        right_front_drive.setPower(throttle_right);

// Range clipping so the code won't crash the app
        throttle_left = Range.clip(throttle_left, -1, 1);
        throttle_right = Range.clip(throttle_right, -1, 1);

        //assigning the servos to the bumpers
        if (gamepad1.left_bumper) {
            if (!srvo.l_claw) {
                srvo.leftPusher(1);
            }
        } else if (!gamepad1.left_bumper) {
            if (srvo.l_claw) {
                srvo.leftPusher(0);
            }
        }
        if (gamepad1.right_bumper) {
            if (!srvo.r_claw) {
                srvo.rightPusher(1);
            }
        } else if (!gamepad1.right_bumper) {
            if (!srvo.r_claw); {
                srvo.rightPusher(0);
            }
        }

    }
}
