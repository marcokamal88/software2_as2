package com.example.demo.service;

import com.example.demo.model.CreateOrderInput;
import com.example.demo.model.Order;
import com.example.demo.model.OrderItemInput;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OrdersService {
    @Autowired
    AuthService auth_service;
    public ArrayList<Order> orders_table = new ArrayList<Order>() {};

<<<<<<< HEAD
    ArrayList<Order> orders_table = new ArrayList<Order>() {
    };

    public void addOrder(CreateOrderInput input_data) {

=======
    private ArrayList<OrderItem> createOrderItems(ArrayList<OrderItemInput> itemInputs) {
        return itemInputs.stream()
                .map(itemInput -> new OrderItem(itemInput.getQuantity(), itemInput.getProduct()))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    private ArrayList<Order> createSubOrders(ArrayList<CreateOrderInput> subOrderInputs) {
        if (subOrderInputs != null) {
            return subOrderInputs.stream()
                    .map(this::addOrder)
                    .collect(Collectors.toCollection(ArrayList::new));
        } else {
            return new ArrayList<>();
        }
    }

    public Order createOrder(CreateOrderInput input_data){
        ArrayList<OrderItem> items = createOrderItems(input_data.getOrderItems());
        ArrayList<Order> subOrders = createSubOrders(input_data.getSubOrders());

        Order newOrder = new Order(items);
        newOrder.setShippingAddress(input_data.getAddress());
        newOrder.setSubOrders(subOrders);
        User user = auth_service.get_user_by_name(input_data.getCustomerName());
        if (user == null) {
            // "User not found";
            return null;
        }
        newOrder.setUser(user);
        return newOrder;
    }
    public Order addOrder(CreateOrderInput input_data){
        Order newOrder = createOrder(input_data);
        orders_table.add(newOrder);
        return newOrder;
>>>>>>> 92fe938f9681f5aebb4eb1540f1e723f025c8513
    }

    public Order getOrder(Integer id) {

        Order order = null;

        for (int i = 0; i < orders_table.size(); i++) {
            Order it_order = orders_table.get(i);
<<<<<<< HEAD

            if (it_order.getId() == id) {
=======
            // print(it_order.getId());
            System.out.println(it_order.getId());
            if(Objects.equals(it_order.getId(), id)){
>>>>>>> 92fe938f9681f5aebb4eb1540f1e723f025c8513
                order = it_order;
            }
        }

        return order;

    }

<<<<<<< HEAD
=======
    // ship the order
    public Order shipOrder(Integer id){
        Order order = getOrder(id);

        if(order != null && order.getStatus().equals("pending")){
            order.ship();
            return order;

        }else{
            return null;
        }

    }

    private Order cancel(Integer id, String expectedStatus,String newStatus) {
        Order order = getOrder(id);
        if (order != null && order.getStatus().equals(expectedStatus)) {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime cancelBy = order.getPlacedAt().plusHours(1); // 1 hour cancellation duration
            if (now.isBefore(cancelBy)) {
                order.setStatus(newStatus);
            }
        }
        return order;
    }

    public Order cancelOrder(Integer id) {
        return cancel(id, "pending", "cancelled");
    }

    public Order cancelShipping(Integer id) {
        return cancel(id, "shipped", "pending");
    }
>>>>>>> 92fe938f9681f5aebb4eb1540f1e723f025c8513
}
