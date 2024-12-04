package frc.robot.subsystems;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.fasterxml.jackson.databind.node.NullNode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import io.github.oblarg.oblog.Loggable;

public class Elevator extends SubsystemBase implements Loggable {
    private static Elevator instance = null;
    
    private static double FALCON_500_MAX_SPEED_RPS = 6380/60;

    //physical prop
    public static final double MAX_EXTENSION_INCHES = 0.0;
    private static final double GEAR_RATIO = 0.0; 
    private static final double OUTPUT_SPROCKET_PITCH_RADIUS_INCHES = 0.0;

    private static final double HOLD_POSITION_VOLTAGE = 0.0;

    private static final double ALLOWABLE_ERROR_INCHES = 0.0;

    private static final CurrentLimitsConfigs CURRENT_LIMITS_CONFIGS = new CurrentLimitsConfigs()
        .withSupplyCurrentLimit(0)
        .withSupplyCurrentThreshold(0)
        .withSupplyTimeThreshold(0);

    private final TalonFX m_leftMotor;
    private final TalonFX m_rightMotor;

    private Elevator() {
        m_leftMotor = new TalonFX(1);
        m_rightMotor = new TalonFX(2);

        setUpMotor(m_leftMotor, InvertedValue.CounterClockwise_Positive);
        setUpMotor(m_rightMotor, InvertedValue.CounterClockwise_Positive);

    }

    private static final Slot0Configs PID_GAINS = new Slot0Configs() 
        .withKV(0.0)
        .withKP(0.0);

    
    private static final MotionMagicConfigs MOTION_MAGIC_CONFIGS = new MotionMagicConfigs()
        .withMotionMagicCruiseVelocity(0.0)
        .withMotionMagicAcceleration(0.0);

    private void setUpMotor(TalonFX motor, InvertedValue invert) {
        motor.getConfigurator().apply(new TalonFXConfiguration());
        motor.setNeutralMode(NeutralModeValue.Brake);

        motor.getConfigurator().apply(PID_GAINS);

        motor.getConfigurator().apply(CURRENT_LIMITS_CONFIGS);    

        motor.getConfigurator().apply(MOTION_MAGIC_CONFIGS);
    }
}
