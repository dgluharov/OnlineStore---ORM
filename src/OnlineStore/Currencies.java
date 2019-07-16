package OnlineStore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Currencies {
    private int id;
    private String iso;
    private BigDecimal rate;
    private List<Orders> ordersList = new ArrayList<>();

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
    @Column(name = "ISO")
    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    @Basic
    @Column(name = "Rate")
    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "CurrencyType")

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
        Currencies that = (Currencies) o;
        return id == that.id &&
                Objects.equals(iso, that.iso) &&
                Objects.equals(rate, that.rate) &&
                Objects.equals(ordersList, that.ordersList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iso, rate, ordersList);
    }
}
