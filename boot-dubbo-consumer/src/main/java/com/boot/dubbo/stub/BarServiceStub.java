package com.boot.dubbo.stub;

/**
 * com.boot.dubbo.stub.BarServiceStub
 *
 * @author lipeng
 * @dateTime 2018/10/25 下午6:01
 */
public class BarServiceStub implements BarService {

    private final BarService barService;

    public BarServiceStub(BarService barService) {
        this.barService = barService;
    }

    @Override
    public void testStub() {
        System.out.println("调用BarService.testStub()方法之前执行");
        try {
            barService.testStub();
        } catch (Exception e) {
            // 做一些数据容错处理
        }
        System.out.println("调用BarService.testStub()方法之后执行");
    }
}
