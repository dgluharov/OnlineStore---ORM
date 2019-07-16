package OnlineStore;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class FacadeSession {
    private static FacadeSession object;

    FacadeSession() {

    }


    public static FacadeSession getSession() {
        if (object == null) {
            object = new FacadeSession();
        }
        return object;
    }

    public Products insertProduct(String name, int availableQuantity, BigDecimal singlePrice,
                                  BigDecimal vat, BigDecimal discount, Vendors vendor) {
        Products product = new Products();
        product.setName(name);
        product.setAvailableQuantity(availableQuantity);
        product.setSinglePrice(singlePrice);
        product.setVat(vat);
        product.setDiscount(discount);
        product.setVendor(vendor);

        return product;
    }

    public Vendors insertVendor(String name) {
        Vendors vendor = new Vendors();
        vendor.setName(name);
        return vendor;
    }


    public Currencies insertCurrency(String iso, BigDecimal rate) {
        Currencies currency = new Currencies();
        currency.setIso(iso);
        currency.setRate(rate);
        return currency;
    }

    public Customers insertCustomer(String name, String email, boolean isCorporate, BigDecimal discount) {
        Customers customer = new Customers();
        customer.setName(name);
        customer.setEmail(email);
        customer.setCorporate(isCorporate);
        customer.setVipDiscount(discount);
        return customer;
    }

    public DeliveryType insertDeliveryType(String name) {
        DeliveryType deliveryType = new DeliveryType();
        deliveryType.setName(name);
        return deliveryType;
    }

    public OrderDetails inserOrderDetails(int quantity, BigDecimal discount, BigDecimal singlePrice,
                                          BigDecimal vat) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setQuantity(quantity);
        orderDetails.setDiscount(discount);
        orderDetails.setSinglePrice(singlePrice);
        orderDetails.setVat(vat);
        return orderDetails;
    }

    public Orders insertOrder(Timestamp purchaseDate, BigDecimal totalPrice, boolean isCheckout,
                              Currencies currency, Customers customer, DeliveryType deliveryType,
                              PaymentType paymentType) {
        Orders orders = new Orders();
        orders.setPurchaseDate(purchaseDate);
        orders.setTotalPrice(totalPrice);
        orders.setCheckout(isCheckout);
        orders.setCurrency(currency);
        orders.setCustomer(customer);
        orders.setDeliveryType(deliveryType);
        orders.setPaymentType(paymentType);
        return orders;
    }

    public PaymentType insertPaymentType(String name, String cardNumber, String ccv, String validUntil) {
        PaymentType paymentType = new PaymentType();
        paymentType.setName(name);
        paymentType.setCardNumber(cardNumber);
        paymentType.setCcv(ccv);
        paymentType.setValidUntil(validUntil);
        return paymentType;
    }

    public ProductType insertProductType(String name) {
        ProductType productType = new ProductType();
        productType.setName(name);
        return productType;
    }
}
