package com.gouqiang.shen;

import org.springframework.beans.factory.FactoryBean;

public class PersonBeanFactoryBean implements FactoryBean<PersonBean> {
    @Override
    public PersonBean getObject() throws Exception {
        PersonBean bean =  new PersonBean();
        bean.setName("shen");
        bean.setAge(16);
        return bean;
    }

    @Override
    public Class<?> getObjectType() {
        return PersonBean.class;
    }
}
