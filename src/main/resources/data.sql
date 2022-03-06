-- noinspection SqlNoDataSourceInspectionForFile

INSERT INTO tb_disciple
(id,address,age,birth_date,christening_status,church_status,details,district,name,decision_type)
values (null, 'Marechal Mallet','19','2002-06-25',0,0,'Pela própria betania','Sulacap','Ronaldo Ribeiro', 0);
INSERT INTO tb_disciple
(id,address,age,birth_date,christening_status,church_status,details,district,name, decision_type)
values (null, 'Marechal Mallet','12','2002-06-25',1,2,'Pela própria betania','Sulacap','Márcio Junior', 0);
INSERT INTO tb_disciple
(id,address,age,birth_date,christening_status,church_status,details,district,name, decision_type)
values (null, 'Marechal Mallet','14','2002-06-25',0,1,'Pela própria betania','Sulacap','Julia Maria', 0);

INSERT INTO tb_phone
(id,ddd,number,phone_type,whatsapp,id_disciple)
values (null, '21','984848785',0,1,1);

INSERT INTO tb_phone
(id,ddd,number,phone_type,whatsapp,id_disciple)
values (null, '21','984848787',1,0,2);

INSERT INTO tb_phone
(id,ddd,number,phone_type,whatsapp,id_disciple)
values (null, '21','984848785',2,1,3);


INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (authority) VALUES ('ROLE_PASTOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_LEADER');

INSERT INTO tb_user(username, password)
values ('victor', '$2a$12$KBjw/Rd10UjKNFi0A4Uol.LuOKZjSmlyAZibF7Um0yE5t.G2IlZnS');
INSERT INTO tb_user(username, password)
values ('pastor', '$2a$12$KBjw/Rd10UjKNFi0A4Uol.LuOKZjSmlyAZibF7Um0yE5t.G2IlZnS');
INSERT INTO tb_user(username, password)
values ('lider', '$2a$12$KBjw/Rd10UjKNFi0A4Uol.LuOKZjSmlyAZibF7Um0yE5t.G2IlZnS');
INSERT INTO tb_user(username, password)
values ('tocamaster', '$2a$13$AfaM05AhA5.YANMpmjs3t.K/Dskl.ZA7AI/uGbnouzTbEoSDoq.Ha');


INSERT INTO tb_user_role(user_id, role_id)
values (1, 1);
INSERT INTO tb_user_role(user_id, role_id)
values (2, 2);
INSERT INTO tb_user_role(user_id, role_id)
values (3, 3);
INSERT INTO tb_user_role(user_id, role_id)
values (4, 1);
