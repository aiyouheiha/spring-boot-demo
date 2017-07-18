package com.heiha.example.web.test.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(ScopeAnnotationPrototypeTestController.class);
    private Integer index = 0;
    @Autowired
    @Qualifier("userSingleton")
    private ScopeOnMethodTest.User userSingleton;

    @Autowired
    @Qualifier("userPrototype")
    private ScopeOnMethodTest.User userPrototype;

    @RequestMapping(value = "/default", method = RequestMethod.GET)
    public Integer testDefault() {
        log(userSingleton.getUserName(), userPrototype.getUserName(), index);
        userSingleton.setUserName("default");
        userPrototype.setUserName("default");
        return ++index;
    }

    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @RequestMapping(value = "/singleton", method = RequestMethod.GET)
    public Integer testSingleton() {
        log(userSingleton.getUserName(), userPrototype.getUserName(), index);
        userSingleton.setUserName("singleton");
        userPrototype.setUserName("singleton");
        return ++index;
    }

    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @RequestMapping(value = "/prototype", method = RequestMethod.GET)
    public Integer testPrototype() {
        log(userSingleton.getUserName(), userPrototype.getUserName(), index);
        userSingleton.setUserName("prototype");
        userPrototype.setUserName("prototype");
        return ++index;
    }

    private void log(String userSingleton, String userPrototype, Integer index) {
        LOGGER.info("userSingleton is {}, userPrototype is {}, index is {}",
                userSingleton, userPrototype, index);
    }
}
