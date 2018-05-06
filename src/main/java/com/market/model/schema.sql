delete from PROJECT;delete from BID;delete from PERSON;

drop table BID;
create table BID 
(ID int PRIMARY KEY NOT NULL, PROPOSAL varchar, AMOUNT decimal, ENGINEER_ID int, PROJECT_ID int);
create unique index bid_key on BID(ENGINEER_ID, PROJECT_ID);

drop table PROJECT;
create table PROJECT 
(ID int PRIMARY KEY NOT NULL, PROJECT_NAME varchar, DESCRIPTION varchar, BUDGET decimal, ENDING_DATE date, ASSIGNEE_ID int, OWNER_ID int);
create unique index project_key on PROJECT(PROJECT_NAME);

drop table PERSON;
create table PERSON (ID int PRIMARY KEY NOT NULL, NAME varchar, CONTACT_INFO varchar);
create unique index person_key on PERSON(NAME);

select * from person;
select * from project;
select * from bid;

