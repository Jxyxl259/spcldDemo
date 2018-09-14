package com.spcld.demo.service;

import com.spcld.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName DeptServiceFallbackFactory
 * @Description
 * @Author jiangxy
 * @Date 2018\9\14 0014 14:15
 * @Version 1.0.0
 */
// 千万不要忘记在此处添加 @Component 注解
@Component
public class DeptServiceFallbackFactory implements FallbackFactory<DeptService> {


    /**
     * 针对哪个接口增加熔断机制
     * @param throwable
     * @return
     */
    @Override
    public DeptService create(Throwable throwable) {
        return new DeptService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                Dept d = new Dept("Consumer客户端提供的降级信息，刺客服务Provider已经关闭");

                return d;
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
