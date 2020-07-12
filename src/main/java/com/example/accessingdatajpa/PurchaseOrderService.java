package com.example.accessingdatajpa;

public interface PurchaseOrderService {

    PurchaseOrder createOrder(PurchaseOrder order);

    PurchaseOrder getOrderById(Long orderId);
}
