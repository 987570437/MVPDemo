package com.itzb.mvpdemo.base;


import java.lang.ref.WeakReference;

public abstract class BasePresenter<M extends BaseModel, V extends BaseView, CONTRACT> {

    protected M m;

    //绑定View层的弱引用
    private WeakReference<V> vWeakReference;

    public BasePresenter() {
        m = getModel();
    }

    public void bindView(BaseView v) {
        vWeakReference = (WeakReference<V>) new WeakReference<>(v);
    }

    public void unbindView() {
        if (vWeakReference != null) {
            vWeakReference.clear();
            vWeakReference = null;
            System.gc();
        }
    }

    //获取View  ，P->V
    public V getView() {
        if (vWeakReference != null) {
            return vWeakReference.get();
        }
        return null;
    }

    public abstract M getModel();

    //获取子类具体契约
    public abstract CONTRACT getContract();

}
