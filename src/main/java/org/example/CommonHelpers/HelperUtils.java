package org.example.CommonHelpers;

import org.example.Annotations.IgnoreCopy;
import org.example.Constants.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HelperUtils {
   public static Map<String, String> getColors() {
       return new HashMap<>() {{
           put("#5d8aa8", "Air Force Blue (Raf)");
           put("#00308f", "Air Force Blue (Usaf)");
           put("#72a0c1", "Air Superiority Blue");
           put("#a32638", "Alabama Crimson");
           put("#f0f8ff", "Alice Blue");
           put("#e32636", "Alizarin Crimson");
           put("#c46210", "Alloy Orange");
           put("#efdecd", "Almond");
           put("#e52b50", "Amaranth");
           put("#ffbf00", "Amber");
           put("#ff7e00", "Amber (Sae/Ece)");
           put("#ff033e", "American Rose");
           put("#96c", "Amethyst");
           put("#a4c639", "Android Green");
           put("#f2f3f4", "Anti-Flash White");
           put("#cd9575", "Antique Brass");
           put("#915c83", "Antique Fuchsia");
           put("#841b2d", "Antique Ruby");
           put("#faebd7", "Antique White");
           put("#008000", "Ao (English)");
           put("#8db600", "Apple Green");
           put("#fbceb1", "Apricot");
           put("#0ff", "Aqua");
           put("#7fffd4", "Aquamarine");
           put("#4b5320", "Army Green");
           put("#3b444b", "Arsenic");
           put("#e9d66b", "Arylide Yellow");
           put("#b2beb5", "Ash Grey");
           put("#87a96b", "Asparagus");
           put("#f96", "Atomic Tangerine");
           put("#a52a2a", "Auburn");
           put("#fdee00", "Aureolin");
           put("#6e7f80", "Aurometalsaurus");
           put("#568203", "Avocado");
           put("#007fff", "Azure");
           put("#f0ffff", "Azure Mist/Web");
           put("#89cff0", "Baby Blue");
           put("#a1caf1", "Baby Blue Eyes");
           put("#f4c2c2", "Baby Pink");
           put("#21abcd", "Ball Blue");
           put("#fae7b5", "Banana Mania");
           put("#ffe135", "Banana Yellow");
           put("#7c0a02", "Barn Red");
           put("#848482", "Battleship Grey");
           put("#98777b", "Bazaar");
           put("#bcd4e6", "Beau Blue");
           put("#9f8170", "Beaver");
           put("#f5f5dc", "Beige");
           put("#9c2542", "Big Dip Oâ€™Ruby");
           put("#ffe4c4", "Bisque");
           put("#3d2b1f", "Bistre");
           put("#fe6f5e", "Bittersweet");
           put("#bf4f51", "Bittersweet Shimmer");
           put("#000", "Black");
           put("#3d0c02", "Black Bean");
           put("#253529", "Black Leather Jacket");
           put("#3b3c36", "Black Olive");
           put("#ffebcd", "Blanched Almond");
           put("#a57164", "Blast-Off Bronze");
           put("#318ce7", "Bleu De France");
           put("#ace5ee", "Blizzard Blue");
           put("#faf0be", "Blond");
           put("#00f", "Blue");
           put("#a2a2d0", "Blue Bell");
           put("#1f75fe", "Blue (Crayola)");
           put("#69c", "Blue Gray");
           put("#0d98ba", "Blue-Green");
           put("#0093af", "Blue (Munsell)");
           put("#0087bd", "Blue (Ncs)");
           put("#339", "Blue (Pigment)");
           put("#0247fe", "Blue (Ryb)");
           put("#126180", "Blue Sapphire");
           put("#8a2be2", "Blue-Violet");
           put("#de5d83", "Blush");
           put("#79443b", "Bole");
           put("#0095b6", "Bondi Blue");
           put("#e3dac9", "Bone");
           put("#c00", "Boston University Red");
           put("#006a4e", "Bottle Green");
           put("#873260", "Boysenberry");
           put("#0070ff", "Brandeis Blue");
           put("#b5a642", "Brass");
           put("#cb4154", "Brick Red");
           put("#1dacd6", "Bright Cerulean");
           put("#6f0", "Bright Green");
           put("#bf94e4", "Bright Lavender");
           put("#c32148", "Bright Maroon");
           put("#ff007f", "Bright Pink");
           put("#08e8de", "Bright Turquoise");
           put("#d19fe8", "Bright Ube");
           put("#f4bbff", "Brilliant Lavender");
           put("#ff55a3", "Brilliant Rose");
           put("#fb607f", "Brink Pink");
           put("#004225", "British Racing Green");
           put("#cd7f32", "Bronze");
           put("#964b00", "Brown (Traditional)");
           put("#ffc1cc", "Bubble Gum");
           put("#e7feff", "Bubbles");
           put("#f0dc82", "Buff");
           put("#480607", "Bulgarian Rose");
           put("#800020", "Burgundy");
           put("#deb887", "Burlywood");
           put("#c50", "Burnt Orange");
           put("#e97451", "Burnt Sienna");
           put("#8a3324", "Burnt Umber");
           put("#bd33a4", "Byzantine");
           put("#702963", "Byzantium");
           put("#536872", "Cadet");
           put("#5f9ea0", "Cadet Blue");
           put("#91a3b0", "Cadet Grey");
           put("#006b3c", "Cadmium Green");
           put("#ed872d", "Cadmium Orange");
           put("#e30022", "Cadmium Red");
           put("#fff600", "Cadmium Yellow");
           put("#a67b5b", "CafÃ© Au Lait");
           put("#4b3621", "CafÃ© Noir");
           put("#1e4d2b", "Cal Poly Green");
           put("#a3c1ad", "Cambridge Blue");
           put("#c19a6b", "Camel");
           put("#efbbcc", "Cameo Pink");
           put("#78866b", "Camouflage Green");
           put("#ffef00", "Canary Yellow");
           put("#ff0800", "Candy Apple Red");
           put("#e4717a", "Candy Pink");
           put("#00bfff", "Capri");
           put("#592720", "Caput Mortuum");
           put("#c41e3a", "Cardinal");
           put("#0c9", "Caribbean Green");
           put("#960018", "Carmine");
           put("#d70040", "Carmine (M&P)");
           put("#eb4c42", "Carmine Pink");
           put("#ff0038", "Carmine Red");
           put("#ffa6c9", "Carnation Pink");
           put("#b31b1b", "Carnelian");
           put("#99badd", "Carolina Blue");
           put("#ed9121", "Carrot Orange");
           put("#062a78", "Catalina Blue");
           put("#92a1cf", "Ceil");
           put("#ace1af", "Celadon");
           put("#007ba7", "Celadon Blue");
           put("#2f847c", "Celadon Green");
           put("#b2ffff", "Celeste (Colour)");
           put("#4997d0", "Celestial Blue");
           put("#de3163", "Cerise");
           put("#ec3b83", "Cerise Pink");
           put("#2a52be", "Cerulean Blue");
           put("#6d9bc3", "Cerulean Frost");
           put("#007aa5", "Cg Blue");
           put("#e03c31", "Cg Red");
           put("#a0785a", "Chamoisee");
           put("#fad6a5", "Champagne");
           put("#36454f", "Charcoal");
           put("#e68fac", "Charm Pink");
           put("#dfff00", "Chartreuse (Traditional)");
           put("#7fff00", "Chartreuse (Web)");
           put("#ffb7c5", "Cherry Blossom Pink");
           put("#cd5c5c", "Chestnut");
           put("#de6fa1", "China Pink");
           put("#a8516e", "China Rose");
           put("#aa381e", "Chinese Red");
           put("#7b3f00", "Chocolate (Traditional)");
           put("#d2691e", "Chocolate (Web)");
           put("#ffa700", "Chrome Yellow");
           put("#98817b", "Cinereous");
           put("#e34234", "Cinnabar");
           put("#e4d00a", "Citrine");
           put("#fbcce7", "Classic Rose");
           put("#0047ab", "Cobalt");
           put("#6f4e37", "Coffee");
           put("#9bddff", "Columbia Blue");
           put("#f88379", "Congo Pink");
           put("#002e63", "Cool Black");
           put("#8c92ac", "Cool Grey");
           put("#b87333", "Copper");
           put("#da8a67", "Copper (Crayola)");
           put("#ad6f69", "Copper Penny");
           put("#cb6d51", "Copper Red");
           put("#966", "Copper Rose");
           put("#ff3800", "Coquelicot");
           put("#ff7f50", "Coral");
           put("#ff4040", "Coral Red");
           put("#893f45", "Cordovan");
           put("#fbec5d", "Corn");
           put("#6495ed", "Cornflower Blue");
           put("#fff8dc", "Cornsilk");
           put("#fff8e7", "Cosmic Latte");
           put("#ffbcd9", "Cotton Candy");
           put("#fffdd0", "Cream");
           put("#dc143c", "Crimson");
           put("#be0032", "Crimson Glory");
           put("#00b7eb", "Cyan (Process)");
           put("#ffff31", "Daffodil");
           put("#f0e130", "Dandelion");
           put("#00008b", "Dark Blue");
           put("#654321", "Dark Brown");
           put("#5d3954", "Dark Byzantium");
           put("#a40000", "Dark Candy Apple Red");
           put("#08457e", "Dark Cerulean");
           put("#986960", "Dark Chestnut");
           put("#cd5b45", "Dark Coral");
           put("#008b8b", "Dark Cyan");
           put("#536878", "Dark Electric Blue");
           put("#b8860b", "Dark Goldenrod");
           put("#a9a9a9", "Dark Gray");
           put("#013220", "Dark Green");
           put("#00416a", "Dark Imperial Blue");
           put("#1a2421", "Dark Jungle Green");
           put("#bdb76b", "Dark Khaki");
           put("#483c32", "Dark Lava");
           put("#734f96", "Dark Lavender");
           put("#8b008b", "Dark Magenta");
           put("#036", "Dark Midnight Blue");
           put("#556b2f", "Dark Olive Green");
           put("#ff8c00", "Dark Orange");
           put("#9932cc", "Dark Orchid");
           put("#779ecb", "Dark Pastel Blue");
           put("#03c03c", "Dark Pastel Green");
           put("#966fd6", "Dark Pastel Purple");
           put("#c23b22", "Dark Pastel Red");
           put("#e75480", "Dark Pink");
           put("#039", "Dark Powder Blue");
           put("#872657", "Dark Raspberry");
           put("#8b0000", "Dark Red");
           put("#e9967a", "Dark Salmon");
           put("#560319", "Dark Scarlet");
           put("#8fbc8f", "Dark Sea Green");
           put("#3c1414", "Dark Sienna");
           put("#483d8b", "Dark Slate Blue");
           put("#2f4f4f", "Dark Slate Gray");
           put("#177245", "Dark Spring Green");
           put("#918151", "Dark Tan");
           put("#ffa812", "Dark Tangerine");
           put("#cc4e5c", "Dark Terra Cotta");
           put("#00ced1", "Dark Turquoise");
           put("#9400d3", "Dark Violet");
           put("#9b870c", "Dark Yellow");
           put("#00703c", "Dartmouth Green");
           put("#555", "Davy'S Grey");
           put("#d70a53", "Debian Red");
           put("#a9203e", "Deep Carmine");
           put("#ef3038", "Deep Carmine Pink");
           put("#e9692c", "Deep Carrot Orange");
           put("#da3287", "Deep Cerise");
           put("#b94e48", "Deep Chestnut");
           put("#704241", "Deep Coffee");
           put("#c154c1", "Deep Fuchsia");
           put("#004b49", "Deep Jungle Green");
           put("#95b", "Deep Lilac");
           put("#c0c", "Deep Magenta");
           put("#ffcba4", "Deep Peach");
           put("#ff1493", "Deep Pink");
           put("#843f5b", "Deep Ruby");
           put("#f93", "Deep Saffron");
           put("#66424d", "Deep Tuscan Red");
           put("#1560bd", "Denim");
           put("#edc9af", "Desert Sand");
           put("#696969", "Dim Gray");
           put("#1e90ff", "Dodger Blue");
           put("#d71868", "Dogwood Rose");
           put("#85bb65", "Dollar Bill");
           put("#967117", "Drab");
           put("#00009c", "Duke Blue");
           put("#e1a95f", "Earth Yellow");
           put("#555d50", "Ebony");
           put("#c2b280", "Ecru");
           put("#614051", "Eggplant");
           put("#f0ead6", "Eggshell");
           put("#1034a6", "Egyptian Blue");
           put("#7df9ff", "Electric Blue");
           put("#ff003f", "Electric Crimson");
           put("#0f0", "Electric Green");
           put("#6f00ff", "Electric Indigo");
           put("#cf0", "Electric Lime");
           put("#bf00ff", "Electric Purple");
           put("#3f00ff", "Electric Ultramarine");
           put("#8f00ff", "Electric Violet");
           put("#ff0", "Electric Yellow");
           put("#50c878", "Emerald");
           put("#b48395", "English Lavender");
           put("#96c8a2", "Eton Blue");
           put("#801818", "Falu Red");
           put("#b53389", "Fandango");
           put("#f400a1", "Fashion Fuchsia");
           put("#e5aa70", "Fawn");
           put("#4d5d53", "Feldgrau");
           put("#4f7942", "Fern Green");
           put("#ff2800", "Ferrari Red");
           put("#6c541e", "Field Drab");
           put("#ce2029", "Fire Engine Red");
           put("#b22222", "Firebrick");
           put("#e25822", "Flame");
           put("#fc8eac", "Flamingo Pink");
           put("#f7e98e", "Flavescent");
           put("#eedc82", "Flax");
           put("#fffaf0", "Floral White");
           put("#ff004f", "Folly");
           put("#014421", "Forest Green (Traditional)");
           put("#228b22", "Forest Green (Web)");
           put("#0072bb", "French Blue");
           put("#86608e", "French Lilac");
           put("#c72c48", "French Raspberry");
           put("#f64a8a", "French Rose");
           put("#f0f", "Fuchsia");
           put("#f7f", "Fuchsia Pink");
           put("#c74375", "Fuchsia Rose");
           put("#e48400", "Fulvous");
           put("#c66", "Fuzzy Wuzzy");
           put("#dcdcdc", "Gainsboro");
           put("#e49b0f", "Gamboge");
           put("#f8f8ff", "Ghost White");
           put("#b06500", "Ginger");
           put("#6082b6", "Glaucous");
           put("#e6e8fa", "Glitter");
           put("#d4af37", "Gold (Metallic)");
           put("#ffd700", "Gold (Web) (Golden)");
           put("#996515", "Golden Brown");
           put("#fcc200", "Golden Poppy");
           put("#ffdf00", "Golden Yellow");
           put("#daa520", "Goldenrod");
           put("#a8e4a0", "Granny Smith Apple");
           put("#808080", "Gray");
           put("#465945", "Gray-Asparagus");
           put("#bebebe", "Gray (X11 Gray)");
           put("#1cac78", "Green (Crayola)");
           put("#00a877", "Green (Munsell)");
           put("#009f6b", "Green (Ncs)");
           put("#00a550", "Green (Pigment)");
           put("#66b032", "Green (Ryb)");
           put("#adff2f", "Green-Yellow");
           put("#a99a86", "Grullo");
           put("#00ff7f", "Guppie Green");
           put("#663854", "HalayÃ  ÃºBe");
           put("#446ccf", "Han Blue");
           put("#5218fa", "Han Purple");
           put("#3fff00", "Harlequin");
           put("#c90016", "Harvard Crimson");
           put("#da9100", "Harvest Gold");
           put("#808000", "Heart Gold");
           put("#df73ff", "Heliotrope");
           put("#f0fff0", "Honeydew");
           put("#007fbf", "Honolulu Blue");
           put("#49796b", "Hooker'S Green");
           put("#ff1dce", "Hot Magenta");
           put("#ff69b4", "Hot Pink");
           put("#355e3b", "Hunter Green");
           put("#71a6d2", "Iceberg");
           put("#fcf75e", "Icterine");
           put("#002395", "Imperial Blue");
           put("#b2ec5d", "Inchworm");
           put("#138808", "India Green");
           put("#e3a857", "Indian Yellow");
           put("#4b0082", "Indigo (Web)");
           put("#002fa7", "International Klein Blue");
           put("#ff4f00", "International Orange (Aerospace)");
           put("#ba160c", "International Orange (Engineering)");
           put("#c0362c", "International Orange (Golden Gate Bridge)");
           put("#5a4fcf", "Iris");
           put("#f4f0ec", "Isabelline");
           put("#009000", "Islamic Green");
           put("#fffff0", "Ivory");
           put("#00a86b", "Jade");
           put("#f8de7e", "Jasmine");
           put("#d73b3e", "Jasper");
           put("#a50b5e", "Jazzberry Jam");
           put("#343434", "Jet");
           put("#fada5e", "Jonquil");
           put("#bdda57", "June Bud");
           put("#29ab87", "Jungle Green");
           put("#4cbb17", "Kelly Green");
           put("#7c1c05", "Kenyan Copper");
           put("#c3b091", "Khaki (Html/Css) (Khaki)");
           put("#f0e68c", "Khaki (X11) (Light Khaki)");
           put("#e8000d", "Ku Crimson");
           put("#087830", "La Salle Green");
           put("#d6cadd", "Languid Lavender");
           put("#26619c", "Lapis Lazuli");
           put("#fefe22", "Laser Lemon");
           put("#a9ba9d", "Laurel Green");
           put("#cf1020", "Lava");
           put("#ccf", "Lavender Blue");
           put("#fff0f5", "Lavender Blush");
           put("#b57edc", "Lavender (Floral)");
           put("#c4c3d0", "Lavender Gray");
           put("#9457eb", "Lavender Indigo");
           put("#ee82ee", "Lavender Magenta");
           put("#e6e6fa", "Lavender Mist");
           put("#fbaed2", "Lavender Pink");
           put("#967bb6", "Lavender Purple");
           put("#fba0e3", "Lavender Rose");
           put("#7cfc00", "Lawn Green");
           put("#fff700", "Lemon");
           put("#fffacd", "Lemon Chiffon");
           put("#e3ff00", "Lemon Lime");
           put("#1a1110", "Licorice");
           put("#fdd5b1", "Light Apricot");
           put("#add8e6", "Light Blue");
           put("#b5651d", "Light Brown");
           put("#e66771", "Light Carmine Pink");
           put("#f08080", "Light Coral");
           put("#93ccea", "Light Cornflower Blue");
           put("#f56991", "Light Crimson");
           put("#e0ffff", "Light Cyan");
           put("#f984ef", "Light Fuchsia Pink");
           put("#fafad2", "Light Goldenrod Yellow");
           put("#d3d3d3", "Light Gray");
           put("#90ee90", "Light Green");
           put("#b19cd9", "Light Pastel Purple");
           put("#ffb6c1", "Light Pink");
           put("#ffa07a", "Light Salmon");
           put("#f99", "Light Salmon Pink");
           put("#20b2aa", "Light Sea Green");
           put("#87cefa", "Light Sky Blue");
           put("#789", "Light Slate Gray");
           put("#b38b6d", "Light Taupe");
           put("#ffffe0", "Light Yellow");
           put("#c8a2c8", "Lilac");
           put("#bfff00", "Lime (Color Wheel)");
           put("#32cd32", "Lime Green");
           put("#9dc209", "Limerick");
           put("#195905", "Lincoln Green");
           put("#faf0e6", "Linen");
           put("#6ca0dc", "Little Boy Blue");
           put("#534b4f", "Liver");
           put("#e62020", "Lust");
           put("#ca1f7b", "Magenta (Dye)");
           put("#ff0090", "Magenta (Process)");
           put("#aaf0d1", "Magic Mint");
           put("#f8f4ff", "Magnolia");
           put("#c04000", "Mahogany");
           put("#6050dc", "Majorelle Blue");
           put("#0bda51", "Malachite");
           put("#979aaa", "Manatee");
           put("#ff8243", "Mango Tango");
           put("#74c365", "Mantis");
           put("#880085", "Mardi Gras");
           put("#800000", "Maroon (Html/Css)");
           put("#b03060", "Maroon (X11)");
           put("#e0b0ff", "Mauve");
           put("#915f6d", "Mauve Taupe");
           put("#ef98aa", "Mauvelous");
           put("#73c2fb", "Maya Blue");
           put("#e5b73b", "Meat Brown");
           put("#6da", "Medium Aquamarine");
           put("#0000cd", "Medium Blue");
           put("#e2062c", "Medium Candy Apple Red");
           put("#af4035", "Medium Carmine");
           put("#f3e5ab", "Medium Champagne");
           put("#035096", "Medium Electric Blue");
           put("#1c352d", "Medium Jungle Green");
           put("#dda0dd", "Medium Lavender Magenta");
           put("#ba55d3", "Medium Orchid");
           put("#0067a5", "Medium Persian Blue");
           put("#9370db", "Medium Purple");
           put("#bb3385", "Medium Red-Violet");
           put("#aa4069", "Medium Ruby");
           put("#3cb371", "Medium Sea Green");
           put("#7b68ee", "Medium Slate Blue");
           put("#c9dc87", "Medium Spring Bud");
           put("#00fa9a", "Medium Spring Green");
           put("#674c47", "Medium Taupe");
           put("#48d1cc", "Medium Turquoise");
           put("#d9603b", "Medium Vermilion");
           put("#c71585", "Medium Violet-Red");
           put("#f8b878", "Mellow Apricot");
           put("#fdbcb4", "Melon");
           put("#191970", "Midnight Blue");
           put("#004953", "Midnight Green (Eagle Green)");
           put("#ffc40c", "Mikado Yellow");
           put("#3eb489", "Mint");
           put("#f5fffa", "Mint Cream");
           put("#98ff98", "Mint Green");
           put("#ffe4e1", "Misty Rose");
           put("#73a9c2", "Moonstone Blue");
           put("#ae0c00", "Mordant Red 19");
           put("#addfad", "Moss Green");
           put("#30ba8f", "Mountain Meadow");
           put("#997a8d", "Mountbatten Pink");
           put("#18453b", "Msu Green");
           put("#c54b8c", "Mulberry");
           put("#ffdb58", "Mustard");
           put("#21421e", "Myrtle");
           put("#f6adc6", "Nadeshiko Pink");
           put("#2a8000", "Napier Green");
           put("#ffdead", "Navajo White");
           put("#000080", "Navy Blue");
           put("#ffa343", "Neon Carrot");
           put("#fe4164", "Neon Fuchsia");
           put("#39ff14", "Neon Green");
           put("#d7837f", "New York Pink");
           put("#a4dded", "Non-Photo Blue");
           put("#059033", "North Texas Green");
           put("#0077be", "Ocean Boat Blue");
           put("#c72", "Ochre");
           put("#cfb53b", "Old Gold");
           put("#fdf5e6", "Old Lace");
           put("#796878", "Old Lavender");
           put("#673147", "Old Mauve");
           put("#c08081", "Old Rose");
           put("#3c341f", "Olive Drab #7");
           put("#6b8e23", "Olive Drab (Web) (Olive Drab #3)");
           put("#9ab973", "Olivine");
           put("#353839", "Onyx");
           put("#b784a7", "Opera Mauve");
           put("#ff7f00", "Orange (Color Wheel)");
           put("#ff9f00", "Orange Peel");
           put("#ff4500", "Orange-Red");
           put("#fb9902", "Orange (Ryb)");
           put("#ffa500", "Orange (Web Color)");
           put("#da70d6", "Orchid");
           put("#900", "Ou Crimson Red");
           put("#414a4c", "Outer Space");
           put("#ff6e4a", "Outrageous Orange");
           put("#002147", "Oxford Blue");
           put("#060", "Pakistan Green");
           put("#273be2", "Palatinate Blue");
           put("#682860", "Palatinate Purple");
           put("#afeeee", "Pale Blue");
           put("#987654", "Pale Brown");
           put("#9bc4e2", "Pale Cerulean");
           put("#ddadaf", "Pale Chestnut");
           put("#abcdef", "Pale Cornflower Blue");
           put("#e6be8a", "Pale Gold");
           put("#eee8aa", "Pale Goldenrod");
           put("#98fb98", "Pale Green");
           put("#dcd0ff", "Pale Lavender");
           put("#f984e5", "Pale Magenta");
           put("#fadadd", "Pale Pink");
           put("#db7093", "Pale Red-Violet");
           put("#96ded1", "Pale Robin Egg Blue");
           put("#c9c0bb", "Pale Silver");
           put("#ecebbd", "Pale Spring Bud");
           put("#bc987e", "Pale Taupe");
           put("#78184a", "Pansy Purple");
           put("#ffefd5", "Papaya Whip");
           put("#aec6cf", "Pastel Blue");
           put("#836953", "Pastel Brown");
           put("#cfcfc4", "Pastel Gray");
           put("#7d7", "Pastel Green");
           put("#f49ac2", "Pastel Magenta");
           put("#ffb347", "Pastel Orange");
           put("#dea5a4", "Pastel Pink");
           put("#b39eb5", "Pastel Purple");
           put("#ff6961", "Pastel Red");
           put("#cb99c9", "Pastel Violet");
           put("#fdfd96", "Pastel Yellow");
           put("#800080", "Patriarch");
           put("#ffe5b4", "Peach");
           put("#fc9", "Peach-Orange");
           put("#ffdab9", "Peach Puff");
           put("#fadfad", "Peach-Yellow");
           put("#d1e231", "Pear");
           put("#eae0c8", "Pearl");
           put("#88d8c0", "Pearl Aqua");
           put("#b768a2", "Pearly Purple");
           put("#e6e200", "Peridot");
           put("#1c39bb", "Persian Blue");
           put("#00a693", "Persian Green");
           put("#32127a", "Persian Indigo");
           put("#d99058", "Persian Orange");
           put("#f77fbe", "Persian Pink");
           put("#701c1c", "Persian Plum");
           put("#c33", "Persian Red");
           put("#fe28a2", "Persian Rose");
           put("#ec5800", "Persimmon");
           put("#cd853f", "Peru");
           put("#df00ff", "Phlox");
           put("#000f89", "Phthalo Blue");
           put("#123524", "Phthalo Green");
           put("#fddde6", "Piggy Pink");
           put("#01796f", "Pine Green");
           put("#ffc0cb", "Pink");
           put("#ffddf4", "Pink Lace");
           put("#e7accf", "Pink Pearl");
           put("#f78fa7", "Pink Sherbet");
           put("#93c572", "Pistachio");
           put("#e5e4e2", "Platinum");
           put("#8e4585", "Plum (Traditional)");
           put("#ff5a36", "Portland Orange");
           put("#b0e0e6", "Powder Blue (Web)");
           put("#ff8f00", "Princeton Orange");
           put("#003153", "Prussian Blue");
           put("#c89", "Puce");
           put("#ff7518", "Pumpkin");
           put("#69359c", "Purple Heart");
           put("#9678b6", "Purple Mountain Majesty");
           put("#9f00c5", "Purple (Munsell)");
           put("#fe4eda", "Purple Pizzazz");
           put("#50404d", "Purple Taupe");
           put("#a020f0", "Purple (X11)");
           put("#51484f", "Quartz");
           put("#ff355e", "Radical Red");
           put("#fbab60", "Rajah");
           put("#e30b5d", "Raspberry");
           put("#e25098", "Raspberry Pink");
           put("#b3446c", "Raspberry Rose");
           put("#826644", "Raw Umber");
           put("#f3c", "Razzle Dazzle Rose");
           put("#e3256b", "Razzmatazz");
           put("#f00", "Red");
           put("#860111", "Red Devil");
           put("#f2003c", "Red (Munsell)");
           put("#c40233", "Red (Ncs)");
           put("#ff5349", "Red-Orange");
           put("#ed1c24", "Red (Pigment)");
           put("#fe2712", "Red (Ryb)");
           put("#ab4e52", "Redwood");
           put("#522d80", "Regalia");
           put("#002387", "Resolution Blue");
           put("#004040", "Rich Black");
           put("#f1a7fe", "Rich Brilliant Lavender");
           put("#0892d0", "Rich Electric Blue");
           put("#a76bcf", "Rich Lavender");
           put("#b666d2", "Rich Lilac");
           put("#414833", "Rifle Green");
           put("#0cc", "Robin Egg Blue");
           put("#f9429e", "Rose Bonbon");
           put("#674846", "Rose Ebony");
           put("#b76e79", "Rose Gold");
           put("#f6c", "Rose Pink");
           put("#aa98a9", "Rose Quartz");
           put("#905d5d", "Rose Taupe");
           put("#65000b", "Rosewood");
           put("#d40000", "Rosso Corsa");
           put("#bc8f8f", "Rosy Brown");
           put("#0038a8", "Royal Azure");
           put("#002366", "Royal Blue (Traditional)");
           put("#4169e1", "Royal Blue (Web)");
           put("#ca2c92", "Royal Fuchsia");
           put("#7851a9", "Royal Purple");
           put("#d10056", "Rubine Red");
           put("#e0115f", "Ruby");
           put("#9b111e", "Ruby Red");
           put("#ff0028", "Ruddy");
           put("#bb6528", "Ruddy Brown");
           put("#e18e96", "Ruddy Pink");
           put("#a81c07", "Rufous");
           put("#80461b", "Russet");
           put("#b7410e", "Rust");
           put("#da2c43", "Rusty Red");
           put("#00563f", "Sacramento State Green");
           put("#8b4513", "Saddle Brown");
           put("#ff6700", "Safety Orange (Blaze Orange)");
           put("#f4c430", "Saffron");
           put("#ff8c69", "Salmon");
           put("#ff91a4", "Salmon Pink");
           put("#ecd540", "Sandstorm");
           put("#f4a460", "Sandy Brown");
           put("#92000a", "Sangria");
           put("#507d2a", "Sap Green");
           put("#0f52ba", "Sapphire");
           put("#cba135", "Satin Sheen Gold");
           put("#ff2400", "Scarlet");
           put("#fd0e35", "Scarlet (Crayola)");
           put("#ffd800", "School Bus Yellow");
           put("#76ff7a", "Screamin' Green");
           put("#006994", "Sea Blue");
           put("#2e8b57", "Sea Green");
           put("#321414", "Seal Brown");
           put("#fff5ee", "Seashell");
           put("#ffba00", "Selective Yellow");
           put("#704214", "Sepia");
           put("#8a795d", "Shadow");
           put("#009e60", "Shamrock Green");
           put("#fc0fc0", "Shocking Pink");
           put("#ff6fff", "Shocking Pink (Crayola)");
           put("#882d17", "Sienna");
           put("#c0c0c0", "Silver");
           put("#cb410b", "Sinopia");
           put("#007474", "Skobeloff");
           put("#87ceeb", "Sky Blue");
           put("#cf71af", "Sky Magenta");
           put("#6a5acd", "Slate Blue");
           put("#708090", "Slate Gray");
           put("#933d41", "Smokey Topaz");
           put("#100c08", "Smoky Black");
           put("#fffafa", "Snow");
           put("#0fc0fc", "Spiro Disco Ball");
           put("#a7fc00", "Spring Bud");
           put("#23297a", "St. Patrick'S Blue");
           put("#4682b4", "Steel Blue");
           put("#4f666a", "Stormcloud");
           put("#e4d96f", "Straw");
           put("#fc3", "Sunglow");
           put("#d2b48c", "Tan");
           put("#f94d00", "Tangelo");
           put("#f28500", "Tangerine");
           put("#fc0", "Tangerine Yellow");
           put("#8b8589", "Taupe Gray");
           put("#d0f0c0", "Tea Green");
           put("#008080", "Teal");
           put("#367588", "Teal Blue");
           put("#00827f", "Teal Green");
           put("#cf3476", "Telemagenta");
           put("#cd5700", "TennÃ© (Tawny)");
           put("#e2725b", "Terra Cotta");
           put("#d8bfd8", "Thistle");
           put("#fc89ac", "Tickle Me Pink");
           put("#0abab5", "Tiffany Blue");
           put("#e08d3c", "Tiger'S Eye");
           put("#dbd7d2", "Timberwolf");
           put("#eee600", "Titanium Yellow");
           put("#ff6347", "Tomato");
           put("#746cc0", "Toolbox");
           put("#ffc87c", "Topaz");
           put("#00755e", "Tropical Rain Forest");
           put("#0073cf", "True Blue");
           put("#417dc1", "Tufts Blue");
           put("#deaa88", "Tumbleweed");
           put("#b57281", "Turkish Rose");
           put("#30d5c8", "Turquoise");
           put("#00ffef", "Turquoise Blue");
           put("#a0d6b4", "Turquoise Green");
           put("#7c4848", "Tuscan Red");
           put("#8a496b", "Twilight Lavender");
           put("#66023c", "Tyrian Purple");
           put("#03a", "Ua Blue");
           put("#d9004c", "Ua Red");
           put("#8878c3", "Ube");
           put("#536895", "Ucla Blue");
           put("#ffb300", "Ucla Gold");
           put("#3cd070", "Ufo Green");
           put("#120a8f", "Ultramarine");
           put("#4166f5", "Ultramarine Blue");
           put("#635147", "Umber");
           put("#ffddca", "Unbleached Silk");
           put("#5b92e5", "United Nations Blue");
           put("#b78727", "University Of California Gold");
           put("#ff6", "Unmellow Yellow");
           put("#7b1113", "Up Maroon");
           put("#ae2029", "Upsdell Red");
           put("#e1ad21", "Urobilin");
           put("#004f98", "Usafa Blue");
           put("#d3003f", "Utah Crimson");
           put("#c5b358", "Vegas Gold");
           put("#c80815", "Venetian Red");
           put("#43b3ae", "Verdigris");
           put("#324ab2", "Violet-Blue");
           put("#7f00ff", "Violet (Color Wheel)");
           put("#8601af", "Violet (Ryb)");
           put("#40826d", "Viridian");
           put("#922724", "Vivid Auburn");
           put("#9f1d35", "Vivid Burgundy");
           put("#da1d81", "Vivid Cerise");
           put("#ffa089", "Vivid Tangerine");
           put("#9f00ff", "Vivid Violet");
           put("#004242", "Warm Black");
           put("#a4f4f9", "Waterspout");
           put("#645452", "Wenge");
           put("#f5deb3", "Wheat");
           put("#fff", "White");
           put("#f5f5f5", "White Smoke");
           put("#a2add0", "Wild Blue Yonder");
           put("#ff43a4", "Wild Strawberry");
           put("#fc6c85", "Wild Watermelon");
           put("#722f37", "Wine");
           put("#c9a0dc", "Wisteria");
           put("#738678", "Xanadu");
           put("#0f4d92", "Yale Blue");
           put("#9acd32", "Yellow-Green");
           put("#efcc00", "Yellow (Munsell)");
           put("#ffd300", "Yellow (Ncs)");
           put("#ffae42", "Yellow Orange");
           put("#fefe33", "Yellow (Ryb)");
           put("#0014a8", "Zaffre");
           put("#2c1608", "Zinnwaldite Brown");
       }};
   }

    public static List<String> getStatesAndUnionTerritories() {
        return Arrays.asList(
                "Andaman and Nicobar Islands",
                "Andhra Pradesh",
                "Arunachal Pradesh",
                "Assam",
                "Bihar",
                "Chandigarh",
                "Chhattisgarh",
                "Dadra and Nagar Haveli",
                "Daman and Diu",
                "Delhi",
                "Goa",
                "Gujarat",
                "Haryana",
                "Himachal Pradesh",
                "Jammu and Kashmir",
                "Jharkhand",
                "Karnataka",
                "Kerala",
                "Lakshadweep",
                "Madhya Pradesh",
                "Maharashtra",
                "Manipur",
                "Meghalaya",
                "Mizoram",
                "Nagaland",
                "Orissa",
                "Pondicherry",
                "Punjab",
                "Rajasthan",
                "Sikkim",
                "Tamil Nadu",
                "Tripura",
                "Uttaranchal",
                "Uttar Pradesh",
                "West Bengal"
        );
    }

    public static List<String> getRoles() {
        return Arrays.asList(
                Roles.Ceo,
                Roles.Admin,
                Roles.Manager,
                Roles.Viewer,
                Roles.Customer,
                Roles.Custom
        );
    }

    public static List<String> getLeadStatuses() {
        return List.of(
                LeadStatus.ATTEMPTED_TO_CONTACT,
                LeadStatus.LOST_LEAD,
                LeadStatus.NOT_CONTACTED,
                LeadStatus.CONTACT_IN_FUTURE,
                LeadStatus.CONTACTED,
                LeadStatus.RE_QUALIFIED,
                LeadStatus.JUNK_LEAD,
                LeadStatus.NOT_QUALIFIED
        );
    }

    public static List<String> getFilterOptions() {
        return List.of(
                FilterOptions.PRICE,
                FilterOptions.CUSTOMER_RATINGS,
                FilterOptions.CONDITION,
                FilterOptions.BRAND,
                FilterOptions.PRODUCT_TYPE
        );
    }

    public static List<String> getSortOptions() {
        return List.of(
                SortOptions.DEFAULT,
                SortOptions.PRICE_LOW_TO_HIGH,
                SortOptions.PRICE_HIGH_TO_LOW,
                SortOptions.NEWEST_ARRIVALS,
                SortOptions.CUSTOMER_RATING,
                SortOptions.BESTSELLING,
                SortOptions.DISCOUNT
        );
    }

    public static TreeSet<String> getFontStyles() {
        return new TreeSet<>(FontStyles.getLabels().keySet());
    }

    public static TreeMap<String, TreeSet<String>> getStateCityMappingOptions() {
        return StateCityMapper.stateCityMap;
    }


    public static TreeMap<String, List<TreeMap<String, String>>> getPaymentOptions() {
        // Define a map to hold payment options
        TreeMap<String, List<TreeMap<String, String>>> paymentOptions = new TreeMap<>();

        // Initialize a TreeMap with entries
        TreeMap<String, Class<?>> categories = new TreeMap<>();

        // Add entries to the TreeMap
        categories.put("Credit And Debit Cards", PaymentOptions.CreditAndDebitCards.class);
        categories.put("Supported Banks", PaymentOptions.SupportedBanks.class);
        categories.put("Supported Wallets", PaymentOptions.SupportedWallets.class);
        categories.put("Supported UPI", PaymentOptions.SupportedUPI.class);
        categories.put("Supported Cardless EMI", PaymentOptions.SupportedCardlessEMI.class);
        categories.put("Supported Pay Later", PaymentOptions.SupportedPayLater.class);


        // Iterate through each category and populate payment options
        for (Map.Entry<String, Class<?>> entry : categories.entrySet()) {
            String category = entry.getKey();
            Class<?> clazz = entry.getValue();

            List<TreeMap<String, String>> optionList = new ArrayList<>();
            try {
                // Retrieve labels using reflection
                Method getLabelsMethod = clazz.getMethod("getLabels");
                TreeMap<String, String> labels = (TreeMap<String, String>) getLabelsMethod.invoke(null);

                // Populate the option list
                for (Map.Entry<String, String> labelEntry : labels.entrySet()) {
                    TreeMap<String, String> optionMap = new TreeMap<>();
                    optionMap.put("label", labelEntry.getValue());
                    optionMap.put("value", labelEntry.getKey());
                    optionList.add(optionMap);
                }
            } catch (Exception e) {
                e.printStackTrace(); // Handle exceptions appropriately
            }

            // Add the populated option list to the map
            paymentOptions.put(category, optionList);
        }

        return paymentOptions;
    }

    public static <T> List<T> copyFields(List<?> sourceList, Class<T> destinationClass) {
        List<T> destinationList = new ArrayList<>();
        for (Object source : sourceList) {
            T destinationObject = copyFields(source, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }

    public static <T> T copyFields(Object source, Class<T> destinationClass) {
        Class<?> sourceClass = source.getClass();

        // Create an instance of the destination class
        T destination = null;
        try {
            Constructor<T> constructor = destinationClass.getDeclaredConstructor();
            destination = constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // Get all fields from the source class
        Field[] sourceFields = sourceClass.getDeclaredFields();

        // Iterate through each field and copy its value to the destination object
        for (Field field : sourceFields) {
            try {
                // Ensure that the field is accessible
                field.setAccessible(true);

                // Skip fields annotated with @JsonIgnore
                if (field.isAnnotationPresent(IgnoreCopy.class)) {
                    continue;
                }

                // Get the field value from the source object
                Object value = field.get(source);

                // Set the field value in the destination object
                Field destinationField = destinationClass.getDeclaredField(field.getName());
                destinationField.setAccessible(true);
                destinationField.set(destination, value);
            } catch (IllegalAccessException | NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }

        return destination;
    }
}