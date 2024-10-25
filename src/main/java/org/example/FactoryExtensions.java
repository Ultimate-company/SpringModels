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
    private ILoginSubTranslator loginSubTranslator;
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

    public FactoryExtensions(String token, Long userId, Long carrierId, String apiUrl)
    {
        this.loginSubTranslator = new LoginSubTranslator(apiUrl);
        if(userId != null && carrierId != null) {
            // central database translators
            setCarrierSubTranslator(new CarrierSubTranslator(token, userId, carrierId, apiUrl));
            setUserSubTranslator(new UserSubTranslator(token, userId, carrierId, apiUrl));
            setUserLogSubTranslator(new UserLogSubTranslator(token, userId, carrierId, apiUrl));

            // carrier database translators
            setAddressSubTranslator(new AddressSubTranslator(token, userId, carrierId, apiUrl));
            setLeadSubTranslator(new LeadSubTranslator(token, userId, carrierId, apiUrl));
            setUserGroupSubTranslator(new UserGroupSubTranslator(token, userId, carrierId, apiUrl));
            setPickupLocationSubTranslator(new PickupLocationSubTranslator(token, userId, carrierId, apiUrl));
            setTodoListSubTranslator(new TodoListSubTranslator(token, userId, carrierId, apiUrl));
            setPromoSubTranslator(new PromoSubTranslator(token, userId, carrierId, apiUrl));
            setMessageSubTranslator(new MessageSubTranslator(token, userId, carrierId, apiUrl));
            setProductSubTranslator(new ProductSubTranslator(token, userId, carrierId, apiUrl));
            setProductReviewSubTranslator(new ProductReviewSubTranslator(token, userId, carrierId, apiUrl));
            setProductCategorySubTranslator(new ProductCategorySubTranslator(token, userId, carrierId, apiUrl));
            setPurchaseOrderSubTranslator(new PurchaseOrderSubTranslator(token, userId, carrierId, apiUrl));
            setSalesOrderSubTranslator(new SalesOrderSubTranslator(token, userId, carrierId, apiUrl));
            setPackageSubTranslator(new PackageSubTranslator(token, userId, carrierId, apiUrl));
            setSupportSubTranslator(new SupportSubTranslator(token, userId, carrierId, apiUrl));
            setWebTemplateSubTranslator(new WebTemplateSubTranslator(token, userId, carrierId, apiUrl));
        }
        else if(userId != null) {
            setCarrierSubTranslator(new CarrierSubTranslator(token, userId, null, apiUrl));
        }
    }


    // these are to be used only by web template project
    public void initFactoryExtensionForWebTemplateWithoutToken(String apiUrl){
        setCarrierSubTranslator(new CarrierSubTranslator(null, null, null, apiUrl));
    }
    public void initFactoryExtensionForWebTemplateWithToken(String token, String wildCard, long webTemplateId, long carrierId, Long userId, String apiUrl) {
        setWebTemplateSubTranslator(new WebTemplateSubTranslator(token, wildCard, webTemplateId, carrierId, userId, apiUrl));
        setProductSubTranslator(new ProductSubTranslator(token, wildCard, webTemplateId, carrierId, userId, apiUrl));
    }
}
