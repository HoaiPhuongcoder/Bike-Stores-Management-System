package ui;

import java.util.ArrayList;
import utils.Validator;

public class Menu extends ArrayList<String> implements IMenu{

    public Menu() {
    }
    public Menu(String[] ops) {
        for(String op:ops){
            this.add(op);
        }
    }
    @Override
    public void addItem(String s) {
        this.add(s);
    }

    @Override
    public int getChoice() {
        return Validator.getInt(" => Enter your choice: ","Enter range","INVALID", 1, this.size());
    }

    @Override
    public void showMenu() {
        System.out.println("--------------------------MENU------------------------");
        for (int i = 0; i < this.size(); i++) {
            System.out.printf("| %2d.  %-35s %10s|\n", i+1, this.get(i), " ");
        }
        System.out.println("------------------------------------------------------");
    }

    @Override
    public boolean confirmYesNo(String welcome) {
        do {
            String flag = Validator.getString(welcome, "Invalid","^(?!\\s*$).+");
            if (flag.equalsIgnoreCase("Y")) {
                return true;
            } else if (flag.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Just enter Y or N ~ Pls re-enter again...");
            }
        } while (true);
    }
}
