package org.archenroot.integration.commons.archive_service.ui.view.orderedit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;

import com.vaadin.spring.annotation.SpringComponent;
import org.prokyon.integration.backend.data.entity.PickupLocation;
import com.vaadin.ui.ComboBox;

@SpringComponent
@PrototypeScope
public class PickupLocationComboBox extends ComboBox<PickupLocation> {

	private final PickupLocationComboBoxDataProvider dataProvider;

	@Autowired
	public PickupLocationComboBox(PickupLocationComboBoxDataProvider dataProvider) {
		this.dataProvider = dataProvider;
		setEmptySelectionAllowed(false);
		setTextInputAllowed(false);
		setPlaceholder("Pickup location");
		setItemCaptionGenerator(PickupLocation::getName);
	}

	@PostConstruct
	private void initDataProvider() {
		setDataProvider(dataProvider);
	}

}
