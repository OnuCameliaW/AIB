package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
 
public class RunRule {
 
    public static void main(String[] args) {
         
        try {
        	FormROA fr = new FormROA();
        	// load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");
             
            kSession.insert(fr);
            kSession.fireAllRules();
            //System.out.println(customerRuleObject.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
 
}