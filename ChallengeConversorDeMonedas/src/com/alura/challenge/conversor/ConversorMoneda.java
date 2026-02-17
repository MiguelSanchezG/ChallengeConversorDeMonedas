package com.alura.challenge.conversor;

import com.alura.challenge.modelos.Moneda;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMoneda {
     public String convertirMoneda(double valor, int conversor){
         double moneda=0;
         String buscar="";
         String aBuscar="USD";
         if(conversor == 1 || conversor == 3 || conversor == 5){
             buscar="USD";
             if(conversor==1){aBuscar="ARS";}
             else if(conversor==3){aBuscar="BRL";}
             else{aBuscar="COP";}
         }
         else if(conversor == 2){buscar = "ARS";}
         else if(conversor == 4){buscar = "BRL";}
         else{buscar="COP";}
         URI direccion = URI.create("https://v6.exchangerate-api.com/v6/724a06fc0a6245918056d6c8/latest/"+buscar);
         HttpClient client = HttpClient.newHttpClient();
         HttpRequest request = HttpRequest.newBuilder()
                 .uri(direccion)
                 .build();
         HttpResponse<String> response = null;
         try{
              response = client
                     .send(request, HttpResponse.BodyHandlers.ofString());



         } catch (Exception e) {
             throw new RuntimeException(e);
         }
         double calcular = 0;
         Moneda mon = new Gson().fromJson(response.body(), Moneda.class);
         calcular = (double) mon.conversion_rates().get(aBuscar);
         return "El valor "+valor+"["+buscar+"] corresponde al valor final de ===>>> "+calcular*valor+" ["+aBuscar+"]";
     }
}
