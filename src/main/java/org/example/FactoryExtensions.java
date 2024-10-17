package org.example;

import lombok.Getter;
import lombok.Setter;
import org.example.Translators.CarrierDatabaseTranslators.*;
import org.example.Translators.CarrierDatabaseTranslators.Interfaces.*;
import org.example.Translators.CentralDatabaseTranslators.*;
import org.example.Translators.CentralDatabaseTranslators.Interfaces.*;

@Getter
@Setter
public class FactoryExtensions
{
    // Central database translators
    private ICarrierSubTranslator carrierSubTranslator;
    private ILoginSubTranslator loginSubTranslator = new LoginSubTranslator();
    private IUserSubTranslator userSubTranslator;
    private IUserLogSubTranslator userLogSubTranslator;

    // carrier database translators
    private IAddressSubTranslator addressSubTranslator;
    private ILeadSubTranslator leadSubTranslator;
    private IUserGroupSubTranslator userGroupSubTranslator;
    private IPickupLocationSubTranslator pickupLocationSubTranslator;
    private ITodoListSubTranslator todoListSubTranslator;
    private IPromoSubTranslator promoSubTranslator;
    private IMessageSubTranslator messageSubTranslator;
    private IProductSubTranslator productSubTranslator;
    private IProductReviewSubTranslator productReviewSubTranslator;
    private IProductCategorySubTranslator productCategorySubTranslator;
    private IPurchaseOrderSubTranslator purchaseOrderSubTranslator;
    private ISalesOrderSubTranslator salesOrderSubTranslator;
    private IPackageSubTranslator packageSubTranslator;
    private ISupportSubTranslator supportSubTranslator;
    private IWebTemplateSubTranslator webTemplateSubTranslator;

    public FactoryExtensions(){}
    public FactoryExtensions(String token, Long userId, Long carrierId)
    {
        if(userId != null && carrierId != null) {
            // central database translators
            setCarrierSubTranslator(new CarrierSubTranslator(token, userId, carrierId));
            setUserSubTranslator(new UserSubTranslator(token, userId, carrierId));
            setUserLogSubTranslator(new UserLogSubTranslator(token, userId, carrierId));

            // carrier database translators
            setAddressSubTranslator(new AddressSubTranslator(token, userId, carrierId));
            setLeadSubTranslator(new LeadSubTranslator(token, userId, carrierId));
            setUserGroupSubTranslator(new UserGroupSubTranslator(token, userId, carrierId));
            setPickupLocationSubTranslator(new PickupLocationSubTranslator(token, userId, carrierId));
            setTodoListSubTranslator(new TodoListSubTranslator(token, userId, carrierId));
            setPromoSubTranslator(new PromoSubTranslator(token, userId, carrierId));
            setMessageSubTranslator(new MessageSubTranslator(token, userId, carrierId));
            setProductSubTranslator(new ProductSubTranslator(token, userId, carrierId));
            setProductReviewSubTranslator(new ProductReviewSubTranslator(token, userId, carrierId));
            setProductCategorySubTranslator(new ProductCategorySubTranslator(token, userId, carrierId));
            setPurchaseOrderSubTranslator(new PurchaseOrderSubTranslator(token, userId, carrierId));
            setSalesOrderSubTranslator(new SalesOrderSubTranslator(token, userId, carrierId));
            setPackageSubTranslator(new PackageSubTranslator(token, userId, carrierId));
            setSupportSubTranslator(new SupportSubTranslator(token, userId, carrierId));
            setWebTemplateSubTranslator(new WebTemplateSubTranslator(token, userId, carrierId));
        }
        else if(userId != null) {
            setCarrierSubTranslator(new CarrierSubTranslator(token, userId, null));
        }
    }


    // these are to be used only by web template project
    public void initFactoryExtensionForWebTemplateWithoutToken(){
        setCarrierSubTranslator(new CarrierSubTranslator(null, null, null));
    }
    public void initFactoryExtensionForWebTemplateWithToken(String token, String wildCard, long webTemplateId, long carrierId, Long userId) {
        setWebTemplateSubTranslator(new WebTemplateSubTranslator(token, wildCard, webTemplateId, carrierId, userId));
        setProductSubTranslator(new ProductSubTranslator(token, wildCard, webTemplateId, carrierId, userId));
    }
}
