-- Table: public.t_calificaciones

-- DROP TABLE IF EXISTS public.t_calificaciones;

CREATE TABLE IF NOT EXISTS public.t_calificaciones
(
    id_t_calificaciones integer NOT NULL DEFAULT 'nextval('t_calificaciones_id_t_calificaciones_seq'::regclass)',
    id_t_materias integer NOT NULL,
    id_t_usuarios integer NOT NULL,
    calificacion real,
    fecha_registro date,
    CONSTRAINT t_calificaciones_pkey PRIMARY KEY (id_t_calificaciones),
    CONSTRAINT t_calificaciones_id_t_materias_fkey FOREIGN KEY (id_t_materias)
        REFERENCES public.t_materias (id_t_materias) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT t_calificaciones_id_t_materias_fkey1 FOREIGN KEY (id_t_materias)
        REFERENCES public.t_materias (id_t_materias) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.t_calificaciones
    OWNER to postgres;