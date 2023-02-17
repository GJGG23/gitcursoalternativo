-- PROCEDURE: public.addcalificacion(integer, integer, real)

-- DROP PROCEDURE IF EXISTS public.addcalificacion(integer, integer, real);

CREATE OR REPLACE PROCEDURE public.addcalificacion(
	IN idmateria integer,
	IN idusuario integer,
	IN calificacion real)
LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
	mensaje varchar;
BEGIN

INSERT INTO public.t_calificaciones(
	id_t_materias, id_t_usuarios, calificacion, fecha_registro)
	VALUES (idmateria, idusuario, calificacion, CURRENT_DATE);
END 
$BODY$;
ALTER PROCEDURE public.addcalificacion(integer, integer, real)
    OWNER TO postgres;
