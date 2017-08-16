package com.google.weather.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;


@Entity
@NamedQueries({
	@NamedQuery(name ="Weather.findAll", query="SELECT w from Weather w ORDER BY w.city"),
	@NamedQuery(name ="Weather.findByTyme", query="SELECT w from Weather w where w.timestamp=:pEmail")
})
//Simple POJO class
public class Weather {
		@Id
		private String city;
		private String description;
		private String humidity;
		private String pressure;
		private String temperature;
		@OneToOne
		private Wind wind;
		private String timestamp;

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
		public String getHumidity() {
			return humidity;
		}
		public void setHumidity(String humidity) {
			this.humidity = humidity;
		}
		public String getPressure() {
			return pressure;
		}
		public void setPressure(String pressure) {
			this.pressure = pressure;
		}
		public String getTemperature() {
			return temperature;
		}
		public void setTemperature(String temperature) {
			this.temperature = temperature;
		}
		public Wind getWind() {
			return wind;
		}
		public void setWind(Wind wind) {
			this.wind = wind;
		}
		public String getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}
		@Override
		public String toString() {
			return "Weather [city=" + city + ", description=" + description + ", humidity=" + humidity + ", pressure="
					+ pressure + ", temperature=" + temperature + ", wind=" + wind + ", timestamp=" + timestamp + "]";
		}			
	}