//Class to define functions to allot rooms to users
public class HashMap {
      private final static int No_Of_Rooms = 11;
 int count=0;
      HashEntry[] room;
 
      HashMap() {
            room = new HashEntry[No_Of_Rooms];
            for (int i = 0; i < No_Of_Rooms; i++){
                  room[i] = null;
           
            }
      }
 
      //To check room allotment according to age
      public void get(int key) {
            int hash = key;
            while (room[hash] != null && room[hash].getKey() != key)
                  hash = (hash + 1) % No_Of_Rooms;
            if (room[hash] == null){
                 System.out.println("Not present");
            return;
            }
            else{
                 System.out.println("Age:	"+ room[hash].getAge());
            System.out.println("Name:	"+ room[hash].getName());
            }
      }
 
      //To allot room according to age
      public void put( int value,String name) {
            int hash = (value % No_Of_Rooms);
           if(count<No_Of_Rooms){
            while ((room[hash] != null))
                  {hash = (hash + 1) % No_Of_Rooms;}
            room[hash] = new HashEntry(hash, value, name);
            System.out.println("Your room is"+hash);
            count=count+1;
           }
           else{
        	   System.out.println("Rooms not possible");
        	   return;
           }
      }
           //To delete alloted rooms
           public void deleteRoom(int hashRoom)
           {
        	  room[hashRoom]=null;
        	  count=count-1;
        	  
           }
           
           public void clear(){
        	   for(int i=0;i<No_Of_Rooms;i++){
        		   room[i]=null;
        		  
        	   }
        	   count=0;
        	   System.out.println("All rooms are empty");
           }//To display the result
           public void display(){
        	   int k=0;
        	   while(k<No_Of_Rooms)
        	   {   System.out.println("Room no  "+k+"  status");
        	   if(room[k]!=null){
        		   System.out.println("Age:	"+ room[k].getAge());
                   System.out.println("Name:	"+ room[k].getName());
                   k++;
        	   }
        	   else{
        		   System.out.println("empty right now");
        		   k++;
        	   }
        	   }
           }
     
}