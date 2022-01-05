
/* tabla medicos */
INSERT INTO medicos (id, nombre, apellido, documento_identidad, profesion, telefono, email) VALUES(1, 'Ricardo', 'Gutierrez', '0394', 'Medico general', '3122020', 'ricardo@gmail.com');
INSERT INTO medicos (id, nombre, apellido, documento_identidad, profesion, telefono, email) VALUES(2, 'Monica', 'Ramirez', '5678', 'Psicologa', '3122060', 'Monica@gmail.com');
INSERT INTO medicos (id, nombre, apellido, documento_identidad, profesion, telefono, email) VALUES(3, 'Angela', 'Muñoz', '4526', 'Fisioterapeuta', '3122067', 'angela@gmail.com');
INSERT INTO medicos (id, nombre, apellido, documento_identidad, profesion, telefono, email) VALUES(4, 'Sebastian', 'Velez', '5235', 'Cardiologo', '3122012', 'sebastian@gmail.com');
INSERT INTO medicos (id, nombre, apellido, documento_identidad, profesion, telefono, email) VALUES(5, 'Santiago', 'Guerra', '8976', 'Gastroenterologo', '3122080', 'santiago@gmail.com');

/* tabla pacientes */
INSERT INTO pacientes (nombre, apellido, documento_identidad, genero, lugar_nacimiento, fecha_nacimiento, tipo_sangre, eps, direccion, telefono, email, estado_civil) VALUES('Juan', 'Botero', '1234', 'Masculino', 'Pereira', '2000-01-01', 'O+', 'Sura', '30 de agosto #30-10', '3122020', 'juan@gmail.com', 'Soltero');
INSERT INTO pacientes (nombre, apellido, documento_identidad, genero, lugar_nacimiento, fecha_nacimiento, tipo_sangre, eps, direccion, telefono, email, estado_civil) VALUES('Felix', 'Ruiz', '3456', 'Masculino', 'Pereira', '2004-01-01', 'O+', 'Nueva', '30 de agosto #30-23', '3122054', 'felix@gmail.com', 'Casado');
INSERT INTO pacientes (nombre, apellido, documento_identidad, genero, lugar_nacimiento, fecha_nacimiento, tipo_sangre, eps, direccion, telefono, email, estado_civil) VALUES('Maria', 'Ramirez', '9867', 'Femenino', 'Manizales', '2001-01-01', '0-', 'Saludcoop', '30 de agosto #30-67', '3122078', 'maria@gmail.com', 'Soltera');
INSERT INTO pacientes (nombre, apellido, documento_identidad, genero, lugar_nacimiento, fecha_nacimiento, tipo_sangre, eps, direccion, telefono, email, estado_civil) VALUES('Ivan', 'Gomez', '5678', 'Masculino', 'Cucuta', '1989-01-01', 'A+', 'Sura', '30 de agosto #30-56', '3122050', 'ivan@gmail.com', 'Viudo');
INSERT INTO pacientes (nombre, apellido, documento_identidad, genero, lugar_nacimiento, fecha_nacimiento, tipo_sangre, eps, direccion, telefono, email, estado_civil) VALUES('Jose', 'Galindo', '3459', 'Masculino', 'Pereira', '1992-01-01', 'A-', 'Colsanitas', '30 de agosto #30-34', '3122098', 'jose@gmail.com', 'Soltero');
INSERT INTO pacientes (nombre, apellido, documento_identidad, genero, lugar_nacimiento, fecha_nacimiento, tipo_sangre, eps, direccion, telefono, email, estado_civil) VALUES('Aleja', 'Botero', '9367', 'Femenino', 'Pereira', '2000-01-01', 'O+', 'Sura', '30 de agosto #30-10', '3122020', 'aleja@gmail.com', 'Soltera');
INSERT INTO pacientes (nombre, apellido, documento_identidad, genero, lugar_nacimiento, fecha_nacimiento, tipo_sangre, eps, direccion, telefono, email, estado_civil) VALUES('Juan', 'Vargas', '5689', 'Masculino', 'Pereira', '2000-01-01', 'O+', 'Sura', '30 de agosto #30-10', '3122020', 'juan1@gmail.com', 'Soltero');
INSERT INTO pacientes (nombre, apellido, documento_identidad, genero, lugar_nacimiento, fecha_nacimiento, tipo_sangre, eps, direccion, telefono, email, estado_civil) VALUES('Pepe', 'Morales', '9258', 'Masculino', 'Manizales', '2000-01-01', 'A+', 'Sura', '30 de agosto #30-10', '3122020', 'Pepe@gmail.com', 'Soltero');
INSERT INTO pacientes (nombre, apellido, documento_identidad, genero, lugar_nacimiento, fecha_nacimiento, tipo_sangre, eps, direccion, telefono, email, estado_civil) VALUES('Alicia', 'Botero', '4375', 'Femenino', 'Pereira', '2000-01-01', 'A-', 'Sura', '30 de agosto #30-10', '3122020', 'alicia@gmail.com', 'Soltera');
INSERT INTO pacientes (nombre, apellido, documento_identidad, genero, lugar_nacimiento, fecha_nacimiento, tipo_sangre, eps, direccion, telefono, email, estado_civil) VALUES('Ruben', 'Botero', '4367', 'Masculino', 'Pereira', '2000-01-01', 'O+', 'Sura', '30 de agosto #30-10', '3122020', 'ruben@gmail.com', 'Soltero');
INSERT INTO pacientes (nombre, apellido, documento_identidad, genero, lugar_nacimiento, fecha_nacimiento, tipo_sangre, eps, direccion, telefono, email, estado_civil) VALUES('Lina', 'Botero', '9700', 'Femenino', 'Pereira', '2000-01-01', 'O+', 'Sura', '30 de agosto #30-10', '3122020', 'lina@gmail.com', 'Soltera');
INSERT INTO pacientes (nombre, apellido, documento_identidad, genero, lugar_nacimiento, fecha_nacimiento, tipo_sangre, eps, direccion, telefono, email, estado_civil) VALUES('Popeye', 'Botero', '0765', 'Masculino', 'Pereira', '2000-01-01', 'O+', 'Sura', '30 de agosto #30-10', '3122020', 'popeye@gmail.com', 'Casado');

/* tabla consultas */
INSERT INTO consultas (medico_id, motivo_consulta, alergias,patologias, patologias_familiares, medicamento, diagnostico, tratamiento, paciente_id, created_at) VALUES(1, 'Malestar general', 'Ninguna', 'Ninguna', 'Diabetes', 'Ninguno', 'Gripa', 'Acetaminofen', 1, '2021-02-13');
INSERT INTO consultas (medico_id, motivo_consulta, alergias,patologias, patologias_familiares, medicamento, diagnostico, tratamiento, paciente_id, created_at) VALUES(5, 'Dolor abdominal', 'Ninguna', 'Ninguna', 'Diabetes', 'Ninguno', 'Gastroenteritis', 'Ozomeprazol', 1, '2021-06-23');
INSERT INTO consultas (medico_id, motivo_consulta, alergias,patologias, patologias_familiares, medicamento, diagnostico, tratamiento, paciente_id, created_at) VALUES(4, 'Dolor de cabeza', 'Piña, fresa, cerdo', 'Ninguna', 'Cancer', 'Advil', 'Migraña', 'Acetaminofen, Advil forte', 2, '2021-04-10');
INSERT INTO consultas (medico_id, motivo_consulta, alergias,patologias, patologias_familiares, medicamento, diagnostico, tratamiento, paciente_id, created_at) VALUES(5, 'Diarrea', 'Ninguna', 'Gastritis cronica', 'Ninguna', 'Ninguno', 'Bacterias y amibas', 'Fuluzal', 3, '2021-09-20');
