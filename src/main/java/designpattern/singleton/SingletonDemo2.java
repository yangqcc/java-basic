package designpattern.singleton;

/**
 * 枚举类实现单利模式 2018/3/19
 */
enum SingletonDemo2 {

    /**
     * 类型
     */
    INSTANCE("this is new instance!");

    private String name;

    SingletonDemo2(String name) {
        this.name = name;
    }
}
