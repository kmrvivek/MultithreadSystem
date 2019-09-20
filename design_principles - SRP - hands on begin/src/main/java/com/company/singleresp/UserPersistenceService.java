package com.company.singleresp;

public class UserPersistenceService {
	private Store store;
	
	public UserPersistenceService() {

		this.store = new Store();
	}

	public void save(User user) {
		store.store(user);
		
	}
	
}
