package com.google.springrest.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;


@Entity
//@NamedQueries({
//	@NamedQuery(name = "Weather.findByCityProperty",
//	  query = "SELECT "+ "?1" + " from Weather where city = '"+ "?2" + "' order by timestamp DESC")
//})

//@NamedStoredProcedureQuery(name = "User.plus1", procedureName = "plus1inout", parameters = {
//	@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = String.class),
//	@StoredProcedureParameter(mode = ParameterMode.IN, name = "city", type = String.class),
//	@StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = Weather.class)
//	})

@NamedNativeQueries({
	@NamedNativeQuery(name="Weather.findHourAverage", query=
	"SELECT a.timestamp, city, AVG(humidity), AVG(pressure), AVG(temperature),"
	+ "AVG(speed), AVG(degree) FROM weather a "
	+ "JOIN wind b ON a.timestamp = b.timestamp where city = "+'?'+" group by HOUR(a.timestamp)"),
	@NamedNativeQuery(name="Weather.findDayAverage", query=
	"SELECT a.timestamp, city, AVG(humidity), AVG(pressure), AVG(temperature),"
	+ "AVG(speed), AVG(degree) FROM weather a "
	+ "JOIN wind b ON a.timestamp = b.timestamp where city = "+'?'+" group by DAY(a.timestamp)")
})
//Simple POJO class
public class Weather {
		@Id
		private Timestamp timestamp;
		private String city;
		private String description;
		private Double humidity;
		private Double pressure;
		private Double temperature;
		@OneToOne
		private Wind wind;

		public String getcity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getdescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Double gethumidity() {
			return humidity;
		}
		public void setHumidity(Double humidity) {
			this.humidity = humidity;
		}
		public Double getpressure() {
			return pressure;
		}
		public void setPressure(Double pressure) {
			this.pressure = pressure;
		}
		public Double gettemperature() {
			return temperature;
		}
		public void setTemperature(Double temperature) {
			this.temperature = temperature;
		}
		public Wind getwind() {
			return wind;
		}
		public void setWind(Wind wind) {
			this.wind = wind;
		}
		public Timestamp gettimestamp() {
			return timestamp;
		}
		public void setTimestamp(Timestamp timestamp) {
			this.timestamp = timestamp;
		}
		@Override
		public String toString() {
			return "Weather [city=" + city + ", description=" + description + ", humidity=" + humidity + ", pressure="
					+ pressure + ", temperature=" + temperature + ", wind=" + wind + ", timestamp=" + timestamp + "]";
		}	
		
	}