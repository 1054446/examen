package com.jesus.examen.examen.Service;

import com.jesus.examen.examen.Model.OpcionDto;
import com.jesus.examen.examen.Model.RespuestaApi;
import com.jesus.examen.examen.Model.ZonaHorariaDto;

public interface ZonaHorariaService {

    RespuestaApi getZona();
    RespuestaApi saveZona(ZonaHorariaDto zonaHorariaDto);
    RespuestaApi updateZona(ZonaHorariaDto zonaHorariaDto);
    RespuestaApi deleteZona(Long id);
}
