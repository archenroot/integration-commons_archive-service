package org.archenroot.integration.commons.archive_service.ui.view.orderedit;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import org.prokyon.integration.app.HasLogger;
import org.prokyon.integration.backend.data.OrderState;
import com.vaadin.ui.ComboBox;

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
