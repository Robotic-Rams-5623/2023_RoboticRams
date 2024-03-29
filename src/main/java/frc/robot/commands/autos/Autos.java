
package frc.robot.commands.autos;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.Constants.posConst;
import frc.robot.commands.BoomPosition;
import frc.robot.subsystems.Boom;
import frc.robot.subsystems.Clamp;
import frc.robot.subsystems.Column;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.StartEndCommand;


public final class Autos {

  /*
   * JUST UNFOLD THE BOOM AND COLUMN. NOTHING ELSE
   */
  public static CommandBase unfoldAuto(Boom boom, Column column) {
    return Commands.sequence(
      new unfold(column, boom)
    );
  }

  /*
   * DRIVE STRAIGHT 52 INCHES. DONT UNFOLD
   */
  public static CommandBase driveStraightAuto(Drivetrain drive) {
    return Commands.sequence(
      new driveDistance(52.0, true, drive)
    );
  }

  /*
   * DRIVE STRAIGHT 52 INCHES AND UNFOLD THE BOOM AND COLUMN
   */
  public static CommandBase driveUnfoldAuto(Drivetrain drive, Boom boom, Column column) {
    return Commands.parallel(
      new unfold(column, boom),
      new driveDistance(52.0, true, drive)
    );
  }

  /*
   * UNFOLD AND DRIVE ONTO THE CHARGING PAD. BLANACE ON THE CHARGING PAD
   */
  public static CommandBase driveBalanceAuto(Drivetrain drive, Boom boom, Column column) {
    return Commands.sequence(
      new unfold(column, boom).withTimeout(3.2),
      new InstantCommand(drive::resetEncoder, drive).withTimeout(1.0),
      new driveDistance(75.0, false, drive).withTimeout(3.0),
      new InstantCommand(drive::setDriveBrake, drive).withTimeout(1.0),
      new driveBalance(drive.getPitch(), drive)
    );
  }

  /*
   * UNFOLD, DROP THE CUBE ON THE FLOOR, THEN DRIVE BACKWARDS
   */
  public static CommandBase cubeFloorAuto(Drivetrain drive, Boom boom, Column column, Clamp clamp, Intake intake) {
    return Commands.sequence(
      new unfold(column, boom).withTimeout(5.0), // Unfold to home positions
      new ParallelCommandGroup( // Open and outtake
        new StartEndCommand(intake::outake, intake::stop, intake),
        new StartEndCommand(clamp::unclamp, clamp::stop, clamp)
        ).withTimeout(2.0),
      new BoomPosition(posConst.kMidBoom, boom).withTimeout(3.0),
      new driveDistance(60.0, false, drive).withTimeout(6.0)
    );
  }

  /*
   * UNFOLD, DROP THE CUBE ON THE MID GRID, THEN DRIVE BACKWARDS
   */
  public static CommandBase cubeMidAuto(Drivetrain drive, Boom boom, Column column, Clamp clamp, Intake intake) {
    return Commands.sequence(
      new unfold(column, boom).withTimeout(5.0), // Unfold to home positions
      new BoomPosition(posConst.kMidBoom, boom).withTimeout(3.0),
      new ParallelCommandGroup( // Open and outtake
        new StartEndCommand(intake::outake, intake::stop, intake),
        new StartEndCommand(clamp::unclamp, clamp::stop, clamp)
        ).withTimeout(2.0),
      new driveDistance(60.0, false, drive).withTimeout(6.0)
    );
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
