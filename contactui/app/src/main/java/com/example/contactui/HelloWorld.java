
public class HelloWorld extends ClassC{
    public static void main(String[] args){
        System.out.println("Hello world");
        EncapTest enp = new EncapTest();
        enp.setName("Moti");
        enp.setIdNum("20UICS096");
        enp.setAge(23);

        System.out.println("Name : " + enp.getName());
        System.out.println("Id : " + enp.getIdNum());
        System.out.println("Age : " + enp.getAge());

        System.out.println(enp.sum(9, 6));
        System.out.println(enp.substraction(9, 6));
        System.out.println(enp.multiply(9, 6));
        System.out.println(enp.division(9, 6));

        HelloWorld hw = new HelloWorld();
        System.out.println(hw.multiply(100, 200));
//
//        final int temp = 10;
//        temp = 11;


    }

    @Override
    public int multiply(int a, int b){
        return a * b;
    }
}

class ClassC{
    public int multiply(int a, int b){
        return a * b;
    }

    public int division(int a, int b){
        return a / b;
    }
}

class EncapTest extends ClassA{
    private String name;
    private String idNum;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
