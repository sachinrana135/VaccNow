
INSERT INTO `vaccine` SET `id` = 1, `name` = 'Covishield', `cost` = 1000, `date_created` = CURRENT_TIMESTAMP(), `date_modified` = CURRENT_TIMESTAMP();
INSERT INTO `vaccine` SET `id` = 2, `name` = 'Covaxin', `cost` = 2000, `date_created` = CURRENT_TIMESTAMP(), `date_modified` = CURRENT_TIMESTAMP();

INSERT INTO `branch` SET `id` = 1, `name` = 'RML Hospital', `location` = 'Delhi', `date_created` = CURRENT_TIMESTAMP(), `date_modified` = CURRENT_TIMESTAMP();
INSERT INTO `branch` SET `id` = 2, `name` = 'GIMS Hospital', `location` = 'Noida', `date_created` = CURRENT_TIMESTAMP(), `date_modified` = CURRENT_TIMESTAMP();
INSERT INTO `branch` SET `id` = 3, `name` = 'Medanta', `location` = 'Gurugram', `date_created` = CURRENT_TIMESTAMP(), `date_modified` = CURRENT_TIMESTAMP();


INSERT INTO `branch_vaccine` SET `id` = 1, `branch_id` = 1, `vaccine_id` = 1, `count` = 2000, `date_created` = CURRENT_TIMESTAMP(), `date_modified` = CURRENT_TIMESTAMP();
INSERT INTO `branch_vaccine` SET `id` = 2, `branch_id` = 1, `vaccine_id` = 2, `count` = 1000, `date_created` = CURRENT_TIMESTAMP(), `date_modified` = CURRENT_TIMESTAMP();
INSERT INTO `branch_vaccine` SET `id` = 3, `branch_id` = 2, `vaccine_id` = 1, `count` = 500, `date_created` = CURRENT_TIMESTAMP(), `date_modified` = CURRENT_TIMESTAMP();
INSERT INTO `branch_vaccine` SET `id` = 4, `branch_id` = 3, `vaccine_id` = 1, `count` = 1000, `date_created` = CURRENT_TIMESTAMP(), `date_modified` = CURRENT_TIMESTAMP();
INSERT INTO `branch_vaccine` SET `id` = 5, `branch_id` = 3, `vaccine_id` = 2, `count` = 1500, `date_created` = CURRENT_TIMESTAMP(), `date_modified` = CURRENT_TIMESTAMP();


INSERT INTO `schedule` SET `id` = 1, `email` = 'user1@example.com', `branch_id` = 2, `vaccine_id` = 2, `payment_type` = 'credit', `slot` = '2021-03-01 13:00', `status` = 'applied',  `date_created` = CURRENT_TIMESTAMP(), `date_modified` = CURRENT_TIMESTAMP();
INSERT INTO `schedule` SET `id` = 2, `email` = 'user2@example.com', `branch_id` = 3, `vaccine_id` = 1, `payment_type` = 'fawry', `slot` = '2021-03-02 11:00', `status` = 'applied',  `date_created` = CURRENT_TIMESTAMP(), `date_modified` = CURRENT_TIMESTAMP();
INSERT INTO `schedule` SET `id` = 3, `email` = 'user3@example.com', `branch_id` = 1, `vaccine_id` = 1, `payment_type` = 'cash', `slot` = '2021-03-14 15:00', `status` = 'confirmed',  `date_created` = CURRENT_TIMESTAMP(), `date_modified` = CURRENT_TIMESTAMP();
INSERT INTO `schedule` SET `id` = 4, `email` = 'user4@example.com', `branch_id` = 1, `vaccine_id` = 2, `payment_type` = 'cash', `slot` = '2021-03-11 12:00', `status` = 'confirmed',  `date_created` = CURRENT_TIMESTAMP(), `date_modified` = CURRENT_TIMESTAMP();


