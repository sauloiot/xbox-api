package com.ghost.xboxapi.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String getDataConvertida(Date date) {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formatador.format(date);
    }
}
