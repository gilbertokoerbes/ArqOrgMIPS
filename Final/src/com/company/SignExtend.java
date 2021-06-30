package com.company;

public class SignExtend {
    



        private static SignExtend uniqueInstance;
    
        private SignExtend() {
        }
    
        public static synchronized SignExtend getInstance() {
            if (uniqueInstance == null)
                uniqueInstance = new SignExtend();
    
            return uniqueInstance;
        }
}
