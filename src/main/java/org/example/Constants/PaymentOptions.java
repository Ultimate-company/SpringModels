package org.example.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PaymentOptions {
    public static class CreditAndDebitCards {
        public static final String AMERICAN_EXPRESS = "American Express";
        public static final String DINERS_CLUB = "Diners Club";
        public static final String MAESTRO = "Maestro";
        public static final String MASTERCARD = "MasterCard";
        public static final String RUPAY = "RuPay";
        public static final String VISA = "Visa";
        public static final String BAJAJ_FINSERV = "Bajaj Finserv";

        private static final TreeMap<String, String> LABEL_MAP = new TreeMap<>();

        static {
            LABEL_MAP.put(AMERICAN_EXPRESS, "American Express");
            LABEL_MAP.put(DINERS_CLUB, "Diners Club");
            LABEL_MAP.put(MAESTRO, "Maestro");
            LABEL_MAP.put(MASTERCARD, "MasterCard");
            LABEL_MAP.put(RUPAY, "RuPay");
            LABEL_MAP.put(VISA, "Visa");
            LABEL_MAP.put(BAJAJ_FINSERV, "Bajaj Finserv");
        }

        public static TreeMap<String, String> getLabels() {
            return LABEL_MAP;
        }
    }

    public static class SupportedBanks {
        public static final String AU_SMALL_FINANCE_BANK = "AUBL";
        public static final String ADITYA_BIRLA_IDEA_PAYMENTS_BANK = "ABPB";
        public static final String AIRTEL_PAYMENTS_BANK = "AIRP";
        public static final String ALLAHABAD_BANK = "ALLA";
        public static final String ANDHRA_BANK = "ANDB";
        public static final String ANDHRA_BANK_CORPORATE_BANKING = "ANDB_C";
        public static final String AXIS_BANK = "UTIB";
        public static final String BANDHAN_BANK = "BDBL";
        public static final String BANK_OF_BAHRAIN_AND_KUWAIT = "BBKM";
        public static final String BANK_OF_BARODA_RETAIL_BANKING = "BARB_R";
        public static final String BANK_OF_INDIA = "BKID";
        public static final String BANK_OF_MAHARASHTRA = "MAHB";
        public static final String BASSEIN_CATHOLIC_COOPERATIVE_BANK = "BACB";
        public static final String CANARA_BANK = "CNRB";
        public static final String CATHOLIC_SYRIAN_BANK = "CSBK";
        public static final String CENTRAL_BANK_OF_INDIA = "CBIN";
        public static final String CITY_UNION_BANK = "CIUB";
        public static final String CORPORATION_BANK = "CORP";
        public static final String COSMOS_COOPERATIVE_BANK = "COSB";
        public static final String DCB_BANK = "DCBL";
        public static final String DENA_BANK = "BKDN";
        public static final String DEUTSCHE_BANK = "DEUT";
        public static final String DEVELOPMENT_BANK_OF_SINGAPORE = "DBSS";
        public static final String DHANLAXMI_BANK = "DLXB";
        public static final String DHANLAXMI_BANK_CORPORATE_BANKING = "DLXB_C";
        public static final String ESAF_SMALL_FINANCE_BANK = "ESAF";
        public static final String EQUITAS_SMALL_FINANCE_BANK = "ESFB";
        public static final String FEDERAL_BANK = "FDRL";
        public static final String HDFC_BANK = "HDFC";
        public static final String ICICI_BANK = "ICIC";
        public static final String IDBI = "IBKL";
        public static final String IDBI_CORPORATE_BANKING = "IBKL_C";
        public static final String IDFC_FIRST_BANK = "IDFB";
        public static final String INDIAN_BANK = "IDIB";
        public static final String INDIAN_OVERSEAS_BANK = "IOBA";
        public static final String INDUSIND_BANK = "INDB";
        public static final String JAMMU_AND_KASHMIR_BANK = "JAKA";
        public static final String JANATA_SAHAKARI_BANK_PUNE = "JSBP";
        public static final String KALUPUR_COMMERCIAL_COOPERATIVE_BANK = "KCCB";
        public static final String KALYAN_JANATA_SAHAKARI_BANK = "KJSB";
        public static final String KARNATAKA_BANK = "KARB";
        public static final String KARUR_VYSYA_BANK = "KVBL";
        public static final String KOTAK_MAHINDRA_BANK = "KKBK";
        public static final String LAKSHMI_VILAS_BANK_CORPORATE_BANKING = "LAVB_C";
        public static final String LAKSHMI_VILAS_BANK_RETAIL_BANKING = "LAVB_R";
        public static final String MEHSANA_URBAN_COOPERATIVE_BANK = "MSNU";
        public static final String NKGSB_COOPERATIVE_BANK = "NKGS";
        public static final String NORTH_EAST_SMALL_FINANCE_BANK = "NESF";
        public static final String PNB_ERSTWHILE_ORIENTAL_BANK_OF_COMMERCE = "ORBC";
        public static final String PNB_ERSTWHILE_UNITED_BANK_OF_INDIA = "UTBI";
        public static final String PUNJAB_NATIONAL_BANK_RETAIL_BANKING = "PUNB_R";
        public static final String RBL_BANK = "RATN";
        public static final String RBL_BANK_CORPORATE_BANKING = "RATN_C";
        public static final String SARASWAT_COOPERATIVE_BANK = "SRCB";
        public static final String SHAMRAO_VITHAL_BANK_CORPORATE_BANKING = "SVCB_C";
        public static final String SHAMRAO_VITHAL_COOPERATIVE_BANK = "SVCB";
        public static final String SOUTH_INDIAN_BANK = "SIBL";
        public static final String STANDARD_CHARTERED_BANK = "SCBL";
        public static final String STATE_BANK_OF_BIKANER_AND_JAIPUR = "SBBJ";
        public static final String STATE_BANK_OF_HYDERABAD = "SBHY";
        public static final String STATE_BANK_OF_INDIA = "SBIN";
        public static final String STATE_BANK_OF_MYSORE = "SBMY";
        public static final String STATE_BANK_OF_PATIALA = "STBP";
        public static final String STATE_BANK_OF_TRAVANCORE = "SBTR";
        public static final String SURYODAY_SMALL_FINANCE_BANK = "SURY";
        public static final String SYNDICATE_BANK = "SYN";
        public static final String TAMILNADU_MERCANTILE_BANK = "TMBL";
        public static final String TAMILNADU_STATE_APEX_COOPERATIVE_BANK = "TNSC";
        public static final String THANE_BHARAT_SAHAKARI_BANK = "TBSB";
        public static final String THANE_JANATA_SAHAKARI_BANK = "TJSB";
        public static final String UCO_BANK = "UCBA";
        public static final String UNION_BANK_OF_INDIA = "UBIN";
        public static final String VARACHHA_COOPERATIVE_BANK = "VARA";
        public static final String VIJAYA_BANK = "VIJB";
        public static final String YES_BANK = "YESB";
        public static final String YES_BANK_CORPORATE_BANKING = "YESB_C";
        public static final String ZOROASTRIAN_COOPERATIVE_BANK = "ZCBL";

        private static final TreeMap<String, String> LABEL_MAP = new TreeMap<>();

        static {
            LABEL_MAP.put(AU_SMALL_FINANCE_BANK, "AU Small Finance Bank");
            LABEL_MAP.put(ADITYA_BIRLA_IDEA_PAYMENTS_BANK, "Aditya Birla Idea Payments Bank");
            LABEL_MAP.put(AIRTEL_PAYMENTS_BANK, "Airtel Payments Bank");
            LABEL_MAP.put(ALLAHABAD_BANK, "Allahabad Bank");
            LABEL_MAP.put(ANDHRA_BANK, "Andhra Bank");
            LABEL_MAP.put(ANDHRA_BANK_CORPORATE_BANKING, "Andhra Bank Corporate Banking");
            LABEL_MAP.put(AXIS_BANK, "Axis Bank");
            LABEL_MAP.put(BANDHAN_BANK, "Bandhan Bank");
            LABEL_MAP.put(BANK_OF_BAHRAIN_AND_KUWAIT, "Bank of Bahrain and Kuwait");
            LABEL_MAP.put(BANK_OF_BARODA_RETAIL_BANKING, "Bank of Baroda Retail Banking");
            LABEL_MAP.put(BANK_OF_INDIA, "Bank of India");
            LABEL_MAP.put(BANK_OF_MAHARASHTRA, "Bank of Maharashtra");
            LABEL_MAP.put(BASSEIN_CATHOLIC_COOPERATIVE_BANK, "Bassein Catholic Cooperative Bank");
            LABEL_MAP.put(CANARA_BANK, "Canara Bank");
            LABEL_MAP.put(CATHOLIC_SYRIAN_BANK, "Catholic Syrian Bank");
            LABEL_MAP.put(CENTRAL_BANK_OF_INDIA, "Central Bank of India");
            LABEL_MAP.put(CITY_UNION_BANK, "City Union Bank");
            LABEL_MAP.put(CORPORATION_BANK, "Corporation Bank");
            LABEL_MAP.put(COSMOS_COOPERATIVE_BANK, "Cosmos Cooperative Bank");
            LABEL_MAP.put(DCB_BANK, "DCB Bank");
            LABEL_MAP.put(DENA_BANK, "Dena Bank");
            LABEL_MAP.put(DEUTSCHE_BANK, "Deutsche Bank");
            LABEL_MAP.put(DEVELOPMENT_BANK_OF_SINGAPORE, "Development Bank of Singapore");
            LABEL_MAP.put(DHANLAXMI_BANK, "Dhanlaxmi Bank");
            LABEL_MAP.put(DHANLAXMI_BANK_CORPORATE_BANKING, "Dhanlaxmi Bank Corporate Banking");
            LABEL_MAP.put(ESAF_SMALL_FINANCE_BANK, "ESAF Small Finance Bank");
            LABEL_MAP.put(EQUITAS_SMALL_FINANCE_BANK, "Equitas Small Finance Bank");
            LABEL_MAP.put(FEDERAL_BANK, "Federal Bank");
            LABEL_MAP.put(HDFC_BANK, "HDFC Bank");
            LABEL_MAP.put(ICICI_BANK, "ICICI Bank");
            LABEL_MAP.put(IDBI, "IDBI");
            LABEL_MAP.put(IDBI_CORPORATE_BANKING, "IDBI Corporate Banking");
            LABEL_MAP.put(IDFC_FIRST_BANK, "IDFC First Bank");
            LABEL_MAP.put(INDIAN_BANK, "Indian Bank");
            LABEL_MAP.put(INDIAN_OVERSEAS_BANK, "Indian Overseas Bank");
            LABEL_MAP.put(INDUSIND_BANK, "IndusInd Bank");
            LABEL_MAP.put(JAMMU_AND_KASHMIR_BANK, "Jammu and Kashmir Bank");
            LABEL_MAP.put(JANATA_SAHAKARI_BANK_PUNE, "Janata Sahakari Bank Pune");
            LABEL_MAP.put(KALUPUR_COMMERCIAL_COOPERATIVE_BANK, "Kalupur Commercial Cooperative Bank");
            LABEL_MAP.put(KALYAN_JANATA_SAHAKARI_BANK, "Kalyan Janata Sahakari Bank");
            LABEL_MAP.put(KARNATAKA_BANK, "Karnataka Bank");
            LABEL_MAP.put(KARUR_VYSYA_BANK, "Karur Vysya Bank");
            LABEL_MAP.put(KOTAK_MAHINDRA_BANK, "Kotak Mahindra Bank");
            LABEL_MAP.put(LAKSHMI_VILAS_BANK_CORPORATE_BANKING, "Lakshmi Vilas Bank Corporate Banking");
            LABEL_MAP.put(LAKSHMI_VILAS_BANK_RETAIL_BANKING, "Lakshmi Vilas Bank Retail Banking");
            LABEL_MAP.put(MEHSANA_URBAN_COOPERATIVE_BANK, "Mehsana Urban Cooperative Bank");
            LABEL_MAP.put(NKGSB_COOPERATIVE_BANK, "NKGSB Cooperative Bank");
            LABEL_MAP.put(NORTH_EAST_SMALL_FINANCE_BANK, "North East Small Finance Bank");
            LABEL_MAP.put(PNB_ERSTWHILE_ORIENTAL_BANK_OF_COMMERCE, "PNB erstwhile Oriental Bank of Commerce");
            LABEL_MAP.put(PNB_ERSTWHILE_UNITED_BANK_OF_INDIA, "PNB erstwhile United Bank of India");
            LABEL_MAP.put(PUNJAB_NATIONAL_BANK_RETAIL_BANKING, "Punjab National Bank Retail Banking");
            LABEL_MAP.put(RBL_BANK, "RBL Bank");
            LABEL_MAP.put(RBL_BANK_CORPORATE_BANKING, "RBL Bank Corporate Banking");
            LABEL_MAP.put(SARASWAT_COOPERATIVE_BANK, "Saraswat Cooperative Bank");
            LABEL_MAP.put(SHAMRAO_VITHAL_BANK_CORPORATE_BANKING, "Shamrao Vithal Bank Corporate Banking");
            LABEL_MAP.put(SHAMRAO_VITHAL_COOPERATIVE_BANK, "Shamrao Vithal Cooperative Bank");
            LABEL_MAP.put(SOUTH_INDIAN_BANK, "South Indian Bank");
            LABEL_MAP.put(STANDARD_CHARTERED_BANK, "Standard Chartered Bank");
            LABEL_MAP.put(STATE_BANK_OF_BIKANER_AND_JAIPUR, "State Bank of Bikaner and Jaipur");
            LABEL_MAP.put(STATE_BANK_OF_HYDERABAD, "State Bank of Hyderabad");
            LABEL_MAP.put(STATE_BANK_OF_INDIA, "State Bank of India");
            LABEL_MAP.put(STATE_BANK_OF_MYSORE, "State Bank of Mysore");
            LABEL_MAP.put(STATE_BANK_OF_PATIALA, "State Bank of Patiala");
            LABEL_MAP.put(STATE_BANK_OF_TRAVANCORE, "State Bank of Travancore");
            LABEL_MAP.put(SURYODAY_SMALL_FINANCE_BANK, "Suryoday Small Finance Bank");
            LABEL_MAP.put(SYNDICATE_BANK, "Syndicate Bank");
            LABEL_MAP.put(TAMILNADU_MERCANTILE_BANK, "Tamilnadu Mercantile Bank");
            LABEL_MAP.put(TAMILNADU_STATE_APEX_COOPERATIVE_BANK, "Tamilnadu State Apex Cooperative Bank");
            LABEL_MAP.put(THANE_BHARAT_SAHAKARI_BANK, "Thane Bharat Sahakari Bank");
            LABEL_MAP.put(THANE_JANATA_SAHAKARI_BANK, "Thane Janata Sahakari Bank");
            LABEL_MAP.put(UCO_BANK, "UCO Bank");
            LABEL_MAP.put(UNION_BANK_OF_INDIA, "Union Bank of India");
            LABEL_MAP.put(VARACHHA_COOPERATIVE_BANK, "Varachha Cooperative Bank");
            LABEL_MAP.put(VIJAYA_BANK, "Vijaya Bank");
            LABEL_MAP.put(YES_BANK, "YES Bank");
            LABEL_MAP.put(YES_BANK_CORPORATE_BANKING, "YES Bank Corporate Banking");
            LABEL_MAP.put(ZOROASTRIAN_COOPERATIVE_BANK, "Zoroastrian Cooperative Bank");
        }

        public static TreeMap<String, String> getLabels() {
            return LABEL_MAP;
        }
    }

    public static class SupportedWallets {
        public static final String FREECHARGE = "freecharge";
        public static final String PHONEPE = "phonepe";
        public static final String MOBIKWIK = "mobikwik";
        public static final String PAYZAPP = "payzapp";
        public static final String OLA_MONEY = "olamoney";
        public static final String AIRTEL_MONEY = "airtelmoney";
        public static final String AMAZON_PAY = "amazonpay";
        public static final String JIOMONEY = "jiomoney";
        public static final String PAYPAL = "paypal";

        private static final TreeMap<String, String> LABEL_MAP = new TreeMap<>();

        static {
            LABEL_MAP.put(FREECHARGE, "Freecharge");
            LABEL_MAP.put(PHONEPE, "PhonePe");
            LABEL_MAP.put(MOBIKWIK, "MobiKwik");
            LABEL_MAP.put(PAYZAPP, "PayZapp");
            LABEL_MAP.put(OLA_MONEY, "OLA Money");
            LABEL_MAP.put(AIRTEL_MONEY, "Airtel Money");
            LABEL_MAP.put(AMAZON_PAY, "Amazon Pay");
            LABEL_MAP.put(JIOMONEY, "JioMoney");
            LABEL_MAP.put(PAYPAL, "PayPal");
        }

        public static TreeMap<String, String> getLabels() {
            return LABEL_MAP;
        }
    }

    public static class SupportedUPI {
        public static final String GOOGLE_PAY = "google_pay";
        public static final String BHIM = "bhim";
        public static final String PAYTM = "paytm";
        public static final String ICICI_IMOBILE = "imobile";
        public static final String BHIM_SBI_PAY = "sbi";
        public static final String AMAZON = "amazon";
        public static final String WHATSAPP = "whatsapp";
        public static final String TRUECALLER = "truecaller";
        public static final String AIRTEL = "airtel";
        public static final String PHONEPE = "phonepe";

        private static final TreeMap<String, String> LABEL_MAP = new TreeMap<>();

        static {
            LABEL_MAP.put(GOOGLE_PAY, "Google Pay");
            LABEL_MAP.put(BHIM, "BHIM");
            LABEL_MAP.put(PAYTM, "Paytm");
            LABEL_MAP.put(ICICI_IMOBILE, "ICICI iMobile");
            LABEL_MAP.put(BHIM_SBI_PAY, "BHIM SBI Pay");
            LABEL_MAP.put(AMAZON, "Amazon UPI");
            LABEL_MAP.put(WHATSAPP, "WhatsApp Pay");
            LABEL_MAP.put(TRUECALLER, "Truecaller Pay");
            LABEL_MAP.put(AIRTEL, "Airtel UPI");
            LABEL_MAP.put(PHONEPE, "PhonePe");
        }

        public static TreeMap<String, String> getLabels() {
            return LABEL_MAP;
        }
    }

    public static class SupportedCardlessEMI {
        public static final String EARLYSALARY = "earlysalary";
        public static final String ZESTMONEY = "zestmoney";
        public static final String AXIO = "walnut369";
        public static final String HDFC_BANK = "hdfc";
        public static final String BANK_OF_BARODA = "barb";
        public static final String KOTAK_BANK = "kkbk";
        public static final String ICICI_BANK = "icic";
        public static final String IDFC_BANK = "idfb";
        public static final String FEDERAL_BANK = "fdrl";
        public static final String HOME_CREDIT = "hcin";

        private static final TreeMap<String, String> LABEL_MAP = new TreeMap<>();

        static {
            LABEL_MAP.put(EARLYSALARY, "EarlySalary");
            LABEL_MAP.put(ZESTMONEY, "ZestMoney");
            LABEL_MAP.put(AXIO, "Axio");
            LABEL_MAP.put(HDFC_BANK, "HDFC Bank");
            LABEL_MAP.put(BANK_OF_BARODA, "Bank of Baroda");
            LABEL_MAP.put(KOTAK_BANK, "Kotak Bank");
            LABEL_MAP.put(ICICI_BANK, "ICICI Bank");
            LABEL_MAP.put(IDFC_BANK, "IDFC Bank");
            LABEL_MAP.put(FEDERAL_BANK, "Federal Bank");
            LABEL_MAP.put(HOME_CREDIT, "Home Credit");
        }

        public static TreeMap<String, String> getLabels() {
            return LABEL_MAP;
        }
    }

    public static class SupportedPayLater {
        public static final String GETSIMPL = "getsimpl";
        public static final String ICICI_BANK_PAYLATER = "icic";
        public static final String FLEXIPAY_BY_HDFC_BANK = "hdfc";
        public static final String LAZYPAY = "lazypay";

        private static final TreeMap<String, String> LABEL_MAP = new TreeMap<>();

        static {
            LABEL_MAP.put(GETSIMPL, "GetSimpl");
            LABEL_MAP.put(ICICI_BANK_PAYLATER, "ICICI Bank PayLater");
            LABEL_MAP.put(FLEXIPAY_BY_HDFC_BANK, "FlexiPay by HDFC Bank");
            LABEL_MAP.put(LAZYPAY, "LazyPay");
        }

        public static TreeMap<String, String> getLabels() {
            return LABEL_MAP;
        }
    }
}