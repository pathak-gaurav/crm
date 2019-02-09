package com.gauravpathak.crm.bootstrap;

import com.gauravpathak.crm.entity.Customer;
import com.gauravpathak.crm.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class dataloader implements CommandLineRunner {

    private CustomerRepository repository;

    public dataloader(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Customer("Zack", "Anderson"));
        repository.save(new Customer("Cody", "Anderson"));
        repository.save(new Customer("Mark", "Seyers"));

    }
}
