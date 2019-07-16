package OnlineStore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class PaymentType extends Base {
    //    private int id;
//    private String name;
    private String cardNumber;
    private String ccv;
    private String validUntil;
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

    @Basic
    @Column(name = "CardNumber")
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Basic
    @Column(name = "CCV")
    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    @Basic
    @Column(name = "ValidUntil")
    public String getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PaymentType")
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
        PaymentType that = (PaymentType) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(cardNumber, that.cardNumber) &&
                Objects.equals(ccv, that.ccv) &&
                Objects.equals(validUntil, that.validUntil) &&
                Objects.equals(ordersList, that.ordersList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cardNumber, ccv, validUntil, ordersList);
    }
}
