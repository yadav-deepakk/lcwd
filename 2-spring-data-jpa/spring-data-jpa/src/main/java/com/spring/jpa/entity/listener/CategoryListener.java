package com.spring.jpa.entity.listener;

import com.spring.jpa.entity.Category;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CategoryListener {
    private static final Logger log = LoggerFactory.getLogger(CategoryListener.class);

    @PrePersist
    public void prePersist(Category category) {
        log.info("Entity is about to be persisted into the database");
    }

    @PostPersist
    public void postPersist(Category category) {
        log.info("Entity is persisted into the database with id {} ", category.getId());
    }

    /* ====== similarly can be done for below ==============
    // PreUpdate, PostUpdate, PreRemove, PostRemove
    =======================================================*/

}
