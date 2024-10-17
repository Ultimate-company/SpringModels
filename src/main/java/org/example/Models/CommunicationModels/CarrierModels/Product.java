package org.example.Models.CommunicationModels.CarrierModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.example.Annotations.IgnoreCopy;

import java.sql.Blob;
import java.time.LocalDateTime;

@Getter
@Setter
public class Product {
    private long productId;
    private String title;
    private String descriptionHtml;
    private Double length;
    private int availableStock;
    private String brand;
    private String color;
    private String colorLabel;
    private boolean deleted;
    private int condition;
    private String countryOfManufacture;
    private String model;
    private boolean itemModified;
    private String upc;
    private String modificationHtml;
    private String mainImage;
    private String topImage;
    private String bottomImage;
    private String frontImage;
    private String backImage;
    private String rightImage;
    private String leftImage;
    private String detailsImage;
    private String defectImage;
    private String additionalImage1;
    private String additionalImage2;
    private String additionalImage3;
    private long pickupLocationId;
    private double price;
    private double discount;
    private boolean discountPercent;
    private boolean returnsAllowed;
    private LocalDateTime itemAvailableFrom;
    private Double breadth;
    private Double height;
    private Double weightKgs;
    private long categoryId;
    @IgnoreCopy
    private String category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
}
