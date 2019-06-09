package com.myproject.common.utils.singleton;

//public class Singleton {
// 饿汉法 : 类创建时加载，无法做到延迟加载；
//    private static Singleton instance = new Singleton();
//
//    private Singleton() {
//    }
//
//    public static Singleton getInstance() {
//        return instance;
//    }

// 懒汉法 : 线程不安全，多线程时有可能创建多个对象
//    private static Singleton instance = null;
//
//    private Singleton() {
//    }
//
//    public static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

// 双重检索，兼顾线程安全和效率
// volatile关键字：
// 1、可见性，对该变量的修改会强制回写主内存；
// 2、禁止指令重排序优化，jdk1.5以后；
//    private static volatile Singleton instance = null;
//
//    private Singleton() {
//    }
//
//    public static Singleton getInstance() {
//        if (instance == null) {
//            synchronized (Singleton.class) {
//                if (instance == null) {
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }

// 静态内部类，避免静态实例在类加载的时候就创建对象；
// 并且静态内部类只会被加载一次，因此保证线程安全；
//    private static class Holder {
//        private static Singleton instance = new Singleton();
//    }
//
//    private Singleton() {
//
//    }
//
//    public static Singleton getInstance() {
//        return Holder.instance;
//    }


//}

public enum Singleton {

    INSTANCE;
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
