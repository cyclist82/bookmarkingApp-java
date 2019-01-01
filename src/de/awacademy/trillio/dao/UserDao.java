package de.awacademy.trillio.dao;

import de.awacademy.trillio.DataStore;
import de.awacademy.trillio.entities.User;

public class UserDao {
	public User[] getUsers() {
		return DataStore.getUsers();
	}
}
