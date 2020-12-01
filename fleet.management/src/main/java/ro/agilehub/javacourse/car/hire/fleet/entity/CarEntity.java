package ro.agilehub.javacourse.car.hire.fleet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "car")
public class CarEntity {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
		
		 @Column(name = "make")
		 private String make;
		
		 @Column(name = "model")
		 private String model;
		
		 @Column(name = "year")
		 private String year;
		
		 @Column(name = "mileage")
		 private String mileage;
		 
		 @Column(name = "fuel")
		 private String fuel;
		 
		 @Column(name = "class_type")
		 private String classType;
		 
		 @Column(name = "status")
		 @Enumerated(EnumType.STRING)
		 private CarStatus status;
}

