package com.github.robotnikthingy.weaponsapi.action;

/**
 * A parser to parse actions and their parameters from configuration files
 * 
 * @author Robotnik
 * @since 8/9/2017
 */
public class MechanicParser {


    MechanicAction parseAction(String configLine){

        //get all text before the parenthesis, which is the name of the mechanicAction
        String actionName = configLine.split("\\(")[0];

        //everything after first parenthesis
        String parameterString = configLine.split("\\(")[1];
        //remove the last parenthesis
        parameterString.split(configLine.split("\\)")[0]);

        //get all the parameters
        String[] parameters = parameterString.split(",");

        MechanicAction mechanicAction = new MechanicAction(actionName,parameters);

        return mechanicAction;
    }
}