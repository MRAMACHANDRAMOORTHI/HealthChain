//package msr.healthchain.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class Home {
//
//    @GetMapping("/")
//    public String homePage() {
//        return "index"; // Ensure index.html exists in src/main/resources/templates/
//    }
//
//    @GetMapping("/contact")
//    public String contactPage() {
//        return "contact"; // Ensure contact.html exists
//    }
//
//    @GetMapping("/blog-single")
//    public String blogPage() {
//        return "blog-single"; // Ensure blog-single.html exists
//    }
//
//    @GetMapping("/portfolio-details")
//    public String portfolioPage() {
//        return "portfolio-details"; // Ensure portfolio-details.html exists
//    }
//
//    @GetMapping("/404")
//    public String errorPage() {
//        return "404"; // Ensure 404.html exists
//    }
//}

package msr.healthchain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

    @GetMapping("/")
    public String homePage() {
        return "index"; // Renders index.html
    }


}
