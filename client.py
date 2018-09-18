# Import socket module
import socket               
import threading
import time
#start_time = time.time()
 
# Create a socket object
s = socket.socket()         
#s2 = socket.socket()
# Define the port on which you want to connect
port = 12345               
start_time = time.time()
 
# connect to the server on local computer
s.connect(('10.10.1.2', port))
packet = "Hello there"
s.sendall(packet);#, ('10.10.1.2', port))
#s2.connect(('10.10.2.2', port))
# receive data from the server
print s.recv(1024)
#print s2.recv(1024)
# close the connection
print("--- %s seconds ---" % (time.time() - start_time))

s.close()       
#s2.close()
#print("--- %s seconds ---" % (time.time() - start_time))
