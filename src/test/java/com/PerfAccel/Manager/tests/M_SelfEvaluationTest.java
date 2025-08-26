package com.PerfAccel.Manager.tests;

import org.testng.annotations.Test;

import base.BaseClass;

public class M_SelfEvaluationTest extends BaseClass{
       @Test
       public void SelfEvaluationTest() throws InterruptedException {
    	   
    	   m_loginpage.M_LoginIntoFrontPage();
    	   m_selfevaluationpage.SelfEvalutionDropdown();
    	   
       }
}
