package org.archenroot.integration.commons.archive_service.ui.view;

import org.archenroot.integration.commons.archive_service.ui.view.dashboard.DashboardViewElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import org.archenroot.integration.commons.archive_service.AbstractIT;

public class LoginIT extends AbstractIT {

	@Test
	public void userIsRedirectedToRequestedView() {
		openLoginView(APP_URL + "#!dashboard").login("barista@vaadin.com", "barista");
		Assert.assertNotNull($(DashboardViewElement.class).first());
	}

	@Test
	public void logoutWorks() {
		loginAsBarista();
		$(MenuElement.class).first().logout();
		Assert.assertEquals("Email", findElement(By.id("login-label")).getText());
	}

}
