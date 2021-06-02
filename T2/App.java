public class App{
    public static void main(String [] args){

        Registradores reg = new Registradores();
       /* String retorno = reg.register("1", 0);
        System.out.println("Retorno " + retorno);
        retorno = reg.register("$t0", 1);
        System.out.println("Retorno $t0 = " + retorno);
        retorno = reg.register("$s1", 1);
        System.out.println("Retorno s1 = " + retorno);
        retorno = reg.register("$s2", 1);
        System.out.println("Retorno s2 = " + retorno);*/


        Codifica cod = new Codifica();
        cod.type_R("add", "$8","$9", "$10");


        
    }   
}