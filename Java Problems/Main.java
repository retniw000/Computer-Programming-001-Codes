public class Main{
    public static void main(String[] args){
        Person human = new Person();

        human.set_name("Nigga");
        human.set_age(25);

        System.out.println(human.get_name());
        System.out.println(human.get_age());
    }
}