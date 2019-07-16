package OnlineStore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@IdClass(OrderDetails.class)
public class OrderDetails implements Serializable {
    //    private int orderId;
//    private int productsId;
    private int quantity;
    private BigDecimal discount;
    private BigDecimal singlePrice;
    private BigDecimal vat;
    private Orders orders;
    private Products products;


//    @Id
//    @Column(name = "OrderID")
//    public int getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(int orderId) {
//        this.orderId = orderId;
//    }
//
//    @Id
//    @Column(name = "ProductsID")
//    public int getProductsId() {
//        return productsId;
//    }
//
//    public void setProductsId(int productsId) {
//        this.productsId = productsId;
//    }

    @Basic
    @Column(name = "Quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "Discount")
    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Basic
    @Column(name = "SinglePrice")
    public BigDecimal getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(BigDecimal singlePrice) {
        this.singlePrice = singlePrice;
    }

    @Basic
    @Column(name = "VAT")
    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "OrderID")
    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ProductsID")
    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetails that = (OrderDetails) o;
        return
//                orderId == that.orderId &&
//                productsId == that.productsId &&
                quantity == that.quantity &&
                        Objects.equals(discount, that.discount) &&
                        Objects.equals(singlePrice, that.singlePrice) &&
                        Objects.equals(orders, that.orders) &&
                        Objects.equals(products, that.products) &&
                        Objects.equals(vat, that.vat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
//                orderId, productsId,
                quantity, discount, singlePrice, vat);
    }
}
