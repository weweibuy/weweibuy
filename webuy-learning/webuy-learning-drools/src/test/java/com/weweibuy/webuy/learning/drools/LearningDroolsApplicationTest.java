package com.weweibuy.webuy.learning.drools;


import org.kie.api.KieBase;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;

public class LearningDroolsApplicationTest {


    public void test01() {
        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent("", ResourceType.DRL);
        KieBase kieBase = kieHelper.build();
        KieContainer kieContainer = kieHelper.getKieContainer();
        KieSession kieSession = kieBase.newKieSession();
    }


}