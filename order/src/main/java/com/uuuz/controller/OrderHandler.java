package com.uuuz.controller;

import com.uuuz.entity.Order;
import com.uuuz.entity.OrderVO;
import com.uuuz.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/save")
    public void save(@RequestBody Order order){
        order.setDate(new Date());
        orderRepository.save(order);
    }

    @GetMapping("/findAllByUid/{index}/{limit}/{uid}")
    public OrderVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit, @PathVariable("uid") long uid){
        OrderVO orderVO = new OrderVO();
        orderVO.setMsg("");
        orderVO.setCount(orderRepository.countByUid(uid));
        orderVO.setData(orderRepository.findAllByUid(index, limit, uid));
        return orderVO;
    }

    @GetMapping("/countByUid/{uid}")
    public int countByUid(@PathVariable("uid") int uid){
        return orderRepository.countByUid(uid);
    }

    @GetMapping("/findAll/{index}/{limit}")
    public OrderVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){
        OrderVO orderVO = new OrderVO();
        orderVO.setMsg("");
        orderVO.setCount(orderRepository.count());
        orderVO.setData(orderRepository.findAll(index, limit));
        return orderVO;
    }

    @PutMapping("/updateState/{id}")
    public void update(@PathVariable("id") long id){
        orderRepository.updateState(id);
    }
}
