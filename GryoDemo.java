package ev3.exercises.library;
	import ev3.exercises.library.*;
	import lejos.hardware.Button;
	import lejos.hardware.Sound;
	import lejos.hardware.motor.*;
	import lejos.hardware.port.*;
	import lejos.utility.Delay;
public class GryoDemo {

	{
	    public static void  main (String[] args);
	    {
	        GyroSensor    gyro = new GyroSensor(SensorPort.S2);

	        System.out.println("Gyro Demo");
	        System.out.println("Press to start");

	        Button.LEDPattern(4); 
	        Sound.beepSequenceUp();   

	        Button.waitForAnyPress();

	        while (Button.ESCAPE.isUp())
	        {
	            Lcd.clear(5);
	            Lcd.print(5, "angle=%d av=%.3f", gyro.getAngle(), gyro.getAngularVelocity());

	            Delay.msDelay(250);
	        }
	        gyro.close();

	        Sound.beepSequence(); 
	    }
	}
}
