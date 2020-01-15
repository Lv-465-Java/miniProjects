insert into producers (name)
values ('Apple'),
       ('Sumsung'),
       ('Xiaomi'),
       ('LG'),
       ('Nokia');

insert into models (name, producerId)
values ('XR', 1),
       ('X PRO MAX', 1),
       ('X ', 1),
       ('GALAXY S10 ', 2),
       ('G6 PLUS ', 4),
       ('REDMI 8', 3),
       ('X2', 5);

insert into phones (year, price, photo, color, screenDiagonal, internalMemory, modelId)
values (2019, 14500, 'd8ff8603-6177-4b03-94c5-55ead48086d1_Nokia-3.2-16GB-Dual-SIM.jpg', 'blue', 4.5, 64, 3),
       (2015, 1540, 'd8ff8603-6177-4b03-94c5-55ead48086d1_Nokia-3.2-16GB-Dual-SIM.jpg', 'blue', 4.5, 512, 1),
       (2011, 31200, '503b9185-2065-49be-ba63-6f91433b33e7_Apple-iPhone-11-Pro-Max-256GB.jpg', 'blue', 6.5, 128, 2),
       (2017, 79100, 'dbaa2af8-7f0c-4324-974b-ba7608717129_Xiaomi-Redmi-Note-8T-4GB-RAM-64GB-Dual-SIM.jpg', 'blue', 7.5, 128, 4),
       (2010, 9821, 'dbaa2af8-7f0c-4324-974b-ba7608717129_Xiaomi-Redmi-Note-8T-4GB-RAM-64GB-Dual-SIM.jpg', 'red', 5.5, 128, 5);

insert into users (nickname, password, email, phone, role)
values ('admin', '123456', 'admin@ua', '13904131', 'admin'),
       ('andrii', '111', 'user@ua', '3321321', 'user'),
       ('student3', '222', 'student@ua', '321321312', 'user');