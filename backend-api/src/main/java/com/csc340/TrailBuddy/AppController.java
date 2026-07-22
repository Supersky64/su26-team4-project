/*package com.csc340.TrailBuddy;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

  public AppController(){
  }

@GetMapping({ "", "/"})
public String mainPage() {
    return "/login";
   }

   @GetMapping("/live")
  public ResponseEntity<String> pulse() {
    return ResponseEntity.ok("App is live");
  }
}*/
