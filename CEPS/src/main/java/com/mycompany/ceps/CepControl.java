package com.mycompany.ceps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

public class CepControl {

    public static Cep buscarCep(String cepDigitado) {
        Cep cep =new Cep(cepDigitado);
        try {
            URL url = new URL(" http://viacep.com.br/ws/" + cepDigitado + "/json");
            URLConnection connection = url.openConnection();
            String line;
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            JSONObject json = new JSONObject(builder.toString());

            cep.setCep(json.getString("cep"));
            cep.setLocalidade(json.getString("localidade"));
            cep.setBairro(json.getString("bairro"));
            cep.setComplemento(json.getString("complemento"));
            cep.setIbge(json.getString("ibge"));
            cep.setLogradouro(json.getString("logradouro"));
            cep.setUf(json.getString("uf"));

            System.out.println(cep);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return cep;

    }

}
