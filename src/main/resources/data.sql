
INSERT INTO `vaccine` SET `id` = 1, `name` = 'Covaxin', `cost` = 23.1, `date_created` = CURRENT_TIMESTAMP(), `date_modified` = CURRENT_TIMESTAMP();
INSERT INTO `vaccine` SET `id` = 2, `name` = 'Oxford', `cost` = 30.1, `date_created` = CURRENT_TIMESTAMP(), `date_modified` = CURRENT_TIMESTAMP();

INSERT INTO `branch` SET `id` = 1, `name` = 'RML Hospital', `location` = 'Delhi', `date_created` = CURRENT_TIMESTAMP(), `date_modified` = CURRENT_TIMESTAMP();
INSERT INTO `branch` SET `id` = 2, `name` = 'GIMS Hospital', `location` = 'Noida', `date_created` = CURRENT_TIMESTAMP(), `date_modified` = CURRENT_TIMESTAMP();


INSERT INTO `branch_vaccine` SET `id` = 1, `branch_id` = 1, `vaccine_id` = 1, `count` = 500, `date_created` = CURRENT_TIMESTAMP(), `date_modified` = CURRENT_TIMESTAMP();
INSERT INTO `branch_vaccine` SET `id` = 2, `branch_id` = 2, `vaccine_id` = 2, `count` = 600, `date_created` = CURRENT_TIMESTAMP(), `date_modified` = CURRENT_TIMESTAMP();

