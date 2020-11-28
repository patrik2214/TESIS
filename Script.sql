CREATE TABLE ALUMNO
(
    id serial NOT NULL,
    nombre text NOT NULL,
    apellido text NOT NULL,
    dni char(8) NOT NULL,
    fecha_nacimiento date NOT NULL,
    direccion text NOT NULL,
    correo text NOT NULL,
    estado char(1) NOT NULL,
    CONSTRAINT PK_alumno PRIMARY KEY ( id )
);

CREATE TABLE DOCENTE
(
    id serial NOT NULL,
    nombre text NOT NULL,
    apellido text NOT NULL,
    dni char(8) NOT NULL,
    fecha_nacimiento date NOT NULL,
    direccion text NOT NULL,
    correo text NOT NULL,
    estado char(1) NOT NULL,
    CONSTRAINT PK_docente PRIMARY KEY ( id )
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
    CONSTRAINT PK_sustentacion PRIMARY KEY ( Id )
);

CREATE TABLE TESIS
(
    id serial NOT NULL,
    titulo text NOT NULL,
    tema text NOT NULL,
    fecha date NOT NULL,
    nota integer NULL,
    resolucion_Jurado text NULL,
    fecha_jurado date NULL,
    resolucion_Asesor text NULL,
    fecha_asesor date null,
    resolucion_Sustentacion text NULL,
    fecha_sustentacion date null,
    url text NULL,
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
    fecha date NOT NULL,
    CONSTRAINT PK_asesoria PRIMARY KEY ( id ),
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
    fecha date NOT NULL,
    CONSTRAINT PK_auditoria PRIMARY KEY ( id ),
    CONSTRAINT FK_116 FOREIGN KEY ( id_Tesis ) REFERENCES TESIS ( id )
);

INSERT INTO alumno
VALUES
    (1, 'Brawer', 'Nuñez Mesones', '73820292', '28-02-1999', 'Mz A Lt20', 'nmesonesb@gmail.com', 'A');
INSERT INTO alumno
VALUES
    (2, 'Brandon Alonso', 'Chiroque Huamanchumo', '73811206', '28-02-1999', 'Mz E Lote 1', 'xiroque@gmail.com', 'A');
INSERT INTO alumno
VALUES
    (3, 'Carlos', 'Olivos Seclen', '73039283', '14-05-2000', 'Mz U Lote 3', 'seclen@gmail.com', 'A');


--CONSULTAS 

--Reporte de tesis aprobadas y rechazadas por año
    /*
        SELECT COUNT(*) as valor FROM alumno 
        INNER JOIN tesis on tesis.id_Alumno = alumno.id
        INNER JOIN sustentacion on sustentacion.id=tesis.id_Sustentacion
        WHERE  EXTRACT(YEAR FROM sustentacion.fecha)::int >= 2001 and EXTRACT(YEAR FROM sustentacion.fecha)::int <= 2005
        GROUP BY tesis.estado;
    */
    


--Reporte de tesis por pasar de año
    /*
        SELECT alumno.nombre||' '||alumno.apellido AS tesista,tesis.titulo, sustentacion.fecha FROM alumno 
        INNER JOIN tesis on tesis.id_Alumno = alumno.id
        INNER JOIN sustentacion on sustentacion.id=tesis.id_Sustentacion
        WHERE  (tesis.fecha- current_date)::int <=48
    */
    

--Reporte de tesis por sustentar segun el mes ingresado 
    /*
        SELECT alumno.nombre||' '||alumno.apellido AS tesista,tesis.titulo, sustentacion.fecha FROM alumno 
        INNER JOIN tesis on tesis.id_Alumno = alumno.id
        INNER JOIN sustentacion on sustentacion.id=tesis.id_Sustentacion
        WHERE  EXTRACT(MONTH FROM sustentacion.fecha)::int = 1
    */
    