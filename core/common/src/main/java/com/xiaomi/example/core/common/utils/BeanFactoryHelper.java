package com.xiaomi.example.core.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * Created by liujin on 2017/10/10.
 */
public class BeanFactoryHelper implements BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public Object getBean(String beanName) {
        if(beanFactory == null) {
            throw new NullPointerException("beanFactory is null");
        }
        return beanFactory.getBean(beanName);
    }
}
