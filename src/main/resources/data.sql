DROP TABLE IF EXISTS vaccine;
CREATE TABLE `vaccine` (
	`id` INT(3) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100) NOT NULL,
	`cost` DOUBLE(11) NOT NULL,
	`date_created` TIMESTAMP NOT NULL,
	`date_modified` TIMESTAMP NOT NULL,
	PRIMARY KEY (`id`)
);

INSERT INTO `vaccine` SET `id` = 1, `name` = 'Test', `cost` = 23.1, `date_created` = CURRENT_TIMESTAMP(), `date_modified` = CURRENT_TIMESTAMP();
INSERT INTO `vaccine` SET `id` = 2, `name` = 'Test1', `cost` = 30.1, `date_created` = CURRENT_TIMESTAMP(), `date_modified` = CURRENT_TIMESTAMP();


/*DROP TABLE IF EXISTS branch;

CREATE TABLE `branch` (
	`id` INT(7) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100) NOT NULL,
	`location` VARCHAR(100) NOT NULL,
	`date_created` TIMESTAMP NOT NULL,
	`date_modified` TIMESTAMP NOT NULL,
	PRIMARY KEY (`id`)
);*/

INSERT INTO `branch` SET `id` = 1, `name` = 'RML Hospital', `location` = 'Delhi', `date_created` = CURRENT_TIMESTAMP(), `date_modified` = CURRENT_TIMESTAMP();
INSERT INTO `branch` SET `id` = 2, `name` = 'GIMS Hospital', `location` = 'Noida', `date_created` = CURRENT_TIMESTAMP(), `date_modified` = CURRENT_TIMESTAMP();
