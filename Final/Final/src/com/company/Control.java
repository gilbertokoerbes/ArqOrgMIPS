package com.company;

public class Control {



    public void ControlInput(String input){

//ver (6): https://moodle.pucrs.br/pluginfile.php/2087479/mod_resource/content/1/Aula_CPUMonociclo_6pp.pdf


    }

    private static Control uniqueInstance;

    private Control() {
        }

    public static synchronized Control getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new Control();

        return uniqueInstance;
    }

}
