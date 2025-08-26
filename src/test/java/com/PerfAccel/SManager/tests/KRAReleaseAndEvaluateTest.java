package com.PerfAccel.SManager.tests;

import org.testng.annotations.Test;

import base.BaseClass;

public class KRAReleaseAndEvaluateTest extends BaseClass {
@Test
public void KRAFlow() throws InterruptedException {
	
	sm_loginpage.SM_LoginIntoFrontPage();
	krareleaseandevaluate.KRAReleaseEvaluateApprove();
	
}
}
