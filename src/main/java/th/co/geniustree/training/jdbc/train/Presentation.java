/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.training.jdbc.train;

import java.util.List;

/**
 *
 * @author Rain
 */
public class Presentation {  //Print 

    public static void print() {
        DAO dao = new DAO();
        List<String[]> results = dao.getData();
        
        for (String[] i : results) {
            System.out.println(i[0] + "\t" + i[1]);
        }
        
    }

    public static void main(String[] args) {
        print();
    }
}
