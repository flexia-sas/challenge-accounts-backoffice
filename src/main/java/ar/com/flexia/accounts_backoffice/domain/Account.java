package ar.com.flexia.accounts_backoffice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

/**
 * Represents a user account
 */
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_account")
	private Long id;
	private String name;
	private String email;
	private String password;
	private Status status;
	private LocalDateTime created;
	private LocalDateTime lastUpdated;

	public Account() {}

	public Account(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.created = LocalDateTime.now();
		this.status = Status.ACTIVE;
	}

	public boolean isActive() {
		return Status.ACTIVE.equals(this.status);
	}

	public void activate() {
		this.status = Status.ACTIVE;
	}

	public void deactivate() {
		this.status = Status.INACTIVE;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public enum Status {
		ACTIVE, INACTIVE;
	}
}
