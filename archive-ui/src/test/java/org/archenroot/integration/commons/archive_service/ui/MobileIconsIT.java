package org.archenroot.integration.commons.archive_service.ui;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.archenroot.integration.commons.archive_service.AbstractIT;

public class MobileIconsIT extends AbstractIT {

	@Test
	public void iconsPresentOnLoginPage() {
		openLoginView(APP_URL);
		List<WebElement> appleIcons = findElements(By.xpath("//link[@rel='apple-touch-icon']"));
		Assert.assertFalse(appleIcons.isEmpty());
		List<WebElement> otherIcons = findElements(By.xpath("//link[@rel='icon']"));
		Assert.assertFalse(otherIcons.isEmpty());
	}

	@Test
	public void iconsPresentInApp() {
		loginAsBarista();
		List<WebElement> appleIcons = findElements(By.xpath("//link[@rel='apple-touch-icon']"));
		Assert.assertFalse(appleIcons.isEmpty());
		List<WebElement> otherIcons = findElements(By.xpath("//link[@rel='icon']"));
		Assert.assertFalse(otherIcons.isEmpty());
	}
}
