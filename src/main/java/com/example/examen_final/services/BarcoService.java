package com.example.examen_final.services;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BarcoService {


    public Map<String, Object> buscarBarco(String[] coordinates){
        Map<String, Object> response = new HashMap<>();
        List<String> coordenadasCorrectas = new ArrayList<>();

        for (String coordinate: coordinates){
            if(coordenasCorrectasBoolean(coordinate)){
                coordenadasCorrectas.add(coordinate);
            }
        }

        response.put("code", coordenadasCorrectas.size() == coordinates.length ? 200 : 403);
        response.put("coordinates", coordenadasCorrectas);
        response.put("result", coordenadasCorrectas.size() == coordinates.length ? "Ok" : "Faile");

        return response;
    }

    private boolean coordenasCorrectasBoolean(String coordinate){
        if (coordinate.length() != 5) {
            return false;
        }

        for (char c : coordinate.toCharArray()) {
            if (c != '0' && c != '1') {
                return false;
            }
        }
        return true;
    }

    public void ProcesarCoordenadas(String[] coordinates){
        for (String coordinate: coordinates){
            System.out.println(coordinate);
        }
    }
}
