Instructions to run the Programme:
1.	Run the Server class in Java first, it will bring up a blank screen on the console
![Chat-Application](screenshot1.png)
2.	Run the client class, this can be run as many times as you like to have many different clients on the server, they will be prompt to enter in their username for the group chat
![Chat-Application](screenshot2.png)
3.	Server will show on the console the users that have joined the chat
![Chat-Application](screenshot3.png)
4.	If user types in “\q” they will leave the chat and the  code will finish
![Chat-Application](screenshot4.png)

The design of the programme I used three classes:

1.	The Server Class – to set up the Server and the port to be used for when clients are looking to join 
2.	The Client Class -  to set up clients that can access the server, let them type in their names, allow them to write messages on the server, by using Threads with Client Handler
3.	The ClientHandler Class – to set up the threads, allow the messages from the clients be read in the server by using a BufferedReader
