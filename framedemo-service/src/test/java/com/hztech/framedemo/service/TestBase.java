package com.hztech.framedemo.service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

/**
 * Created by allan on 2015/7/8.
 */
public class TestBase {
    @PersistenceContext(unitName = "basePu")
    protected EntityManager entityManager;
    @Resource(name = "entityManagerFactory")
    protected EntityManagerFactory managerFactory;
}
