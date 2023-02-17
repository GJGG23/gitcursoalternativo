-- PROCEDURE: public.readcalificaciones(integer, refcursor)

-- DROP PROCEDURE IF EXISTS public.readcalificaciones(integer, refcursor);

CREATE OR REPLACE PROCEDURE public.readcalificaciones(
	IN idusuario integer,
	INOUT pcursor refcursor DEFAULT 'rs_resultone'::refcursor)
LANGUAGE 'plpgsql'
AS $BODY$
                                                    
 BEGIN
 OPEN pcursor FOR 
		select  c.id_t_usuarios, a.nombre, a.ap_paterno, m.nombre,
		c.calificacion, TO_CHAR (c.fecha_registro, 'mm/dd/yyyy') as fecha
		from t_calificaciones c
		inner join t_materias m on c.id_t_materias = m.id_t_materias
		inner join t_alumnos a on c.id_t_usuarios = a.id_t_usuarios
		where c.id_t_usuarios = idusuario;
 END;
 
$BODY$;
ALTER PROCEDURE public.readcalificaciones(integer, refcursor)
    OWNER TO postgres;
