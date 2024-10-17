package org.example.Constants;

import java.util.HashMap;
import java.util.Map;

public class FontStyles {
    public static final String ARIAL = "Arial";
    public static final String ARIAL_BLACK = "Arial Black";
    public static final String ARIAL_NARROW = "Arial Narrow";
    public static final String ARIAL_ROUNDED_MT_BOLD = "Arial Rounded MT Bold";
    public static final String AVANT_GARDE = "Avant Garde";
    public static final String CALIBRI = "Calibri";
    public static final String CANDARA = "Candara";
    public static final String CENTURY_GOTHIC = "Century Gothic";
    public static final String COMIC_SANS_MS = "Comic Sans MS";
    public static final String CONSOLAS = "Consolas";
    public static final String COURIER = "Courier";
    public static final String COURIER_NEW = "Courier New";
    public static final String FRANKLIN_GOTHIC_MEDIUM = "Franklin Gothic Medium";
    public static final String FUTURA = "Futura";
    public static final String GENEVA = "Geneva";
    public static final String GEORGIA = "Georgia";
    public static final String GILL_SANS = "Gill Sans";
    public static final String HELVETICA = "Helvetica";
    public static final String HELVETICA_NEUE = "Helvetica Neue";
    public static final String IMPACT = "Impact";
    public static final String LUCIDA_CONSOLE = "Lucida Console";
    public static final String LUCIDA_GRANDE = "Lucida Grande";
    public static final String LUCIDA_SANS_UNICODE = "Lucida Sans Unicode";
    public static final String MICROSOFT_SANS_SERIF = "Microsoft Sans Serif";
    public static final String MONACO = "Monaco";
    public static final String OPTIMA = "Optima";
    public static final String PALATINO = "Palatino";
    public static final String PALATINO_LINOTYPE = "Palatino Linotype";
    public static final String SEGOE_PRINT = "Segoe Print";
    public static final String SEGOE_SCRIPT = "Segoe Script";
    public static final String SEGOE_UI = "Segoe UI";
    public static final String TAHOMA = "Tahoma";
    public static final String TIMES = "Times";
    public static final String TIMES_NEW_ROMAN = "Times New Roman";
    public static final String TREBUCHET_MS = "Trebuchet MS";
    public static final String VERDANA = "Verdana";

    private static final Map<String, String> LABEL_MAP = new HashMap<>();

    static {
        LABEL_MAP.put(ARIAL, "Arial");
        LABEL_MAP.put(ARIAL_BLACK, "Arial Black");
        LABEL_MAP.put(ARIAL_NARROW, "Arial Narrow");
        LABEL_MAP.put(ARIAL_ROUNDED_MT_BOLD, "Arial Rounded MT Bold");
        LABEL_MAP.put(AVANT_GARDE, "Avant Garde");
        LABEL_MAP.put(CALIBRI, "Calibri");
        LABEL_MAP.put(CANDARA, "Candara");
        LABEL_MAP.put(CENTURY_GOTHIC, "Century Gothic");
        LABEL_MAP.put(COMIC_SANS_MS, "Comic Sans MS");
        LABEL_MAP.put(CONSOLAS, "Consolas");
        LABEL_MAP.put(COURIER, "Courier");
        LABEL_MAP.put(COURIER_NEW, "Courier New");
        LABEL_MAP.put(FRANKLIN_GOTHIC_MEDIUM, "Franklin Gothic Medium");
        LABEL_MAP.put(FUTURA, "Futura");
        LABEL_MAP.put(GENEVA, "Geneva");
        LABEL_MAP.put(GEORGIA, "Georgia");
        LABEL_MAP.put(GILL_SANS, "Gill Sans");
        LABEL_MAP.put(HELVETICA, "Helvetica");
        LABEL_MAP.put(HELVETICA_NEUE, "Helvetica Neue");
        LABEL_MAP.put(IMPACT, "Impact");
        LABEL_MAP.put(LUCIDA_CONSOLE, "Lucida Console");
        LABEL_MAP.put(LUCIDA_GRANDE, "Lucida Grande");
        LABEL_MAP.put(LUCIDA_SANS_UNICODE, "Lucida Sans Unicode");
        LABEL_MAP.put(MICROSOFT_SANS_SERIF, "Microsoft Sans Serif");
        LABEL_MAP.put(MONACO, "Monaco");
        LABEL_MAP.put(OPTIMA, "Optima");
        LABEL_MAP.put(PALATINO, "Palatino");
        LABEL_MAP.put(PALATINO_LINOTYPE, "Palatino Linotype");
        LABEL_MAP.put(SEGOE_PRINT, "Segoe Print");
        LABEL_MAP.put(SEGOE_SCRIPT, "Segoe Script");
        LABEL_MAP.put(SEGOE_UI, "Segoe UI");
        LABEL_MAP.put(TAHOMA, "Tahoma");
        LABEL_MAP.put(TIMES, "Times");
        LABEL_MAP.put(TIMES_NEW_ROMAN, "Times New Roman");
        LABEL_MAP.put(TREBUCHET_MS, "Trebuchet MS");
        LABEL_MAP.put(VERDANA, "Verdana");
    }

    public static Map<String, String> getLabels() {
        return LABEL_MAP;
    }
}
