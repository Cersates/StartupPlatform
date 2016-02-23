CREATE database StartupPlatform;
use StartupPlatform;

CREATE TABLE addresses
(
    id		INT PRIMARY KEY AUTO_INCREMENT,
    country	VARCHAR(50),
    region	VARCHAR(50),
    city	VARCHAR(50),
    street	VARCHAR(50),
    building	VARCHAR(50)
);

INSERT INTO `StartupPlatform`.`addresses` (`country`, `region`, `city`, `street`, `building`) VALUES ('Ukraine', 'Odessa', 'Odessa', 'Govorova', '11A');
INSERT INTO `StartupPlatform`.`addresses` (`country`, `region`, `city`, `street`, `building`) VALUES ('Ukraine', 'Kyiv', 'Kyiv', 'Bogdan Khmelnitsky', '125');
