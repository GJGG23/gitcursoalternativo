-- Table: public.t_materias

-- DROP TABLE IF EXISTS public.t_materias;

CREATE TABLE IF NOT EXISTS public.t_materias
(
    id_t_materias integer NOT NULL DEFAULT 'nextval('t_materias_id_t_materias_seq'::regclass)',
    nombre character varying(80) COLLATE pg_catalog."default",
    activo integer NOT NULL DEFAULT 1,
    CONSTRAINT t_materias_pkey PRIMARY KEY (id_t_materias)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.t_materias
    OWNER to postgres;