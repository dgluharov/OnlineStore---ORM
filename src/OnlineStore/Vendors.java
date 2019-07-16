package OnlineStore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity

public class Vendors extends Base {
    //    private int id;
//    private String name;
    private List<Products> productsList = new ArrayList<>();

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
//    @Basic
//    @Column(name = "Name")
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "VendorId")
    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendors vendors = (Vendors) o;
        return id == vendors.id &&
                Objects.equals(name, vendors.name) &&
                Objects.equals(productsList, vendors.productsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, productsList);
    }
}
