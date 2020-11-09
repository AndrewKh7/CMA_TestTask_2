package com.testtask;


import com.testtask.actions.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleMenu implements  Runnable{

    private List<Action> menus;
    private Scanner scanner;

    public ConsoleMenu(List<Action> menus, Scanner scanner) {
        this.menus = menus;
        this.scanner = scanner;
    }

    @Override
    public void run() {
        int cmd = 0;
        do{
            System.out.println();
            System.out.println("Choose action:");
            System.out.println("0 - exit");
            int cnt = 0;
            for(Action act: menus){
                System.out.println((++cnt) + " - " + act.getActionName());
            };
            cmd = scanner.nextInt();
            scanner.nextLine();
            if( cmd!=0 && cmd<=menus.size())
                menus.get(cmd-1).start();
        }while(cmd!=0);

    }

    private int mainMenu(){
        menus.forEach(Action::start);
        return 1;
    }
}

