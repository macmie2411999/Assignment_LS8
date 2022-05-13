create
database ManageClient;
use
ManageClient;

create table Client
(
    ID_Client       varchar(20),
    Email_Client    varchar(50),
    Password_Client varchar(30),
    FullName_Client varchar(30),
    PRIMARY KEY (ID_Client)
);

insert into Client (ID_Client, Email_Client, Password_Client, FullName_Client)
values (1, "caoducmanh@gmail.com", "macmie", "Cao Duc Manh");
insert into Client (ID_Client, Email_Client, Password_Client, FullName_Client)
values (2, "dauvanminh@gmail.com", "vanminh", "Dau Van Minh");
insert into Client (ID_Client, Email_Client, Password_Client, FullName_Client)
values (3, "admin@gmail.com", "admin", "Admin");
insert into Client (ID_Client, Email_Client, Password_Client, FullName_Client)
values (4, "nguyentruongson@gmail.com", "truongson", "Nguyen Truong Son");