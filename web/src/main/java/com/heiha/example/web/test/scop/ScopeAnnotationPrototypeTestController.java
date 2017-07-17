package com.heiha.example.web.test.scop;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/7/17 10:18<br>
 * <b>Author:</b> heiha<br>
 */
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("/test/20170717/scope/prototype")
public class ScopeAnnotationPrototypeTestController {
    private Integer index = 0;

    @RequestMapping(value = "/default", method = RequestMethod.GET)
    public Integer testDefault() {
        return ++index;
    }

    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @RequestMapping(value = "/singleton", method = RequestMethod.GET)
    public Integer testSingleton() {
        return ++index;
    }

    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @RequestMapping(value = "/prototype", method = RequestMethod.GET)
    public Integer testPrototype() {
        return ++index;
    }
}
