package com.google.springrest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//Simple POJO class
public class Wind {
		@Id
		private String id;
		private Double speed;
		private Double degree;
		

		public Double speed() {
			return speed;
		}
		public void setSpeed(Double speed) {
			this.speed = speed;
		}
		public Double degree() {
			return degree;
		}
		public void setDegree(Double degree) {
			this.degree = degree;
		}
		public Double getSpeed() {
			return speed;
		}
		public Double getDegree() {
			return degree;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String id() {
			return id;
		}
		@Override
		public String toString() {
			return "Wind [id=" + id + ", speed=" + speed + ", degree=" + degree + "]";
		}
		
		
	}