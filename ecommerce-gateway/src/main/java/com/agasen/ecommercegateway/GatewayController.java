package com.agasen.ecommercegateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {

  @GetMapping("/test")
  String test() {
    return "Testing";
  }

}
