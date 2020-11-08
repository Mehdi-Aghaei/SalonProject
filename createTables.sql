
CREATE TABLE customer
(
    customer_id  SERIAL PRIMARY KEY,
    first_name   varchar(30) NOT NULL,
    last_name    varchar(30) NOT NULL,
    email        varchar(80) NOT NULL,
    phone_number varchar(20) NULL
);
CREATE TABLE services
(
    service_id          SERIAL PRIMARY KEY,
    service_name        varchar(80) NOT NULL,
    service_price       integer(12) NOT NULL,
);
CREATE TABLE appointment
(
    appointment_id        SERIAL PRIMARY KEY,
    full_name                 varchar(80) NOT NULL,
    phone_number         varchar(20) NULL,
    appointment_date     date NOT NULL,
    start_time           time without time zone NOT NULL,
    end_time             time without time zone NOT NULL,
    service_name         varchar(80) NOT NULL REFERENCES services (service_name),
);
