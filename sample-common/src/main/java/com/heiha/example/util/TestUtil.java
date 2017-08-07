//package com.heiha.example.util;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
///**
// * <br>
// * <b>Project:</b> spring-boot-demo<br>
// * <b>Date:</b> 2017/7/19 14:11<br>
// * <b>Author:</b> heiha<br>
// */
//@Component
//public class TestUtil {
//    @Autowired
//    private RestTemplate restTemplate;
//
//    public void doSomething() {
//        ResponseEntity<String> responseEntity = restTemplate.exchange("http://rocketship.com.au/404/", HttpMethod.GET, null, String.class);
//        ResponseEntity<String> responseEntity2 = restTemplate.getForEntity("http://rocketship.com.au/404/", String.class);
//        System.out.println(responseEntity.getStatusCode());
//        System.out.println(responseEntity2.getStatusCode());
//    }
//}
