package org.archenroot.integration.commons.archive_service.ui.view.orderedit;

import org.archenroot.integration.commons.archive_service.backend.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;

import com.vaadin.spring.annotation.SpringComponent;

import com.vaadin.ui.ComboBox;

@SpringComponent
@PrototypeScope
public class ProductComboBox extends ComboBox<Product> {

	@Autowired
	public ProductComboBox(ProductComboBoxDataProvider dataProvider) {
		setWidth("100%");
		setEmptySelectionAllowed(false);
		setPlaceholder("Product");
		setItemCaptionGenerator(Product::getName);
		setDataProvider(dataProvider);
	}

}
