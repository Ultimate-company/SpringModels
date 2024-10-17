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