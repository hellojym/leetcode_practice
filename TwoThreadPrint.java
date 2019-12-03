class TwoThreadPrint{

    public synchronized void print(String num) {
        while(true) {
            notify();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
    
            }
            System.out.println(num);
            try {
                wait();
            } catch (Exception e) {
    
            }
        }
    }



}