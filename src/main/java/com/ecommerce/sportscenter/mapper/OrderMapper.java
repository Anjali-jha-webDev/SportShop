package com.ecommerce.sportscenter.mapper;

import com.ecommerce.sportscenter.entity.OrderAggregate.Order;
import com.ecommerce.sportscenter.model.OrderDto;
import com.ecommerce.sportscenter.model.OrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    // Single mappings - KEY: These enable auto collection mapping
    OrderDto map(Order order);           // NEW: For Order -> OrderDto (collection elements)
    Order map(OrderDto orderDto);        // For OrderDto -> Order

    // Entity → Response
    OrderResponse toOrderResponse(Order order);
    
    // Alias methods for backward compatibility with OrderServiceImpl
    default OrderResponse OrderToOrderResponse(Order order) {
        return toOrderResponse(order);
    }
    
    default Order orderResponseToOrder(OrderDto orderDto) {
        return map(orderDto);
    }

    // List mappings (auto-generated from singles above - REMOVE manual version)
    List<OrderDto> map(Collection<Order> orders);  // Replaces toOrderDtos

    // Update existing entity
    void updateOrderFromDto(OrderDto orderDto, @MappingTarget Order order);
}
