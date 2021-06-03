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
        Decodifica dec = new Decodifica();
        //cod.type_SRL("srl", "$8","$9", "0x00005");
        //cod.type_I("bne", "$9","$18", "0xfffffffa");    
        //cod.type_I("slti", "$8","$9","0xff00000f");  
        //cod.type_J("0x00400020");
        //cod.type_JR("$31");

        cod.Codificador("j 0x00400020");        
        cod.Codificador("jr $31");
        cod.Codificador("add $8,$9, $10");            
        System.out.println("                ");  
        cod.Codificador("beq $8,$9,0xfffffffb");
        cod.Codificador("bne $9,$18, 0xfffffffa");   
        cod.Codificador("ori $9,$9,0x00000002");
        cod.Codificador("and $8,$9,$10");
        cod.Codificador("srl $9,$10,0x00000001");
        cod.Codificador("slti $8,$9,0x0000000a");
        
    
    }   
}