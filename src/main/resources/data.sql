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
