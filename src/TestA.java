public class TestA extends Parent {

    protected  int bb = 2;

    @Override
    public void a() {
        System.out.println("child a");
    }

    public void b(){
        super.b();
    }

    public static void main(String[]args){
        new TestA().b();
    }
}

class Parent{

    protected  int bb = 1;
    public void a(){
        System.out.println("paretn a");
    }

    public void b(){
        System.out.println(this.bb);
    }
}
