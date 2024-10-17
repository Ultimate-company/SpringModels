package org.example.Constants;

import java.util.*;

public class StateCityMapper {
    public static final TreeMap<String, TreeSet<String>> stateCityMap;

    static {
        stateCityMap = new TreeMap<>();

        stateCityMap.put("Andhra Pradesh", new TreeSet<>(Set.of(
                "Adoni", "Amalapuram", "Anakapalle", "Bhimavaram", "Chilakaluripet", "Chirala", "Dharmavaram",
                "Eluru", "Gooty", "Gudivada", "Gudur", "Guntakal", "Guntur", "Hindupur", "Jaggaiahpet",
                "Jammalamadugu", "Kadapa", "Kadiri", "Kakinada", "Kandukur", "Kavali", "Kurnool", "Macherla",
                "Machilipatnam", "Madanapalle", "Mandapeta", "Markapur", "Nagari", "Naidupet", "Nandyal",
                "Narasapuram", "Narasaraopet", "Narsipatnam", "Nellore", "Nidadavole", "Nuzvid", "Ongole",
                "Palacole", "Palasa Kasibugga", "Parvathipuram", "Pedana", "Piduguralla", "Ponnur", "Proddatur",
                "Punganur", "Puttur", "Rajahmundry", "Rajam", "Rajampet", "Ramachandrapuram", "Rayachoti",
                "Rayadurg", "Renigunta", "Repalle", "Salur", "Samalkot", "Sattenapalle", "Srikakulam",
                "Srikalahasti", "Srisailam Project (Right Flank Colony) Township", "Sullurpeta", "Tadepalligudem",
                "Tadpatri", "Tanuku", "Tenali", "Tirupati", "Tiruvuru", "Tuni", "Uravakonda", "Venkatagiri",
                "Vijayawada", "Vinukonda", "Visakhapatnam", "Vizianagaram", "Yemmiganur", "Yerraguntla"
        )));

        stateCityMap.put("Arunachal Pradesh", new TreeSet<>(Set.of(
                "Bomdila", "Itanagar", "Naharlagun", "Pasighat", "Tawang", "Ziro"
        )));

        stateCityMap.put("Assam", new TreeSet<>(Set.of(
                "Barpeta", "Bongaigaon City", "Dhekiajuli", "Dhubri", "Dibrugarh", "Digboi", "Diphu",
                "Dispur", "Gauripur", "Goalpara", "Guwahati", "Haflong", "Hailakandi", "Hojai", "Jorhat",
                "Karimganj", "Kokrajhar", "Lanka", "Lumding", "Mangaldoi", "Mankachar", "Margherita",
                "Mariani", "Marigaon", "Nagaon", "Nalbari", "North Lakhimpur", "Rangia", "Sibsagar",
                "Silapathar", "Silchar", "Tezpur", "Tinsukia", "Umrangso"
        )));

        stateCityMap.put("Bihar", new TreeSet<>(Set.of(
                "Anisabad", "Araria", "Arwal", "Ashiana Nagar", "Bagaha", "Bairgania", "Begusarai",
                "Belsand", "Bhagirathi", "Bhawanipur", "Bhorey", "Bhagalpur", "Buxar",
                "Chanpatia", "Chakia", "Chapra", "Dalsinghsarai", "Danapur", "Dhamdaha", "Digha",
                "Dumraon", "Forbesganj", "Gandhi Nagar", "Ghoghardiha", "Gopalganj", "Gulzarbagh",
                "Hajipur", "Halsi", "Hathua", "Hisua", "Jamalpur", "Jhanjharpur", "Jokihat", "Kahalgaon",
                "Kalyani", "Kankana", "Kasba", "Karpi", "Kataiya", "Kesath", "Kidwaipuri", "Kumhrar",
                "Kurtha", "Kursakatta", "Laheriasarai", "Lakhisarai", "Lalganj", "Madhepura", "Maharajganj",
                "Mahua", "Mairwa", "Maner", "Mansurganj", "Masaurhi", "Motihari", "Motipur", "Murliganj",
                "Muzaffarpur", "Nalanda", "Narkatiaganj", "Nathnagar", "Navgachhia", "Nawada", "Nirmali",
                "Pandaul", "Paliganj", "Patliputra", "Patna", "Phulparas", "Phulwari Sharif", "Purnia",
                "Rajendra Nagar", "Rajgir", "Ramgarh", "Ramna", "Revelganj", "Rupauli", "Sakra",
                "Samastipur", "Saharsa", "Saraigarh Bhattacharya", "Sheikhpura", "Sheohar", "Sikti",
                "Simri Bakhtiarpur", "Singhapore", "Singhia", "Sitamarhi", "Sonbarsa", "Supaul", "Suppi",
                "Sultanganj", "Sonepur", "Sugauli", "Taraiya", "Tilkamanjhi"
        )));

        stateCityMap.put("Chhattisgarh", new TreeSet<>(Set.of(
                "Akaltara", "Ambikapur", "Baikunthpur", "Balod", "Baloda Bazar", "Bhatapara", "Bhatgaon",
                "Bilaspur", "Chirmiri", "Dalli-Rajhara", "Dhamtari", "Dongargarh", "Gobra Nawapara",
                "Janjgir", "Kanker", "Katghora", "Kawardha", "Korba", "Kumhari", "Mahasamund", "Mungeli",
                "Naila-Janjgir", "Panduka", "Raigarh", "Raipur", "Sakti", "Sirgiti", "Tilda Newra"
        )));

        stateCityMap.put("Goa", new TreeSet<>(Set.of(
                "Bicholim", "Cancona", "Cuncolim", "Curchorem", "Goa Velha", "Margao", "Mapusa",
                "Mormugao", "Panaji", "Pernem", "Ponda", "Quepem", "Sanguem", "Sanquelim", "Valpoi",
                "Vasco da Gama"
        )));

        stateCityMap.put("Gujarat", new TreeSet<>(Set.of(
                "Ahmednagar", "Amod", "Amalsad", "Ambaji", "Amreli", "Anand", "Anjar", "Bamna", "Bantva",
                "Bansda", "Bans Kantha", "Bardoli", "Bareja", "Barwala", "Bhabhar", "Bharatpur", "Bharuch",
                "Bharthana", "Bhagwanpur", "Bhagalpur", "Bhanpura", "Bhanpur", "Bhanvad", "Bhayavadar",
                "Bhuj", "Borsad", "Botad", "Bhavnagar", "Chapra",
                "Chhala", "Chhaya", "Chotila", "Dabhoi", "Detroj-Rampura", "Dhansura", "Dharampur",
                "Dholka", "Dhrangadhra", "Dhrol", "Dhoraji", "Faridabad", "Gandhinagar",
                "Gariadhar", "Godhra", "Gondal", "Halol", "Himatnagar", "Jambusar", "Jamjodhpur", "Jasdan",
                "Jhagadia", "Jetpur Navagadh", "Jodhpur", "Junagadh", "Kalol", "Kamrej",
                "Kankrej", "Kapadwanj", "Kapadvanj", "Kathor", "Kadi", "Kalyanpur",
                "Khambhat", "Kheralu", "Khedbrahma", "Kodinar", "Keshod", "Kutiyana",
                "Kutch", "Kundla", "Lakhtar", "Lathi", "Limdi", "Lunawada", "Mahesana",
                "Mahuva", "Mandvi", "Mansa", "Mehsana", "Mithapur", "Morbi", "Nadiad", "Navsari",
                "Narmada", "Okha", "Palanpur", "Panchmahal", "Patel", "Patan", "Porbandar",
                "Radhanpur", "Rajkot", "Rajpipla", "Rapar", "Sabarkantha", "Sagbara", "Sanand",
                "Sankheda", "Sarangpur", "Savarkundla", "Sidhpur", "Somnath", "Surat", "Tapi", "Valsad",
                "Vapi", "Viramgam", "Visnagar", "Vadnagar", "Vadodara"
        )));

        stateCityMap.put("Haryana", new TreeSet<>(Set.of(
                "Ambala", "Bhiwani", "Faridabad", "Fatehabad", "Gurgaon", "Hisar", "Jhajjar", "Jind",
                "Kaithal", "Karnal", "Mahendergarh", "Mewat", "Panchkula", "Panipat", "Rewari", "Sirsa",
                "Sonipat", "Yamunanagar"
        )));

        stateCityMap.put("Himachal Pradesh", new TreeSet<>(Set.of(
                "Bilaspur", "Chamba", "Hamirpur", "Kangra", "Kullu", "Mandi", "Shimla", "Sirmaur", "Solan",
                "Una"
        )));

        stateCityMap.put("Jammu and Kashmir", new TreeSet<>(Set.of(
                "Anantnag", "Baramulla", "Jammu", "Kathua", "Kishtwar", "Poonch", "Rajouri", "Srinagar",
                "Udhampur"
        )));

        stateCityMap.put("Jharkhand", new TreeSet<>(Set.of(
                "Bokaro", "Chaibasa", "Dhanbad", "Jamshedpur", "Hazaribagh", "Deoghar", "Dumka",
                "Giridih", "Jharia", "Koderma", "Palamu", "Ramgarh", "Ranchi", "Sahibganj", "Simdega",
                "Singhbhum", "West Singhbhum"
        )));

        stateCityMap.put("Karnataka", new TreeSet<>(Set.of(
                "Bagalkot", "Bangalore", "Belgaum", "Bellary", "Bidar", "Bijapur", "Chikkamagaluru",
                "Chitradurga", "Davanagere", "Gadag", "Hassan", "Haveri", "Kodagu", "Kolar", "Koppal",
                "Mandya", "Mysore", "Raichur", "Ramanagara", "Shimoga", "Tumkur", "Udupi", "Yadgir"
        )));

        stateCityMap.put("Kerala", new TreeSet<>(Set.of(
                "Alappuzha", "Ernakulam", "Idukki", "Kannur", "Kasaragod", "Kottayam", "Kozhikode",
                "Malappuram", "Palakkad", "Pathanamthitta", "Thrissur", "Trivandrum"
        )));

        stateCityMap.put("Madhya Pradesh", new TreeSet<>(Set.of(
                "Bhopal", "Burhanpur", "Chhindwara", "Dewas", "Guna", "Gwalior", "Hoshangabad",
                "Indore", "Jabalpur", "Khandwa", "Mandla", "Mandsaur", "Ratlam", "Sagar", "Satna",
                "Sehore", "Shahdol", "Shajapur", "Ujjain", "Vidisha"
        )));

        stateCityMap.put("Maharashtra", new TreeSet<>(Set.of(
                "Ahmednagar", "Amravati", "Aurangabad", "Bhiwandi", "Chandrapur", "Dhule", "Jalgaon",
                "Jalna", "Kolhapur", "Latur", "Mumbai", "Nagpur", "Nashik", "Navi Mumbai", "Pune",
                "Ratnagiri", "Solapur", "Thane", "Ulhasnagar", "Vasai-Virar", "Yavatmal"
        )));

        stateCityMap.put("Manipur", new TreeSet<>(Set.of(
                "Imphal", "Churachandpur", "Thoubal", "Kakching", "Jiribam", "Ukhrul", "Senapati", "Tamenglong"
        )));

        stateCityMap.put("Meghalaya", new TreeSet<>(Set.of(
                "Shillong", "Tura", "Jowai", "Williamnagar", "Bongai", "Mawkyrwat", "Nongpoh"
        )));

        stateCityMap.put("Mizoram", new TreeSet<>(Set.of(
                "Aizawl", "Lunglei", "Kolasib", "Champhai", "Mamit", "Saiha", "Serchhip"
        )));

        stateCityMap.put("Nagaland", new TreeSet<>(Set.of(
                "Kohima", "Dimapur", "Mokokchung", "Wokha", "Phek", "Zunheboto", "Tuensang"
        )));

        stateCityMap.put("Odisha", new TreeSet<>(Set.of(
                "Bhubaneswar", "Cuttack", "Berhampur", "Rourkela", "Sambalpur", "Baleswar", "Koraput",
                "Paradip", "Balangir", "Jeypore", "Nayagarh", "Baripada", "Phulbani", "Bhadrak", "Kendujhar"
        )));

        stateCityMap.put("Punjab", new TreeSet<>(Set.of(
                "Amritsar", "Jalandhar", "Ludhiana", "Patiala", "Mohali", "Bathinda", "Moga", "Hoshiarpur",
                "Rupnagar", "Fatehgarh Sahib", "Faridkot", "Sangrur", "Mansa", "Gurdaspur"
        )));

        stateCityMap.put("Rajasthan", new TreeSet<>(Set.of(
                "Jaipur", "Jodhpur", "Udaipur", "Kota", "Ajmer", "Bikaner", "Alwar", "Sikar", "Bhilwara",
                "Nagaur", "Pali", "Sri Ganganagar", "Hanumangarh", "Barmer", "Dungarpur", "Jaisalmer"
        )));

        stateCityMap.put("Sikkim", new TreeSet<>(Set.of(
                "Gangtok", "Namchi", "Mangan", "Gyalshing", "Rangpo"
        )));

        stateCityMap.put("Tamil Nadu", new TreeSet<>(Set.of(
                "Chennai", "Coimbatore", "Madurai", "Salem", "Tiruchirappalli", "Erode", "Tirunelveli",
                "Vellore", "Nagercoil", "Dharmapuri", "Kanchipuram", "Sivakasi", "Kanyakumari", "Cuddalore",
                "Thanjavur", "Dindigul", "Karur", "Namakkal", "Pudukkottai", "Ramanathapuram", "Tirupur"
        )));

        stateCityMap.put("Telangana", new TreeSet<>(Set.of(
                "Hyderabad", "Warangal", "Karimnagar", "Nizamabad", "Khammam", "Mahabubnagar", "Nalgonda",
                "Adilabad", "Medak", "Rangareddy", "Jagtial", "Jagityal", "Peddapalli", "Kamareddy"
        )));

        stateCityMap.put("Tripura", new TreeSet<>(Set.of(
                "Agartala", "Udaipur", "Kailasahar", "Dharmanagar", "Sonamura", "Khowai", "Belonia",
                "Amarpur", "Badharghat", "Dhanpur", "Kumarghat"
        )));

        stateCityMap.put("Uttar Pradesh", new TreeSet<>(Set.of(
                "Agra", "Aligarh", "Allahabad", "Ambedkar Nagar", "Azamgarh", "Badaun", "Baghpat", "Bahraich",
                "Ballia", "Banda", "Barabanki", "Bareilly", "Basti", "Bijnor", "Bulandshahr", "Chandauli",
                "Deoria", "Etah", "Etawah", "Faizabad", "Farrukhabad", "Fatehpur", "Firozabad", "Ghaziabad",
                "Gonda", "Gorakhpur", "Hamirpur", "Hapur", "Hardoi", "Hathras", "Jalaun", "Jaunpur",
                "Jhansi", "Kannauj", "Kanpur", "Kasganj", "Kushinagar", "Lakhimpur Kheri", "Lucknow",
                "Mathura", "Meerut", "Mirzapur", "Moradabad", "Muzaffarnagar", "Pilibhit", "Pratapgarh",
                "Raebareli", "Rae Bareli", "Rampur", "Saharanpur", "Sambhal", "Sant Kabir Nagar",
                "Shahjahanpur", "Shamli", "Siddharthnagar", "Sitapur", "Sonbhadra", "Sultanpur", "Unnao",
                "Varanasi"
        )));

        stateCityMap.put("Uttarakhand", new TreeSet<>(Set.of(
                "Dehradun", "Haridwar", "Nainital", "Rudrapur", "Roorkee", "Haldwani", "Pithoragarh",
                "Almora", "Kashipur", "Bageshwar", "Champawat", "Tehri", "Uttarkashi", "Rishikesh", "Kirtinagar"
        )));

        stateCityMap.put("West Bengal", new TreeSet<>(Set.of(
                "Asansol", "Baharampur", "Bardhaman", "Baranagar", "Barisal", "Bidhannagar", "Kolkata",
                "Durgapur", "Haldia", "Howrah", "Jalpaiguri", "Kharagpur", "Malda", "Medinipur", "Murarai",
                "Purulia", "Siliguri", "Sonarpur", "Suri", "Tamluk", "Bankura", "Chandannagar", "Krishnanagar"
        )));
    }
}