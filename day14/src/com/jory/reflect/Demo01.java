package com.jory.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Properties;
import java.util.stream.Stream;

/*
获取class对象的方式:
    1.Class.forName("全类名")
    2.类名.class
    3.对象.getClass()
 */
public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, IOException {
//        reflectDemo1();
//        reflectDemo2();
//        reflectDemo3();
//        reflectDemo4();
        propertiesDemo();
    }
    static void reflectDemo1() throws ClassNotFoundException{
        //方法1:通过全类名获取
        Class<?> aclass = Class.forName("com.jory.reflect.Person");
        System.out.println(aclass);
        System.out.println("---------------------");
        //方法2:通过类名获取
        Class<Person> personClass = Person.class;
        System.out.println(personClass);
        System.out.println("-------------------------------");
        //方法3:通过实例获取
        Class<? extends Person> aClass1 = new Person().getClass();
        System.out.println(aClass1);
    }
    /*
    通过Class对象获取成员变量:
    1.getFields()获取public
    2.getField(成员变量名)
        1.返回成员变量
        2.可以通过成员变量.get(对象名)获取值
        3.可以通过成员变量.set(对象名,值)设置值
    3.getDeclaredFields()获取所有
    */
    static void reflectDemo2() throws NoSuchFieldException, IllegalAccessException {
        // 获取public成员变量
        Class<Person> personClass = Person.class;
        Field[] fields = personClass.getFields();
        Stream<Field> stream = Arrays.stream(fields);
        stream.forEach(System.out::println);
        System.out.println("------------------------");
        // 获取所有成员变量
        Field[] fields1 = personClass.getDeclaredFields();
        Stream<Field> stream1 = Arrays.stream(fields1);
        stream1.forEach(System.out::println);
        System.out.println("------------------------");
        //3.设置反射设置成员变量的值
        Person cuFeng = new Person("楚枫", 22);
        System.out.println(cuFeng);
        //3.1获取楚枫的a成员变量
        Field a = personClass.getDeclaredField("a");
        //3.2设置楚枫的年龄
        a.set(cuFeng, "哈哈哈");
        System.out.println(cuFeng.a);
    }
    /*
    反射获取构造方法:
    1.getConstructors 获取公开的
    2.getDeclaredConstructors 获取所有的
    */
    static void reflectDemo3() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //获取构造方法1:公开的
        Class<Person> personClass = Person.class;
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("-------------------------------");
        //获取构造方法2:所有的
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        System.out.println("-------------------------------");

        //通过反射创建对象1:有参构造
        Constructor<Person> constructor = personClass.getConstructor(String.class,int.class);
        Person cuFeng = constructor.newInstance("name",34);
        System.out.println(cuFeng);
        System.out.println("-------------------------------");
        //通过反射创建对象2:无参构造
        Constructor<Person> constructor1 = personClass.getConstructor();
        Person cuiCui = constructor1.newInstance();
        cuiCui.setName("cuicui");
        cuiCui.setAge(43);
        System.out.println(cuiCui);
    }
    /*
    通过反射获取成员方法:
    1.getMethod
    2.getDeclaredMethod
    */
    static void reflectDemo4() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Student> studentClass = Student.class;
        //1.获取Student类的公开方法
        Method show = studentClass.getMethod("show");
        //2.调用方法
        /*
        注意:
            1.调用方法不能直接调用,需要依赖invoke方法
            2.参数是一个类的实例对象
         */
        //show.invoke(new Student());
        show.invoke(new Student());
    }
    static void propertiesDemo() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //1.创建Properties对象
        Properties properties = new Properties();
        //2.加载配置文件,转换为集合
        ClassLoader classLoader = Demo01.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("prop.properties");
        properties.load(inputStream);
        //3.获取配置文件数据
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
        //4.加载该类
        Class<?> aClass = Class.forName(className);
        //5.创建对象
        Object o = aClass.newInstance();
        //6.获取方法对象
        Method method = aClass.getMethod(methodName);
        //7.执行方法
        method.invoke(o);
    }
}
