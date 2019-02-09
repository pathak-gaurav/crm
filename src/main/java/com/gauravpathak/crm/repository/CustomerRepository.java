package com.gauravpathak.crm.repository;

import com.gauravpathak.crm.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    public List<Customer> findAllByOrderByFirstNameAsc();
}
