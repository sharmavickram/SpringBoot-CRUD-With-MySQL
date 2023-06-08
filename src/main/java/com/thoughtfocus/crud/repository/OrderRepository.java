package com.thoughtfocus.crud.repository;

import com.thoughtfocus.crud.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
