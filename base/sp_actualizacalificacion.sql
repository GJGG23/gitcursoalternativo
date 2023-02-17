-- PROCEDURE: public.actualizacalificacion(integer, integer, real)

-- DROP PROCEDURE IF EXISTS public.actualizacalificacion(integer, integer, real);

CREATE OR REPLACE PROCEDURE public.actualizacalificacion(
	IN pidmateria integer,
	IN pidusuario integer,
	IN pcalificacion real)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN

UPDATE public.t_calificaciones
	SET calificacion = pcalificacion, fecha_registro = CURRENT_DATE
	WHERE id_t_materias = pidmateria and id_t_usuarios = pidusuario;
END 
$BODY$;
ALTER PROCEDURE public.actualizacalificacion(integer, integer, real)
    OWNER TO postgres;
