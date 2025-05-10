-- Insertar tipos de usuario
INSERT INTO gym.USERTYPE (ID, DESCRIPTION) VALUES
(1, 'Entrenador'),
(2, 'Cliente'),
(3, 'Nutricionista'),
(4, 'Administrador');

INSERT INTO gym.Users (ID, PASSWORD, USERNAME, id_userType)VALUES
(1,'admin','admin',4);
(2,'entrenador','entrenador',1);
(3,'cliente','cliente',2);
(4,'nutricionista','nutricionista',3);

-- Insertar gimnasios (deben ir primero)
INSERT INTO gym.GYM (ID, address, NAME, phone) VALUES
(1, 'Av. Siempre Viva 123', 'Gym Central', '555-1234'),
(2, 'Calle Falsa 456', 'Fitness Club', '555-5678'),
(3, 'Boulevard del Ejercicio 789', 'PowerHouse', '555-9012');

-- Insertar clientes
INSERT INTO gym.CUSTOMER (ID, DNI, EMAIL, GOAL, LASTNAME, NAME, GYM_ID) VALUES
(1, '12345678A', 'juan.perez@example.com', 'Ser el mas facha', 'Pérez', 'Juan', 1),
(2, '87654321B', 'ana.lopez@example.com', NULL, 'López', 'Ana', 2),
(3, '11223344C', 'carlos.gomez@example.com', NULL, 'Gómez', 'Carlos', 1),
(4, '44332211D', 'maria.ramirez@example.com', NULL, 'Ramírez', 'María', 3),
(5, '55667788E', 'lucas.martin@example.com', NULL, 'Martín', 'Lucas', 2),
(6, '99887766F', 'laura.torres@example.com', NULL, 'Torres', 'Laura', 1),
(7, '66778899G', 'david.ruiz@example.com', NULL, 'Ruiz', 'David', 3),
(8, '77889900H', 'sofia.fernandez@example.com', NULL, 'Fernández', 'Sofía', 2),
(9, '88990011I', 'jorge.navarro@example.com', NULL, 'Navarro', 'Jorge', 1),
(10, '99001122J', 'paula.molina@example.com', 'Estar top', 'Molina', 'Paula', 3);
