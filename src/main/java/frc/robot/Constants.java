/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

package frc.robot;

public final class Constants {
  
  /** CONSTANTS FOR USE IN ROBOT CONTAINER **/
  public static class controllerConst {
    // Controller USB Constants
    public static final int kDriveJoystickUSB = 0; // Driver Joystick is currently programmed to be flight stick in USB Slot 0 (In Driverstation Menu)
    public static final int kOpJoystickUSB = 1; // Operator Joystick is currently programmed to be Xbox Controler in USB Slot 1 (In Driverstation Menu)
    // Deadband for controller axis inputs
    public static final double kDriveAxisZDeadband = 0.08; // Driver Stick Twist Deadband
    public static final double kDriveAxisYDeadband = 0.10; // Driver Stick Forward/Backward Deadband
    public static final double kOpAxisLeftYDeadband = 0.10; // Op Xbox Left Stick Forward/Backward Deadband
    public static final double kOpAxisRightYDeadband = 0.10; // Op Xbox Right Stick Forward/Backward Deadband
  }
  
  /** CONSTANTS FOR USE IN POSITIONING BOOM/COLUMN FOR GRID HEIGHTS **/
  public static class posConst {
    /* Angles are derived from the negative Z-axis in a CCW sweep.
     *                      ||----\
     *    Robot \/          ||     \
     *          ================    \
                |    X  O      |     \
     *    ----- ================      \==    <- Boom Arm
     *    Y             |
     *                  | Z -> (+ Angle)
     */
    // Emergency Stow Position
    public static final double kStowBoom = 90; // [Degrees]
    public static final double kStowColm = 0; // [Inches]
    
    // Pickup Position (From SUBSTATION)
    public static final double kSubstBoom = 80; // [Degrees]
    public static final double kSubstColm = 3; // [Inches]
    
    // Pickup Position (From FLOOR)
    public static final double kPickupBoom = 40; // [Degrees]
    public static final double kPickupColm = 2; // [Inches]

    // Middle GRID Position
    public static final double kMidBoom = 75; // [Degrees]
    public static final double kMidColm = 6; // [Inches]

    // Top GRID Position
    public static final double kTopBoom = 140; // [Degrees]
    public static final double kTopColm = 11.5; // [Inches]

    // Floor GRID Position
    public static final double kBotBoom = 50; // [Degrees]
    public static final double kBotColm = 0; // [Inches]

    // MAX BOOM AND COLUMN POSITIONS
    public static final double kMaxBoom = 160; // [degrees] From floor to max robot height 4'8"
    public static final double kMaxColm = 11.5; // [Inches] Max Forward Position
    
    // MIN BOOM AND COLUMN POSITION
    public static final double kMinBoom = 30; // [degrees] At floor
    public static final double kMinColm = 0; // [Inches] Max Reverse Position
    
    // Column Inch Position Conversion Constant
    public static final double kMaxColmLength = 11.5625; // [Inches] Full travel from rev switch to fwd switch
    public static final int kMaxColmEncCount = 9000; // [Pulses] Full travel from rev switch to fwd switch
    public static final double kColmCountPerInch = kMaxColmEncCount / kMaxColmLength; // [Pulse/Inch] Conversion constant to go between encoder counts and inches
    
    // Boom Angle Position Conversion Constant
    public static final double kBoomCalAngle = 90.0; // [Degrees] Arbitrary angle to calibrate the boom arm to
    public static final int kBoomCalCount = 2400; // [Pulses] Arbitrary encoder count from zero to kBoomCalAngle degrees
    public static final double kBoomCountPerDegree = kBoomCalCount / kBoomCalAngle; // [Pulse/Degree] Conversion constant to go between encoder counts and degrees
  }

  /** CONSTANTS FOR USE IN THE COLUMN SUBSYSTEM **/
  public static class columnConst {
    // Talon CAN ID
    public static final int ktalon_column = 15;
    // Talon SRX command deadband zone (Different then joystick deadband zone)
    public static final double kDeadbandColumn = 0.05;
    // Encoder PID Stuff
    public static final int kSlotidx = 0;
    public static final int kPIDidx = 0;
    public static final double kF = 0.0; // Open Loop (???)
    public static final double kP = 2.0; // Proportional Constant (oomph to apply to difference in setpoint and actual position)
    public static final double kI = 0.0; // Integral Constant (Accumulation of error from setpoint)
    public static final double kD = 0.0; // Derivative Constant (Smoothness of change in command)
    public static final int kEncoderCPR = 4096; // [Pulses/Revolution of Encoder] Constant with quadrature encoders

    // motor speed limiters (MOSTLY USED IN AUTO TO UNFOLD)
    public static final double SPEED_FORWARD = 0.5; // [Percent]
    public static final double SPEED_BACKWARD = 0.5; // [Percent]

    // Column rear limit switch for reseting encoder
    public static final int kswitchRev_column = 0;
    public static final int kswitchFwd_column = 1;
  }

  /** CONSTANTS FOR USE IN THE BOOM SUBSYSTEM **/
  public static class boomConst {
    // Talon CAN ID
    public static final int ktalon_boom = 16;
    // Talon SRX command deadband zone (Different then joystick deadband zone)
    public static final double kDeadbandBoom = 0.05;
    // Talon SRX Arbitrarty Feedback for Gravity (NEED TO INCLUDE WEIGHT OF CONE)
    public static final double karbitraryBoom = -0.085;
    // Encoder PID Stuff
    public static final int kSlotidx = 0;
    public static final int kPIDidx = 0;
    public static final double kF = 0.0; // Open Loop (???)
    public static final double kP = 2.0; // Proportional Constant (oomph to apply to difference in setpoint and actual position)
    public static final double kI = 0.0; // Integral Constant (Accumulation of error from setpoint)
    public static final double kD = 0.0; // Derivative Constant (Smoothness of change in command)
    public static final int kEncoderCPR = 4096; // [Pulses/Revolution of Encoder] Constant with quadrature encoders
    public static final double kGearRatio = 1 / 200; // Gear Ratio from Encoder to positional movment of mechanism
    public static final boolean kSensorPhase = true;
    
    public static final double kFloorAngle = 10; // COMMENT THIS OUT
    public static final double kMaxAngle = 150; //COMMENT THIS OUT
    
    // Speed reducer commands (MOSTLY USED IN AUTO TO UNFOLD)
    public static final double SPEED_UP = 0.5; // [Percent]
    public static final double SPEED_DOWN = 0.5; // [Percent]

    // Boom rear limit switch for reseting encoder
    public static final int kswitch_boom = 2;
  }

  /** CONSTANTS FOR USE IN THE INTAKE SUBSYSTEM **/
  public static class intakeConst {
    // Talon CAN ID
    public static final int ktalon_intake = 17;
    // Talon SRX command deadband zone
    public static final double kDeadbandIntake = 0.05;
    // Speed reducer commands
    public static final double SPEED_IN = 0.75; // [Percent]
    public static final double SPEED_OUT = 0.55; // [Percent]
  }

  /** CONSTANTS FOR USE IN THE CLAMP SUBSYSTEM **/
  public static class clampConst {
    // Talon CAN ID
    public static final int ktalon_clamp = 18;
    // Talon SRX command deadband zone
    public static final double kDeadbandClamp = 0.05;
    // Encoder PID Stuff
    public static final int kSlotidx = 0;
    public static final int kPIDidx = 0;
    public static final double kF = 0.0; // Open Loop (???)
    public static final double kP = 0.1; // Proportional Constant (oomph to apply to difference in setpoint and actual position)
    public static final double kI = 0.001; // Integral Constant (Accumulation of error from setpoint)
    public static final double kD = 0.0; // Derivative Constant (Smoothness of change in command)
    // Clamp Current Setpoint
    public static final double kCurrentClamp = 3.0; // [Amps]
    public static final double kCurrentWatch = 5.6; // [Amps]
    // Speed reducer commands
    public static final double SPEED_CLAMP = 0.7; // [Percent]
    public static final double SPEED_RELEASE = 0.7; // [Percent]
  }

  /** CONSTANTS FOR USE IN THE DRIVETRAIN SUBSYSTEM **/
  public static class driveConst {
    // Talon CAN IDs
    public static final int ktalon_FR = 14;
    public static final int ktalon_FL = 13;
    public static final int ktalon_RR = 12;
    public static final int ktalon_RL = 11;
    // Pidgey 1.0 CAN ID
    public static final int kpidgey = ktalon_RL; // Not on CAN so this doesnt apply. Only assign an INT ID number when wired directly to CAN
    // Talon SRX command deadband zone
    public static final double kDeadbandLeft = 0.15;
    public static final double kDeadbandRight = 0.10;
    // Encoder PID Stuff
    public static final int kSlotidx = 0;
    public static final int kPIDidx = 0;
    public static final double kLeftP = 2.0;
    public static final double kLeftI = 0.0;
    public static final double kLeftD = 0.0;
    // Position Math
    public static final int kEncoderCPR = 4096; // Stadard pulse/rev for ctre encoder
    public static final double kWheelDiameter = 6.01; // Inches
    public static final double kEncDistancePerPulse = 
        // Assumes encoders are mounted on wheel shafts
        (kWheelDiameter * Math.PI) / (double) kEncoderCPR; // inch per encoder count
        // For 6 inch wheels:
        // 1 Encoder Revolution = 4096 Encoder Counts = 1 Wheel Revolution = 18.84956 Travel Distance (Inches)
        // To use:
        // Have Counts but Need Inches - RawEncoder * kEncDistancePerPulse
        // Have Inches but Need Counts - Inches / kEncDistancePerPulse

    // Speed reducer commands
    public static final double SPEED_TURN = 0.65; // Max straight speed percentage (positive constant)  // [Percent]
    public static final double SPEED_STRT = 0.85; // Max straight speed percentage (positive constant)  // [Percent]
  }
}
