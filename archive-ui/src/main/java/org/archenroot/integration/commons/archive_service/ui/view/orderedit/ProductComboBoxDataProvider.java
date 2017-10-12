package org.archenroot.integration.commons.archive_service.ui.view.orderedit;

import java.util.ArrayList;
import java.util.List;

import org.archenroot.integration.commons.archive_service.backend.domain.entity.Product;
import org.archenroot.integration.commons.archive_service.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vaadin.artur.spring.dataprovider.PageableDataProvider;

import com.vaadin.data.provider.Query;
import com.vaadin.data.provider.QuerySortOrder;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.spring.annotation.SpringComponent;

@SpringComponent
public class ProductComboBoxDataProvider extends PageableDataProvider<Product, String> {

	private final ProductService productService;

	@Autowired
	public ProductComboBoxDataProvider(ProductService productService) {
		this.productService = productService;
	}

	@Override
	protected Page<Product> fetchFromBackEnd(Query<Product, String> query, Pageable pageable) {
		return productService.findAnyMatching(query.getFilter(), pageable);
	}

	@Override
	protected int sizeInBackEnd(Query<Product, String> query) {
		return (int) productService.countAnyMatching(query.getFilter());
	}

	@Override
	protected List<QuerySortOrder> getDefaultSortOrders() {
		List<QuerySortOrder> sortOrders = new ArrayList<>();
		sortOrders.add(new QuerySortOrder("name", SortDirection.ASCENDING));
		return sortOrders;
	}

}
