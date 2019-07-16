package OnlineStore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class DeliveryType extends Base {
    //    private int id;
//    private String name;
    private List<Orders> ordersList = new ArrayList<>();

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
    @JoinColumn(name = "DeliveryType")
    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryType that = (DeliveryType) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(ordersList, that.ordersList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ordersList);
    }
}
