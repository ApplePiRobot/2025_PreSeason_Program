// package frc.robot.subsystems;

// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
// import frc.robot.commands.FalconRun;

// public class Controls extends SubsystemBase{
//     private static Controls instance = null;

//     private static final int CONTROLLER_PORT = 0;
//     private final CommandXboxController m_Controller;

//     public static Controls getInstance(){
//         if (instance == null){
//             instance = new Controls();
//         }
//         return instance;
//     }

//     private Controls(){
//         m_Controller = new CommandXboxController(CONTROLLER_PORT);
//         configControllerBindings();
//     }

//     private void configControllerBindings(){
//         m_Controller.a().onTrue(new FalconRun(90.00));
//         m_Controller.a().onFalse(new FalconRun(0.00));
//     }
// }
