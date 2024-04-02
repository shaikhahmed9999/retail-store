package com.store.retail.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.retail.modals.UserDetail;

public interface UserRepository extends JpaRepository<UserDetail, Long>  {

}
