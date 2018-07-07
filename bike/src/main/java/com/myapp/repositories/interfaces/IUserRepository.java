package com.myapp.repositories.interfaces;

import java.util.List;

public interface IUserRepository<T> {

	public T user(Long id);

	public List<T> users();

}