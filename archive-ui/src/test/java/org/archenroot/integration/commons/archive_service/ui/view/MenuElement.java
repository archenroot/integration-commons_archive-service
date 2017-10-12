package org.archenroot.integration.commons.archive_service.ui.view;

import org.archenroot.integration.commons.archive_service.ui.view.storefront.StorefrontViewElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import org.archenroot.integration.commons.archive_service.AbstractIT;
import com.vaadin.testbench.By;
import com.vaadin.testbench.elements.AbstractComponentElement;

public class MenuElement extends AbstractComponentElement {

	public StorefrontViewElement navigateToStorefront() {
		WebElement menuLink = getMenuLink("Storefront");
		menuLink.click();
		return AbstractIT.findFirstElement(this, StorefrontViewElement.class);
	}

	public void logout() {
		WebElement menuLink = getMenuLink("Log out");
		menuLink.click();
	}

	public WebElement getMenuLink(String caption) {
		try {
			// ../.. is because WebDriver refuses to click on a covered element
			return findElement(By.xpath("//span[text()='" + caption + "']/../.."));
		} catch (NoSuchElementException e) {
			return null;
		}
	}

}
