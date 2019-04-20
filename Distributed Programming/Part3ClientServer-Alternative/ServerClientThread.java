
import java.net.*;
import java.io.*;
 
class ServerClientThread extends Thread {
  Socket serverClient;
  int clientNo;
  int squre;
  
  static Player1 player1;
  static Player2 player2;
  static RacingGame game;
  
  ServerClientThread(Socket inSocket,int counter){
    serverClient = inSocket;
    clientNo=counter;
  }
  public void run(){
    GameMain gameMain = new GameMain();
    
    try{
      DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
      DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
      String clientMessage="", serverMessage="";
      
      player1 = new Player1(370, 700);
      player2 = new Player2(370, 820);
	   RacingGame game = new RacingGame(player1,player2);
      gameMain.LoadGame(game);
      while(!clientMessage.equals("bye")){
      
        clientMessage=inStream.readUTF();
        System.out.println("From Client-" +clientNo+ ": Number is :"+clientMessage);
        squre = Integer.parseInt(clientMessage) * Integer.parseInt(clientMessage);
        serverMessage="From Server to Client-" + clientNo + " Square of " + clientMessage + " is " +squre;
        outStream.writeUTF(serverMessage);
        outStream.flush();
      }
      inStream.close();
      outStream.close();
      serverClient.close();
    }catch(Exception ex){
      System.out.println(ex);
    }finally{
      System.out.println("Client -" + clientNo + " exit!! ");
    }
  }
}