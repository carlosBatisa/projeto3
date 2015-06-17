drop database if exists banco1;
create database banco1;
use banco1;

create table produto(
	idProduto int primary key auto_increment,
	nome varchar(35),
	preco double,
	quantidade int
);

insert into produto values(10,'camisa criaca',30.,1);
insert into produto values(11,'camisa xxx',90.,1);
insert into produto values(12,'camisa nike',200.,1);
insert into produto values(13,'tenis nike',600.,1);
commit;
select * from produto;