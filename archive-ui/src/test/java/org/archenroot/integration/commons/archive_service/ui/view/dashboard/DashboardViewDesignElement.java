package org.archenroot.integration.commons.archive_service.ui.view.dashboard;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.testbench.elements.AbstractComponentElement;
import com.vaadin.testbench.elements.VerticalLayoutElement;
import com.vaadin.testbench.elementsbase.ServerClass;

@ServerClass("DashboardViewDesign")
@AutoGenerated
public class DashboardViewDesignElement extends VerticalLayoutElement {

	public AbstractComponentElement getBoard() {
		return $(com.vaadin.testbench.elements.AbstractComponentElement.class).id("board");
	}
}