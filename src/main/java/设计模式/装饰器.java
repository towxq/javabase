package 设计模式;

public class 装饰器 {
    public static void main(String[] args) {
        ShapDecorator shapDecorator = new RedShap(new CircleShap());
        ShapDecorator shapDecorator1 = new RedShap(new SJXShap());
        shapDecorator.draw();
        shapDecorator1.draw();
    }
}

interface Shap{
    void draw();
}

class CircleShap implements Shap{

    @Override
    public void draw() {
        System.out.println("画个圆形");
    }
}

class SJXShap implements Shap{

    @Override
    public void draw() {
        System.out.println("画个三角形");
    }
}

abstract class ShapDecorator implements Shap{
    public Shap decoratorShap;

    ShapDecorator(Shap shap){
        this.decoratorShap = shap;
    }

    public void draw(){
        decoratorShap.draw();
    }}

class RedShap extends ShapDecorator{

    RedShap(Shap shap) {
        super(shap);
    }

    public void draw(){
        decoratorShap.draw();
        setRed();
    }

    private void setRed(){
        System.out.println("加个红色");
    }
}
