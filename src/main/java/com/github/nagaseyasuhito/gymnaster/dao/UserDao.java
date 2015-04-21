package com.github.nagaseyasuhito.gymnaster.dao;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import com.github.nagaseyasuhito.gymnaster.entity.User;
import com.github.nagaseyasuhito.gymnaster.entity.User_;

public class UserDao extends BaseDao<User, Integer> {

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}

	public Optional<Long> countNumberOfInvitees(@NotNull Integer id) {
		return this.getSingleResult((b, q, r) -> q.select(b.count(r)).where(b.equal(r.get(User_.id), id)), Long.class);
	}
}
