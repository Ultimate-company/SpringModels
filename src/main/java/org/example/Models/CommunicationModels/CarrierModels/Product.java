package org.example.Models.CommunicationModels.CarrierModels;

import lombok.Getter;
import lombok.Setter;
import org.example.Annotations.FrontEndVariable;
import org.example.Annotations.IgnoreCopy;
import org.example.Annotations.IsRequired;

import java.time.LocalDateTime;

@Getter
@Setter
public class Product {
    private long productId;

    @FrontEndVariable
    @IsRequired
    private String title;

    @FrontEndVariable
    @IsRequired
    private String descriptionHtml;

    @FrontEndVariable
    @IsRequired
    private int availableStock;

    @FrontEndVariable
    @IsRequired
    private String brand;

    @FrontEndVariable
    @IsRequired
    private String color;

    @FrontEndVariable
    @IsRequired
    private String colorLabel;
    private boolean deleted;

    @FrontEndVariable
    @IsRequired
    private int condition;

    @FrontEndVariable
    @IsRequired
    private String countryOfManufacture;

    @FrontEndVariable
    private String model;

    @FrontEndVariable
    @IsRequired
    private boolean itemModified;

    @FrontEndVariable
    @IsRequired
    private String upc;

    @FrontEndVariable
    private String modificationHtml;

    @IgnoreCopy
    @FrontEndVariable
    @IsRequired
    private String mainImage;

    @IgnoreCopy
    @FrontEndVariable
    @IsRequired
    private String topImage;

    @IgnoreCopy
    @FrontEndVariable
    @IsRequired
    private String bottomImage;

    @IgnoreCopy
    @FrontEndVariable
    @IsRequired
    private String frontImage;

    @IgnoreCopy
    @FrontEndVariable
    @IsRequired
    private String backImage;

    @IgnoreCopy
    @FrontEndVariable
    @IsRequired
    private String rightImage;

    @IgnoreCopy
    @FrontEndVariable
    @IsRequired
    private String leftImage;

    @IgnoreCopy
    @FrontEndVariable
    @IsRequired
    private String detailsImage;

    @IgnoreCopy
    @FrontEndVariable
    private String defectImage;

    @IgnoreCopy
    @FrontEndVariable
    private String additionalImage1;

    @IgnoreCopy
    @FrontEndVariable
    private String additionalImage2;

    @IgnoreCopy
    @FrontEndVariable
    private String additionalImage3;

    @FrontEndVariable
    @IsRequired
    private long pickupLocationId;

    @FrontEndVariable
    @IsRequired
    private double price;

    @FrontEndVariable
    @IsRequired
    private double discount;

    @FrontEndVariable
    @IsRequired
    private boolean discountPercent;

    @FrontEndVariable
    @IsRequired
    private boolean returnsAllowed;

    @FrontEndVariable
    @IsRequired
    private LocalDateTime itemAvailableFrom;

    @FrontEndVariable
    @IsRequired
    private Double length;

    @FrontEndVariable
    @IsRequired
    private Double breadth;

    @FrontEndVariable
    @IsRequired
    private Double height;

    @FrontEndVariable
    @IsRequired
    private Double weightKgs;
    private long categoryId;

    @IgnoreCopy
    @FrontEndVariable
    @IsRequired
    private String category;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @FrontEndVariable
    private String notes;
    private Long auditUserId;
}