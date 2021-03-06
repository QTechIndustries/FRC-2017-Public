/**
 * TalonSRX Native Units
 * Native velocity units are counts/100ms
 * Native position units are counts
 * Native current units are milliAmps
 * Control loops run at 1kHz (period = 1ms)
 * Output units are -1023 to 1023
 */
package org.usfirst.frc.team1592.arch.utils;

import com.ctre.CANTalon;

public class CANTalonPID {
	//kF: Feed-forward 	[outputUnits/nativeUnits]
	//kP: Proportional	[outputUnits/nativeUnits]
	//kI: Integral		[outputUnits/nativeUnits/1ms]
	//kD: Derivative	[outputUnits/nativeUnits*1ms]
	//kIz: I-Zone 		[native units]
	public double kF, kP, kI, kD;
	public int kIz;
	
	public CANTalonPID(double kP, double kI, double kD) {
		this(kP, kI, kD, 0, 0);
	}
	
	public CANTalonPID(double kP, double kI, double kD,double kF) {
		this(kP, kI, kD, kF, 0);
	}

	public CANTalonPID(double kP, double kI, double kD,double kF, int kIz) {
		this.kF = kF;
		this.kP = kP;
		this.kI = kI;
		this.kD = kD;
		this.kIz = kIz;
	}
	
	/**
	 * Apply the PID Parameters to the specified CANTALON motor controller
	 * @param motor
	 */
	public void applyConstants(CANTalon motor) {
		motor.setPID(kP, kI, kD);
		motor.setF(kF);
		motor.setIZone(kIz);
		
	}
}
