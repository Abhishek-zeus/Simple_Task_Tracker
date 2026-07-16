    import java.util.*;
    
    class TodoItem{
        private String itemName;
        private boolean completed;
        
        //Constructor
        TodoItem(String itemName){
            this.itemName = itemName;
            completed = false;
        }
        
        //Getters and Setters
        public void setCompletedStatus(){
            this.completed = true;
        }
        
        public boolean getCompletedStatus(){
            return completed;
        }
        
        public String getItemName(){
            return itemName;
        }
    }
    
    class Main {
        //In-Memory storage
        private static ArrayList<TodoItem> items = new ArrayList<>();
        
        //Add Items
        public static void addItem(String itemName){
            if(itemName.strip().length()<1){
                System.out.println("Invalid Task");
            }
            else{
                items.add(new TodoItem(itemName));
                System.out.println("Task Added successfully");   
            }
           
        }
        
        //Display Items
        public static void display(){
            for(int i=0;i<items.size();i++){
                String status = items.get(i).getCompletedStatus()? "Completed" : "Pending";
                System.out.println("Task "+(i+1)+": "+items.get(i).getItemName()+"--> "+status);
            }
        }
        
        //Mark Item Complete
        public static void markComplete(int itemNumber){
            if(itemNumber<=0 || itemNumber>items.size()){
                System.out.println("Invalid Task Number");
            }
            else{
                items.get(itemNumber - 1).setCompletedStatus();
                System.out.println("Marked Successfully");
            }
        }
        
        //Delete Item
        public static void delete(int itemNumber){
            if(itemNumber<=0 || itemNumber>items.size()){
                System.out.println("Invalid Task Number");
            }
            else{
                items.remove(itemNumber-1);
                System.out.println("Task Deleted Successfully");
            }
        }
        
        //Main Method
        public static void main(String[] args) {
            //for taking Input
            Scanner sc = new Scanner(System.in);
            final int ADD_ITEM = 1;
            final int DISPLAY_ITEMS = 2;
            final int MARK_ITEM = 3;
            final int DELETE_ITEM = 4;
            final int EXIT = 5;
            //Displaying the Option repetitively
            while(true){
                //Main Menu
                System.out.println("TASK TRACKER");
                System.out.println("1. Add Task");
                System.out.println("2. View Tasks");
                System.out.println("3. Mark Completed");
                System.out.println("4. Delete Task");
                System.out.println("5. Exit");
                
                //Taking Choice Input
                System.out.println("Enter your choice");
                
                try{
                    int choice = sc.nextInt();
                    sc.nextLine();
                    
                    switch(choice){
                        //Add Task
                        case ADD_ITEM:
                            System.out.println("Enter Task");
                            String itemName = sc.nextLine();
                            addItem(itemName);
                            break;
                            
                        //Display All the Tasks
                        case DISPLAY_ITEMS:
                            if(items.isEmpty()){
                                System.out.println("No Task found");
                            }
                            else
                                display();
                            break;
                            
                        //To mark a Task as completed
                        case MARK_ITEM: 
                            if(items.isEmpty()){
                                System.out.println("Can't Mark. Its Empty");
                            }
                            else{
                                System.out.println("Enter Task number");
                                int itemNumber = sc.nextInt();
                                markComplete(itemNumber);
                            }
                            break;
                            
                        //Delete a Task
                        case DELETE_ITEM:
                            if(items.isEmpty()){
                                System.out.println("Can't Delete. Already Empty");
                            }
                            else{
                                System.out.println("Enter Task number");
                                int itemNumber = sc.nextInt();
                                delete(itemNumber);
                            }
                            break;
                            
                        //Exit the Menu 
                        case EXIT:
                            System.out.println("Thank You");
                            System.exit(0);
                        
                        //Invalid choice
                        default:
                            System.out.println("Invalid choice");
                    }
                    System.out.println("............................");
                }
                catch(Exception exception){
                    System.out.println("Invalid Input. Enter a valid number and try again");
                    sc.nextLine();
                    System.out.println("............................");
                }
            }
            
        }
    }