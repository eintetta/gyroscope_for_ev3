package ev3.exercises.library;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.robotics.Gyroscope;
import lejos.robotics.SampleProvider;

public class GyroSensor implements Gyroscope
{
	EV3GyroSensor	sensor;
	SampleProvider	sp;
    	float [] 	sample;
    	int 		offset = 0;

	public GyroSensor(Port port)
	{
		sensor = new EV3GyroSensor(port);
		sp = sensor.getAngleAndRateMode();
		sample = new float[sp.sampleSize()];
		sensor.reset();
	}
	public EV3GyroSensor getSensor()
	{
		return sensor;
	}
	public float getAngularVelocity()
	{
       		sp.fetchSample(sample, 0);
  
       		return sample[1];
	}
	public int getAngle()
	{
       		sp.fetchSample(sample, 0);
  
       		return (int) sample[0] - offset;
	}
	public void reset()
	{
       		sp.fetchSample(sample, 0);
	       
       		offset = (int) sample[0];
	}
	
	public void resetGyro()
	{
		sensor.reset();
		
		offset = 0;
	}

	public void close()
	{
		sensor.close();
	}

	@Override
	public void recalibrateOffset()
	{
		resetGyro();
	}
}