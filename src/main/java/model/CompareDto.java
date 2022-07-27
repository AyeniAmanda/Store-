package model;

import java.util.Comparator;

public class CompareDto implements Comparator<CustomerDto> {

    @Override
    public int compare(CustomerDto o1, CustomerDto o2) {
       if(o1.getQuantity() < o2.getQuantity()){
           return 1;
       }
        return -1;
    }
}
