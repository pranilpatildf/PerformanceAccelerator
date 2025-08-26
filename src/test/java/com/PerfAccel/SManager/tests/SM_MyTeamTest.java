package com.PerfAccel.SManager.tests;

import org.testng.annotations.Test;

import base.BaseClass;

public class SM_MyTeamTest extends BaseClass{
  @Test
  public void ValidateQuarterDropdownTest() throws InterruptedException
  {
	  
	  sm_loginpage.SM_LoginIntoFrontPage();
	  sm_myteampage.ValidateQuarterDropdown();
  }
}
