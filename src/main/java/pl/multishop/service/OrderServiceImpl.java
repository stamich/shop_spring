package pl.multishop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.multishop.dao.OrderDao;
import pl.multishop.model.Order;

import java.util.List;

/**
 * This class implements business logic for order model of data.
 * @author Michal Stawarski
 */
@Service("orderService")
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    /**
     * This method finds order by its id.
     * @param orderId
     * @return orderDao.findById(orderId)
     */
    @Override
    public Order findById(Long orderId) {
        return orderDao.findById(orderId);
    }

    /**
     * This method finds client id.
     * @param clientId
     * @return orderDao.findByClientId(clientId)
     */
    @Override
    public Order findByClientId(Long clientId) {
        return orderDao.findByClientId(clientId);
    }

    /**
     * This method saves order.
     * @param order
     */
    @Override
    public void saveOrder(Order order) {
        orderDao.saveOrder(order);
    }

    /**
     * This method updates order.
     * @param order
     */
    @Override
    public void updateOrder(Order order) {
        Order entity = orderDao.findById(order.getId());
        if(entity!=null) {
            //entity.setOrderId(order.getOrderId());//updatable = false
            //entity.setClientId(order.getClientId());//updatable = false
            //entity.setProductId(order.getProductId());//updatable = false
            entity.setAmount(order.getAmount());
            entity.setCreatedAt(order.getCreatedAt());
            entity.setStatus(order.getStatus());
        }
    }

    /**
     * This method deletes order.
     * @param orderId
     */
    @Override
    public void delOrderById(int orderId) {
        orderDao.delOrderById(orderId);
    }

    /**
     * This method makes the list of all orders.
     * @return orderDao.findAllOrders()
     */
    @Override
    public List<Order> findAllOrders() {
        return orderDao.findAllOrders();
    }

    @Override
    public List<Order> findAllOrders(Long clientId) {
        return orderDao.findAllOrders(clientId);
    }

    /**
     * This method verifies if order number is unique.
     * @param orderId
     * @param clientId
     * @return (orders == null || (orderId != null) && orders.getOrderId() == orderId)
     */
    @Override
    public boolean isOrderNumberUnique(Long orderId, Long clientId){
        Order order = findByClientId(clientId);
        return (order == null || (orderId != null) && order.getId() == orderId);
    }
}
