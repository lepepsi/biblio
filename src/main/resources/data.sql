--We are adding members of our Application library to the "Member" table of our database.
INSERT INTO MEMBER (ID, NAME, LOCATION, BIRTHDATE, EMAIL)
VALUES (1001, 'DAVID', 'BERLIN', sysdate(), 'stephane_ngameni@yahoo.fr');

INSERT INTO MEMBER (ID, NAME, LOCATION, BIRTHDATE, EMAIL)
VALUES (1002, 'SYLVIA', 'BUEA', sysdate(), 'stephane_ngameni@yahoo.fr');

INSERT INTO MEMBER (ID, NAME, LOCATION, BIRTHDATE, EMAIL)
VALUES (1003, 'AUDREY', 'YAOUNDE', sysdate(), 'stephane_ngameni@yahoo.fr');

INSERT INTO MEMBER (ID, NAME, LOCATION, BIRTHDATE, EMAIL)
VALUES (1004, 'STEPHANE', 'HAMBURG', sysdate(), 'stephane_ngameni@yahoo.fr');

INSERT INTO MEMBER (ID, NAME, LOCATION, BIRTHDATE, EMAIL)
VALUES (1005, 'MICHELE', 'GELSENKIRCHEN', sysdate(), 'stephane_ngameni@yahoo.fr');


--We are adding members of our Application library to the "Book" table of our database.
INSERT INTO BOOK (ID, TITEL, ISBN, NUMBER_IN_STOCK)
VALUES (1001, 'Java Is a Insel', '1000101', 5);

INSERT INTO BOOK (ID, TITEL, ISBN, NUMBER_IN_STOCK)
VALUES (1002, 'Java Head First', '1000202', 5);

INSERT INTO BOOK (ID, TITEL, ISBN, NUMBER_IN_STOCK)
VALUES (1003, 'Java For Dummies', '1000303', 5);

INSERT INTO BOOK (ID, TITEL, ISBN, NUMBER_IN_STOCK)
VALUES (1004, 'Lean Path Collections', '1000404', 5);

INSERT INTO BOOK (ID, TITEL, ISBN, NUMBER_IN_STOCK)
VALUES (1005, 'Java Functional Algorithm', '1000505', 5);

INSERT INTO BOOK (ID, TITEL, ISBN, NUMBER_IN_STOCK)
VALUES (1006, 'Java Design Patterns', '1000606', 5);


--We are adding members of our Application library to the "Lending_Book" table of our database.
INSERT INTO Lending_Book (ID, BOOK_ID, MEMBER_ID, LOAN_START, LOAN_END)
VALUES (1001, 1002, 1001, sysdate(), sysdate +14);

INSERT INTO Lending_Book (ID, BOOK_ID, MEMBER_ID, LOAN_START, LOAN_END)
VALUES (1000, 1001,1001, sysdate(), sysdate +14);

INSERT INTO Lending_Book (ID, BOOK_ID, MEMBER_ID, LOAN_START, LOAN_END)
VALUES (1002, 1001,1002, sysdate(), sysdate +2);