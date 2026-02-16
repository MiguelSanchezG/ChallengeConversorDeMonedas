package com.alura.challenge.principal;

import com.alura.challenge.conversor.ConversorMoneda;

import java.util.Scanner;

public class ChallengeConversor {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);

        while(true){
            System.out.println("******************************************");
            System.out.println("Sea bienvenido/a al conversor de moneda =]");
            System.out.println();
            System.out.println("1) Dolar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dolar");
            System.out.println("3) Dolar =>> Real brasileno");
            System.out.println("4) Real brasileno =>> Dolar");
            System.out.println("5) Dolar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dolar");
            System.out.println("7) Salir");
            System.out.println("Elija una opcion valida");
            System.out.println("******************************************");
            try{
                var opcion = lectura.nextInt();
                if(opcion == 7){
                    break;
                }
                System.out.println("Ingrese el valor que desear convertir: ");
                var valor = lectura.nextDouble();
                if(opcion<7 && opcion>0){
                    ConversorMoneda conversorMoneda = new ConversorMoneda();
                    System.out.println(conversorMoneda.convertirMoneda(valor,opcion));
                }
                else{
                    System.out.println("por favor selecciona una opcion valida");
                }
            }catch (Exception e){
                System.out.println("Opcion invalida, proceso terminado");
                break;
            }


        }


    }
}