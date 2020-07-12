package com.example.orders;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Item name cannot be null")
    private String itemName;

    @NotNull(message = "Item Amount cannot be null")
    private BigDecimal itemAmount;

    public OrderDetails() {
    }

    public OrderDetails(String itemName, BigDecimal itemAmount) {
        this.itemName = itemName;
        this.itemAmount = itemAmount;
    }

    public Long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getItemAmount() {
        return itemAmount;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemAmount=" + itemAmount +
                '}';
    }
}
