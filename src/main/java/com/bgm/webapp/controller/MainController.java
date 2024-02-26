package com.bgm.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * MainController
 */
@Controller
public class MainController {

  @GetMapping("/home")
  public String getHome() {
    return "home";
  }

}
