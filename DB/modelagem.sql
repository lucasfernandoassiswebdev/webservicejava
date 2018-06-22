CREATE DATABASE fazenda
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;


CREATE TABLE animal
(
  id serial NOT NULL,
  nome character varying(50),
  caracteristicas character varying(50),
  criadofazenda bit(1),
  CONSTRAINT chaveprimaria PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE animal
  OWNER TO postgres;


CREATE TABLE fazenda
(
  id serial NOT NULL,
  nome character varying(100),
  hectares numeric,
  localizacao character varying(100),
  CONSTRAINT chavefazenda PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE fazenda
  OWNER TO postgres;


CREATE TABLE fazendaanimal
(
  idfazenda integer NOT NULL,
  idanimal integer NOT NULL,
  quantidade integer,
  CONSTRAINT aaa PRIMARY KEY (idfazenda, idanimal),
  CONSTRAINT "fazendaT" FOREIGN KEY (idfazenda)
      REFERENCES fazenda (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fazendaanimal_idanimal_fkey FOREIGN KEY (idanimal)
      REFERENCES animal (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE fazendaanimal
  OWNER TO postgres;


CREATE TABLE usuario
(
  login character varying(20) NOT NULL,
  senha character varying(20),
  perfil character varying(50),
  email character varying(50),
  CONSTRAINT chaveusuario PRIMARY KEY (login)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE usuario
  OWNER TO postgres;             