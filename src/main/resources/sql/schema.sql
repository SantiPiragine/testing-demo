DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS (
                       ID BIGINT NOT NULL AUTO_INCREMENT,
                       USER_NAME VARCHAR(255) NOT NULL,
                       PASSWORD VARCHAR(255) NOT NULL,
                       PRIMARY KEY (ID)
);
