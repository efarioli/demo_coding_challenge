-- DROP TABLE CUSTOMERS;
-- DROP TABLE CUSTOMERSITES;
-- DROP TABLE SITES;
CREATE TABLE IF NOT EXISTS CUSTOMERS
(
    customerId       INT PRIMARY KEY auto_increment,
    registered   timestamp,
    email        VARCHAR(255) unique,
    title        VARCHAR(5),
    firstname    VARCHAR(50),
    lastname     VARCHAR(50),
    addressline1 VARCHAR(255),
    addressline2 VARCHAR(255),
    city         VARCHAR(255),
    postcode     VARCHAR(10),
    telephone    VARCHAR(20)

);

CREATE TABLE IF NOT EXISTS SITES
(
    siteId   INT PRIMARY KEY auto_increment,
    siteName VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS CUSTOMERSITES
(
    siteId   INT ,
    customerId INT ,
    foreign key (siteId) references SITES (siteId),
    foreign key (customerId) references CUSTOMERS (customerId)
);

INSERT INTO SITES (siteName)
VALUES ('Avalon City');
INSERT INTO SITES (siteName)
VALUES ('AceParks');


