package com.itzb.mvpdemo.base;

//接受P层给他的需求(基类)
public abstract class BaseModel<P extends BasePresenter, CONTRACT> {
    protected P p;

    //业务结束通过，通过presenter调用契约、合同 void responseResult(T t);

    public BaseModel(P p) {
        this.p = p;
    }

    protected abstract CONTRACT getContract();
}
