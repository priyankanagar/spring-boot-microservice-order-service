package com.example.orders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class OrderRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PurchaseOrderRepository purchaseOrders;

    @Test
    public void testFindById() {

        OrderDetails orderDetails1 =
                new OrderDetails("Elsa Costume" + UUID.randomUUID().toString(), new BigDecimal(12));
        List<OrderDetails> orderDetailsList = new ArrayList<>();
        orderDetailsList.add(orderDetails1);

        OrderDetails orderDetails2 = new OrderDetails("Anna Costume" + UUID.randomUUID().toString(),
                new BigDecimal(15));
        orderDetailsList.add(orderDetails2);

        PurchaseOrder purchaseOrder = new PurchaseOrder(new BigDecimal(12.34), orderDetailsList);

        PurchaseOrder saved = entityManager.persist(purchaseOrder);

        Optional<PurchaseOrder> findById = purchaseOrders.findById(saved.getId());

        assertEquals(findById.get().getId(), saved.getId());

        assertTrue(findById.get().getOrderDetails().contains(orderDetails1));
        assertTrue(findById.get().getOrderDetails().contains(orderDetails2));

    }


}
