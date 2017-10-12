package org.archenroot.integration.commons.archive_service.ui.view.orderedit;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;

import com.vaadin.ui.ComboBox;

import org.archenroot.integration.commons.archive_service.backend.domain.OrderState;
import org.archenroot.integration.commons.archive_service.core.HasLogger;

@SpringComponent
@ViewScope
public class OrderStateSelect extends ComboBox<OrderState> implements HasLogger {

	public OrderStateSelect() {
		setEmptySelectionAllowed(false);
		setTextInputAllowed(false);
		setItems(OrderState.values());
		setItemCaptionGenerator(OrderState::getDisplayName);
	}

}
