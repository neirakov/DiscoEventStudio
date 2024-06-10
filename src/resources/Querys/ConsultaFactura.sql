SELECT 
    e.id_evento,
    c.nombre AS cliente,
    GROUP_CONCAT(CONCAT(emp.nombre, ' ', emp.apellidos) SEPARATOR ', ') AS empleados,
    e.tipo_evento,
    IF(e.tipo_evento = 'boda', tb.nombre, tf.nombre) AS tipo_pack,
    IF(e.tipo_evento = 'boda', tb.descripcion, tf.descripcion) AS descripcion_pack,
    IF(e.tipo_evento = 'boda', tb.importe_base, tf.importe_base) AS importe_pack,
    f.modelo AS furgoneta,
    CASE 
        WHEN e.fotomaton = TRUE THEN 'SI'
        ELSE 'NO'
    END AS fotomaton,
    CASE 
        WHEN e.karaoke = TRUE THEN 'SI'
        ELSE 'NO'
    END AS karaoke,
    CASE 
        WHEN e.proyeccion = TRUE THEN 'SI'
        ELSE 'NO'
    END AS proyeccion,
    IF(e.fotomaton = TRUE, 
       CASE 
           WHEN e.tipo_evento = 'boda' THEN 400
           WHEN e.tipo_evento = 'fiesta' THEN 430
       END, 0) AS importe_base_fotomaton,
    IF(e.karaoke = TRUE, 200, 0) AS importe_base_karaoke,
    IF(e.proyeccion = TRUE, 80, 0) AS importe_base_proyeccion,
    e.horas_extra_disco,
    CASE 
        WHEN e.tipo_evento = 'boda' THEN 80
        WHEN e.tipo_evento = 'fiesta' THEN 60
    END AS importe_hora_extra_disco,
    e.horas_extra_fotomaton,
    50 AS importe_hora_extra_fotomaton,
    -- Calcular el importe total sin IVA
    (IF(e.tipo_evento = 'boda', tb.importe_base, tf.importe_base)
     + IF(e.fotomaton = TRUE, 
          CASE 
              WHEN e.tipo_evento = 'boda' THEN 400
              WHEN e.tipo_evento = 'fiesta' THEN 430
          END, 0)
     + IF(e.karaoke = TRUE, 200, 0)
     + IF(e.proyeccion = TRUE, 80, 0)
     + e.horas_extra_disco * CASE 
           WHEN e.tipo_evento = 'boda' THEN 80
           WHEN e.tipo_evento = 'fiesta' THEN 60
       END
     + e.horas_extra_fotomaton * 50) AS importe_total_calculado,
    -- Calcular el importe del IVA
    (IF(e.tipo_evento = 'boda', tb.importe_base, tf.importe_base)
     + IF(e.fotomaton = TRUE, 
          CASE 
              WHEN e.tipo_evento = 'boda' THEN 400
              WHEN e.tipo_evento = 'fiesta' THEN 430
          END, 0)
     + IF(e.karaoke = TRUE, 200, 0)
     + IF(e.proyeccion = TRUE, 80, 0)
     + e.horas_extra_disco * CASE 
           WHEN e.tipo_evento = 'boda' THEN 80
           WHEN e.tipo_evento = 'fiesta' THEN 60
       END
     + e.horas_extra_fotomaton * 50) * 0.21 AS importe_iva,
    -- Calcular el importe total con IVA incluido
    (IF(e.tipo_evento = 'boda', tb.importe_base, tf.importe_base)
     + IF(e.fotomaton = TRUE, 
          CASE 
              WHEN e.tipo_evento = 'boda' THEN 400
              WHEN e.tipo_evento = 'fiesta' THEN 430
          END, 0)
     + IF(e.karaoke = TRUE, 200, 0)
     + IF(e.proyeccion = TRUE, 80, 0)
     + e.horas_extra_disco * CASE 
           WHEN e.tipo_evento = 'boda' THEN 80
           WHEN e.tipo_evento = 'fiesta' THEN 60
       END
     + e.horas_extra_fotomaton * 50) * 1.21 AS importe_total_con_iva
FROM 
    Eventos e
LEFT JOIN 
    Clientes c ON e.id_cliente = c.id_cliente
LEFT JOIN 
    Furgonetas f ON e.id_furgoneta = f.id_furgoneta
LEFT JOIN 
    Tipos_Boda tb ON e.id_tipo_boda = tb.id_tipo_boda
LEFT JOIN 
    Tipos_Fiesta tf ON e.id_tipo_fiesta = tf.id_tipo_fiesta
LEFT JOIN 
    Empleados_Eventos ee ON e.id_evento = ee.id_evento
LEFT JOIN 
    Empleados emp ON ee.id_empleado = emp.id_empleado
GROUP BY 
    e.id_evento;
