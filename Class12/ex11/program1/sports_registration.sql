-- Database schema for Sports Event Registration

CREATE DATABASE IF NOT EXISTS sports_db;
USE sports_db;

CREATE TABLE IF NOT EXISTS sports_registration (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(100) NOT NULL,
    roll_number VARCHAR(50) NOT NULL,
    department VARCHAR(50) NOT NULL,
    sports_event VARCHAR(50) NOT NULL,
    contact_number VARCHAR(20) NOT NULL,
    registered_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
