package implementation;

import model.CustomerDto;

import java.util.Queue;


public class SellingThread implements Runnable{

   private UserServiceImpl userService;

   Queue<CustomerDto> queue;


    public SellingThread(UserServiceImpl userService, Queue<CustomerDto> queue) {
        this.userService = userService;
        this.queue = queue;
    }

    @Override
   public void run() {
        userService.sellByPriority(userService.getBranQueue());
        System.out.println(Thread.currentThread().getName() + " sold ");

    }

}


