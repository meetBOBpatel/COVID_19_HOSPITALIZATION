CREATE DATABASE COVID-19_HOSPITALIZATION;


use COVID-19_HOSPITALIZATION;

CREATE TABLE tb_user 
(
  
  username VARCHAR(50) primary key,
  `password` VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL
);

CREATE TABLE hospital
(
  hospital_name VARCHAR(50) NOT NULL,
  hospital_id INT primary key not null,
  hospital_type VARCHAR(50) NOT NULL
);

CREATE TABLE location
(
  address VARCHAR(50) primary key not null,
  hospital_id INT not null,
  city VARCHAR(50) NOT NULL,
  state VARCHAR(50) NOT NULL,
  county VARCHAR(50) NOT NULL,
  zipcode VARCHAR(50) NOT NULL,
  state_fips INT NOT NULL, 
  county_fips INT NOT NULL,
  fips INT NOT NULL,
  FOREIGN KEY (hospital_id) REFERENCES hospital(hospital_id)
);


CREATE TABLE beds
(
  license_num INT primary key NOT NULL,
  license_beds INT not null,
  staffed_beds INT not null,
  icu_beds INT not null,
  pedi_ice_beds INT,
  bed_utilization decimal,
  potential_increase INT not null,
  avg_ventilator_use decimal,
  hospital_id INT not null,
  FOREIGN KEY (hospital_id) REFERENCES hospital(hospital_id)
);