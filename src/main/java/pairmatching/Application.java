package pairmatching;

import jdk.jfr.internal.tool.Main;
import pairmatching.controller.MainController;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.execute();
    }
}
