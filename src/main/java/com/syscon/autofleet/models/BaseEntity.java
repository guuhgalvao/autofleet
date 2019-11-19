package com.syscon.autofleet.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public abstract class BaseEntity {

    @Column(updatable = false)
    @CreationTimestamp
    private Timestamp created_at;
    
    @UpdateTimestamp
    private Timestamp updated_at;
	
	@PrePersist
    protected void prePersist() {
        if (this.created_at == null) created_at = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void preUpdate() {
        this.updated_at = new Timestamp(System.currentTimeMillis());
    }
    
	public Timestamp getCreated_at() {
		return created_at;
	}
	
	public Timestamp getUpdated_at() {
		return updated_at;
	}
}
