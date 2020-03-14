/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.SalaryHistory;
import entity.Worker;
import java.util.ArrayList;

/**
 *
 * @author huyNguyen
 */
public class WorkerManagement {

    ArrayList<Worker> workers;

    public WorkerManagement(ArrayList<Worker> w) {
        this.workers = w;
    }

    public void addWorker(Worker w) {
        this.workers.add(w);
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public Worker searchWorker(String code) {
        for (Worker k : getWorkers()) {
            if (k.getCode().equalsIgnoreCase(code)) {
                return k;
            } else {
                k = null;
            }
        }
        return null;
    }

    public void decreaseSalary(int salary, String code) {
        Worker k = searchWorker(code);
        SalaryHistory sh = new SalaryHistory(k.getCurrentSalary(), salary);
        k.addSalaryHistory(sh);
        k.setCurrentSalary(salary);
    }

    public void increaseSalary(int salary, String code) {
        Worker k = searchWorker(code);
        SalaryHistory sh = new SalaryHistory(k.getCurrentSalary(), salary);
        k.addSalaryHistory(sh);
        k.setCurrentSalary(salary);
    }
    
}
