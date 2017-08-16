package com.google.weather.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//Simple POJO class
public class Wind {
		@Id
		private String speed;
		private String degree;
		
		public String getSpeed() {
			return speed;
		}
		public void setSpeed(String speed) {
			this.speed = speed;
		}
		public String getDegree() {
			return degree;
		}
		public void setDegree(String degree) {
			this.degree = degree;
		}
		@Override
		public String toString() {
			return "Wind [speed=" + speed + ", degree=" + degree + "]";
		}

	}