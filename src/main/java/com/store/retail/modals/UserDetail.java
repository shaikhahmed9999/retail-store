package com.store.retail.modals;

import java.time.LocalDateTime;

import com.store.retail.constants.UserTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class UserDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true) 
	private String userName;
	private UserTypes userType;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	
	public UserDetail() {
    }
	
	public UserDetail(long id, String userName, UserTypes userType, LocalDateTime createdDate,
			LocalDateTime modifiedDate) {
		this.id = id;
		this.userName = userName;
		this.userType = userType;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}
	
	public UserTypes getUserType() {
		return userType;
	}
	public void setUserType(UserTypes userType) {
		this.userType = userType;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	@PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedDate = LocalDateTime.now();
    }
	
}
