package org.archenroot.integration.commons.archive_service.backend.domain;

public class Role {
	public static final String DATA_MANAGER = "data_manager";
	public static final String OPERATOR = "operator";
	public static final String ADMIN = "admin";

	private Role() {
		// Static methods and fields only
	}

	public static String[] getAllRoles() {
		return new String[] { DATA_MANAGER, OPERATOR, ADMIN };
	}

}
