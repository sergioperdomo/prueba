package com.prueba.notificacion.notificacion.util;

import java.util.regex.Pattern;

public class Validador {

    public static boolean emailValido(String email){
        return Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", email);
    }

    public static boolean numeroColombianoValido(String numero){
        return numero.startsWith("+57") && numero.length() >= 10;
    }

}
