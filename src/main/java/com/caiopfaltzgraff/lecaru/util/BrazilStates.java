package com.caiopfaltzgraff.lecaru.util;

import java.util.HashMap;
import java.util.Map;

public class BrazilStates {

    private static final Map<String, String> statesMap = new HashMap<>();

    static {
        statesMap.put("AC", "Acre");
        statesMap.put("AL", "Alagoas");
        statesMap.put("AP", "Amapá");
        statesMap.put("AM", "Amazonas");
        statesMap.put("BA", "Bahia");
        statesMap.put("CE", "Ceará");
        statesMap.put("DF", "Distrito Federal");
        statesMap.put("ES", "Espírito Santo");
        statesMap.put("GO", "Goiás");
        statesMap.put("MA", "Maranhão");
        statesMap.put("MT", "Mato Grosso");
        statesMap.put("MS", "Mato Grosso do Sul");
        statesMap.put("MG", "Minas Gerais");
        statesMap.put("PA", "Pará");
        statesMap.put("PB", "Paraíba");
        statesMap.put("PR", "Paraná");
        statesMap.put("PE", "Pernambuco");
        statesMap.put("PI", "Piauí");
        statesMap.put("RJ", "Rio de Janeiro");
        statesMap.put("RN", "Rio Grande do Norte");
        statesMap.put("RS", "Rio Grande do Sul");
        statesMap.put("RO", "Rondônia");
        statesMap.put("RR", "Roraima");
        statesMap.put("SC", "Santa Catarina");
        statesMap.put("SP", "São Paulo");
        statesMap.put("SE", "Sergipe");
        statesMap.put("TO", "Tocantins");
    }

    public static String getStateFullName(String fu) {
        return statesMap.getOrDefault(fu, "Estado desconhecido");
    }

}
