package com.company;

public class PreMuxAlu {




    private static PreMuxAlu uniqueInstance;
    
    private PreMuxAlu() {
    }

    public static synchronized PreMuxAlu getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new PreMuxAlu();
        return uniqueInstance;
    }
    
    
}
