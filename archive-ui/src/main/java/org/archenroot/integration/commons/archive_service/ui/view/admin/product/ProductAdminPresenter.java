package org.archenroot.integration.commons.archive_service.ui.view.admin.product;

import org.archenroot.integration.commons.archive_service.ui.navigation.NavigationManager;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import org.prokyon.integration.backend.data.entity.Product;
import org.prokyon.integration.backend.service.ProductService;
import org.archenroot.integration.commons.archive_service.ui.view.admin.AbstractCrudPresenter;

@SpringComponent
@ViewScope
public class ProductAdminPresenter extends AbstractCrudPresenter<Product, ProductService, ProductAdminView> {

	@Autowired
	public ProductAdminPresenter(ProductAdminDataProvider productAdminDataProvider, NavigationManager navigationManager,
			ProductService service, BeanFactory beanFactory) {
		super(navigationManager, service, Product.class, productAdminDataProvider, beanFactory);
	}
}
