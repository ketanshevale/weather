package com.google.springrest.entity;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;


@Entity
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
		private String id;
		private Timestamp timestamp;
		private String city;
		private String description;
		private Double humidity;
		private Double pressure;
		private Double temperature;
		@OneToOne
		private Wind wind;

		public Weather() {
			this.id = UUID.randomUUID().toString();
		}
		
		public String city() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String description() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Double humidity() {
			return humidity;
		}
		public void setHumidity(Double humidity) {
			this.humidity = humidity;
		}
		public Double pressure() {
			return pressure;
		}
		public void setPressure(Double pressure) {
			this.pressure = pressure;
		}
		public Double temperature() {
			return temperature;
		}
		public void setTemperature(Double temperature) {
			this.temperature = temperature;
		}
		public Wind wind() {
			return wind;
		}
		public void setWind(Wind wind) {
			this.wind = wind;
		}
		public Timestamp timestamp() {
			return timestamp;
		}
		public void setTimestamp(Timestamp timestamp) {
			this.timestamp = timestamp;
		}

		public Timestamp getTimestamp() {
			return timestamp;
		}
		public String getCity() {
			return city;
		}
		public String getDescription() {
			return description;
		}
		public Double getHumidity() {
			return humidity;
		}
		public Double getPressure() {
			return pressure;
		}
		public Double getTemperature() {
			return temperature;
		}
		public Wind getWind() {
			return wind;
		}

		public String id() {
			return id;
		}
		
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return "Weather [id=" + id + ", timestamp=" + timestamp + ", city=" + city + ", description=" + description
					+ ", humidity=" + humidity + ", pressure=" + pressure + ", temperature=" + temperature + ", wind="
					+ wind + "]";
		}	
		
		
	}