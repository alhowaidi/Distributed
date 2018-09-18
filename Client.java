public class Client {

    public static void main(String[] args) {

long startTime = System.nanoTime();

         Connection w1 = new Connection("127.0.0.1", 25000);
         w1.star();

/*         Connection w2 = new Connection("10.10.2.2", 25000);
         w2.star();

       Connection w3 = new Connection("10.10.3.2", 25000);
     w3.star();

 Connection w4 = new Connection("10.10.4.2", 25000);
     w4.star();
 Connection w5 = new Connection("10.10.8.2", 25000);
     w5.star();
 Connection w6 = new Connection("10.10.12.2", 25000);
     w6.star();
*/
         w1.sendMessage("2\n");
  /*       w2.sendMessage("3\n");
        w3.sendMessage("4\n");
 w4.sendMessage("5\n");
 w5.sendMessage("6\n");
 w6.sendMessage("7\n");
*/
         w1.terminate();
long stopTime = System.nanoTime();
System.out.println(stopTime - startTime);
  /*      w2.terminate();
         w3.terminate();
 w4.terminate();
 w5.terminate();
w6.terminate();*/
    }
}
