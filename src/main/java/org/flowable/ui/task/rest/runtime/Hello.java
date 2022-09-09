package org.flowable.ui.task.rest.runtime;


import org.flowable.engine.ProcessEngine;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello implements InitializingBean {
    private final ProcessEngine processEngine;

    public Hello(ProcessEngine processEngine) {
        this.processEngine = processEngine;
    }

    public void afterPropertiesSet()  {
        System.out.println("blablablablabla");
    }
    @GetMapping("/app/rest/hello/{prodef}")
    public String hello(@PathVariable String prodef) {
        return processEngine.getFormService().getStartFormKey(prodef);
    }
}
