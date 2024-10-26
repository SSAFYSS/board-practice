-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema boardpractice
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `boardpractice`;
-- -----------------------------------------------------
-- Schema boardpractice
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `boardpractice` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `boardpractice` ;

-- -----------------------------------------------------
-- Table `boardpractice`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `boardpractice`.`User` ;

CREATE TABLE IF NOT EXISTS `boardpractice`.`User` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `oauthId` CHAR(255) NULL DEFAULT NULL,
  `oauthType` CHAR(255) NULL DEFAULT NULL,
  `email` CHAR(255) NOT NULL,
  `password` CHAR(60) NOT NULL,
  `profileImage` VARCHAR(255) NULL DEFAULT NULL,
  `createdAt` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deletedAt` TIMESTAMP NULL DEFAULT NULL,
  `deleted` TINYINT(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `oauthId_UNIQUE` (`oauthId` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `boardpractice`.`Todo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `boardpractice`.`Todo` ;

CREATE TABLE IF NOT EXISTS `boardpractice`.`Todo` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `userId` BIGINT NOT NULL,
  `content` VARCHAR(50) NOT NULL,
  `completed` TINYINT(1) NOT NULL DEFAULT '0',
  `createdAt` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deletedAt` TIMESTAMP NULL DEFAULT NULL,
  `updatedAt` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` TINYINT(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `userId_idx` (`userId` ASC) VISIBLE,
  CONSTRAINT `userId`
    FOREIGN KEY (`userId`)
    REFERENCES `boardpractice`.`User` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

insert into user(email, password) values('ssafy@ssafy.com', 'qwertyuiopsdfghm456789sdfghj');
insert into user(email, password) values('admin@ssafy.com', 'asdfghjwertyui1234562345678');

insert into todo(userId, content) values(1, '알고리즘 1문제 풀기');
insert into todo(userId, content) values(1, '스프링 강의 1개 듣기');
insert into todo(userId, content) values(1, '30분 운동하기');