package com.example.day011;

import dagger.Component;

/**
 * @Date 2022/5/31
 */
//@Component(modules = {UserModule.class,StudentModule.class})

@Component(modules = {UserModule.class})
public interface UserComponent {
    void inject(MainActivity mainActivity);
}
