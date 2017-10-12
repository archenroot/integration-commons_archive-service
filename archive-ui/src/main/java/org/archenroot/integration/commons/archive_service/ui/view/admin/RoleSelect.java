package org.archenroot.integration.commons.archive_service.ui.view.admin;


import com.vaadin.ui.ComboBox;
import org.archenroot.integration.commons.archive_service.backend.domain.Role;

public class RoleSelect extends ComboBox<String> {

	public RoleSelect() {
		setCaption("Role");
		setEmptySelectionAllowed(false);
		setItems(Role.getAllRoles());
		setTextInputAllowed(false);
	}
}
