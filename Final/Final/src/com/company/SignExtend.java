package com.company;

public class SignExtend {
    
        public String signEXTEND;

        public void signExt(String sgnext){
            this.signEXTEND = sgnext;
            while(signEXTEND.length()<31) signEXTEND = "0"+signEXTEND; //extende os bits de 16 para 32
            PreMuxAlu.getInstance().Mux1 = signEXTEND;
            //Shiftleft1.getInstance().Input = signEXTEND;  implementar shift1
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
