-- Table: public.t_alumnos

-- DROP TABLE IF EXISTS public.t_alumnos;

CREATE TABLE IF NOT EXISTS public.t_alumnos
(
    id_t_usuarios integer NOT NULL DEFAULT 'nextval('t_alumnos_id_t_usuarios_seq'::regclass)',
    nombre character varying(80) COLLATE pg_catalog."default",
    ap_paterno character varying(80) COLLATE pg_catalog."default",
    ap_materno character varying(80) COLLATE pg_catalog."default",
    activo integer NOT NULL DEFAULT 1,
    CONSTRAINT t_alumnos_pkey PRIMARY KEY (id_t_usuarios)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.t_alumnos
    OWNER to postgres;