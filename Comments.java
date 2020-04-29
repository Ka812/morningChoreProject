import java.util.* ;

class Comments {

    public static void hello(Locale locale) throws Exception {
        ResourceBundle labels = ResourceBundle.getBundle("ui", locale);
        String sayhello = labels.getString("hello");
        System.out.println(sayhello);
        sleep(1500);
        emptyLine(2) ;
    }
            
        
    public static void emptyLine(int howMany) {
        int i = 0 ;
        while (i<howMany) {
            System.out.println(" ") ;
            i++ ;   
        }
    }

    public static void sleep(int millisecs) {
        try {
           Thread.sleep(millisecs);
        } catch(Exception e) {
           e.printStackTrace();
        }
    }
    
}


