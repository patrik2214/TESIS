CREATE TABLE USUARIO
(
    id serial primary key,
    usuario text NOT NULL,
    contraseña text NOT NULL,
    fecha date NOT NULL,
    estado boolean NOT NULL
);


CREATE TABLE ALUMNO
(
    id serial NOT NULL PRIMARY KEY,
    nombre text NOT NULL,
    apellido text NOT NULL,
    dni char(8) NOT NULL,
    fecha_nacimiento date NOT NULL,
    direccion text NOT NULL,
    codigo char(10) NOT NULL,
    correo text NOT NULL,
    contraseña text NOT NULL,
    estado char(1) NOT NULL,
    id_usuario integer NOT NULL REFERENCES usuario

);

CREATE TABLE DOCENTE
(
    id serial NOT NULL PRIMARY KEY,
    nombre text NOT NULL,
    apellido text NOT NULL,
    dni char(8) NOT NULL,
    fecha_nacimiento date NOT NULL,
    direccion text NOT NULL,
    codigo char(10) NOT NULL,
    correo text NOT NULL,
    contraseña text NOT NULL,
    estado char(1) NOT NULL,
    id_usuario integer NOT NULL REFERENCES usuario
);

CREATE TABLE AMBIENTE
(
    id serial NOT NULL,
    nombre text NOT NULL,
    descripcion text NOT NULL,
    estado char(1) NOT NULL,
    CONSTRAINT PK_ambiente PRIMARY KEY ( id )
);

CREATE TABLE HORARIO
(
    id serial NOT NULL,
    fecha date NOT NULL,
    hora_inicio time NOT NULL,
    hora_fin time NOT NULL,
    estado boolean NOT NULL,
    id_Ambiente integer NOT NULL,
    CONSTRAINT PK_horario PRIMARY KEY ( id ),
    CONSTRAINT FK_92 FOREIGN KEY ( id_Ambiente ) REFERENCES AMBIENTE ( id )
);

CREATE TABLE DOCUMENTO
(
    id serial NOT NULL,
    nombre text NOT NULL,
    descripcion text NULL,
    url text NOT NULL,
    id_Tesis integer NOT NULL,
    CONSTRAINT PK_documento PRIMARY KEY ( id ),
    CONSTRAINT FK_55 FOREIGN KEY ( id_Tesis ) REFERENCES TESIS ( id )
);

CREATE TABLE SUSTENTACION
(
    Id serial NOT NULL,
    fecha date NOT NULL,
    hora_inicio time NOT NULL,
    hora_fin time NOT NULL,
    calificación varchar(10) NOT NULL,
    comentarios text NOT NULL,
    decision varchar(10) NOT NULL,
    estado boolean NOT NULL,
    id_ambiente integer NOT NULL,
    CONSTRAINT PK_sustentacion PRIMARY KEY ( Id ),
    CONSTRAINT FK_173 FOREIGN KEY ( id_ambiente ) REFERENCES AMBIENTE ( id )
);

CREATE TABLE TESIS
(
    id serial NOT NULL,
    titulo text NOT NULL,
    tema text NOT NULL,
    fecha date NOT NULL,
    nota integer NOT NULL,
    resolucionJurado text NULL,
    fecha_jurado date NOT NULL,
    estado boolean NOT NULL,
    id_Alumno integer NOT NULL,
    Id_Sustentacion integer NULL,
    CONSTRAINT PK_tesis PRIMARY KEY ( id ),
    CONSTRAINT FK_145 FOREIGN KEY ( Id_Sustentacion ) REFERENCES SUSTENTACION ( Id ),
    CONSTRAINT FK_64 FOREIGN KEY ( id_Alumno ) REFERENCES ALUMNO ( id )
);

CREATE TABLE ASESORIA
(
    id serial NOT NULL,
    comentarios text NOT NULL,
    id_Docente integer NOT NULL,
    id_Tesis integer NOT NULL,
    id_Horario integer NOT NULL,
    CONSTRAINT PK_asesoria PRIMARY KEY ( id ),
    CONSTRAINT FK_101 FOREIGN KEY ( id_Horario ) REFERENCES HORARIO ( id ),
    CONSTRAINT FK_95 FOREIGN KEY ( id_Docente ) REFERENCES DOCENTE ( id ),
    CONSTRAINT FK_98 FOREIGN KEY ( id_Tesis ) REFERENCES TESIS ( id )
);

CREATE TABLE ASIGNACION_JURADO
(
    Id serial NOT NULL,
    id_Tesis integer NOT NULL,
    id_Docente integer NOT NULL,
    CONSTRAINT PK_jurado PRIMARY KEY ( Id ),
    CONSTRAINT FK_166 FOREIGN KEY ( id_Tesis ) REFERENCES TESIS ( id ),
    CONSTRAINT FK_169 FOREIGN KEY ( id_Docente ) REFERENCES DOCENTE ( id )
);

CREATE TABLE AUDITORIA
(
    id serial NOT NULL,
    comentarios varchar(100) NULL,
    estado boolean NULL,
    id_Tesis integer NOT NULL,
    id_Horario integer NOT NULL,
    CONSTRAINT PK_auditoria PRIMARY KEY ( id ),
    CONSTRAINT FK_116 FOREIGN KEY ( id_Tesis ) REFERENCES TESIS ( id ),
    CONSTRAINT FK_151 FOREIGN KEY ( id_Horario ) REFERENCES HORARIO ( id )
);