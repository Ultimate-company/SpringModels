package org.example.Constants;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class TimeZones {
    public static final String UTC = "UTC";
    public static final String GMT = "GMT";
    public static final String PST = "PST";
    public static final String PDT = "PDT";
    public static final String MST = "MST";
    public static final String MDT = "MDT";
    public static final String CST = "CST";
    public static final String CDT = "CDT";
    public static final String EST = "EST";
    public static final String EDT = "EDT";
    public static final String IST = "IST";
    public static final String BST = "BST";
    public static final String CEST = "CEST";
    public static final String CET = "CET";
    public static final String AEST = "AEST";
    public static final String AEDT = "AEDT";
    public static final String JST = "JST";
    public static final String KST = "KST";
    public static final String HKT = "HKT";
    public static final String SGT = "SGT";
    public static final String NZST = "NZST";
    public static final String NZDT = "NZDT";

    private static final Map<String, String> TIME_ZONE_MAP;

    static {
        Map<String, String> map = new TreeMap<>();
        map.put(UTC, "Coordinated Universal Time");
        map.put(GMT, "Greenwich Mean Time");
        map.put(PST, "Pacific Standard Time");
        map.put(PDT, "Pacific Daylight Time");
        map.put(MST, "Mountain Standard Time");
        map.put(MDT, "Mountain Daylight Time");
        map.put(CST, "Central Standard Time");
        map.put(CDT, "Central Daylight Time");
        map.put(EST, "Eastern Standard Time");
        map.put(EDT, "Eastern Daylight Time");
        map.put(IST, "Indian Standard Time");
        map.put(BST, "British Summer Time");
        map.put(CEST, "Central European Summer Time");
        map.put(CET, "Central European Time");
        map.put(AEST, "Australian Eastern Standard Time");
        map.put(AEDT, "Australian Eastern Daylight Time");
        map.put(JST, "Japan Standard Time");
        map.put(KST, "Korea Standard Time");
        map.put(HKT, "Hong Kong Time");
        map.put(SGT, "Singapore Time");
        map.put(NZST, "New Zealand Standard Time");
        map.put(NZDT, "New Zealand Daylight Time");
        TIME_ZONE_MAP = Collections.unmodifiableMap(map);
    }

    public static Map<String, String> getTimeZoneMap() {
        return TIME_ZONE_MAP;
    }
}
