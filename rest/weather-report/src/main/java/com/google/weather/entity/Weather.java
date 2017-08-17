package com.google.weather.entity;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;


@Entity
@NamedQueries({
	@NamedQuery(name ="Weather.findAllCities", query="SELECT DISTINCT w.city from Weather w"),
	@NamedQuery(name ="Weather.findByTime", query="SELECT w from Weather w where w.city= :pCity order by w.timestamp DESC"),
})
@NamedNativeQueries({
	@NamedNativeQuery(name="Weather.findHourAverage", query=
	"SELECT a.city, AVG(a.humidity) as humidity, "
	+ "AVG(a.pressure) as pressure, AVG(a.temperature) as temperature, "
	+ "AVG(b.speed) as speed, AVG(b.degree) as degree FROM weather a "
	+ "JOIN wind b ON a.id = b.id where city = "+'?'+" group by HOUR(a.timestamp)"),
	@NamedNativeQuery(name="Weather.findDayAverage", query=
	"SELECT a.city, AVG(a.humidity) as humidity, "
	+ "AVG(a.pressure) as pressure, AVG(a.temperature) as temperature, "
	+ "AVG(b.speed) as speed, AVG(b.degree) as degree FROM weather a "
	+ "JOIN wind b ON a.id = b.id where city = "+'?'+" group by DAY(a.timestamp)")
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
		
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Double getHumidity() {
			return humidity;
		}
		public void setHumidity(Double humidity) {
			this.humidity = humidity;
		}
		public Double getPressure() {
			return pressure;
		}
		public void setPressure(Double pressure) {
			this.pressure = pressure;
		}
		public Double getTemperature() {
			return temperature;
		}
		public void setTemperature(Double temperature) {
			this.temperature = temperature;
		}
		public Wind getWind() {
			return wind;
		}
		public void setWind(Wind wind) {
			this.wind = wind;
		}
		public Timestamp getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(Timestamp timestamp) {
			this.timestamp = timestamp;
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