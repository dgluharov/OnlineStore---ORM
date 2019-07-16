package OnlineStore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
public class Products extends Base {
    //    private int id;
//    private String name;
    private int availableQuantity;
    private BigDecimal singlePrice;
    private BigDecimal discount;
    private BigDecimal vat;
    //private int vendorId;
    private Vendors vendor;
    //private Set<ProductsProductTypes> productsProductTypesSet = new HashSet<>();
    private List<OrderDetails> orderDetailsList = new ArrayList<>();
    private Set<ProductType> productTypeSet = new HashSet<>();

//    @Id
//    @Column(name = "ID")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
////    @Basic
////    @Column(name = "VendorId")
////    public int getVendorId() {
////        return vendorId;
////    }
////
////    public void setVendorId(int vendorId) {
////        this.vendorId = vendorId;
////    }
//
//    @Basic
//    @Column(name = "Name")
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    @Basic
    @Column(name = "AvailableQuantity")
    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
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
    @Column(name = "Discount")
    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Basic
    @Column(name = "VAT")
    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "VendorID")
    public Vendors getVendor() {
        return vendor;
    }

    @ManyToMany(mappedBy = "productsSet")
    public Set<ProductType> getProductTypeSet() {
        return this.productTypeSet;
    }

    public void setProductTypeSet(Set<ProductType> productTypeSet) {
        this.productTypeSet = productTypeSet;
    }


//    @ManyToMany(mappedBy = "productsSet")
//    public Set<ProductsProductTypes> getProductsProductTypesSet() {
//        return productsProductTypesSet;
//    }
//
//    public void setProductsProductTypesSet(Set<ProductsProductTypes> productsProductTypesSet) {
//        this.productsProductTypesSet = productsProductTypesSet;
//    }

    public void setVendor(Vendors vendor) {
        this.vendor = vendor;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ProductsID")
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
        Products products = (Products) o;
        return id == products.id &&
                //vendorId == products.vendorId &&
                availableQuantity == products.availableQuantity &&
                Objects.equals(vendor, products.vendor) &&
                Objects.equals(name, products.name) &&
                Objects.equals(singlePrice, products.singlePrice) &&
                Objects.equals(discount, products.discount) &&
                //Objects.equals(productsProductTypesSet, products.productsProductTypesSet)&&
                Objects.equals(orderDetailsList, products.orderDetailsList) &&
                Objects.equals(productTypeSet, products.productTypeSet) &&
                Objects.equals(vat, products.vat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, availableQuantity, singlePrice, discount, vat,
                vendor, /*productsProductTypesSet, */orderDetailsList, productTypeSet
                //        ,vendorId
        );
    }


}
