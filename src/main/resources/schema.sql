DROP TABLE IF EXISTS meals;

CREATE TABLE meals (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    description VARCHAR(100) NOT NULL,
    UNIQUE(name)
);

CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    start_date DATE NOT NULL,
    start_time TIME NOT NULL,
    end_date DATE,
    end_time TIME,
    status VARCHAR(10) NOT NULL
);

