package 设计模式;

public class 外观设计模式 {
    public static void main(String[] args){
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawSquare();
        shapeMaker.drawCircle();
        shapeMaker.drawRentangle();
    }
}


interface Shape{
    void draw();
}

class Rectangle implements Shape{


    public void draw() {
        System.out.println("Recrangle draw");
    }
}

class Square implements Shape{

    public void draw() {
        System.out.println("Square draw");
    }
}

class  Circle implements Shape{

    public void draw() {
        System.out.println("Circle draw");
    }
}

//外观类
class ShapeMaker{
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeMaker(){
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawCircle(){
        circle.draw();
    }

    public void drawRentangle(){
        rectangle.draw();

    }

    public void drawSquare(){
        square.draw();
    }
}