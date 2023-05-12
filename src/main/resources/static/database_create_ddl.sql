CREATE TABLE IF NOT EXISTS "dashboard" (
                                           "dashboard_id" integer NOT NULL,
                                           "dashboard_title" varchar(40) NULL,
    "dashboard_type" varchar(10) NULL,
    "dashboard_sequence" integer NULL,
    PRIMARY KEY ("dashboard_id")
    );

CREATE TABLE IF NOT EXISTS "devices" (
                                         "device_id" integer NOT NULL,
                                         "device_name" varchar(255) NULL,
    PRIMARY KEY ("device_id")
    );

CREATE TABLE IF NOT EXISTS "sensors" (
                                         "sensor_id" integer NOT NULL,
                                         "sensor_name" varchar(255) NULL,
    "sensor_unit" varchar(40) NULL,
    "device_id" integer NOT NULL,
    PRIMARY KEY ("sensor_id"),
    FOREIGN KEY ("device_id") REFERENCES "devices" ("device_id")
    );

CREATE TABLE IF NOT EXISTS "widget" (
                                        "widget_id" integer NOT NULL,
                                        "widget_type" varchar(40) NULL,
    PRIMARY KEY ("widget_id")
    );


CREATE TABLE IF NOT EXISTS "layout" (
                                        "layout_id" integer NOT NULL,
                                        "layout_sequence" integer NULL,
                                        "dashboard_id" integer NOT NULL,
                                        PRIMARY KEY ("layout_id"),
    FOREIGN KEY ("dashboard_id") REFERENCES "dashboard" ("dashboard_id")
    );


CREATE TABLE IF NOT EXISTS "layout_widget" (
                                               "layout_widget_id" integer NOT NULL,
                                               "layout_widget_start_pos" integer NULL,
                                               "layout_widget_end_pos" integer NULL,
                                               "layout_widget_z_pos" integer NULL,
                                               "layout_widget_color" varchar(40) NULL,
    "layout_widget_property" text NULL,
    "widget_id" integer NOT NULL,
    "layout_id" integer NOT NULL,
    PRIMARY KEY ("layout_widget_id"),
    FOREIGN KEY ("widget_id") REFERENCES "widget" ("widget_id"),
    FOREIGN KEY ("layout_id") REFERENCES "layout" ("layout_id")
    );


CREATE TABLE IF NOT EXISTS "layout_widget_sensor" (
                                                      "layout_widget_sensor_id" integer NOT NULL,
                                                      "layout_widget_sensor_sequence" integer NULL,
                                                      "layout_widget_id" integer NOT NULL,
                                                      "sensor_id" integer NOT NULL,
                                                      PRIMARY KEY ("layout_widget_sensor_id"),
    FOREIGN KEY ("layout_widget_id") REFERENCES "layout_widget" ("layout_widget_id"),
    FOREIGN KEY ("sensor_id") REFERENCES "sensors" ("sensor_id")
    );


CREATE TABLE IF NOT EXISTS "event" (
                                       "event" integer NOT NULL,
                                       "event_over" integer NULL,
                                       "event_under" integer NULL,
                                       "event_color" varchar(40) NULL,
    "event_type" varchar(40) NULL,
    "layout_widget_id" integer NOT NULL,
    PRIMARY KEY ("event"),
    FOREIGN KEY ("layout_widget_id") REFERENCES "layout_widget" ("layout_widget_id")
    );

CREATE TABLE sensor_data
(
    sensor_data_id    UUID    NOT NULL,
    sensor_data_value VARCHAR(40),
    sensor_data_time  TIMESTAMP WITHOUT TIME ZONE,
    sensor_id         INTEGER NOT NULL,
    CONSTRAINT pk_sensor_data PRIMARY KEY (sensor_data_id)
);

ALTER TABLE sensor_data
    ADD CONSTRAINT FK_SENSOR_DATA_ON_SENSOR FOREIGN KEY (sensor_id) REFERENCES sensors (sensor_id);