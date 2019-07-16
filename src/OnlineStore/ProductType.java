package OnlineStore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ProductType extends Base {
    private ProductType productType;
    private Set<ProductType> productTypeSet = new HashSet<>();
    private Set<Products> productsSet = new HashSet<>();

    //    private int id;
//    private String name;
//
//    @Id
//    @Column(name = "ID")
//
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
//    @Basic
//    @Column(name = "Name")
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ProductType that = (ProductType) o;
//        return id == that.id &&
//                Objects.equals(name, that.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name);
//    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ParentID")
    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ParentID", referencedColumnName = "ID")
    public Set<ProductType> getProductTypeSet() {
        return productTypeSet;
    }

    public void setProductTypeSet(Set<ProductType> productTypeSet) {
        this.productTypeSet = productTypeSet;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Products_ProductTypes",
            joinColumns = {
                    @JoinColumn(name = "ProductTypeID", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "ProductID", nullable = false, updatable = false)})
    public Set<Products> getProductsSet() {
        return this.productsSet;
    }

    public void setProductsSet(Set<Products> productsSet) {
        this.productsSet = productsSet;
    }
}
