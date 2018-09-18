import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
//import java.net.Socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Connection implements Runnable {
Thread runner;
private String MSG;
    private String host;
    private int port;
    //private PrintWriter os;
private static Socket socket;
private OutputStream os;// = socket.getOutputStream();
        private    OutputStreamWriter osw;// = new OutputStreamWriter(os);
        private    BufferedWriter bw;// = new BufferedWriter(osw);

private  InputStream is;// = socket.getInputStream();
        private    InputStreamReader isr;// = new InputStreamReader(is);
         private   BufferedReader br;// = new BufferedReader(isr);
         private   String message;// = br.readLine();

    private volatile boolean running = false;
//    private ConcurrentLinkedQueue<String> queue;

    public Connection(String host, int port) {
        this.host = host;
        this.port = port;
//        this.queue = new ConcurrentLinkedQueue<String>();
    };

    public void star() {
  try {
this.socket = new Socket(host, port);
this.os = socket.getOutputStream();
this.osw = new OutputStreamWriter(os);
 this.bw = new BufferedWriter(osw);

this.is = socket.getInputStream();
     this.isr = new InputStreamReader(is);
   this.br = new BufferedReader(isr);
        //    String message = br.readLine();

//            this.os = new PrintWriter(new Socket(host, port).getOutputStream());
        } catch (IOException e) {
            return;
        }
        running = true;
this.runner = new Thread(this);
//this.runner.start();
        //new Thread(this).start();
    }

    @Override
    public void run() {
       /* while(true)*/ {
            // send messages in queue
          /*  while(!queue.isEmpty())*/ {
               // os.print(queue.poll());
try {
String sMsg = this.MSG;//queue.poll();
             System.out.println("Message sent to the server : "+sMsg);
bw.write(sMsg);
            bw.flush();

          //  InputStream is = socket.getInputStream();
           // InputStreamReader isr = new InputStreamReader(is);
           // BufferedReader br = new BufferedReader(isr);
            String message = br.readLine();
            System.out.println("Message received from the server : " +message);
}
 catch (Exception exception)
        {
            exception.printStackTrace();
        }
            }
            // wait to be notified about new messages
            try {
           //     waitMsg();//this.wait();
            } catch (Exception e) { //(InterruptedException e) {
                terminate();
            }
        }
    }
public synchronized void waitMsg(){
try{
this.wait();
}
catch(InterruptedException e) {
                terminate();
            }

}
    public synchronized void sendMessage(String msg) {
System.out.println("msg is: " + msg);
this.MSG = msg;
this.runner.start();
//        queue.add(msg);
       // this.notify();
    }

    public void terminate() {
  running = false;
    }

    public boolean isRunning() {
        return running;
    }
}

