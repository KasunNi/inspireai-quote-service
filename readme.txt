




### SQL QUERY


CREATE TABLE quote (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    quote TEXT NOT NULL,
    tags TEXT NOT NULL
);

*****************************************
SEPARATE TABLES

CREATE TABLE quote (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    quote TEXT NOT NULL
);



CREATE TABLE tag (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);


CREATE TABLE quote_tag (
    quote_id INT,
    tag_id INT,
    PRIMARY KEY (quote_id, tag_id),
    FOREIGN KEY (quote_id) REFERENCES quote(id) ON DELETE CASCADE,
    FOREIGN KEY (tag_id) REFERENCES tag(id) ON DELETE CASCADE
);







### build

build

gradlew.bat build (in root)

without test
gradlew.bat build -x test


docer build

docker build -t inspireai-quoting-image . (in root)


docker run

docker run -p 8080:8080 inspireai-quoting-image





### aws datastore

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://database-1.c7q6y0yscvdu.us-east-2.rds.amazonaws.com/srifoundation?useSSL=true&serverTimezone=UTC
spring.datasource.username=admin
spring.datasource.password=srifoundation1
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database=mysql
