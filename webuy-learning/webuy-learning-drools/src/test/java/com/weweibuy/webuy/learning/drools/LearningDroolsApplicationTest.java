package com.weweibuy.webuy.learning.drools;


import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;

public class LearningDroolsApplicationTest {


    public void test01() {
        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent("", ResourceType.DRL);
        KieSession kieSession = kieHelper.build().newKieSession();
    }

}