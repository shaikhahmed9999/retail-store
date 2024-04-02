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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	private String userName;
	private UserTypes userType;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;

	@PrePersist
	protected void onCreate() {
		createdDate = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		modifiedDate = LocalDateTime.now();
	}

}
