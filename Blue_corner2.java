package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

//@Autonomous(name = "Blue_Corner_Vortex_Position_2", group = "Rise Robot")

/**
 * Created by rpcardosimd on 11/8/16.
 */
@Disabled
public class Blue_corner2 extends OpMode {
    //naming the DcMotors
    private DcMotor left_back_drive;
    DcMotor left_front_drive;
    DcMotor right_back_drive;
    DcMotor right_front_drive;


    public void init() {

        left_back_drive = hardwareMap.dcMotor.get("1");//name these motors 1 and 2
        left_front_drive = hardwareMap.dcMotor.get("2");
        left_front_drive.setDirection(DcMotor.Direction.REVERSE);// set these motors to go forward
        left_back_drive.setDirection(DcMotor.Direction.REVERSE);


        right_back_drive = hardwareMap.dcMotor.get("3");//name these motors 3 and 4
        right_front_drive = hardwareMap.dcMotor.get("4");
        right_back_drive.setDirection(DcMotor.Direction.FORWARD);//reverse these motors
        right_front_drive.setDirection(DcMotor.Direction.FORWARD);

//resetting the encoders
        left_back_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        left_front_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);// reset encoders
        right_back_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_front_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        left_back_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        left_front_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);// use encoders while the motors are running
        right_back_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right_front_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        resetStartTime();
    }


    public void loop() {


        float currentR = right_front_drive.getCurrentPosition(); //get encoder values
        float currentL = left_back_drive.getCurrentPosition();

        telemetry.addData("right_encoders", currentR);//display encoder values
        telemetry.addData("left_encoders", currentL);


        left_back_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);// make robot go to the target position set below
        left_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_back_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        right_back_drive.setTargetPosition(7000);//setting the motors to go to the position 7000
        right_front_drive.setTargetPosition(7000);//setting the motors to go to the position 7000
        left_back_drive.setTargetPosition(10000);//setting the motors to go to the position 10000
        left_front_drive.setTargetPosition(10000);//setting the motors to go to the position 10000


        left_back_drive.setPower(0.77);//setting the motor power to 0.2
        left_front_drive.setPower(0.77);//go forward
        right_back_drive.setPower(0.3);
        right_front_drive.setPower(0.3);
        getRuntime();
        if (time >= 8.7) {
            requestOpModeStop();
        }
    }
}