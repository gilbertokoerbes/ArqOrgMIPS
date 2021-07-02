package com.company;

public class SignExtend {
    
        public String signEXTENDIn;

        public void execute(){//ja é executado quando InstrutionMemory manda os dados
            System.out.println("\n------------------ Entrou no SignExtend ------------------");
            while(signEXTENDIn.length()<31) signEXTENDIn = "0"+signEXTENDIn; //extende os bits de 16 para 32
            PreMuxAlu.getInstance().Mux1 = signEXTENDIn;
            System.out.println("          - Valor SignExtend = "+ signEXTENDIn);
           //Shiftleft1.getInstance().Input = signEXTENDIn;  implementar shift1
        }


        private static SignExtend uniqueInstance;
    
        private SignExtend() {
        }
    
        public static synchronized SignExtend getInstance() {
            if (uniqueInstance == null)
                uniqueInstance = new SignExtend();
    
            return uniqueInstance;
        }
}
