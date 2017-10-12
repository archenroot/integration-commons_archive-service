package org.archenroot.integration.commons.archive_service.ui.view.admin.user;

import java.io.Serializable;

import org.archenroot.integration.commons.archive_service.ui.navigation.NavigationManager;
import org.archenroot.integration.commons.archive_service.ui.view.admin.AbstractCrudPresenter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import org.prokyon.integration.backend.data.entity.User;
import org.prokyon.integration.backend.service.UserService;

@SpringComponent
@ViewScope
public class UserAdminPresenter extends AbstractCrudPresenter<User, UserService, UserAdminView>
		implements Serializable {

	@Autowired
	public UserAdminPresenter(UserAdminDataProvider userAdminDataProvider, NavigationManager navigationManager,
			UserService service, BeanFactory beanFactory) {
		super(navigationManager, service, User.class, userAdminDataProvider, beanFactory);
	}

	public String encodePassword(String value) {
		return getService().encodePassword(value);
	}

	@Override
	protected void editItem(User item) {
		super.editItem(item);
		getView().setPasswordRequired(item.isNew());
	}
}