/**
 * Bootstrapped data for demo
 */

INSERT INTO `account` VALUES (1,750,'2007-12-10',NULL,'Super duper company'),(2,-125,'2007-10-12',NULL,'Uper duper employee'),(3,6000,'2007-10-12',NULL,'Company A'),(4,0,'2007-10-12','2019-09-01','Company B');

INSERT INTO `authorization` VALUES (1,'CREDIT_CARD'),(2,'DEBIT_CARD'),(3,'PAYMENT'),(4,'VIEW');

INSERT INTO `card_limit` VALUES (1,'PER_MONTH','CREDIT',3000),(2,'PER_WEEK','ATM',3000),(3,'PER_MONTH','POS',50),(4,'PER_DAY','ATM',100),(5,'PER_MONTH','POS',10000),(6,'PER_DAY','ATM',100),(7,'PER_MONTH','POS',10000),(8,'PER_DAY','ATM',500),(9,'PER_MONTH','POS',50);

INSERT INTO `card` VALUES ('CREDIT_CARD',1,'Boromir',5075,FALSE,1,'ACTIVE',1,NULL,NULL),('DEBIT_CARD',2,'Frodo Baggins',1234,TRUE,5,'ACTIVE',NULL,2,2),('DEBIT_CARD',3,'Aragorn',6527,TRUE,1,'ACTIVE',NULL,3,3),('DEBIT_CARD',4,'Super duper employee',1111,TRUE,32,'ACTIVE',NULL,4,4),('DEBIT_CARD',5,'Darth Vader',5678,TRUE,5,'BLOCKED',NULL,5,5);

INSERT INTO `power_of_attorney` VALUES ('0001','NL23RABO123456789','GIVEN',3,1),('0002','NL23RABO987654321','GIVEN',2,1),('0003','NL23RABO343434343','GIVEN',2,1),('0004','NL23RABO123123123','RECEIVED',1,2);

INSERT INTO `power_of_attorney_authorizations` VALUES ('0001',3),('0001',4),('0002',2),('0002',3),('0002',4),('0003',3),('0003',4),('0004',3),('0004',4);

INSERT INTO `power_of_attorney_cards` VALUES ('0001',1),('0001',2),('0001',3),('0002',4);
