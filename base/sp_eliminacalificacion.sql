-- PROCEDURE: public.eliminacalificacion(integer, integer)

-- DROP PROCEDURE IF EXISTS public.eliminacalificacion(integer, integer);

CREATE OR REPLACE PROCEDURE public.eliminacalificacion(
	IN pidmateria integer,
	IN pidusuario integer)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN

	DELETE FROM public.t_calificaciones
	WHERE id_t_materias = pidmateria and id_t_usuarios = pidusuario;
END 
$BODY$;
ALTER PROCEDURE public.eliminacalificacion(integer, integer)
    OWNER TO postgres;
