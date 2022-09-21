package com.ideas2it;

import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

import com.ideas2it.controller.EmployeeController;
import com.ideas2it.controller.ProjectController;

public class EmployeeManagementSystem {

    private static Logger logger = Logger.getLogger(EmployeeManagementSystem.class);

    public static void main(String[] args) {

	EmployeeController controller = new EmployeeController();
        ProjectController projectController = new ProjectController();
        BasicConfigurator.configure();
        Scanner scanner = new Scanner(System.in);

        logger.info("Enter\n1.Employee Management\n2.ProjectManagement");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:	
                controller.userInput();
                break;
            case 2:
                projectController.manageProject();
                break;
        }
    }
}