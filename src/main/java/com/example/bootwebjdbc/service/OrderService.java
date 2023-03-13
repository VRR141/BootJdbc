package com.example.bootwebjdbc.service;

import com.example.bootwebjdbc.repo.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    public String getProductNameByCustomerName(String name) {
        return String.join(", ", orderDao.getProductName(name));
    }
}
