CREATE TABLE mass_conversion
(
    id           SERIAL PRIMARY KEY,
    user_name    VARCHAR(255)     NOT NULL,
    type         VARCHAR(255)     NOT NULL,
    input_value  DOUBLE PRECISION NOT NULL,
    input_unit   VARCHAR(255)     NOT NULL,
    output_value DOUBLE PRECISION NOT NULL,
    output_unit  VARCHAR(255)     NOT NULL
);