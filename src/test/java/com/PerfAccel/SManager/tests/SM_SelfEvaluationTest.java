package com.PerfAccel.SManager.tests;

import org.testng.annotations.Test;

import base.BaseClass;

public class SM_SelfEvaluationTest extends BaseClass{
       @Test
       public void SMSelfEvaluationTest() throws InterruptedException {
    	   
    	   sm_loginpage.SM_LoginIntoFrontPage();
    	   sm_selfevaluationpage.SM_SelfEvalutionDropdown();
    	   
       }
}
