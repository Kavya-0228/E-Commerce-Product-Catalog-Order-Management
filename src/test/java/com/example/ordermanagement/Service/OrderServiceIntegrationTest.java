package com.example.ordermanagement.Service;

import com.example.ordermanagement.Entity.Order;
import com.example.ordermanagement.Entity.User;
import com.example.ordermanagement.Repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceIntegrationTest {

    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;
    
    @BeforeEach
    void setUp() {
        orderService = new OrderService();
        // Use reflection to set the repository
        try {
            java.lang.reflect.Field field = OrderService.class.getDeclaredField("orderRepo");
            field.setAccessible(true);
            field.set(orderService, orderRepository);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void createAndUpdateOrder_Success() {
        // Given
        Order order = new Order();
        User user = new User();
        user.setId(1L);
        order.setUser(user);
        order.setStatus("PENDING");
        order.setTotalAmount(299.99);
        
        Order savedOrder = new Order();
        savedOrder.setId(1L);
        savedOrder.setUser(user);
        savedOrder.setStatus("PENDING");
        savedOrder.setTotalAmount(299.99);

        when(orderRepository.save(any(Order.class))).thenReturn(savedOrder);

        // When
        Order createdOrder = orderService.placeOrder(order);

        // Then
        assertNotNull(createdOrder);
        assertEquals(1L, createdOrder.getId());
        assertEquals("PENDING", createdOrder.getStatus());

        // And When updating status
        createdOrder.setStatus("DELIVERED");
        when(orderRepository.save(any(Order.class))).thenReturn(createdOrder);
        
        Order updatedOrder = orderService.updateOrderStatus(1L, "DELIVERED");

        // Then
        assertEquals("DELIVERED", updatedOrder.getStatus());
    }
}