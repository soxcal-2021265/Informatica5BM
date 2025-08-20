drop database if exists DB_Zapatos;
create database DB_Zapatos;
use DB_Zapatos;

create table Zapato (
	codigoZapato int not null auto_increment,
    nombre varchar(256) not null,
    marca varchar(256) not null,
    talla varchar(10) not null,
    color varchar(256) not null,
    primary key PK_codigoZapato(codigoZapato)
);

create table Cliente (
	codigoCliente int not null auto_increment,
    codigoZapato int not null,
    nombre varchar(256) not null,
    telefono varchar(8)not null unique,
    correo varchar(256) not null unique,
    direccion varchar(256),
    primary key PK_codigoCliente(codigoCliente),
    constraint FK_codigoZapato foreign key(codigoZapato)
		references Zapato(codigoZapato)
);

-- Procedimientos almacenados de Zapato
delimiter //
create procedure sp_AgregarZapato(
	in nZapato varchar(256),
    in mZapato varchar(256),
    in tZapato varchar(256), 
    in cZapato varchar(256)
    )
    begin
		insert into Zapato(nombre, marca, talla, color)
			values(nZapato, mZapato, tZapato, cZapato);
    end//
delimiter ;
call sp_AgregarZapato('Zapatilla Deportiva', 'Nike', '42', 'Negro');
call sp_AgregarZapato('Bota de Montaña', 'Columbia', '43', 'Marrón');
call sp_AgregarZapato('Sandalia de Verano', 'Birkenstock', '38', 'Beige');
call sp_AgregarZapato('Zapato Formal', 'Clarks', '41', 'Negro');
call sp_AgregarZapato('Tenis Casual', 'Adidas', '40', 'Blanco');
call sp_AgregarZapato('Botín Chelsea', 'Zara', '39', 'Gris');
call sp_AgregarZapato('Deportiva de Running', 'Brooks', '44', 'Azul');
call sp_AgregarZapato('Mocasín Elegante', 'Gucci', '42', 'Café');
call sp_AgregarZapato('Zapatilla de Baloncesto', 'Jordan', '45', 'Rojo');
call sp_AgregarZapato('Bailarina Clásica', 'Repetto', '37', 'Rosa');

delimiter //
create procedure sp_ListarZapato()
	begin
		select codigoZapato, nombre, marca, talla, color from Zapato;
	end//
delimiter ;
call sp_ListarZapato();


delimiter //
create procedure sp_EliminarZapato(in cZapato int)
	begin
		delete from Zapato where codigoZapato = cZapato;
	end//
delimiter ;
-- call sp_EliminarZapato(1);

delimiter //
create procedure sp_ActualizarZapato(
	in codZapato int,
	in nZapato varchar(256),
    in mZapato varchar(256),
    in tZapato varchar(256), 
    in cZapato varchar(256)
    )
    begin
		update Zapato 
        set nombre = nZapato,
        marca = mZapato,
        talla = tZapato,
        color = cZapato
        where codigoZapato = codZapato;
    end//
delimiter ;
-- call sp_ActualizarZapato(1, 'Zapatos', 'Nike', '41', 'Azul');

delimiter //
create procedure sp_BuscarZapato(in codZapato int)
begin
	select codigoZapato, nombre, marca, talla, color from Zapato
		where codigoZapato = codZapato;
end//
delimiter ;
-- call sp_BuscarZapato(1);

-- Procedimientos almacenados de Cliente
delimiter //
create procedure sp_AgregarCliente(
	in codZapato int,
    in nCliente varchar(256),
    in tCliente varchar(8),
    in cCliente varchar(256),
    in dCliente varchar(256)
    )
    begin
		insert into Cliente(codigoZapato, nombre, telefono, correo, direccion)
			values(codZapato, nCliente, tCliente, cCliente, dCliente);
    end//
delimiter ;
call sp_AgregarCliente(1, 'Ana López','12345678','ana.lopez@gmail.com','Zona 1');
call sp_AgregarCliente(2, 'Carlos Méndez','23456789','carlos.m@gmail.com','Zona 2');
call sp_AgregarCliente(3, 'Lucía Torres','34567890','lucia.t@gmail.com','Zona 3');
call sp_AgregarCliente(4, 'Mario Ruiz','45678901','mario.r@gmail.com','Zona 4');
call sp_AgregarCliente(5, 'Sandra Díaz','56789012','sandra.d@gmail.com','Zona 5');
call sp_AgregarCliente(6, 'José Ramírez','67890123','jose.r@gmail.com','Zona 6');
call sp_AgregarCliente(7, 'Paola Soto','78901234','paola.s@gmail.com','Zona 7');
call sp_AgregarCliente(8, 'Luis Castillo','89012345','luis.c@gmail.com','Zona 8');
call sp_AgregarCliente(9, 'Diana Pérez','90123456','diana.p@gmail.com','Zona 9');
call sp_AgregarCliente(10, 'Héctor Gómez','10234567','hector.g@gmail.com','Zona 10');

delimiter //
create procedure sp_ListarCliente()
	begin
		select codigoCliente, codigoZapato, nombre, telefono, correo, direccion from Cliente;
	end//
delimiter ;
call sp_ListarCliente();

delimiter //
create procedure sp_EliminarCliente(in codCliente int)
	begin
		delete from Cliente where codigoCliente = codCliente;
    end//
delimiter ;
-- call sp_EliminarCliente(1);

delimiter //
create procedure sp_ActualizarCliente(
	in codCliente int, 
    in codZapato int,
    in nCliente varchar(256),
    in tCliente varchar(8),
    in cCliente varchar(256),
    in dCliente varchar(256)
    )
    begin
		update Cliente
        set codigoZapato = codZapato, 
        nombre = nCliente,
        telefono = tCliente,
        correo = cCliente,
        direccion = dCliente
        where codigoCliente = codCliente;
    end//
delimiter ;
-- call sp_ActualizarCliente(1, 1, 'Sebastian', '14321432', 'sebastian@gmail.com', 'zona 2');

delimiter //
create procedure sp_BuscarCliente(in codCliente int)
	begin
		select codigoCliente, codigoZapato, nombre, telefono, correo, direccion from Cliente
        where codigoCliente = codCliente;
    end//
delimiter ;
-- call sp_BuscarCliente(1);