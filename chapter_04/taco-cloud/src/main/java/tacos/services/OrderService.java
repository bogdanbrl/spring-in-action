package tacos.services;

import org.springframework.stereotype.Service;
import tacos.domain.Order;
import tacos.repository.OrderRepository;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void add(Order order){
        orderRepository.save(order);
    }

    public void edit(Order order){
        orderRepository.save(order);
    }
}
