package pl.sda.javalondek4springdemo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.javalondek4springdemo.exception.BookNotFoundException;
import pl.sda.javalondek4springdemo.service.MyService;

@RestController
public class MyFirstRestController {

    private static final Logger logger = LoggerFactory.getLogger(MyFirstRestController.class);

    private final MyService myService;

    public MyFirstRestController() {
        logger.info("my service will be null:(");
        myService = null;
    }

    @Autowired // choose one way to create Spring Bean!!!
    // if only one way of object creation exists @Autowired is not necessary
    public MyFirstRestController(MyService myService) {
        logger.info("my service initialized with correct value:)");
        this.myService = myService;
    }

    @GetMapping("/say-something")
    public String saySomething() {

        // logging levels
        // trace
        // debug
        // info <-- current level
        // warn --
        // error -- inside catch
        logger.info("/say-something");
        logger.debug("is it visible???");
        logger.trace("and this??");
        return "hello rest:P";
    }

    // /convert-name?myName=Mariusz
    @GetMapping("/convert-name")
    public String convertMyNameToUpperCase(@RequestParam("myName") String name) {

        String result = myService.convertToUpperCase(name);

        logger.info("input param: [{}], result: [{}]", name, result);
        return result;
    }

    @GetMapping("/throw-exception")
    public void throwException() {
        logger.info("throwing exception from controller...");

        throw new BookNotFoundException("no message");
    }
}
