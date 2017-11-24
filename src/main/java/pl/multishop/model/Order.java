package pl.multishop.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "zamowienie")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private int orderId;

    @Column(name = "clientId", nullable = false, unique = true, updatable = false)
    private String clientId;

    @Column(name = "kwota", nullable = false)
    private double amount;

    @Column(name = "data_zamowienia", nullable = false)
    private LocalDate orderDate;

    public Order(){
        super();
    }

    public Order(int orderId, String clientId, double amount){

        this.orderId = orderId;
        this.clientId = clientId;
        this.amount = amount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return orderId == order.orderId;
    }

    @Override
    public int hashCode() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", clientId='" + clientId + '\'' +
                '}';
    }
}