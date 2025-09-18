package az.hafizrzazade.safproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "saf_robotdata")
public class RobotData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer sequenceNumber;
	private String sentAt;
	private Double temperatureC_dht22;
	private Double humidityPercentDht22;
	private Double pressurePa_bmp180;
	private Double altitudeM_bmp180;
	private Double altitudeM_gps;
	private Double gpsLatitude;
	private Double gpsLongitude;
	private Double gpsAltitudeM;
	private Double gpsSpeedKmh;
	private String gpsUtcTime;
	private Integer gpsSatellites;
	private Double gpsHdop;
	private Double accelX_lsm303;
	private Double accelY_lsm303;
	private Double accelZ_lsm303;

	private Double accelX_mpu6050;
	private Double accelY_mpu6050;
	private Double accelZ_mpu6050;

	private Double gyroX_mpu6050;
	private Double gyroY_mpu6050;
	private Double gyroZ_mpu6050;

	private Double magX_lsm303;
	private Double magY_lsm303;
	private Double magZ_lsm303;
}
