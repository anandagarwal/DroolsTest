package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import pojo.Product;

public class DiscountTest {

    public static void main(String args[]) {
        KieServices services = KieServices.Factory.get();
        KieContainer container = services.getKieClasspathContainer();
        KieSession session = container.newKieSession("ksession-rules");

        Product product = Product.builder().name("Flight").build();
        session.insert(product);
        session.fireAllRules();
        System.out.println("Discount is " + product.getDiscount());
    }
}