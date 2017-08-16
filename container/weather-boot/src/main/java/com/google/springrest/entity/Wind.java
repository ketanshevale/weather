package com.google.springrest.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//Simple POJO class
public class Wind {
		@Id
		private Timestamp timestamp;
		private Double speed;
		private Double degree;
		
		
		public Timestamp getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(Timestamp timestamp) {
			this.timestamp = timestamp;
		}
		public Double getSpeed() {
			return speed;
		}
		public void setSpeed(Double speed) {
			this.speed = speed;
		}
		public Double getDegree() {
			return degree;
		}
		public void setDegree(Double degree) {
			this.degree = degree;
		}
		@Override
		public String toString() {
			return "Wind [speed=" + speed + ", degree=" + degree + "]";
		}

	}