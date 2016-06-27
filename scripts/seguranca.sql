DROP DATABASE IF EXISTS `DBSEGURANCA`;

CREATE DATABASE `DBSEGURANCA`;

USE DBSEGURANCA;



INSERT INTO TB_SISTEMA(nm_sistema,ds_url)
VALUES
			('Sistema Ecommerce', 'http://localhost:8080/SistemaEcommerce/'),
			('Seguranca', 'http://localhost:8080/Seguranca/')
;

INSERT INTO TB_USUARIO(ds_login,fl_ativo,ds_senha,ds_email) 
VALUES 
			('marisevc', 1, '0yi5Yer5LzRwL9mB8l1l4W/W0DNfplpediqtA9QDA6s=', 'marisevc@hotmail.com'),
			('cabuloso', 1, 'i4jDXre6hrkdjEtp1GjfPSSTEHEgbAfMYcOq/wOq6og=', 'cabuloso@gmail.com')
;

-- rato
-- bola
			
insert into tb_role(nm_role,cd_sistema)
values ('ECO_admin',1),
       ('ECO_cadastro',1),
       ('ECO_consulta',1),
       ('SEG_admin',2),
       ('SEG_cadastro',2),
       ('SEG_consulta',2);

INSERT INTO TB_USUARIO_ROLE(cd_role,ds_login) 
VALUES 
			(1,'cabuloso'),
			(4,'cabuloso'),
			(3,'marisevc'),
			(6,'marisevc')
;
