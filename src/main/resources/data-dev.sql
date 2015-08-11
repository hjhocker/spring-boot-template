insert into ACCOUNT (ACCOUNT_ID, FIRST_NAME, LAST_NAME) VALUES (1, 'Harrison', 'Hocker');
insert into ACCOUNT (ACCOUNT_ID, FIRST_NAME, LAST_NAME) VALUES (2, 'Gabby', 'Hocker');

insert into TRANSACTION (TRANSACTION_ID, AMOUNT, DATE, LOCATION, ACCOUNT_ID) VALUES (1, 123.44, '2015-03-21', 'CVS', 1);
insert into TRANSACTION (TRANSACTION_ID, AMOUNT, DATE, LOCATION, ACCOUNT_ID) VALUES (2, 12.23, '2015-03-22', 'Museum', 1);
insert into TRANSACTION (TRANSACTION_ID, AMOUNT, DATE, LOCATION, ACCOUNT_ID) VALUES (3, 73.14, '2015-03-23', 'Best Buy', 1);
insert into TRANSACTION (TRANSACTION_ID, AMOUNT, DATE, LOCATION, ACCOUNT_ID) VALUES (4, 12.84, '2015-03-24', 'Arcade', 1);
insert into TRANSACTION (TRANSACTION_ID, AMOUNT, DATE, LOCATION, ACCOUNT_ID) VALUES (5, 13.24, '2015-03-25', 'Honda', 1);
insert into TRANSACTION (TRANSACTION_ID, AMOUNT, DATE, LOCATION, ACCOUNT_ID) VALUES (6, 20.43, '2015-03-25', 'Whole Foods', 1);
insert into TRANSACTION (TRANSACTION_ID, AMOUNT, DATE, LOCATION, ACCOUNT_ID) VALUES (7, 13.00, '2015-03-26', 'Rouses', 1);

insert into TRANSACTION (TRANSACTION_ID, AMOUNT, DATE, LOCATION, ACCOUNT_ID) VALUES (8, 123.44, '2015-03-21', 'CVS', 2);
insert into TRANSACTION (TRANSACTION_ID, AMOUNT, DATE, LOCATION, ACCOUNT_ID) VALUES (9, 12.23, '2015-03-22', 'Museum', 2);
insert into TRANSACTION (TRANSACTION_ID, AMOUNT, DATE, LOCATION, ACCOUNT_ID) VALUES (10, 73.14, '2015-03-23', 'Best Buy', 2);
insert into TRANSACTION (TRANSACTION_ID, AMOUNT, DATE, LOCATION, ACCOUNT_ID) VALUES (11, 12.84, '2015-03-24', 'Arcade', 2);
insert into TRANSACTION (TRANSACTION_ID, AMOUNT, DATE, LOCATION, ACCOUNT_ID) VALUES (12, 13.24, '2015-03-25', 'Honda', 2);
insert into TRANSACTION (TRANSACTION_ID, AMOUNT, DATE, LOCATION, ACCOUNT_ID) VALUES (13, 20.43, '2015-03-25', 'Whole Foods', 2);
insert into TRANSACTION (TRANSACTION_ID, AMOUNT, DATE, LOCATION, ACCOUNT_ID) VALUES (14, 13.00, '2015-03-26', 'Rouses', 2);

insert into REGISTERED_USERS (REGISTERED_USER_ID, USERNAME, TOKEN) VALUES (1, 'HJHOCKER', 'XZY');
insert into REGISTERED_USERS (REGISTERED_USER_ID, USERNAME, TOKEN) VALUES (2, 'GTH', 'ABC');

-- SELECT * 
-- FROM Transaction t
-- join account a on t.account_id = a.account_id
-- and  t.location = 'CVS';
