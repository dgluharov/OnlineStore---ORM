package OnlineStore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Orders {
    private int id;
    private Timestamp purchaseDate;
    private BigDecimal totalPrice;
    private boolean isCheckout;
    private Currencies currency;
    private Customers customer;
    private DeliveryType deliveryType;
    private PaymentType paymentType;
    private List<OrderDetails> orderDetailsList = new ArrayList<>();

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PurchaseDate")
    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Basic
    @Column(name = "TotalPrice")
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column(name = "IsCheckout")
    public boolean isCheckout() {
        return isCheckout;
    }

    public void setCheckout(boolean checkout) {
        isCheckout = checkout;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CurrencyType")
    public Currencies getCurrency() {
        return currency;
    }

    public void setCurrency(Currencies currencies) {
        this.currency = currencies;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CustomerID")
    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DeliveryType")
    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PaymentType")
    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "OrderID")
    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return id == orders.id &&
                isCheckout == orders.isCheckout &&
                Objects.equals(purchaseDate, orders.purchaseDate) &&
                Objects.equals(totalPrice, orders.totalPrice) &&
                Objects.equals(currency, orders.currency) &&
                Objects.equals(customer, orders.customer) &&
                Objects.equals(deliveryType, orders.deliveryType) &&
                Objects.equals(orderDetailsList, orders.orderDetailsList) &&
                Objects.equals(paymentType, orders.paymentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, purchaseDate, totalPrice,
                isCheckout, currency, customer,
                deliveryType, paymentType, orderDetailsList);
    }
}
