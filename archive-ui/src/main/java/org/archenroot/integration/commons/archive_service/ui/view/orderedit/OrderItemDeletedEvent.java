package org.archenroot.integration.commons.archive_service.ui.view.orderedit;


import org.archenroot.integration.commons.archive_service.backend.domain.entity.OrderItem;

public class OrderItemDeletedEvent {

	private OrderItem orderItem;

	public OrderItemDeletedEvent(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	public OrderItem getOrderItem() {
		return orderItem;
	}
}
