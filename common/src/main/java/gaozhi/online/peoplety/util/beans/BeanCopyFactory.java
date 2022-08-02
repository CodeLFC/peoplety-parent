package gaozhi.online.peoplety.util.beans;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO 对象拷贝工厂,如果没有特殊的字段需要拷贝，默认工厂就可以完成要求
 * @date: 2022/8/2 17:09
 */
public interface BeanCopyFactory<F, T> {

    default void copy(F objF, T objT) {
        BeanUtils.copyProperties(objF, objT);
    }

    /**
     * @description: 拷贝的目标对象必须存在默认构造函数
     * @param: obj
     * @param: klass
     * @return: T
     * @author LiFucheng
     * @date: 2022/8/2 18:27
     */
    default T copy(F obj, Class<T> klass) {
        T result = null;
        try {
            result = klass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        copy(obj, result);
        return result;
    }
}
